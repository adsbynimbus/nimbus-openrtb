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
	enc.IntKeyOmitEmpty("w", f.W)
	enc.IntKeyOmitEmpty("h", f.H)
}

// IsNil checks if instance is nil
func (f *Format) IsNil() bool {
	return f == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (f *Format) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "w":
		return dec.Int(&f.W)

	case "h":
		return dec.Int(&f.H)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (f *Format) NKeys() int { return 0 }

// Formats ...
type Formats []Format

// UnmarshalJSONArray ...
func (s *Formats) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value = Format{}
	if err := dec.Object(&value); err != nil {
		return err
	}
	*s = append(*s, value)
	return nil
}

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
