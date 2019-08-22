package twofive

import "github.com/francoispqt/gojay"

// APS is the response Object the APS sdk generates
type APS struct {
	AmznB     []string `json:"amzn_b"     valid:"optional"`
	AmznVid   []string `json:"amzn_vid"   valid:"optional"`
	AmznH     []string `json:"amzn_h"     valid:"optional"`
	Amznp     []string `json:"amznp"      valid:"optional"`
	Amznrdr   []string `json:"amznrdr"    valid:"optional"`
	Amznslots []string `json:"amznslots"  valid:"optional"`
	Dc        []string `json:"dc"         valid:"optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (s *APS) MarshalJSONObject(enc *gojay.Encoder) {
	var amznBSlice = Strings(s.AmznB)
	enc.ArrayKey("amzn_b", amznBSlice)
	var amznVidSlice = Strings(s.AmznVid)
	enc.ArrayKey("amzn_vid", amznVidSlice)
	var amznHSlice = Strings(s.AmznH)
	enc.ArrayKey("amzn_h", amznHSlice)
	var amznpSlice = Strings(s.Amznp)
	enc.ArrayKey("amznp", amznpSlice)
	var amznrdrSlice = Strings(s.Amznrdr)
	enc.ArrayKey("amznrdr", amznrdrSlice)
	var amznslotsSlice = Strings(s.Amznslots)
	enc.ArrayKey("amznslots", amznslotsSlice)
	var dcSlice = Strings(s.Dc)
	enc.ArrayKey("dc", dcSlice)
}

// IsNil checks if instance is nil
func (s *APS) IsNil() bool {
	return s == nil
}

// APSs ...
type APSs []APS

// MarshalJSONArray ...
func (s APSs) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range s {
		enc.Object(&s[i])
	}
}

// IsNil ...
func (s APSs) IsNil() bool {
	return len(s) == 0
}
