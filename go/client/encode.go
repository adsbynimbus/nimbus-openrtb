package client

import (
	"bytes"
	"encoding/json"

	"github.com/francoispqt/gojay"
)

// MarshalBidRequest calls gojay to marshal data, if that fails we fallback to the standard package
func MarshalBidRequest(v interface{}) ([]byte, error) {
	// byte buffers grow more effiently than the encoder gojay is using internally
	b := new(bytes.Buffer)
	enc := gojay.BorrowEncoder(b)
	defer enc.Release()

	// addding fall back logic for normal behavior
	err := enc.Encode(v)
	if err != nil {
		tb, err := json.Marshal(v)
		if err != nil {
			return nil, err
		}
		_, _ = b.Write(tb)
	}

	return b.Bytes(), nil
}
