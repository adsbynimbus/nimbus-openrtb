package twofive

import (
	"github.com/francoispqt/gojay"
)

// Imp describes an ad placement or impression being auctioned. A single bid request can include
// multiple Imp objects, a use case for which might be an exchange that supports selling all ad positions on
// a given page. Each Imp object has a required ID so that bids can reference them individually.
type Imp struct {
	ID       string  `json:"id,omitempty"                   valid:"optional"`
	Banner   *Banner `json:"banner,omitempty"               valid:"optional"`
	Video    *Video  `json:"video,omitempty"                valid:"optional"`
	Instl    int     `json:"instl"                          valid:"range(0|1),optional"` // 0 = not interstitial, 1 = interstitial
	BidFloor float64 `json:"bidfloor"                       valid:"optional"`
	Secure   *int    `json:"secure"                         valid:"range(0|1),optional"`
	Ext      *ImpExt `json:"ext,omitempty"                  valid:"optional"`
}

// ImpExt ...
type ImpExt struct {
	APS           []APS  `json:"aps,omitempty"             valid:"optional"`
	FacebookAppID string `json:"facebook_app_id,omitempty" valid:"optional"` // needed for pubs that have FB hybrid SDK solution in thier stack
	Position      string `json:"position,omitempty"        valid:"required"` // flexible optional field for publishers to track on ad position performance
	Viewability   int    `json:"viewability,omitempty"     valid:"range(0|100),optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (i *Imp) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("id", i.ID)
	enc.ObjectKeyOmitEmpty("banner", i.Banner)
	enc.ObjectKeyOmitEmpty("video", i.Video)
	enc.IntKey("instl", i.Instl)
	enc.Float64Key("bidfloor", i.BidFloor)
	if i.Secure != nil {
		enc.IntKey("secure", *i.Secure)
	}
	enc.ObjectKeyOmitEmpty("ext", i.Ext)
}

// IsNil checks if instance is nil
func (i *Imp) IsNil() bool {
	return i == nil
}

// MarshalJSONObject implements MarshalerJSONObject
func (e *ImpExt) MarshalJSONObject(enc *gojay.Encoder) {
	var aPSSlice = APSs(e.APS)
	enc.ArrayKeyOmitEmpty("aps", aPSSlice)
	enc.StringKeyOmitEmpty("facebook_app_id", e.FacebookAppID)
	enc.StringKeyOmitEmpty("position", e.Position)
	enc.IntKeyOmitEmpty("viewability", e.Viewability)
}

// IsNil checks if instance is nil
func (e *ImpExt) IsNil() bool {
	return e == nil
}

// Imps ...
type Imps []Imp

// MarshalJSONArray ...
func (s Imps) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range s {
		enc.Object(&s[i])
	}
}

// IsNil ...
func (s Imps) IsNil() bool {
	return len(s) == 0
}
