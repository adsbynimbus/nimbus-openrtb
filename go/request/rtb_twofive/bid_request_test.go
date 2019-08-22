package twofive

import (
	"bytes"
	"encoding/json"
	"testing"

	"github.com/francoispqt/gojay"
	"github.com/google/go-cmp/cmp"
	"github.com/marcsantiago/govalidator"
	"github.com/timehop/nimbus-openrtb/go/request/requestutil"
)

func TestValidateBidRequest(t *testing.T) {

	tests := []struct {
		name    string
		Request Request
		wantErr bool
	}{
		{
			name: "request should be valid",
			Request: Request{
				App: App{
					Name:     "foo",
					Bundle:   "com.foo",
					Domain:   "foo.com",
					StoreURL: "https://play.google.com/store/apps/details?id=com.foo",
					Cat:      []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
					Publisher: Publisher{
						Name:   "foo",
						Cat:    []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
						Domain: "foo.com",
					},
				},
				Device: Device{
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
				Format: &Format{
					H: 1920,
					W: 1080,
				},
				User: User{
					Age:    30,
					YOB:    1991,
					Gender: "male",
				},
				Ext: RequestExt{
					APIKey:    "3b117631-538d-4315-bc47-d4e8ce6527e5",
					SessionID: "fab5d528-5ac9-4082-a1ff-968a7f8fefc4",
				},
				Imp: []Imp{
					Imp{
						Banner: &Banner{
							BidFloor: requestutil.FloatPointer(2.00),
							H:        480,
							W:        320,
							Pos:      7,
							Format: []Format{
								Format{H: 1, W: 2},
								Format{H: 3, W: 4},
								Format{H: 5, W: 6},
							},
							BAttr: []int{1, 2},
						},
						Video: &Video{
							BidFloor:    requestutil.FloatPointer(3.00),
							Mimes:       []string{"foo", "bar"},
							MinBitRate:  1,
							MaxBitRate:  200000,
							API:         []int{2, 3},
							Pos:         1,
							Minduration: 100,
							Maxduration: 20000,
							H:           1920,
							W:           1080,
						},
						Instl:    1,
						BidFloor: 1.00,
						Secure:   requestutil.IntPointer(1),
						Ext: &ImpExt{
							APS: []APS{
								APS{
									AmznB:     []string{"1"},
									AmznVid:   []string{"2"},
									AmznH:     []string{"3"},
									Amznp:     []string{"4"},
									Amznrdr:   []string{"5"},
									Amznslots: []string{"6"},
									Dc:        []string{"7"},
								},
							},
							FacebookAppID: "facebook_app_id",
							Position:      "App Open",
						},
					},
				},
			},
			wantErr: false,
		},
		{
			name: "request should be invalid missing banner w and h",
			Request: Request{
				App: App{
					Name:     "foo",
					Bundle:   "com.foo",
					Domain:   "foo.com",
					StoreURL: "https://play.google.com/store/apps/details?id=com.foo",
					Cat:      []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
					Publisher: Publisher{
						Name:   "foo",
						Cat:    []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
						Domain: "foo.com",
					},
				},
				Device: Device{
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
				Format: &Format{
					H: 1920,
					W: 1080,
				},
				User: User{
					Age:    30,
					YOB:    1991,
					Gender: "male",
				},
				Ext: RequestExt{
					APIKey:    "3b117631-538d-4315-bc47-d4e8ce6527e5",
					SessionID: "fab5d528-5ac9-4082-a1ff-968a7f8fefc4",
				},
				Imp: []Imp{
					Imp{
						Banner: &Banner{
							BidFloor: requestutil.FloatPointer(2.00),
							Pos:      7,
							Format: []Format{
								Format{H: 1, W: 2},
								Format{H: 3, W: 4},
								Format{H: 5, W: 6},
							},
							BAttr: []int{1, 2},
						},
						Video: &Video{
							BidFloor:    requestutil.FloatPointer(3.00),
							Mimes:       []string{"foo", "bar"},
							MinBitRate:  1,
							MaxBitRate:  200000,
							API:         []int{2, 3},
							Pos:         1,
							Minduration: 100,
							Maxduration: 20000,
							H:           1920,
							W:           1080,
						},
						Instl:    1,
						BidFloor: 1.00,
						Secure:   requestutil.IntPointer(1),
						Ext: &ImpExt{
							APS: []APS{
								APS{
									AmznB:     []string{"1"},
									AmznVid:   []string{"2"},
									AmznH:     []string{"3"},
									Amznp:     []string{"4"},
									Amznrdr:   []string{"5"},
									Amznslots: []string{"6"},
									Dc:        []string{"7"},
								},
							},
							FacebookAppID: "facebook_app_id",
							Position:      "App Open",
						},
					},
				},
			},
			wantErr: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			_, err := govalidator.ValidateStruct(tt.Request)

			if tt.wantErr {
				if err == nil {
					t.Fatalf("expected the request structure to be invalid")
				}
				return
			}

			if err != nil {
				t.Fatalf("expected the request structure to be valid, got %v", err)
			}
		})
	}
}

func TestBidRequestMarshaling(t *testing.T) {
	tests := []struct {
		name    string
		Request Request
	}{
		{
			name: "json marshal and gojay marshal should output the same way",
			Request: Request{
				App: App{
					Name:     "foo",
					Bundle:   "com.foo",
					Domain:   "foo.com",
					StoreURL: "https://play.google.com/store/apps/details?id=com.foo",
					Cat:      []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
					Publisher: Publisher{
						Name:   "foo",
						Cat:    []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
						Domain: "foo.com",
					},
				},
				Device: Device{
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
				Format: &Format{
					H: 1920,
					W: 1080,
				},
				User: User{
					Age:    30,
					YOB:    1991,
					Gender: "male",
				},
				Ext: RequestExt{
					APIKey:    "3b117631-538d-4315-bc47-d4e8ce6527e5",
					SessionID: "fab5d528-5ac9-4082-a1ff-968a7f8fefc4",
				},
				Imp: []Imp{
					Imp{
						Banner: &Banner{
							BidFloor: requestutil.FloatPointer(2.00),
							H:        480,
							W:        320,
							Pos:      7,
							Format: []Format{
								Format{H: 1, W: 2},
								Format{H: 3, W: 4},
								Format{H: 5, W: 6},
							},
							BAttr: []int{1, 2},
						},
						Video: &Video{
							BidFloor:    requestutil.FloatPointer(3.00),
							Mimes:       []string{"foo", "bar"},
							MinBitRate:  1,
							MaxBitRate:  200000,
							API:         []int{2, 3},
							Pos:         1,
							Minduration: 100,
							Maxduration: 20000,
							H:           1920,
							W:           1080,
						},
						Instl:    1,
						BidFloor: 1.00,
						Secure:   requestutil.IntPointer(1),
						Ext: &ImpExt{
							APS: []APS{
								APS{
									AmznB:     []string{"1"},
									AmznVid:   []string{"2"},
									AmznH:     []string{"3"},
									Amznp:     []string{"4"},
									Amznrdr:   []string{"5"},
									Amznslots: []string{"6"},
									Dc:        []string{"7"},
								},
							},
							FacebookAppID: "facebook_app_id",
							Position:      "App Open",
						},
					},
				},
			},
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			regJSON, err := json.Marshal(tt.Request)
			if err != nil {
				t.Fatalf("json.Marshal failed %v", err)
			}

			b := new(bytes.Buffer)
			enc := gojay.BorrowEncoder(b)
			err = enc.Encode(&tt.Request)
			defer enc.Release()
			if err != nil {
				t.Fatalf("gojay.Marshal failed %v", err)
			}
			gojayJSON := b.Bytes()

			if !cmp.Equal(regJSON, gojayJSON) {
				t.Errorf("TestBidRequestMarshalling()\ndiff\n %+v", cmp.Diff(string(regJSON), string(gojayJSON)))
			}
		})
	}
}
