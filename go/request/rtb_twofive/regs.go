package twofive

import "github.com/francoispqt/gojay"

// Regs object contains any legal, governmental, or industry regulations that apply to the request. The
// coppa flag signals whether or not the request falls under the United States Federal Trade Commission’s
// regulations for the United States Children’s Online Privacy Protection Act (“COPPA”).
type Regs struct {
	Coppa int      `json:"coppa" valid:"range(0|1),optional"`
	Ext   *RegsExt `json:"ext"   valid:"optional"`
}

// RegsExt being used for GDPR
type RegsExt struct {
	GDPR int `json:"gdpr" valid:"range(0|1),optional"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (r *Regs) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("coppa", r.Coppa)
	enc.ObjectKeyNullEmpty("ext", r.Ext)
}

// IsNil checks if instance is nil
func (r *Regs) IsNil() bool {
	return r == nil
}

// MarshalJSONObject implements MarshalerJSONObject
func (e *RegsExt) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("gdpr", e.GDPR)
}

// IsNil checks if instance is nil
func (e *RegsExt) IsNil() bool {
	return e == nil
}
