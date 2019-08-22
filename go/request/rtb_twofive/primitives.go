// Slice data structures to work with Gojay

package twofive

import (
	"github.com/francoispqt/gojay"
)

// Ints is an alias of []int
type Ints []int

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

// Strings is an alias of []string
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
