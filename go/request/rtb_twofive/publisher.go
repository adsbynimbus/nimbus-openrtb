package twofive

import "github.com/francoispqt/gojay"

// Publisher object describes the publisher of the media in which the ad will be displayed. The publisher is
// typically the seller in an OpenRTB transaction.
type Publisher struct {
	Name   string   `json:"name"          valid:"required"`
	Cat    []string `json:"cat,omitempty" valid:"optional"`
	Domain string   `json:"domain"        valid:"required"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (p *Publisher) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKey("name", p.Name)
	var catSlice = Strings(p.Cat)
	enc.ArrayKeyOmitEmpty("cat", catSlice)
	enc.StringKey("domain", p.Domain)
}

// IsNil checks if instance is nil
func (p *Publisher) IsNil() bool {
	return p == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (p *Publisher) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "name":
		return dec.String(&p.Name)

	case "cat":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			p.Cat = []string(aSlice)
		}
		return err

	case "domain":
		return dec.String(&p.Domain)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (p *Publisher) NKeys() int { return 0 }
