// Slice data structures to work with Gojay

package twofive

import (
	"github.com/francoispqt/gojay"
)

// Ints ...
type Ints []int

// UnmarshalJSONArray decodes JSON array elements into slice
func (a *Ints) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value int
	if err := dec.Int(&value); err != nil {
		return err
	}
	*a = append(*a, value)
	return nil
}

// MarshalJSONArray encodes arrays into JSON
func (a Ints) MarshalJSONArray(enc *gojay.Encoder) {
	for _, item := range a {
		enc.Int(item)
	}
}

// IsNil checks if array is nil
func (a Ints) IsNil() bool {
	return len(a) == 0
}

// Strings ...
type Strings []string

// UnmarshalJSONArray decodes JSON array elements into slice
func (a *Strings) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value string
	if err := dec.String(&value); err != nil {
		return err
	}
	*a = append(*a, value)
	return nil
}

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
