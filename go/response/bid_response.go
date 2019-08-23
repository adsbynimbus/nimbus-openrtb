package response

import "github.com/francoispqt/gojay"

// Bid represents what Nimbus responds with and is unique to the Nimbus environment
type Bid struct {
	Type           string    `json:"type"`
	AuctionID      string    `json:"auction_id"`
	BidInCents     int       `json:"bid_in_cents"`
	ContentType    string    `json:"content_type"`
	Height         int       `json:"height,omitempty"`
	Width          int       `json:"width,omitempty"`
	IsInterstitial int       `json:"is_interstitial"`
	Markup         string    `json:"markup"`
	Network        string    `json:"network"`
	Trackers       *Trackers `json:"trackers,omitempty"`
	PlacementID    string    `json:"placement_id,omitempty"`
}

// Trackers provides a forward thinking impression structure that clients have to fire
type Trackers struct {
	ImpressionTrackers []string `json:"impression_trackers,omitempty"`
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (r *Bid) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "type":
		return dec.String(&r.Type)

	case "auction_id":
		return dec.String(&r.AuctionID)

	case "bid_in_cents":
		return dec.Int(&r.BidInCents)

	case "content_type":
		return dec.String(&r.ContentType)

	case "height":
		return dec.Int(&r.Height)

	case "width":
		return dec.Int(&r.Width)

	case "is_interstitial":
		return dec.Int(&r.IsInterstitial)

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

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (r *Bid) NKeys() int { return 0 }

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (t *Trackers) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "impression_trackers":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			t.ImpressionTrackers = []string(aSlice)
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (t *Trackers) NKeys() int { return 0 }
