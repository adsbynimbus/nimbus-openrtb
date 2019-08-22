package twofive

import "github.com/francoispqt/gojay"

// Device object provides information pertaining to the device through which the user is interacting. Device
// information includes its hardware, platform, location, and carrier data. The device can refer to a mobile
// handset, a desktop computer, set top box, or other digital device.
type Device struct {
	Ua             string `json:"ua"                        valid:"required"`
	Geo            *Geo   `json:"geo,omitempty"             valid:"optional"`
	Dnt            int    `json:"dnt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking is restricted
	Lmt            int    `json:"lmt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking must be limited by commericial guidelines
	IP             string `json:"ip"                        valid:"ipv4,optional"`
	DeviceType     int    `json:"devicetype,omitempty"      valid:"optional"`
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
	enc.IntKeyOmitEmpty("devicetype", d.DeviceType)
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
