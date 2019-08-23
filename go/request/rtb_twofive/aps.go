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

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (s *APS) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "amzn_b":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.AmznB = []string(aSlice)
		}
		return err

	case "amzn_vid":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.AmznVid = []string(aSlice)
		}
		return err

	case "amzn_h":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.AmznH = []string(aSlice)
		}
		return err

	case "amznp":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.Amznp = []string(aSlice)
		}
		return err

	case "amznrdr":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.Amznrdr = []string(aSlice)
		}
		return err

	case "amznslots":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.Amznslots = []string(aSlice)
		}
		return err

	case "dc":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.Dc = []string(aSlice)
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (s *APS) NKeys() int { return 0 }

// APSs ...
type APSs []APS

// UnmarshalJSONArray ...
func (s *APSs) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value = APS{}
	if err := dec.Object(&value); err != nil {
		return err
	}
	*s = append(*s, value)
	return nil
}

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
