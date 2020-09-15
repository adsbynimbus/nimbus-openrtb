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
	Native   *Native `json:"native,omitempty"               valid:"optional"`
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
	Skadn         *Skadn `json:"skadn"                     valid:"optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (i *Imp) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("id", i.ID)
	enc.ObjectKeyOmitEmpty("banner", i.Banner)
	enc.ObjectKeyOmitEmpty("video", i.Video)
	enc.ObjectKeyOmitEmpty("native", i.Native)
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

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (i *Imp) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "id":
		return dec.String(&i.ID)

	case "banner":
		var value = &Banner{}
		err := dec.Object(value)
		if err == nil {
			i.Banner = value
		}

		return err

	case "video":
		var value = &Video{}
		err := dec.Object(value)
		if err == nil {
			i.Video = value
		}

		return err

	case "native":
		var value = &Native{}
		err := dec.Object(value)
		if err == nil {
			i.Native = value
		}

		return err

	case "instl":
		return dec.Int(&i.Instl)

	case "bidfloor":
		return dec.Float64(&i.BidFloor)

	case "secure":
		var value int
		err := dec.Int(&value)
		if err == nil {
			i.Secure = &value
		}
		return err

	case "ext":
		var value = &ImpExt{}
		err := dec.Object(value)
		if err == nil {
			i.Ext = value
		}

		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (i *Imp) NKeys() int { return 0 }

// MarshalJSONObject implements MarshalerJSONObject
func (e *ImpExt) MarshalJSONObject(enc *gojay.Encoder) {
	var aPSSlice = APSs(e.APS)
	enc.ArrayKeyOmitEmpty("aps", aPSSlice)
	enc.StringKeyOmitEmpty("facebook_app_id", e.FacebookAppID)
	enc.StringKeyOmitEmpty("position", e.Position)
	enc.ObjectKeyOmitEmpty("skadn", e.Skadn)
}

// IsNil checks if instance is nil
func (e *ImpExt) IsNil() bool {
	return e == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (e *ImpExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "aps":
		var aSlice = APSs{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			e.APS = []APS(aSlice)
		}
		return err

	case "facebook_app_id":
		return dec.String(&e.FacebookAppID)

	case "position":
		return dec.String(&e.Position)

	case "skadn":
		var value = &Skadn{}
		err := dec.Object(value)
		if err == nil {
			e.Skadn = value
		}

		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (e *ImpExt) NKeys() int { return 0 }

// Imps ...
type Imps []Imp

// UnmarshalJSONArray ...
func (s *Imps) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value = Imp{}
	if err := dec.Object(&value); err != nil {
		return err
	}
	*s = append(*s, value)
	return nil
}

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
