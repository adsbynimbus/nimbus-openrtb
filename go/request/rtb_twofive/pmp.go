package twofive

import "github.com/francoispqt/gojay"

// PMP object is the private marketplace container for direct deals between buyers and sellers that may
// pertain to this impression. The actual deals are represented as a collection of Deal objects. Refer to
// Section 7.3 for more deta
type PMP struct {
	PrivateAuction int    `json:"private_auction" valid:"-"` // 0 = all bids accepted, 1 = bids are restricted to the dleads specified and the terms thereof
	Deals          []Deal `json:"deals,omitempty" valid:"optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (p *PMP) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("private_auction", p.PrivateAuction)
	var dealsSlice = Deals(p.Deals)
	enc.ArrayKeyOmitEmpty("deals", dealsSlice)
}

// IsNil checks if instance is nil
func (p *PMP) IsNil() bool {
	return p == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (p *PMP) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "private_auction":
		return dec.Int(&p.PrivateAuction)

	case "deals":
		var aSlice = Deals{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			p.Deals = []Deal(aSlice)
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal, by returning 0 we are saying to return all keys for marshalling
func (p *PMP) NKeys() int { return 0 }
