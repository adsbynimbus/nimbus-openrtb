package twofive

import "github.com/francoispqt/gojay"

// Device object provides information pertaining to the device through which the user is interacting. Device
// information includes its hardware, platform, location, and carrier data. The device can refer to a mobile
// handset, a desktop computer, set top box, or other digital device.
type Device struct {
	Ua             string     `json:"ua"                        valid:"required"`
	Geo            *Geo       `json:"geo,omitempty"             valid:"optional"`
	Dnt            int        `json:"dnt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking is restricted
	Lmt            int        `json:"lmt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking must be limited by commercial guidelines
	IP             string     `json:"ip"                        valid:"ipv4,optional"`
	DeviceType     int        `json:"devicetype,omitempty"      valid:"required"`
	Make           string     `json:"make,omitempty"            valid:"optional"`
	Model          string     `json:"model,omitempty"           valid:"optional"`
	HWV            string     `json:"hwv,omitempty"             valid:"optional"`
	OS             string     `json:"os,omitempty"              valid:"in(android|ios),required"`
	OSV            string     `json:"osv,omitempty"             valid:"optional"`
	H              int        `json:"h,omitempty"               valid:"optional"`
	W              int        `json:"w,omitempty"               valid:"optional"`
	Language       string     `json:"language,omitempty"        valid:"optional"`
	Carrier        string     `json:"carrier,omitempty"         valid:"optional"`
	ConnectionType int        `json:"connectiontype,omitempty"  valid:"optional"`
	Ifa            string     `json:"ifa"                       valid:"required"`
	Ext            *DeviceExt `json:"ext,omitempty"             valid:"optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (d *Device) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKey("ua", d.Ua)
	enc.ObjectKeyOmitEmpty("geo", d.Geo)
	enc.IntKey("dnt", d.Dnt)
	enc.IntKey("lmt", d.Lmt)
	enc.StringKey("ip", d.IP)
	enc.IntKey("devicetype", d.DeviceType)
	enc.StringKeyOmitEmpty("make", d.Make)
	enc.StringKeyOmitEmpty("model", d.Model)
	enc.StringKeyOmitEmpty("hwv", d.HWV)
	enc.StringKeyOmitEmpty("os", d.OS)
	enc.StringKeyOmitEmpty("osv", d.OSV)
	enc.IntKeyOmitEmpty("h", d.H)
	enc.IntKeyOmitEmpty("w", d.W)
	enc.StringKeyOmitEmpty("language", d.Language)
	enc.StringKeyOmitEmpty("carrier", d.Carrier)
	enc.IntKeyOmitEmpty("connectiontype", d.ConnectionType)
	enc.StringKey("ifa", d.Ifa)
	enc.ObjectKeyOmitEmpty("ext", d.Ext)
}

// IsNil checks if instance is nil
func (d *Device) IsNil() bool {
	return d == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (d *Device) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "ua":
		return dec.String(&d.Ua)

	case "geo":
		var geo Geo
		err := dec.Object(&geo)
		if err == nil {
			d.Geo = &geo
		}
		return err

	case "dnt":
		return dec.Int(&d.Dnt)

	case "lmt":
		return dec.Int(&d.Lmt)

	case "ip":
		return dec.String(&d.IP)

	case "devicetype":
		return dec.Int(&d.DeviceType)

	case "make":
		return dec.String(&d.Make)

	case "model":
		return dec.String(&d.Model)

	case "hwv":
		return dec.String(&d.HWV)

	case "os":
		return dec.String(&d.OS)

	case "osv":
		return dec.String(&d.OSV)

	case "h":
		return dec.Int(&d.H)

	case "w":
		return dec.Int(&d.W)

	case "language":
		return dec.String(&d.Language)

	case "carrier":
		return dec.String(&d.Carrier)

	case "connectiontype":
		return dec.Int(&d.ConnectionType)

	case "ifa":
		return dec.String(&d.Ifa)

	case "ext":
		var ext DeviceExt
		err := dec.Object(&ext)
		if err == nil {
			d.Ext = &ext
		}
		return err
	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (d *Device) NKeys() int { return 0 }

// DeviceExt adds extended in IAB support SKAdNetwork.
// If the IDFA is not available, DSPs require an alternative, limited-scope identifier in order to provide
// basic frequency capping functionality to advertisers. The IDFV is the same for apps from the same vendor but
// different across vendors. Please refer to Apple's Guidelines for further information about when it can be accessed and used.
// DSPs may also want to understand what is the status of a user on iOS 14+. The atts field will pass the
// AppTrackingTransparency Framework's authorization status.
type DeviceExt struct {
	Atts int    `json:"atts" valid:"optional"`
	Ifv  string `json:"ifv"  valid:"optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (d *DeviceExt) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("atts", d.Atts)
	enc.StringKeyOmitEmpty("ifv", d.Ifv)
}

// IsNil checks if instance is nil
func (d *DeviceExt) IsNil() bool {
	return d == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (d *DeviceExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "atts":
		return dec.Int(&d.Atts)

	case "ifv":
		return dec.String(&d.Ifv)
	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (d *DeviceExt) NKeys() int { return 0 }
