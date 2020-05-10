package oneone

import (
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
			name: "should build a native request just fine",
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

// BenchmarkBuildDefaultImageNative-12    	 2000000	       949 ns/op	     496 B/op	       6 allocs/op
func BenchmarkBuildDefaultImageNative(b *testing.B) {
	var s string
	_ = s
	for i := 0; i < b.N; i++ {
		s = BuildDefaultImageNative(300, 250)
	}
}
