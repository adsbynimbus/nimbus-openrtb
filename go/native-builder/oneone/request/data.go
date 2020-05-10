package request

import "github.com/francoispqt/gojay"

// Data .Type
// 1 sponsored Sponsored By message whereresponse should contain the brandname of the sponsor.text Required. Max 25or longer.
// 2 desc Descriptive text associated with theproduct or service being advertised.Longer length of text in responsemay be truncated or ellipsed by theexchange. text Recommended. Max 140 or longer.
// 3 rating Rating of the product being offeredto the user. For example an app’srating in an app store from 0-5.numberformatted asstringOptional. 0-5integer formattedas string.
// 4 likes Number of social ratings or “likes” ofthe product being offered to theuser.numberformatted asstring
// 5 downloads Number downloads/installs of thisproductnumberformatted asstring
// Data returns contextual data about the Native asset
type Data struct {
	Type int `json:"type"` // should be 2 for most cases
	Len  int `json:"len"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (d *Data) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("type", d.Type)
	enc.IntKey("len", d.Len)
}

// IsNil checks if instance is nil
func (d *Data) IsNil() bool {
	return d == nil
}
