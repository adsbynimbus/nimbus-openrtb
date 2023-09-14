package main

import (
	"encoding/json"
	"fmt"
	"log"

	"github.com/adsbynimbus/nimbus-openrtb/go/native-builder/oneone"
	"github.com/adsbynimbus/nimbus-openrtb/go/native-builder/oneone/request"
	twofive "github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive"
)

func main() {
	bidRequest := twofive.Request{
		App: twofive.App{
			Name:     "foo",
			Bundle:   "com.foo",
			Domain:   "foo.com",
			StoreURL: "https://play.google.com/store/apps/details?id=com.foo",
			Cat:      []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
			Publisher: twofive.Publisher{
				Name:   "foo",
				Cat:    []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
				Domain: "foo.com",
			},
		},
		Device: twofive.Device{
			DeviceType:     1,
			Ua:             "Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36",
			IP:             "71.125.59.151",
			Make:           "Pixel 2 XL",
			Model:          "Samsung",
			OS:             "android",
			OSV:            "4.2.4",
			Language:       "en",
			ConnectionType: 6,
			Ifa:            "13579176-e94e-4e6e-96ae-572b787af21c",
		},
		Format: &twofive.Format{
			H: 1920,
			W: 1080,
		},
		User: twofive.User{
			Age:    30,
			YOB:    1991,
			Gender: "male",
		},
		Ext: twofive.RequestExt{
			APIKey:    "3b117631-538d-4315-bc47-d4e8ce6527e5",
			SessionID: "fab5d528-5ac9-4082-a1ff-968a7f8fefc4",
		},
		// creative an impression object with the Native object helpers
		Imp: []twofive.Imp{
			twofive.Imp{
				Instl:    1,
				BidFloor: 1.00,
				Secure:   twofive.IntPointer(1),
				Native: &twofive.Native{
					Request: oneone.BuildDefaultImageNative(300, 250),
					Ver:     request.Version,
				},
			},
		},
	}

	// printing out example of generated body
	b, err := json.MarshalIndent(bidRequest, "", " ")
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(string(b))
}
