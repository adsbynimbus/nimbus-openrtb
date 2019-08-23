package twofive

import "github.com/francoispqt/gojay"

// Geo object encapsulates various methods for specifying a geographic location. When subordinate to a
// Device object, it indicates the location of the device which can also be interpreted as the user’s current
// location. When subordinate to a User object, it indicates the location of the user’s home base (i.e., not
// necessarily their current location).
type Geo struct {
	Lat       float64 `json:"lat,omitempty"       valid:"required"`
	Lon       float64 `json:"lon,omitempty"       valid:"required"`
	Type      int     `json:"type,omitempty"      valid:"range(1|3),optional"`    // 1,2,3 -> GPS/Location Services, IP Address, User provided (e.g., registration data)
	IPService int     `json:"ipservice,omitempty" valid:"range(1|4),optional"`    // 1,2,3,4 -> ip2location, Neustar (Quova), MaxMind, NetAcuity (Digital Element)
	Country   string  `json:"country,omitempty"   valid:"ISO3166Alpha3,optional"` // alpha 3
	City      string  `json:"city,omitempty"      valid:"optional"`
	Metro     string  `json:"metro,omitempty"     valid:"optional"`
	State     string  `json:"state,omitempty"     valid:"optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (g *Geo) MarshalJSONObject(enc *gojay.Encoder) {
	enc.Float64KeyOmitEmpty("lat", g.Lat)
	enc.Float64KeyOmitEmpty("lon", g.Lon)
	enc.IntKeyOmitEmpty("type", g.Type)
	enc.IntKeyOmitEmpty("ipservice", g.IPService)
	enc.StringKeyOmitEmpty("country", g.Country)
	enc.StringKeyOmitEmpty("city", g.City)
	enc.StringKeyOmitEmpty("metro", g.Metro)
	enc.StringKeyOmitEmpty("state", g.State)
}

// IsNil checks if instance is nil
func (g *Geo) IsNil() bool {
	return g == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (g *Geo) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "lat":
		return dec.Float64(&g.Lat)

	case "lon":
		return dec.Float64(&g.Lon)

	case "type":
		return dec.Int(&g.Type)

	case "ipservice":
		return dec.Int(&g.IPService)

	case "country":
		return dec.String(&g.Country)

	case "city":
		return dec.String(&g.City)

	case "metro":
		return dec.String(&g.Metro)

	case "state":
		return dec.String(&g.State)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (g *Geo) NKeys() int { return 0 }
