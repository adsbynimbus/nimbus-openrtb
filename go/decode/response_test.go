package decode

import (
	"bytes"
	"compress/flate"
	"compress/gzip"
	"encoding/json"
	"io/ioutil"
	"net/http"
	"testing"

	"github.com/adsbynimbus/nimbus-openrtb/go/response"
	"github.com/google/go-cmp/cmp"
)

var jsonResponseTestBody = []byte(`{"type":"facebook","auction_id":"7d1a4f2b-b7b2-445e-b1f9-61e7ce56ef48","bid_in_cents":100,"bid_raw":0,"content_type":"application/json; charset=utf-8","is_interstitial":1,"is_mraid":0,"markup":"{\"type\":\"ID\",\"bid_id\":\"2762638018393877168\",\"placement_id\":\"IMG_16_9_LINK#191445434271484_1906402376109106\",\"resolved_placement_id\":\"IMG_16_9_LINK#191445434271484_1906402376109106\",\"sdk_version\":\"4.99.1\",\"device_id\":\"0F9DC9F9-C7E7-4579-A945-88A87BDF91E8\",\"template\":200,\"payload\":null}","network":"facebook","trackers":{"impression_trackers":["foobar.com"],"click_trackers":["foobar.com"]},"placement_id":"IMG_16_9_LINK#191445434271484_1906402376109106"}`)

func TestResponseToStruct(t *testing.T) {
	// gzipped response
	var b bytes.Buffer
	gzipw := gzip.NewWriter(&b)
	gzipw.Write(jsonResponseTestBody)
	gzipw.Close()

	header := make(http.Header)
	header.Add("Content-Encoding", gzipHeader)

	// flated response, which is gzip without the error handling
	var b2 bytes.Buffer
	flatew, _ := flate.NewWriter(&b2, flate.BestSpeed)
	flatew.Write(jsonResponseTestBody)
	flatew.Close()

	header2 := make(http.Header)
	header2.Add("Content-Encoding", deflateHeader)

	type args struct {
		res *http.Response
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
				&http.Response{
					Header: header,
					Body:   ioutil.NopCloser(bytes.NewReader(b.Bytes())),
				},
			},
			want:    jsonResponseTestBody,
			wantErr: false,
		},
		{
			name: "should decode the body when the content-encoding header is set and flate",
			args: args{
				&http.Response{
					Header: header2,
					Body:   ioutil.NopCloser(bytes.NewReader(b2.Bytes())),
				},
			},
			want:    jsonResponseTestBody,
			wantErr: false,
		},
		{
			name: "should decode the body when the content-encoding unset",
			args: args{
				&http.Response{
					Body: ioutil.NopCloser(bytes.NewReader(jsonResponseTestBody)),
				},
			},
			want:    jsonResponseTestBody,
			wantErr: false,
		},
		{
			name: "should not decode the body because the header is missing, but the content is gzipped",
			args: args{
				&http.Response{
					Body: ioutil.NopCloser(bytes.NewReader(b.Bytes())),
				},
			},
			want:    b.Bytes(),
			wantErr: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			var br response.Bid
			err := ResponseToStruct(tt.args.res, &br)
			if (err != nil) != tt.wantErr {
				t.Errorf("ResponseToStruct() error = %v, wantErr %v", err, tt.wantErr)
				return
			}

			if !tt.wantErr {
				got, _ := json.Marshal(br)
				if !cmp.Equal(got, tt.want) {
					t.Errorf("ResponseToStruct() got = %s, want %s", got, tt.want)
				}
			}
		})
	}
}

func TestResponseToBytes(t *testing.T) {
	// gzipped response
	var b bytes.Buffer
	gzipw := gzip.NewWriter(&b)
	gzipw.Write(jsonResponseTestBody)
	gzipw.Close()

	header := make(http.Header)
	header.Add("Content-Encoding", gzipHeader)

	// flated response, which is gzip without the error handling
	var b2 bytes.Buffer
	flatew, _ := flate.NewWriter(&b2, flate.BestSpeed)
	flatew.Write(jsonResponseTestBody)
	flatew.Close()

	header2 := make(http.Header)
	header2.Add("Content-Encoding", deflateHeader)

	type args struct {
		res *http.Response
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
				&http.Response{
					Header: header,
					Body:   ioutil.NopCloser(bytes.NewReader(b.Bytes())),
				},
			},
			want:    jsonResponseTestBody,
			wantErr: false,
		},
		{
			name: "should decode the body when the content-encoding header is set and flate",
			args: args{
				&http.Response{
					Header: header2,
					Body:   ioutil.NopCloser(bytes.NewReader(b2.Bytes())),
				},
			},
			want:    jsonResponseTestBody,
			wantErr: false,
		},
		{
			name: "should decode the body when the content-encoding unset",
			args: args{
				&http.Response{
					Body: ioutil.NopCloser(bytes.NewReader(jsonResponseTestBody)),
				},
			},
			want:    jsonResponseTestBody,
			wantErr: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := ResponseToBytes(tt.args.res)
			if (err != nil) != tt.wantErr {
				t.Errorf("ResponseToBytes() error = %v, wantErr %v", err, tt.wantErr)
				return
			}

			if !tt.wantErr {
				if !cmp.Equal(got, tt.want) {
					t.Errorf("ResponseToBytes() got = %s, want %s", got, tt.want)
				}
			}
		})
	}
}
