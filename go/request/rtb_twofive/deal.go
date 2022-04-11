package twofive

import "github.com/francoispqt/gojay"

// Deal object constitutes a specific deal that was struck a priori between a buyer and a seller. Its presence
// with the Pmp collection indicates that this impression is available under the terms of that deal. Refer to
// Section 7.3 for more details.
type Deal struct {
	ID          string   `json:"id"                    valid:"required"`
	BidFloor    float64  `json:"bidfloor,omitempty"    valid:"-"`
	BidFloorCur string   `json:"bidfloorcur,omitempty"  valid:"-"`
	At          int      `json:"at,omitempty"          valid:"range(1|3),optional"` // 1 = first price, 2 = second price, 3 = value passed in the bid floor is the agreed upon deal price
	WSeat       []string `json:"wseat,omitempty"       valid:"-"`
	WAdomain    []string `json:"wadomain,omitempty"    valid:"-"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (d *Deal) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKey("id", d.ID)
	enc.Float64KeyOmitEmpty("bidfloor", d.BidFloor)
	enc.StringKeyOmitEmpty("bidfloorcur", d.BidFloorCur)
	enc.IntKeyOmitEmpty("at", d.At)
	var wSeatSlice = Strings(d.WSeat)
	enc.ArrayKeyOmitEmpty("wseat", wSeatSlice)
	var wAdomainSlice = Strings(d.WAdomain)
	enc.ArrayKeyOmitEmpty("wadomain", wAdomainSlice)
}

// IsNil checks if instance is nil
func (d *Deal) IsNil() bool {
	return d == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (d *Deal) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "id":
		return dec.String(&d.ID)

	case "bidfloor":
		return dec.Float64(&d.BidFloor)

	case "at":
		return dec.Int(&d.At)

	case "wseat":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			d.WSeat = []string(aSlice)
		}
		return err

	case "wadomain":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			d.WAdomain = []string(aSlice)
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal, by returning 0 we are saying to return all keys for marshalling
func (d *Deal) NKeys() int { return 0 }

// Deals ...
type Deals []Deal

// UnmarshalJSONArray ...
func (s *Deals) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value = Deal{}
	if err := dec.Object(&value); err != nil {
		return err
	}
	*s = append(*s, value)
	return nil
}

// MarshalJSONArray ...
func (s Deals) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range s {
		enc.Object(&s[i])
	}
}

// IsNil ...
func (s Deals) IsNil() bool {
	return len(s) == 0
}
