package client

import (
	"sync"
	"testing"

	"github.com/francoispqt/gojay"
	"github.com/google/go-cmp/cmp"
)

type TestingStructure struct {
	Age        int       `json:"age,omitempty"`
	LargeAge   int32     `json:"large_age,omitempty"`
	LargestAge int64     `json:"largest_age,omitempty"`
	Ages       []int     `json:"ages,omitempty"`
	Name       string    `json:"name,omitempty"`
	Names      []string  `json:"names,omitempty"`
	Money      float64   `json:"money"`
	MoreMoney  []float64 `json:"more_money,omitempty"`
	Data       data      `json:"data,omitempty"`
}

type data struct {
	X string `json:"x,omitempty"`
	Y string `json:"y,omitempty"`
}

func TestMarshalBidRequest(t *testing.T) {
	type args struct {
		v interface{}
	}
	tests := []struct {
		name    string
		args    args
		want    string
		wantErr bool
	}{
		{
			name: "should work just fine",
			args: args{
				v: &TestingStructure{
					Age:        1,
					LargeAge:   10,
					LargestAge: 1000,
					Ages:       []int{1, 2, 3, 4, 5, 6},
					Name:       "foo",
					Names:      []string{"foo", "bar"},
					Money:      1.00,
					MoreMoney:  []float64{10000.00, 1000000.00},
					Data: data{
						X: "candy",
						Y: "land",
					},
				},
			},
			want: `{"age":1,"large_age":10,"largest_age":1000,"ages":[1,2,3,4,5,6],"name":"foo","names":["foo","bar"],"money":1,"more_money":[10000,1000000],"data":{"x":"candy","y":"land"}}`,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := MarshalBidRequest(tt.args.v)
			if (err != nil) != tt.wantErr {
				t.Errorf("MarshalBidRequest() error = %v, wantErr %v", err, tt.wantErr)
				return
			}

			if !cmp.Equal(string(got), tt.want) {
				t.Errorf("MarshalBidRequest() diff=\n %v", cmp.Diff(string(got), tt.want))
			}
		})
	}
}

func init() {
	dataPool = &sync.Pool{
		New: func() interface{} {
			return &data{}
		},
	}
	TestingStructurePool = &sync.Pool{
		New: func() interface{} {
			return &TestingStructure{}
		},
	}
}

var dataPool *sync.Pool
var TestingStructurePool *sync.Pool

type Float64s []float64

// UnmarshalJSONArray decodes JSON array elements into slice
func (a *Float64s) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value float64
	if err := dec.Float64(&value); err != nil {
		return err
	}
	*a = append(*a, value)
	return nil
}

// MarshalJSONArray encodes arrays into JSON
func (a Float64s) MarshalJSONArray(enc *gojay.Encoder) {
	for _, item := range a {
		enc.Float64(item)
	}
}

// IsNil checks if array is nil
func (a Float64s) IsNil() bool {
	return len(a) == 0
}

type Ints []int

// UnmarshalJSONArray decodes JSON array elements into slice
func (a *Ints) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value int
	if err := dec.Int(&value); err != nil {
		return err
	}
	*a = append(*a, value)
	return nil
}

// MarshalJSONArray encodes arrays into JSON
func (a Ints) MarshalJSONArray(enc *gojay.Encoder) {
	for _, item := range a {
		enc.Int(item)
	}
}

// IsNil checks if array is nil
func (a Ints) IsNil() bool {
	return len(a) == 0
}

type Strings []string

// UnmarshalJSONArray decodes JSON array elements into slice
func (a *Strings) UnmarshalJSONArray(dec *gojay.Decoder) error {
	var value string
	if err := dec.String(&value); err != nil {
		return err
	}
	*a = append(*a, value)
	return nil
}

// MarshalJSONArray encodes arrays into JSON
func (a Strings) MarshalJSONArray(enc *gojay.Encoder) {
	for _, item := range a {
		enc.String(item)
	}
}

// IsNil checks if array is nil
func (a Strings) IsNil() bool {
	return len(a) == 0
}

// MarshalJSONObject implements MarshalerJSONObject
func (d *data) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("x", d.X)
	enc.StringKeyOmitEmpty("y", d.Y)
}

// IsNil checks if instance is nil
func (d *data) IsNil() bool {
	return d == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (d *data) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "x":
		return dec.String(&d.X)

	case "y":
		return dec.String(&d.Y)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (d *data) NKeys() int { return 2 }

// Reset reset fields
func (d *data) Reset() {
	d.X = ""
	d.Y = ""
}

// MarshalJSONObject implements MarshalerJSONObject
func (s *TestingStructure) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKeyOmitEmpty("age", s.Age)
	enc.Int32KeyOmitEmpty("large_age", s.LargeAge)
	enc.Int64KeyOmitEmpty("largest_age", s.LargestAge)
	var agesSlice = Ints(s.Ages)
	enc.ArrayKeyOmitEmpty("ages", agesSlice)
	enc.StringKeyOmitEmpty("name", s.Name)
	var namesSlice = Strings(s.Names)
	enc.ArrayKeyOmitEmpty("names", namesSlice)
	enc.Float64Key("money", s.Money)
	var moreMoneySlice = Float64s(s.MoreMoney)
	enc.ArrayKeyOmitEmpty("more_money", moreMoneySlice)
	enc.ObjectKeyOmitEmpty("data", &s.Data)
}

// IsNil checks if instance is nil
func (s *TestingStructure) IsNil() bool {
	return s == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (s *TestingStructure) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "age":
		return dec.Int(&s.Age)

	case "large_age":
		return dec.Int32(&s.LargeAge)

	case "largest_age":
		return dec.Int64(&s.LargestAge)

	case "ages":
		var aSlice = Ints{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.Ages = []int(aSlice)
		}
		return err

	case "name":
		return dec.String(&s.Name)

	case "names":
		var aSlice = Strings{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.Names = []string(aSlice)
		}
		return err

	case "money":
		return dec.Float64(&s.Money)

	case "more_money":
		var aSlice = Float64s{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			s.MoreMoney = []float64(aSlice)
		}
		return err

	case "data":
		err := dec.Object(&s.Data)

		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (s *TestingStructure) NKeys() int { return 9 }

// Reset reset fields
func (s *TestingStructure) Reset() {
	s.Age = 0
	s.LargeAge = 0
	s.LargestAge = 0
	s.Ages = nil
	s.Name = ""
	s.Names = nil
	s.Money = 0.0
	s.MoreMoney = nil
}
