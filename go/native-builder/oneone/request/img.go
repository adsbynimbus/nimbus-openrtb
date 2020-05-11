package request

import "github.com/francoispqt/gojay"

// Img .Type
// 1 Icon Icon image Optional.max height: at least 50aspect ratio: 1:1
// 2 Logo Logo image for thebrand/app.To be deprecated in future version- use type 1 Icon.
// 3 Main Large image preview for theadAt least one of 2 size variantsrequired:Small Variant:max height: at least 200max width: at least 200,267, or 382aspect ratio: 1:1, 4:3, or1.91:1Large Variant:max height: at least 627max width: at least 627,836, or 1198aspect ratio: 1:1, 4:3, or1.91:1
// 500+ XXX Reserved for Exchangespecific usage numberedabove 500 No recommendations
// Img requesting types
type Img struct {
	Hmin  int      `json:"hmin"`
	Type  int      `json:"type"` // should be 3 for most cases
	Wmin  int      `json:"wmin"`
	Mimes []string `json:"mimes"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (i *Img) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("hmin", i.Hmin)
	enc.IntKey("type", i.Type)
	enc.IntKey("wmin", i.Wmin)
	var mimes = Strings(i.Mimes)
	enc.ArrayKeyOmitEmpty("mimes", mimes)

}

// IsNil checks if instance is nil
func (i *Img) IsNil() bool {
	return i == nil
}
