package twofive

import "github.com/francoispqt/gojay"

// Video object represents an in-stream video impression. Many of the fields are non-essential for minimally
// viable transactions, but are included to offer fine control when needed. Video in OpenRTB generally
// assumes compliance with the VAST standard. As such, the notion of companion ads is supported by
// optionally including an array of Banner objects (refer to the Banner object in Section 3.2.3) that define
// these companion ads.
type Video struct {
	BidFloor       *float64 `json:"bidfloor,omitempty"       valid:"optional"`
	Mimes          []string `json:"mimes,omitempty"          valid:"optional"`
	Minduration    int      `json:"minduration"              valid:"optional"`
	Maxduration    int      `json:"maxduration,omitempty"    valid:"optional"`
	Protocols      []int    `json:"protocols,omitempty"      valid:"inintarr(2|3|5|6),optional"` // 1,2,3,4,5,6,7,8,9,10 -> VAST 1.0,VAST 2.0,VAST 3.0,VAST 1.0 Wrapper,VAST 2.0 Wrapper,VAST 3.0 Wrapper,VAST 4.0,VAST 4.0 Wrapper,DAAST 1.0,DAAST 1.0 Wrapper
	W              int      `json:"w,omitempty"              valid:"required"`
	H              int      `json:"h,omitempty"              valid:"required"`
	StartDelay     int      `json:"startdelay"               valid:"optional"`
	Placement      int      `json:"placement,omitempty"      valid:"range(1|5),optional"`            // 1,2,3,4,5 -> In-Stream, In-Banner, In-Article, In-Feed - Found in content, social, or product feeds, Interstitial/Slider/Floating
	Linearity      int      `json:"linearity,omitempty"      valid:"range(1|2),optional"`            // 1,2 -> linear, non linear
	Playbackmethod []int    `json:"playbackmethod,omitempty" valid:"inintarr(1|2|3|4|5|6),optional"` // 1,2,3,4,5,6 - > Initiates on Page Load with Sound On, Initiates on Page Load with Sound Off by Default, Initiates on Click with Sound On, Initiates on Mouse-Over with Sound On, Initiates on Entering Viewport with Sound On, Initiates on Entering Viewport with Sound Off by Default
	Skip           int      `json:"skip"                     valid:"range(0|1),optional"`            // 0 no 1 yes
	Delivery       []int    `json:"Delivery,omitempty"       valid:"range(0|3),optional"`            // 0,1,2,3 -> Unknown, Professionally Produced, Prosumer, User Generated (UGC)
	Pos            int      `json:"pos,omitempty"            valid:"range(0|7),optional"`            // 0,1,2,3,4,5,6,7 -> Unknown,Above the Fold,DEPRECATED - May or may not be initially visible depending on screen size/resolution.,Below the Fold,Header,Footer,Sidebar,Full Screen
	API            []int    `json:"api,omitempty"            valid:"inintarr(1|2|3|4|5|6),optional"`
	MinBitRate     int      `json:"minbitrate,omitempty"     valid:"optional"`
	MaxBitRate     int      `json:"maxbitrate,omitempty"     valid:"optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (v *Video) MarshalJSONObject(enc *gojay.Encoder) {
	if v.BidFloor != nil {
		enc.Float64KeyOmitEmpty("bidfloor", *v.BidFloor)
	}
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
}

// IsNil checks if instance is nil
func (v *Video) IsNil() bool {
	return v == nil
}
