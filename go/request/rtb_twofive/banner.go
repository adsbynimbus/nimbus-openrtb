package twofive

import (
	"github.com/francoispqt/gojay"
)

// Banner represents the most general type of impression. Although the term “banner” may have very
// specific meaning in other contexts, here it can be many things including a simple static image, an
// expandable ad unit, or even in-banner video (refer to the Video object in Section 3.2.4 for the more
// generalized and full featured video ad units). An array of Banner objects can also appear within the
// Video to describe optional companion ads defined in the VAST specification.
type Banner struct {
	BidFloor *float64 `json:"bidfloor,omitempty" valid:"optional"`
	BAttr    []int    `json:"battr,omitempty"    valid:"optional"`
	Format   []Format `json:"format,omitempty"   valid:"optional"`
	W        int      `json:"w"                  valid:"required"`
	H        int      `json:"h"                  valid:"required"`
	API      []int    `json:"api,omitempty"      valid:"inintarr(1|2|3|4|5|6),optional"` // 3,5,6 -> mraid1, 2, and 3
	Pos      int      `json:"pos,omitempty"      valid:"range(0|7),optional"`            // 0,1,2,3,4,5,6,7 -> Unknown, Above the Fold, DEPRECATED - May or may not be initially visible depending on screen size/resolution.,Below the Fold,Header,Footer,Sidebar,Full Screen
}

// MarshalJSONObject implements MarshalerJSONObject
func (b *Banner) MarshalJSONObject(enc *gojay.Encoder) {
	if b.BidFloor != nil {
		enc.Float64KeyOmitEmpty("bidfloor", *b.BidFloor)
	}
	var battrSlice = Ints(b.BAttr)
	enc.ArrayKeyOmitEmpty("battr", battrSlice)
	var formatSlice = Formats(b.Format)
	enc.ArrayKeyOmitEmpty("format", formatSlice)
	enc.IntKeyOmitEmpty("w", b.W)
	enc.IntKeyOmitEmpty("h", b.H)
	enc.IntKeyOmitEmpty("pos", b.Pos)
	var aPISlice = Ints(b.API)
	enc.ArrayKeyOmitEmpty("api", aPISlice)
}

// IsNil checks if instance is nil
func (b *Banner) IsNil() bool {
	return b == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (b *Banner) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {

	case "bidfloor":
		var value float64
		err := dec.Float64(&value)
		if err == nil {
			b.BidFloor = &value
		}
		return err

	case "format":
		var aSlice = Formats{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			b.Format = []Format(aSlice)
		}
		return err

	case "battr":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			b.BAttr = []int(aSlice)
		}
		return err

	case "w":
		return dec.Int(&b.W)

	case "h":
		return dec.Int(&b.H)

	case "pos":
		return dec.Int(&b.Pos)

	case "api":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			b.API = []int(aSlice)
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (b *Banner) NKeys() int { return 0 }

// Banners ...
type Banners []Banner

// UnmarshalJSONArray ...
func (s *Banners) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value = Banner{}
	if err := dec.Object(&value); err != nil {
		return err
	}
	*s = append(*s, value)
	return nil
}

// MarshalJSONArray ...
func (s Banners) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range s {
		enc.Object(&s[i])
	}
}

// IsNil ...
func (s Banners) IsNil() bool {
	return len(s) == 0
}
