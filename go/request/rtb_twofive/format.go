package twofive

import "github.com/francoispqt/gojay"

// Format object represents an allowed size (i.e., height and width combination) for a banner impression.
// These are typically used in an array for an impression where multiple sizes are permitted.
type Format struct {
	W int `json:"w"      valid:"required"`
	H int `json:"h"      valid:"required"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (f *Format) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("w", f.W)
	enc.IntKey("h", f.H)
}

// IsNil checks if instance is nil
func (f *Format) IsNil() bool {
	return f == nil
}

// Formats ...
type Formats []Format

// MarshalJSONArray ...
func (s Formats) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range s {
		enc.Object(&s[i])
	}
}

// IsNil ...
func (s Formats) IsNil() bool {
	return len(s) == 0
}
