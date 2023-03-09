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
	Source *Source    `json:"source,omitempty"  valid:"optional"`
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
	enc.ObjectKey("user", &r.User)
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
	enc.ObjectKeyOmitEmpty("source", r.Source)
	enc.ObjectKeyOmitEmpty("regs", &r.Regs)
	enc.ObjectKeyOmitEmpty("ext", &r.Ext)
}

// IsNil checks if instance is nil
func (r *Request) IsNil() bool {
	return r == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (r *Request) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {

	case "imp":
		var aSlice = Imps{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			r.Imp = []Imp(aSlice)
		}
		return err

	case "app":
		err := dec.Object(&r.App)

		return err

	case "device":
		err := dec.Object(&r.Device)

		return err

	case "format":
		var format Format
		err := dec.Object(&format)
		if err == nil {
			r.Format = &format
		}
		return err

	case "user":
		err := dec.Object(&r.User)

		return err

	case "test":
		return dec.Int(&r.Test)

	case "wseat":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			r.WSeat = []string(aSlice)
		}
		return err

	case "bseat":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			r.BSeat = []string(aSlice)
		}
		return err

	case "wlang":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			r.Wlang = []string(aSlice)
		}
		return err

	case "bcat":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			r.Bcat = []string(aSlice)
		}
		return err

	case "badv":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			r.BAdv = []string(aSlice)
		}
		return err

	case "bapp":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			r.BApp = []string(aSlice)
		}
		return err

	case "source":
		var source Source
		err := dec.Object(&source)
		if err == nil {
			r.Source = &source
		}
		return err

	case "regs":
		err := dec.Object(&r.Regs)

		return err

	case "ext":
		err := dec.Object(&r.Ext)

		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (r *Request) NKeys() int { return 0 }

// MarshalJSONObject implements MarshalerJSONObject
func (e *RequestExt) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("api_key", e.APIKey)
	enc.StringKeyOmitEmpty("session_id", e.SessionID)
}

// IsNil checks if instance is nil
func (e *RequestExt) IsNil() bool {
	return e == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (e *RequestExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "api_key":
		return dec.String(&e.APIKey)

	case "session_id":
		return dec.String(&e.SessionID)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (e *RequestExt) NKeys() int { return 0 }
