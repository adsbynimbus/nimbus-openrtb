package decode

import (
	"bytes"
	"compress/flate"
	"compress/gzip"
	"encoding/json"
	"io/ioutil"
	"net/http"
	"testing"

	"github.com/google/go-cmp/cmp"

	twofive "github.com/timehop/nimbus-openrtb/go/request/rtb_twofive"
)

var jsonRequestTestBody = []byte(`{"imp":[{"banner":{"w":320,"h":480,"pos":7,"api":[3,5]},"instl":1,"bidfloor":2}],"app":{"name":"foo","bundle":"bar","domain":"https://foo.com","storeurl":"https://itunes.apple.com/us/app/foo","cat":["IAB14","IAB1","IAB9"],"privacypolicy":1,"paid":0,"publisher":{"name":"foo","domain":"https://foo.com"}},"device":{"ua":"Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4","geo":{"lat":37.751,"lon":-97.822,"ipservice":3,"country":"USA","city":"New York"},"dnt":0,"lmt":0,"ip":"174.193.148.17","make":"Apple","model":"iPhone","os":"ios","osv":"10.3.2","language":"en","carrier":"Verizon","connection_type":6,"ifa":"13579176-e94e-4e6e-96ae-572b787af21c"},"user":{"gender":"male"},"format":{"h":480,"w":360},"at":1,"regs":{"ext":{"gdpr":1,"us_privacy":"1YNY","gpp":"DBABMA~CPXxRfAPXxRfAAfKABENB-CgAAAAAAAAAAYgAAAAAAAA","gpp_sid":"2"}},"ext":{"api_key":"83499783-c452-461f-8c37-43877f859ba3","session_id":"1","position":"pingpong"}}`)

func TestRequestToStruct(t *testing.T) {
	// gzipped request
	var b bytes.Buffer
	gzipw := gzip.NewWriter(&b)
	gzipw.Write(jsonRequestTestBody)
	gzipw.Close()

	header := make(http.Header)
	header.Add("Content-Encoding", gzipHeader)

	// flated request, which is gzip without the error handling
	var b2 bytes.Buffer
	flatew, _ := flate.NewWriter(&b2, flate.BestSpeed)
	flatew.Write(jsonRequestTestBody)
	flatew.Close()

	header2 := make(http.Header)
	header2.Add("Content-Encoding", deflateHeader)

	type args struct {
		res *http.Request
	}
	tests := []struct {
		name    string
		args    args
		want    []byte
		wantErr bool
	}{
		{
			name: "should decode the body when the content-encoding header is set and gzip",
			args: args{
				&http.Request{
					Header: header,
					Body:   ioutil.NopCloser(bytes.NewReader(b.Bytes())),
				},
			},
			want:    jsonRequestTestBody,
			wantErr: false,
		},
		{
			name: "should decode the body when the content-encoding header is set and flate",
			args: args{
				&http.Request{
					Header: header2,
					Body:   ioutil.NopCloser(bytes.NewReader(b2.Bytes())),
				},
			},
			want:    jsonRequestTestBody,
			wantErr: false,
		},
		{
			name: "should decode the body when the content-encoding unset",
			args: args{
				&http.Request{
					Body: ioutil.NopCloser(bytes.NewReader(jsonRequestTestBody)),
				},
			},
			want:    jsonRequestTestBody,
			wantErr: false,
		},
		{
			name: "should not decode the body because the header is missing, but the content is gzipped",
			args: args{
				&http.Request{
					Body: ioutil.NopCloser(bytes.NewReader(b.Bytes())),
				},
			},
			want:    b.Bytes(),
			wantErr: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			var br twofive.Request
			err := RequestToStruct(tt.args.res, &br)
			if (err != nil) != tt.wantErr {
				t.Errorf("RequestToStruct() error = %v, wantErr %v", err, tt.wantErr)
				return
			}

			if !tt.wantErr {
				var wbr twofive.Request
				_ = json.Unmarshal(tt.want, &wbr)
				if !cmp.Equal(br, wbr) {
					t.Errorf("RequestToStruct() got = %v, want %v", br, wbr)
				}
			}
		})
	}
}
