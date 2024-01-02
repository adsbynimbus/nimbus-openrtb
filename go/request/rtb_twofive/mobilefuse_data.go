package twofive

import (
	"github.com/francoispqt/gojay"
)

type MobileFuseData map[string]string

// MarshalJSONObject implements MarshalerJSONObject
func (m *MobileFuseData) MarshalJSONObject(enc *gojay.Encoder) {
	if m != nil {
		for k, v := range *m {
			enc.StringKey(k, v)
		}
	}
}

// IsNil checks if instance is nil
func (m *MobileFuseData) IsNil() bool {
	return m == nil || len(*m) == 0
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (m *MobileFuseData) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {
	if m == nil || *m == nil {
		*m = make(MobileFuseData)
	}
	var value string
	if err := dec.String(&value); err == nil {
		tmp := *m
		tmp[k] = value
		*m = tmp
	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (m *MobileFuseData) NKeys() int { return 0 }
