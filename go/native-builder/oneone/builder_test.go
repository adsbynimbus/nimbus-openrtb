package oneone

import (
	"reflect"
	"testing"

	"github.com/google/go-cmp/cmp"
)

func TestBuildDefaultImageNative(t *testing.T) {
	type args struct {
		hmin int
		wmin int
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			name: "should build a native-builder request just fine",
			args: args{
				hmin: 300,
				wmin: 250,
			},
			want: `{"assets":[{"id":1,"img":{"hmin":250,"type":3,"wmin":300,"mimes":["image/jpeg","image/png","image/gif"]},"title":{"len":140},"data":{"type":2,"len":140},"required":1}],"plcmttype":11,"plcmtcnt":1,"required":1,"ver":"1.1"}`,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := BuildDefaultImageNative(tt.args.hmin, tt.args.wmin); !cmp.Equal(got, tt.want) {
				t.Errorf("BuildDefaultImageNative() = %v, want %v", got, tt.want)
			}
		})
	}
}

var s string

// BenchmarkBuildDefaultImageNative-12    	 2000000	       949 ns/op	     496 B/op	       6 allocs/op
func BenchmarkBuildDefaultImageNative(b *testing.B) {
	for i := 0; i < b.N; i++ {
		s = BuildDefaultImageNative(300, 250)
	}
}

func deepAllowUnexported(vs ...interface{}) cmp.Option {
	m := make(map[reflect.Type]struct{})
	for _, v := range vs {
		structTypes(reflect.ValueOf(v), m)
	}
	var typs []interface{}
	for t := range m {
		typs = append(typs, reflect.New(t).Elem().Interface())
	}
	return cmp.AllowUnexported(typs...)
}

func structTypes(v reflect.Value, m map[reflect.Type]struct{}) {
	if !v.IsValid() {
		return
	}
	switch v.Kind() {
	case reflect.Ptr:
		if !v.IsNil() {
			structTypes(v.Elem(), m)
		}
	case reflect.Interface:
		if !v.IsNil() {
			structTypes(v.Elem(), m)
		}
	case reflect.Slice, reflect.Array:
		for i := 0; i < v.Len(); i++ {
			structTypes(v.Index(i), m)
		}
	case reflect.Map:
		for _, k := range v.MapKeys() {
			structTypes(v.MapIndex(k), m)
		}
	case reflect.Struct:
		m[v.Type()] = struct{}{}
		for i := 0; i < v.NumField(); i++ {
			structTypes(v.Field(i), m)
		}
	}
}
