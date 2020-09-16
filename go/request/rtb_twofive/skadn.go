package twofive

import "github.com/francoispqt/gojay"

// Skadn is used for direct SSP to DSP connections where a DSP wants to only consume their own relevant SKAdNetwork IDs.
// Object should only be present if both the SSP SDK version and the OS version (iOS 14.0+) support SKAdNetwork.
type Skadn struct {
	Version    string   `json:"version,omitempty"    valid:"optional"` // Version of skadnetwork supported. Always "2.0" or higher. Dependent on both the OS version and the SDK version.
	SourceApp  string   `json:"sourceapp,omitempty"  valid:"required"` // ID of publisher app in Apple’s App Store. Should match app.bundle in OpenRTB 2.x and app.storeid in AdCOM 1.x
	Skadnetids []string `json:"skadnetids,omitempty" valid:"optional"` // 	A subset of SKAdNetworkItem entries in the publisher app’s Info.plist that are relevant to the DSP. Recommended that this list not exceed 20.
}

// MarshalJSONObject implements MarshalerJSONObject
func (s *Skadn) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("version", s.Version)
	enc.StringKeyOmitEmpty("sourceapp", s.SourceApp)
	var bAppSlice = Strings(s.Skadnetids)
	enc.ArrayKeyOmitEmpty("skadnetids", bAppSlice)
}

// IsNil checks if instance is nil
func (s *Skadn) IsNil() bool {
	return s == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (s *Skadn) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "version":
		return dec.String(&s.Version)

	case "sourceapp":
		return dec.String(&s.SourceApp)

	case "skadnetids":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.Skadnetids = []string(aSlice)
		}
		return err
	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (s *Skadn) NKeys() int { return 0 }
