package oneone

import (
	"github.com/francoispqt/gojay"
	"github.com/timehop/nimbus-openrtb/go/pool"
	"github.com/timehop/nimbus-openrtb/go/request/native/oneone/request"
)

// BuildDefaultImageNative creatives a Native RTB Request string 1.1 with many defaults pre set
func BuildDefaultImageNative(wmin, hmin int) string {
	r := request.Request{
		Plcmttype: 11,
		Plcmtcnt:  1,
		Ver:       request.Version,
		Required:  1,
		Assets: []request.Asset{
			request.Asset{
				ID: 1,
				Img: request.Img{
					Hmin: hmin,
					Wmin: wmin,
					Type: 3,
					Mimes: []string{
						"image/jpeg",
						"image/png",
						"image/gif",
					},
				},
				Title: request.Title{
					Len: 140,
				},
				Data: request.Data{
					Type: 2,
					Len:  140,
				},
				Required: 1,
			},
		},
	}

	b := pool.GetBuffer()
	defer pool.PutBuffer(b)

	enc := gojay.BorrowEncoder(b)
	defer enc.Release()

	err := enc.Encode(&r)
	if err != nil {
		return ""
	}
	return b.String()
}
