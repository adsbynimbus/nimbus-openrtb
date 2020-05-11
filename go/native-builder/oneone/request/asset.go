package request

import "github.com/francoispqt/gojay"

// Asset requesting Native assests
type Asset struct {
	ID       int   `json:"id"`
	Img      Img   `json:"img"`
	Title    Title `json:"title"`
	Data     Data  `json:"data"`
	Required int   `json:"required"` // should default to 1
}

// MarshalJSONObject implements MarshalerJSONObject
func (a *Asset) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("id", a.ID)
	enc.ObjectKey("img", &a.Img)
	enc.ObjectKey("title", &a.Title)
	enc.ObjectKey("data", &a.Data)
	enc.IntKey("required", a.Required)
}

// IsNil checks if instance is nil
func (a *Asset) IsNil() bool {
	return a == nil
}

// Assets ...
type Assets []Asset

// MarshalJSONArray ...
func (s Assets) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range s {
		enc.Object(&s[i])
	}
}

// IsNil ...
func (s Assets) IsNil() bool {
	return len(s) == 0
}
