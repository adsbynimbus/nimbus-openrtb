package twofive

import "github.com/francoispqt/gojay"

// Video object represents an in-stream video impression. Many of the fields are non-essential for minimally
// viable transactions, but are included to offer fine control when needed. Video in OpenRTB generally
// assumes compliance with the VAST standard. As such, the notion of companion ads is supported by
// optionally including an array of Banner objects (refer to the Banner object in Section 3.2.3) that define
// these companion ads.
type Video struct {
	BidFloor       *float64  `json:"bidfloor,omitempty"       valid:"optional"`
	CompanionAd    []Banner  `json:"companionad,omitempty"    valid:"optional"`
	CompanionType  []int     `json:"companiontype,omitempty"  valid:"optional"` //1, 2, 3 -> Static Resource, HTM Resource, iframe Resource
	Mimes          []string  `json:"mimes,omitempty"          valid:"optional"`
	Minduration    int       `json:"minduration"              valid:"optional"`
	Maxduration    int       `json:"maxduration,omitempty"    valid:"optional"`
	Protocols      []int     `json:"protocols,omitempty"      valid:"inintarr(2|3|5|6),optional"` // 1,2,3,4,5,6,7,8,9,10 -> VAST 1.0,VAST 2.0,VAST 3.0,VAST 1.0 Wrapper,VAST 2.0 Wrapper,VAST 3.0 Wrapper,VAST 4.0,VAST 4.0 Wrapper,DAAST 1.0,DAAST 1.0 Wrapper
	W              int       `json:"w,omitempty"              valid:"required"`
	H              int       `json:"h,omitempty"              valid:"required"`
	StartDelay     int       `json:"startdelay"               valid:"optional"`
	Placement      int       `json:"placement,omitempty"      valid:"range(1|5),optional"`            // 1,2,3,4,5 -> In-Stream, In-Banner, In-Article, In-Feed - Found in content, social, or product feeds, Interstitial/Slider/Floating
	Linearity      int       `json:"linearity,omitempty"      valid:"range(1|2),optional"`            // 1,2 -> linear, non linear
	Playbackmethod []int     `json:"playbackmethod,omitempty" valid:"inintarr(1|2|3|4|5|6),optional"` // 1,2,3,4,5,6 - > Initiates on Page Load with Sound On, Initiates on Page Load with Sound Off by Default, Initiates on Click with Sound On, Initiates on Mouse-Over with Sound On, Initiates on Entering Viewport with Sound On, Initiates on Entering Viewport with Sound Off by Default
	Skip           int       `json:"skip"                     valid:"range(0|1),optional"`            // 0 no 1 yes
	Delivery       []int     `json:"delivery,omitempty"       valid:"range(0|3),optional"`            // 0,1,2,3 -> Unknown, Professionally Produced, Prosumer, User Generated (UGC)
	Pos            int       `json:"pos,omitempty"            valid:"range(0|7),optional"`            // 0,1,2,3,4,5,6,7 -> Unknown,Above the Fold,DEPRECATED - May or may not be initially visible depending on screen size/resolution.,Below the Fold,Header,Footer,Sidebar,Full Screen
	API            []int     `json:"api,omitempty"            valid:"inintarr(1|2|3|4|5|6|7),optional"`
	MinBitRate     int       `json:"minbitrate,omitempty"     valid:"optional"`
	MaxBitRate     int       `json:"maxbitrate,omitempty"     valid:"optional"`
	Ext            *VideoExt `json:"ext"                      valid:"optional"`
}

// VideoExt ...
type VideoExt struct {
	IsRewarded int `json:"is_rewarded,omitempty"  valid:"range(0|1),optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (v *Video) MarshalJSONObject(enc *gojay.Encoder) {
	if v.BidFloor != nil {
		enc.Float64KeyOmitEmpty("bidfloor", *v.BidFloor)
	}
	var bannerSlice = Banners(v.CompanionAd)
	enc.ArrayKeyOmitEmpty("companionad", bannerSlice)
	var mimesSlice = Strings(v.Mimes)
	enc.ArrayKeyOmitEmpty("mimes", mimesSlice)
	enc.IntKey("minduration", v.Minduration)
	enc.IntKeyOmitEmpty("maxduration", v.Maxduration)
	var protocolsSlice = Ints(v.Protocols)
	enc.ArrayKeyOmitEmpty("protocols", protocolsSlice)
	enc.IntKeyOmitEmpty("w", v.W)
	enc.IntKeyOmitEmpty("h", v.H)
	enc.IntKey("startdelay", v.StartDelay)
	enc.IntKeyOmitEmpty("placement", v.Placement)
	enc.IntKeyOmitEmpty("linearity", v.Linearity)
	var playbackmethodSlice = Ints(v.Playbackmethod)
	enc.ArrayKeyOmitEmpty("playbackmethod", playbackmethodSlice)
	enc.IntKey("skip", v.Skip)
	var deliverySlice = Ints(v.Delivery)
	enc.ArrayKeyOmitEmpty("Delivery", deliverySlice)
	enc.IntKeyOmitEmpty("pos", v.Pos)
	var aPISlice = Ints(v.API)
	enc.ArrayKeyOmitEmpty("api", aPISlice)
	enc.IntKeyOmitEmpty("minbitrate", v.MinBitRate)
	enc.IntKeyOmitEmpty("maxbitrate", v.MaxBitRate)
	var companionTypeSlice = Ints(v.CompanionType)
	enc.ArrayKeyOmitEmpty("companiontype", companionTypeSlice)
	enc.ObjectKeyNullEmpty("ext", v.Ext)
}

// IsNil checks if instance is nil
func (v *Video) IsNil() bool {
	return v == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (v *Video) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "bidfloor":
		var value float64
		err := dec.Float64(&value)
		if err == nil {
			v.BidFloor = &value
		}
		return err

	case "companionad":
		var aSlice = Banners{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			v.CompanionAd = []Banner(aSlice)
		}
		return err

	case "companiontype":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			v.CompanionType = []int(aSlice)
		}
		return err

	case "mimes":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			v.Mimes = []string(aSlice)
		}
		return err

	case "minduration":
		return dec.Int(&v.Minduration)

	case "maxduration":
		return dec.Int(&v.Maxduration)

	case "protocols":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			v.Protocols = []int(aSlice)
		}
		return err

	case "w":
		return dec.Int(&v.W)

	case "h":
		return dec.Int(&v.H)

	case "startdelay":
		return dec.Int(&v.StartDelay)

	case "placement":
		return dec.Int(&v.Placement)

	case "linearity":
		return dec.Int(&v.Linearity)

	case "playbackmethod":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			v.Playbackmethod = []int(aSlice)
		}
		return err

	case "skip":
		return dec.Int(&v.Skip)

	case "Delivery":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			v.Delivery = []int(aSlice)
		}
		return err

	case "pos":
		return dec.Int(&v.Pos)

	case "api":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			v.API = []int(aSlice)
		}
		return err

	case "minbitrate":
		return dec.Int(&v.MinBitRate)

	case "maxbitrate":
		return dec.Int(&v.MaxBitRate)

	case "ext":
		var videoExt VideoExt
		err := dec.Object(&videoExt)
		if err == nil {
			v.Ext = &videoExt
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (v *Video) NKeys() int { return 0 }

// MarshalJSONObject implements MarshalerJSONObject
func (e *VideoExt) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("is_rewarded", e.IsRewarded)
}

// IsNil checks if instance is nil
func (e *VideoExt) IsNil() bool {
	return e == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (e *VideoExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {
	switch k {
	case "is_rewarded":
		return dec.Int(&e.IsRewarded)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (e *VideoExt) NKeys() int { return 0 }
