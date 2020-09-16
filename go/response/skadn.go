package response

import "github.com/francoispqt/gojay"

type Skadn struct {
	Version    string `json:"version"       valid:"optional"`
	Network    string `json:"network"       valid:"optional"`
	Campaign   string `json:"campaign"      valid:"required"`
	Itunesitem string `json:"itunesitem"    valid:"required"`
	Nonce      string `json:"nonce"         valid:"required"`
	Sourceapp  string `json:"sourceapp"     valid:"required"`
	Timestamp  string `json:"timestamp"     valid:"optional"`
	Signature  string `json:"signature"     valid:"optional"`
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (s *Skadn) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "version":
		return dec.String(&s.Version)

	case "network":
		return dec.String(&s.Network)

	case "campaign":
		return dec.String(&s.Campaign)

	case "itunesitem":
		return dec.String(&s.Itunesitem)

	case "nonce":
		return dec.String(&s.Nonce)

	case "sourceapp":
		return dec.String(&s.Sourceapp)

	case "timestamp":
		return dec.String(&s.Timestamp)

	case "signature":
		return dec.String(&s.Signature)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (s *Skadn) NKeys() int { return 0 }
