package twofive

import (
	"bytes"
	"encoding/json"
	"reflect"
	"testing"

	"github.com/francoispqt/gojay"
	"github.com/google/go-cmp/cmp"
	"github.com/marcsantiago/govalidator"
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
							BidFloor: FloatPointer(2.00),
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
							BidFloor:    FloatPointer(3.00),
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
						Secure:   IntPointer(1),
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
							BidFloor: FloatPointer(2.00),
							Pos:      7,
							Format: []Format{
								Format{H: 1, W: 2},
								Format{H: 3, W: 4},
								Format{H: 5, W: 6},
							},
							BAttr: []int{1, 2},
						},
						Video: &Video{
							BidFloor:    FloatPointer(3.00),
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
						Secure:   IntPointer(1),
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
					Ext: &UserExt{
						EIDS: EIDS{
							{
								Source: "foobar.com",
								UIDS: UIDS{
									{
										ID:  "foo-id",
										Ext: &IdentityExt{RTIPartner: "foo-partner"},
									},
								},
							},
						},
						MobileFuseData: MobileFuseData{
							"foo":  "bar",
							"foo1": "bar1",
							"foo2": "bar2",
							"foo3": "bar3",
						},
					},
				},
				Ext: RequestExt{
					APIKey:    "3b117631-538d-4315-bc47-d4e8ce6527e5",
					SessionID: "fab5d528-5ac9-4082-a1ff-968a7f8fefc4",
				},
				Imp: []Imp{
					Imp{
						Banner: &Banner{
							BidFloor: FloatPointer(2.00),
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
							BidFloor:    FloatPointer(3.00),
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
						Secure:   IntPointer(1),
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
							FacebookAppID:      "facebook_app_id",
							FacebookTestAdType: ImageLandscapeAppInstall,
							Position:           "App Open",
							Skadn: &Skadn{
								Version:    "2.0",
								SourceApp:  "foo.bundle",
								Skadnetids: []string{"cDkw7geQsH.skadnetwork"},
							},
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
			// forces the go std lib to sort the keys for byte comparison
			regJSON, _ = jsonRemarshal(regJSON)
			gojayJSON, _ := jsonRemarshal(b.Bytes())
			if !cmp.Equal(regJSON, gojayJSON) {
				t.Errorf("TestBidRequestMarshalling()\ndiff\n %+v", cmp.Diff(string(regJSON), string(gojayJSON)))
			}
		})
	}
}

func TestBidRequestUnmarshaling(t *testing.T) {
	bidRequest := []byte(`{"app":{"bundle":"com.foo","cat":["IAB14","IAB1","IAB9","IAB12","IAB16","IAB17","IAB18","IAB20"],"domain":"https://foobar.com","name":"Timehop","paid":0,"privacypolicy":1,"publisher":{"cat":["IAB14","IAB1","IAB9","IAB12","IAB16","IAB17","IAB18","IAB20"],"domain":"https://foobar.com","name":"Bar"},"storeurl":"https://play.google.com/store/apps/details?id=com.foo","ver":"4.2.4"},"device":{"connectiontype":6,"devicetype":1,"dnt":0,"geo":{"city":"New York","country":"USA","lat":40.7089,"lon":-74.0012,"type":2},"ifa":"13579176-e94e-4e6e-96ae-572b787af21c","ip":"71.125.59.151","language":"en","lmt":0,"make":"Pixel 2 XL","model":"Samsung","os":"android","osv":"4.2.4","ua":"Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36"},"ext":{"api_key":"mykey","platformid":"foobar","session_id":"1"},"imp":[{"banner":{"battr":[1,2],"format":[{"h":1,"w":2},{"h":3,"w":4},{"h":5,"w":6}],"h":480,"pos":7,"w":320},"bidfloor":0,"ext":{"aps":[{"amzn_b":["1"],"amzn_h":["3"],"amzn_vid":["2"],"amznp":["4"],"amznrdr":["5"],"amznslots":["6"],"dc":["7"]},{"amzn_b":["1"],"amzn_h":["3"],"amzn_vid":["2"],"amznp":["4"],"amznrdr":["5"],"amznslots":["6"],"dc":["7"]}],"facebook_app_id":"foobar","facebook_test_ad_type":"IMG_16_9_APP_INSTALL","position":"test","viewability":100},"id":"th_unique_id","instl":0,"secure":1,"video":{"api":[2,3],"maxbitrate":200000,"maxduration":20000,"mimes":["foo","bar"],"minbitrate":1,"minduration":100,"pos":1,"skip":0,"startdelay":0}}],"regs":{"coppa":0,"ext":{"gdpr":1}},"source":{"ext":{"omidpn":"foo","omidpv":"bar"}},"user":{"ext":{"age":30,"consent":"i said yes","did_consent":1,"mfx_buyerdata":{"foo":"bar","foo1":"bar1","foo2":"bar2","foo3":"bar3"}},"gender":"male","yob":1991}}`)

	tests := []struct {
		name       string
		bidRequest []byte
	}{
		{
			name:       "json marshal and gojay marshal should output the same way",
			bidRequest: bidRequest,
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			var regJSON Request
			err := json.Unmarshal(tt.bidRequest, &regJSON)
			if err != nil {
				t.Fatalf("json.Unmarshal failed %v", err)
			}

			var gojayJSON Request
			err = gojay.UnmarshalJSONObject(tt.bidRequest, &gojayJSON)
			if err != nil {
				t.Fatalf("gojay.Unmarshal failed %v", err)
			}

			if !cmp.Equal(regJSON, gojayJSON) {
				t.Errorf("TestBidRequestUnmarshaling() = diff\n %+v", cmp.Diff(regJSON, gojayJSON))
			}

		})
	}
}

var benchRegJSON, benchGojayJSON []byte

func BenchmarkMarshalSTDJSON(b *testing.B) {
	bidRequest := Request{
		Imp: []Imp{
			Imp{
				ID: "th_unique_id",
				Video: &Video{
					Mimes:       []string{"foo", "bar"},
					MinBitRate:  1,
					MaxBitRate:  200000,
					API:         []int{2, 3},
					Pos:         1,
					Minduration: 100,
					Maxduration: 20000,
				},
				Secure: IntPointer(1),
			},
		},
		App: App{
			Name:          "Timehop",
			Bundle:        "com.timehop",
			Domain:        "https://timehop.com",
			StoreURL:      "https://play.google.com/store/apps/details?id=com.timehop",
			Cat:           []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
			Ver:           "4.2.4",
			PrivacyPolicy: 1,
			Paid:          0,
			Publisher: Publisher{
				Name:   "Timehop",
				Domain: "https://timehop.com",
				Cat:    []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
			},
		},
		Device: Device{
			DeviceType: 1,
			Ua:         "Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36",
			Geo: &Geo{
				Lat:     40.7089,
				Lon:     -74.0012,
				Country: "USA",
				City:    "New York",
			},
			IP:             "71.125.59.151",
			Make:           "android",
			Model:          "Samsung",
			OS:             "android",
			OSV:            "4.2.4",
			Language:       "en",
			ConnectionType: 6,
			Ifa:            "13579176-e94e-4e6e-96ae-572b787af21c",
		},

		User: User{
			YOB:    1991,
			Gender: "male",
		},
		Regs: Regs{
			Ext: &RegsExt{},
		},
	}
	b.ResetTimer()

	for i := 0; i < b.N; i++ {
		benchRegJSON, _ = json.Marshal(bidRequest)
	}
}

func BenchmarkMarshalGoJayJSON(b *testing.B) {
	bidRequest := Request{
		Imp: []Imp{
			Imp{
				ID: "th_unique_id",
				Video: &Video{
					Mimes:       []string{"foo", "bar"},
					MinBitRate:  1,
					MaxBitRate:  200000,
					API:         []int{2, 3},
					Pos:         1,
					Minduration: 100,
					Maxduration: 20000,
				},
				Secure: IntPointer(1),
			},
		},
		App: App{
			Name:          "Timehop",
			Bundle:        "com.timehop",
			Domain:        "https://timehop.com",
			StoreURL:      "https://play.google.com/store/apps/details?id=com.timehop",
			Cat:           []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
			Ver:           "4.2.4",
			PrivacyPolicy: 1,
			Paid:          0,
			Publisher: Publisher{
				Name:   "Timehop",
				Domain: "https://timehop.com",
				Cat:    []string{"IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20"},
			},
		},
		Device: Device{
			DeviceType: 1,
			Ua:         "Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36",
			Geo: &Geo{
				Lat:     40.7089,
				Lon:     -74.0012,
				Country: "USA",
				City:    "New York",
			},
			IP:             "71.125.59.151",
			Make:           "android",
			Model:          "Samsung",
			OS:             "android",
			OSV:            "4.2.4",
			Language:       "en",
			ConnectionType: 6,
			Ifa:            "13579176-e94e-4e6e-96ae-572b787af21c",
		},

		User: User{
			YOB:    1991,
			Gender: "male",
		},
		Regs: Regs{
			Ext: &RegsExt{},
		},
	}
	b.ResetTimer()

	for i := 0; i < b.N; i++ {
		b := new(bytes.Buffer)
		enc := gojay.BorrowEncoder(b)
		enc.Encode(&bidRequest)
		benchGojayJSON = b.Bytes()
		enc.Release()
	}
}

var benchRegJSONObject, benchGojayJSONObject Request

func BenchmarkUnmarshalSTDJSON(b *testing.B) {
	bidRequest := []byte(`{"imp":[{"id":"th_unique_id","banner":{"format":[{"w":2,"h":1},{"w":4,"h":3},{"w":6,"h":5}],"w":320,"h":480,"pos":7},"video":{"mimes":["foo","bar"],"minduration":100,"maxduration":20000,"startdelay":0,"skip":0,"pos":1,"api":[2,3],"minbitrate":1,"maxbitrate":200000},"instl":0,"bidfloor":0,"secure":1,"ext":{"aps":{"amzn_b":["1"],"amzn_vid":["2"],"amzn_h":["3"],"amznp":["4"],"amznrdr":["5"],"amznslots":["6"],"dc":["7"]},"facebook_app_id":"foobar","position":"test","viewability":100}}],"app":{"name":"Timehop","bundle":"com.timehop","domain":"https://timehop.com","storeurl":"https://play.google.com/store/apps/details?id=com.timehop","cat":["IAB14","IAB1","IAB9","IAB12","IAB16","IAB17","IAB18","IAB20"],"ver":"4.2.4","privacypolicy":1,"paid":0,"publisher":{"name":"Timehop","cat":["IAB14","IAB1","IAB9","IAB12","IAB16","IAB17","IAB18","IAB20"],"domain":"https://timehop.com"}},"device":{"ua":"Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36","geo":{"lat":40.7089,"lon":-74.0012,"type":2,"country":"USA","city":"New York"},"dnt":0,"lmt":0,"ip":"71.125.59.151","devicetype":1,"make":"android","model":"Samsung","os":"android","osv":"4.2.4","language":"en","connectiontype":6,"ifa":"13579176-e94e-4e6e-96ae-572b787af21c"},"user":{"yob":1991,"gender":"male","ext":{"age":30,"consent":"i said yes","did_consent":1}},"regs":{"coppa":0,"ext":{"gdpr":1}},"ext":{"api_key":"mykey","platformid":"foobar","session_id":"1"}}`)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		_ = json.Unmarshal(bidRequest, &benchRegJSONObject)
	}
}

func BenchmarkUnmarshalGoJayJSON(b *testing.B) {
	bidRequest := []byte(`{"imp":[{"id":"th_unique_id","banner":{"format":[{"w":2,"h":1},{"w":4,"h":3},{"w":6,"h":5}],"w":320,"h":480,"pos":7},"video":{"mimes":["foo","bar"],"minduration":100,"maxduration":20000,"startdelay":0,"skip":0,"pos":1,"api":[2,3],"minbitrate":1,"maxbitrate":200000},"instl":0,"bidfloor":0,"secure":1,"ext":{"aps":{"amzn_b":["1"],"amzn_vid":["2"],"amzn_h":["3"],"amznp":["4"],"amznrdr":["5"],"amznslots":["6"],"dc":["7"]},"facebook_app_id":"foobar","position":"test","viewability":100}}],"app":{"name":"Timehop","bundle":"com.timehop","domain":"https://timehop.com","storeurl":"https://play.google.com/store/apps/details?id=com.timehop","cat":["IAB14","IAB1","IAB9","IAB12","IAB16","IAB17","IAB18","IAB20"],"ver":"4.2.4","privacypolicy":1,"paid":0,"publisher":{"name":"Timehop","cat":["IAB14","IAB1","IAB9","IAB12","IAB16","IAB17","IAB18","IAB20"],"domain":"https://timehop.com"}},"device":{"ua":"Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36","geo":{"lat":40.7089,"lon":-74.0012,"type":2,"country":"USA","city":"New York"},"dnt":0,"lmt":0,"ip":"71.125.59.151","devicetype":1,"make":"android","model":"Samsung","os":"android","osv":"4.2.4","language":"en","connectiontype":6,"ifa":"13579176-e94e-4e6e-96ae-572b787af21c"},"user":{"yob":1991,"gender":"male","ext":{"age":30,"consent":"i said yes","did_consent":1}},"regs":{"coppa":0,"ext":{"gdpr":1}},"ext":{"api_key":"mykey","platformid":"foobar","session_id":"1"}}`)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		_ = gojay.UnmarshalJSONObject(bidRequest, &benchGojayJSONObject)
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

func jsonRemarshal(bytes []byte) ([]byte, error) {
	var ifce interface{}
	err := json.Unmarshal(bytes, &ifce)
	if err != nil {
		return nil, err
	}
	return json.Marshal(ifce)
}
