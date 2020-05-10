package twofive

import "github.com/francoispqt/gojay"

// Native object represents a native type impression. Native ad units are intended to blend seamlessly into
// the surrounding content (e.g., a sponsored Twitter or Facebook post). As such, the response must be
// well-structured to afford the publisher fine-grained control over rendering.
type Native struct {
	ID      string `json:"id,omitempty"      valid:"optional"`
	Request string `json:"request,omitempty" valid:"required"`
	Ver     string `json:"ver,omitempty"     valid:"optional"`
	API     []int  `json:"api,omitempty"     valid:"optional"`
	Battr   []int  `json:"battr,omitempty"   valid:"optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (n *Native) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("id", n.ID)
	enc.StringKeyOmitEmpty("request", n.Request)
	enc.StringKeyOmitEmpty("ver", n.Ver)
	var aPISlice = Ints(n.API)
	enc.ArrayKeyOmitEmpty("api", aPISlice)
	var battrSlice = Ints(n.Battr)
	enc.ArrayKeyOmitEmpty("battr", battrSlice)
}

// IsNil checks if instance is nil
func (n *Native) IsNil() bool {
	return n == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (n *Native) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "id":
		return dec.String(&n.ID)

	case "request":
		return dec.String(&n.Request)

	case "ver":
		return dec.String(&n.Ver)

	case "api":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			n.API = []int(aSlice)
		}
		return err

	case "battr":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			n.Battr = []int(aSlice)
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (n *Native) NKeys() int { return 0 }
