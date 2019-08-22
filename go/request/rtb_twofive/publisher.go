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
