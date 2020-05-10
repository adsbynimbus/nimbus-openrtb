package request

import (
	"github.com/francoispqt/gojay"
)

// Version of the request string
const Version = "1.1"

// Request is the structure for the 1.1 json string request in the RTB spec
type Request struct {
	Assets    []Asset `json:"assets"`
	Plcmttype int     `json:"plcmttype"`
	Plcmtcnt  int     `json:"plcmtcnt"`
	Required  int     `json:"required"` // should default to 1
	Ver       string  `json:"ver"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (r *Request) MarshalJSONObject(enc *gojay.Encoder) {
	var assetSlice = Assets(r.Assets)
	enc.ArrayKey("assets", assetSlice)
	enc.IntKey("plcmttype", r.Plcmttype)
	enc.IntKey("plcmtcnt", r.Plcmtcnt)
	enc.IntKey("required", r.Required)
	enc.StringKey("ver", r.Ver)
}

// IsNil checks if instance is nil
func (r *Request) IsNil() bool {
	return r == nil
}
