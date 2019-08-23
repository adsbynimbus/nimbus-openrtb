package twofive

import "github.com/francoispqt/gojay"

// Segment objects are essentially key-value pairs that convey specific units of data about the user. The
// parent Data object is a collection of such values from a given data provider. The specific segment
// names and value options must be published by the exchange a priori to its bidders.
type Segment struct {
	ID    string `json:"id,omitempty"    valid:"optional"`
	Name  string `json:"name,omitempty"  valid:"optional"`
	Value string `json:"value,omitempty" valid:"optional"`
}

// Segments ...
type Segments []Segment

// UnmarshalJSONArray ...
func (s *Segments) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value = Segment{}
	if err := dec.Object(&value); err != nil {
		return err
	}
	*s = append(*s, value)
	return nil
}

// MarshalJSONArray ...
func (s Segments) MarshalJSONArray(enc *gojay.Encoder) {
	for i := range s {
		enc.Object(&s[i])
	}
}

// IsNil ...
func (s Segments) IsNil() bool {
	return len(s) == 0
}

// MarshalJSONObject implements MarshalerJSONObject
func (s *Segment) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("id", s.ID)
	enc.StringKeyOmitEmpty("name", s.Name)
	enc.StringKeyOmitEmpty("value", s.Value)
}

// IsNil checks if instance is nil
func (s *Segment) IsNil() bool {
	return s == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (s *Segment) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "id":
		return dec.String(&s.ID)

	case "name":
		return dec.String(&s.Name)

	case "value":
		return dec.String(&s.Value)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (s *Segment) NKeys() int { return 0 }
