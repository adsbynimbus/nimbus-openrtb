package decode

import (
	"compress/flate"
	"compress/gzip"
	"encoding/json"
	"io"
	"net/http"

	"github.com/francoispqt/gojay"
)

// RequestToStruct takes the a request generically, checks the Content-Encoding
// and unmarshals the object to the provided data structure
func RequestToStruct(res *http.Request, v interface{}) error {
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
