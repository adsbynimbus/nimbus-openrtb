package request

import "github.com/francoispqt/gojay"

// Title being represent ensure Title metadata on the image
type Title struct {
	Len int `json:"len"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (t *Title) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("len", t.Len)

}

// IsNil checks if instance is nil
func (t *Title) IsNil() bool {
	return t == nil
}
