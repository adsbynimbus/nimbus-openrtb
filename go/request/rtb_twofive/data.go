package twofive

import "github.com/francoispqt/gojay"

// Data and Segment objects together allow additional data about the user to be specified. This data
// may be from multiple sources whether from the exchange itself or third party providers as specified by
// the id field. A bid request can mix data objects from multiple providers. The specific data providers in
// use should be published by the exchange a priori to its bidders.
type Data struct {
	ID      string    `json:"id,omitempty"      valid:"optional"`
	Name    string    `json:"name,omitempty"    valid:"optional"`
	Segment []Segment `json:"segment,omitempty" valid:"optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (d *Data) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("id", d.ID)
	enc.StringKeyOmitEmpty("name", d.Name)
	var segmentSlice = Segments(d.Segment)
	enc.ArrayKeyOmitEmpty("segment", segmentSlice)
}

// IsNil checks if instance is nil
func (d *Data) IsNil() bool {
	return d == nil
}

// Datas ...
type Datas []Data

// MarshalJSONArray ...
func (s Datas) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range s {
		enc.Object(&s[i])
	}
}

// IsNil ...
func (s Datas) IsNil() bool {
	return len(s) == 0
}
