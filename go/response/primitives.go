// Slice data structures to work with Gojay

package response

import (
	"github.com/francoispqt/gojay"
)

// Strings is an alias of []string
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
