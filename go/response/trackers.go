package response

import "github.com/francoispqt/gojay"

// Trackers provides a forward-thinking impression structure that clients have to fire typically handled by the nimbus render sdk
type Trackers struct {
	ImpressionTrackers []string `json:"impression_trackers,omitempty"`
	ClickTrackers      []string `json:"click_trackers,omitempty"`
}

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

	case "click_trackers":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			t.ClickTrackers = []string(aSlice)
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (t *Trackers) NKeys() int { return 0 }
