package twofive

import "github.com/francoispqt/gojay"

// EID is a higher level wrapper for vendor identifiers
type EID struct {
	Source string `json:"source"`
	UIDS   UIDS   `json:"uids"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (e *EID) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("source", e.Source)
	enc.ArrayKeyOmitEmpty("uids", e.UIDS)
}

// IsNil checks if instance is nil
func (e *EID) IsNil() bool {
	return e == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (e *EID) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {
	switch k {
	case "source":
		return dec.String(&e.Source)

	case "uids":
		var aSlice = UIDS{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			e.UIDS = aSlice
		}
		return err
	}
	return nil
}

// NKeys returns the number of keys to unmarshal, by returning 0 we are saying to return all keys for marshalling
func (e *EID) NKeys() int { return 0 }

// EIDS defines a slice of EID
type EIDS []EID

// UnmarshalJSONArray implements gojay's array Unmarshaler
func (e *EIDS) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value = EID{}
	if err := dec.Object(&value); err != nil {
		return err
	}
	*e = append(*e, value)
	return nil
}

// MarshalJSONArray ...
func (e EIDS) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range e {
		enc.Object(&e[i])
	}
}

// IsNil checks if instance is nil
func (e EIDS) IsNil() bool {
	return len(e) == 0
}

// UID defines metadata for vendors
type UID struct {
	ID  string       `json:"id"`
	Ext *IdentityExt `json:"ext"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (u *UID) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("id", u.ID)
	enc.ObjectKeyOmitEmpty("ext", u.Ext)
}

// IsNil checks if instance is nil
func (u *UID) IsNil() bool {
	return u == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (u *UID) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {
	switch k {
	case "id":
		return dec.String(&u.ID)

	case "ext":
		var identityExt IdentityExt
		err := dec.Object(&identityExt)
		if err == nil {
			u.Ext = &identityExt
		}
		return err
	}
	return nil
}

// NKeys returns the number of keys to unmarshal, by returning 0 we are saying to return all keys for marshalling
func (u *UID) NKeys() int { return 0 }

// UIDS defines a slice of UID
type UIDS []UID

// UnmarshalJSONArray implements gojay's array Unmarshaler
func (u *UIDS) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value = UID{}
	if err := dec.Object(&value); err != nil {
		return err
	}
	*u = append(*u, value)
	return nil
}

// MarshalJSONArray ...
func (u UIDS) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range u {
		enc.Object(&u[i])
	}
}

// IsNil provides on abstraction to determine if the object is empty
func (u UIDS) IsNil() bool {
	return len(u) == 0
}

type IdentityExt struct {
	RTIPartner string `json:"rtiPartner"`
}

// MarshalJSONObject implements MarshalerJSONObject
func (i *IdentityExt) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("rtiPartner", i.RTIPartner)
}

// IsNil checks if instance is nil
func (i *IdentityExt) IsNil() bool {
	return i == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (i *IdentityExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {
	switch k {
	case "rtiPartner":
		return dec.String(&i.RTIPartner)
	}
	return nil
}

// NKeys returns the number of keys to unmarshal, by returning 0 we are saying to return all keys for marshalling
func (i *IdentityExt) NKeys() int { return 0 }
