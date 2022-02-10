package response

import (
	"github.com/francoispqt/gojay"
)

// Bid represents what Nimbus responds with and is unique to the Nimbus environment
type Bid struct {
	Type           string    `json:"type"`
	AuctionID      string    `json:"auction_id"`
	Adomain        []string  `json:"adomain,omitempty"`
	BidInCents     int       `json:"bid_in_cents"`
	BidRaw         float64   `json:"bid_raw"`
	ContentType    string    `json:"content_type"`
	Crid           string    `json:"crid,omitempty"`
	Height         int       `json:"height,omitempty"`
	Width          int       `json:"width,omitempty"`
	IsInterstitial int       `json:"is_interstitial"`
	IsMraid        int       `json:"is_mraid"`
	Markup         string    `json:"markup"`
	Network        string    `json:"network"`
	Trackers       *Trackers `json:"trackers,omitempty"`
	PlacementID    string    `json:"placement_id,omitempty"`
	Duration       int       `json:"duration,omitempty"`
	Ext            *BidExt   `json:"ext,omitempty"`
}

type BidExt struct {
	Skadn *Skadn `json:"skadn,omitempty"`
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (r *Bid) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "type":
		return dec.String(&r.Type)

	case "auction_id":
		return dec.String(&r.AuctionID)

	case "adomain":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			r.Adomain = []string(aSlice)
		}
		return err

	case "bid_in_cents":
		return dec.Int(&r.BidInCents)

	case "bid_raw":
		return dec.Float(&r.BidRaw)

	case "content_type":
		return dec.String(&r.ContentType)

	case "crid":
		return dec.String(&r.Crid)

	case "height":
		return dec.Int(&r.Height)

	case "width":
		return dec.Int(&r.Width)

	case "is_interstitial":
		return dec.Int(&r.IsInterstitial)

	case "is_mraid":
		return dec.Int(&r.IsMraid)

	case "markup":
		return dec.String(&r.Markup)

	case "network":
		return dec.String(&r.Network)

	case "trackers":
		var value = &Trackers{}
		err := dec.Object(value)
		if err == nil {
			r.Trackers = value
		}

		return err

	case "placement_id":
		return dec.String(&r.PlacementID)

	case "duration":
		return dec.Int(&r.Duration)

	case "ext":
		var value = &BidExt{}
		err := dec.Object(value)
		if err == nil {
			r.Ext = value
		}

		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (r *Bid) NKeys() int { return 0 }

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (e *BidExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "skadn":
		var value = &Skadn{}
		err := dec.Object(value)
		if err == nil {
			e.Skadn = value
		}

		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (e *BidExt) NKeys() int { return 0 }
