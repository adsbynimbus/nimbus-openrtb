package twofive

import "github.com/francoispqt/gojay"

// Device object provides information pertaining to the device through which the user is interacting. Device
// information includes its hardware, platform, location, and carrier data. The device can refer to a mobile
// handset, a desktop computer, set top box, or other digital device.
type Device struct {
	Ua             string `json:"ua"                        valid:"required"`
	Geo            *Geo   `json:"geo,omitempty"             valid:"optional"`
	Dnt            int    `json:"dnt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking is restricted
	Lmt            int    `json:"lmt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking must be limited by commercial guidelines
	IP             string `json:"ip"                        valid:"ipv4,optional"`
	DeviceType     int    `json:"devicetype,omitempty"      valid:"required"`
	Make           string `json:"make,omitempty"            valid:"optional"`
	Model          string `json:"model,omitempty"           valid:"optional"`
	OS             string `json:"os,omitempty"              valid:"in(android|ios),required"`
	OSV            string `json:"osv,omitempty"             valid:"optional"`
	H              int    `json:"h,omitempty"               valid:"optional"`
	W              int    `json:"w,omitempty"               valid:"optional"`
	Language       string `json:"language,omitempty"        valid:"optional"`
	Carrier        string `json:"carrier,omitempty"         valid:"optional"`
	ConnectionType int    `json:"connectiontype,omitempty"  valid:"optional"`
	Ifa            string `json:"ifa"                       valid:"required"`
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
	enc.StringKeyOmitEmpty("os", d.OS)
	enc.StringKeyOmitEmpty("osv", d.OSV)
	enc.IntKeyOmitEmpty("h", d.H)
	enc.IntKeyOmitEmpty("w", d.W)
	enc.StringKeyOmitEmpty("language", d.Language)
	enc.StringKeyOmitEmpty("carrier", d.Carrier)
	enc.IntKeyOmitEmpty("connectiontype", d.ConnectionType)
	enc.StringKey("ifa", d.Ifa)
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
	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (d *Device) NKeys() int { return 0 }
