package request

import "github.com/francoispqt/gojay"

// Strings ...
type Strings []string

// MarshalJSONArray encodes arrays into JSON
func (a Strings) MarshalJSONArray(enc *gojay.Encoder) {
	for _, item := range a {
		enc.String(item)
	}
}

// IsNil checks if array is nil
func (a Strings) IsNil() bool {
	return len(a) == 0
}
