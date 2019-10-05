package decode

import (
	"compress/flate"
	"compress/gzip"
	"encoding/json"
	"io"
	"io/ioutil"
	"net/http"

	"github.com/francoispqt/gojay"
)

const (
	gzipHeader    = "gzip"
	deflateHeader = "deflate"
)

// ResponseToStruct takes the response generically, checks the Content-Encoding
// and unmarshals the object to the provided data structure
func ResponseToStruct(res *http.Response, v interface{}) error {
	var reader io.ReadCloser
	var err error
	switch res.Header.Get("Content-Encoding") {
	case gzipHeader:
		reader, err = gzip.NewReader(res.Body)
		if err != nil {
			return err
		}
		defer reader.Close()
	case deflateHeader:
		reader = flate.NewReader(res.Body)
		defer reader.Close()
	default:
		reader = res.Body
	}

	decoder := gojay.BorrowDecoder(reader)
	defer decoder.Release()

	err = decoder.Decode(&v)
	if err != nil {
		return json.NewDecoder(reader).Decode(v)
	}

	return nil
}

// ResponseToBytes takes the Nimbus response, decodes if neccasary and returns the body as bytes
// if the Content-Encoding header is missing this can silently fail
func ResponseToBytes(res *http.Response) ([]byte, error) {
	var reader io.ReadCloser
	var err error
	switch res.Header.Get("Content-Encoding") {
	case gzipHeader:
		reader, err = gzip.NewReader(res.Body)
		if err != nil {
			return nil, err
		}
		defer reader.Close()
	case deflateHeader:
		reader = flate.NewReader(res.Body)
		defer reader.Close()
	default:
		reader = res.Body
	}
	return ioutil.ReadAll(reader)
}
