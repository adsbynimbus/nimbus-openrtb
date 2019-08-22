package twofive

import "github.com/francoispqt/gojay"

// Header required in RTB requests
const (
	Header  = "x-openrtb-version"
	Version = "2.5"

	EncodingHeader = "Content-Encoding"
	EncodingValue  = "gzip"
)

// Request openRTB 2.5 spec
type Request struct {
	Imp    []Imp      `json:"imp"               valid:"required"`
	App    App        `json:"app"               valid:"required"`
	Device Device     `json:"device"            valid:"required"`
	Format *Format    `json:"format"            valid:"required"` // this is not part of the spec, adding this here for convience allows h and width to be passed without the video/banner object to backwards support the GET
	User   User       `json:"user,omitempty"    valid:"optional"`
	Test   int        `json:"test,omitempty"    valid:"range(0|1),optional"`
	WSeat  []string   `json:"wseat,omitempty"   valid:"optional"`
	BSeat  []string   `json:"bseat,omitempty"   valid:"optional"`
	Wlang  []string   `json:"wlang,omitempty"   valid:"optional"`
	Bcat   []string   `json:"bcat,omitempty"    valid:"optional"`
	BAdv   []string   `json:"badv,omitempty"    valid:"optional"`
	BApp   []string   `json:"bapp,omitempty"    valid:"optional"`
	Source Source     `json:"source,omitempty"  valid:"optional"`
	Regs   Regs       `json:"regs,omitempty"    valid:"optional"`
	Ext    RequestExt `json:"ext,omitempty"     valid:"required"`
}

// RequestExt used to communicate the publishers api key to nimbus
type RequestExt struct {
	APIKey    string `json:"api_key,omitempty"     valid:"uuidv4,required"`
	SessionID string `json:"session_id,omitempty"  valid:"required"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (r *Request) MarshalJSONObject(enc *gojay.Encoder) {
	var impSlice = Imps(r.Imp)
	enc.ArrayKey("imp", impSlice)
	enc.ObjectKey("app", &r.App)
	enc.ObjectKey("device", &r.Device)
	enc.ObjectKeyOmitEmpty("format", r.Format)
	enc.ObjectKeyOmitEmpty("user", &r.User)
	enc.IntKeyOmitEmpty("test", r.Test)
	var wSeatSlice = Strings(r.WSeat)
	enc.ArrayKeyOmitEmpty("wseat", wSeatSlice)
	var bSeatSlice = Strings(r.BSeat)
	enc.ArrayKeyOmitEmpty("bseat", bSeatSlice)
	var wlangSlice = Strings(r.Wlang)
	enc.ArrayKeyOmitEmpty("wlang", wlangSlice)
	var bcatSlice = Strings(r.Bcat)
	enc.ArrayKeyOmitEmpty("bcat", bcatSlice)
	var bAdvSlice = Strings(r.BAdv)
	enc.ArrayKeyOmitEmpty("badv", bAdvSlice)
	var bAppSlice = Strings(r.BApp)
	enc.ArrayKeyOmitEmpty("bapp", bAppSlice)
	enc.ObjectKey("source", &r.Source)
	enc.ObjectKeyOmitEmpty("regs", &r.Regs)
	enc.ObjectKeyOmitEmpty("ext", &r.Ext)
}

// IsNil checks if instance is nil
func (r *Request) IsNil() bool {
	return r == nil
}

// MarshalJSONObject implements MarshalerJSONObject
func (e *RequestExt) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("api_key", e.APIKey)
	enc.StringKeyOmitEmpty("session_id", e.SessionID)
}

// IsNil checks if instance is nil
func (e *RequestExt) IsNil() bool {
	return e == nil
}
