package request

import (
	"bytes"
	"encoding/json"
	"testing"

	"github.com/francoispqt/gojay"
	"github.com/google/go-cmp/cmp"
)

func TestBidRequestMarshalling(t *testing.T) {
	request := Request{
		Plcmttype: 11,
		Plcmtcnt:  1,
		Ver:       Version,
		Required:  1,
		Assets: []Asset{
			Asset{
				ID: 1,
				Img: Img{
					Hmin: 320,
					Type: 3,
					Wmin: 480,
					Mimes: []string{
						"image/jpeg",
						"image/png",
						"image/gif",
					},
				},
				Title: Title{
					Len: 140,
				},
				Data: Data{
					Type: 2,
					Len:  140,
				},
				Required: 1,
			},
		},
	}

	tests := []struct {
		name       string
		bidRequest Request
	}{
		{
			name:       "json marshal and gojay marshal should output the same way",
			bidRequest: request,
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			regJSON, err := json.Marshal(tt.bidRequest)
			if err != nil {
				t.Fatalf("json.Marshal failed %v", err)
			}

			b := new(bytes.Buffer)
			enc := gojay.BorrowEncoder(b)
			err = enc.Encode(&request)
			defer enc.Release()
			if err != nil {
				t.Fatalf("gojay.Marshal failed %v", err)
			}
			gojayJSON := b.Bytes()

			if !cmp.Equal(regJSON, gojayJSON) {
				t.Errorf("TestBidRequestMarshalling()\ndiff\n%+v", cmp.Diff(string(regJSON), string(gojayJSON)))
			}
		})
	}
}
