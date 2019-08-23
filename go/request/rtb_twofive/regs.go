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

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (r *Regs) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "coppa":
		return dec.Int(&r.Coppa)

	case "ext":
		var regsExt RegsExt
		err := dec.Object(&regsExt)
		if err == nil {
			r.Ext = &regsExt
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (r *Regs) NKeys() int { return 0 }

// MarshalJSONObject implements MarshalerJSONObject
func (e *RegsExt) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKey("gdpr", e.GDPR)
}

// IsNil checks if instance is nil
func (e *RegsExt) IsNil() bool {
	return e == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (e *RegsExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "gdpr":
		return dec.Int(&e.GDPR)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (e *RegsExt) NKeys() int { return 0 }
