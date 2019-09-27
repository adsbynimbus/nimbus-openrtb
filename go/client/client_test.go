package client

import (
	"bytes"
	"context"
	"crypto/tls"
	"encoding/json"
	"fmt"
	"io"
	"net"
	"net/http"
	"net/http/httptest"
	"strings"
	"testing"
	"time"

	twofive "github.com/timehop/nimbus-openrtb/go/request/rtb_twofive"
)

type testRequest struct {
	Value int `json:"value"`
}

func TestPostNimbus(t *testing.T) {
	h := http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		var tr testRequest
		err := json.NewDecoder(r.Body).Decode(&tr)
		if err != nil {
			t.Fatalf("NewDecoder failed to decode %v", err)
		}
		defer r.Body.Close()

		switch {
		case tr.Value < 10:
			w.Write([]byte("good"))
			return
		case tr.Value > 10 && tr.Value < 25:
			w.Write([]byte("good"))
			return
		case tr.Value > 25 && tr.Value < 50:
			w.Write([]byte("good"))
			return
		case tr.Value > 50 && tr.Value < 75:
			w.Write([]byte("bad"))
			return
		case tr.Value > 75 && tr.Value < 100:
			w.Write([]byte("bad"))
			return
		case tr.Value == 300:
			time.Sleep(time.Second * 3)
			w.Write([]byte("won't be written"))
			return
		default:
			w.Write([]byte("unknown"))
			return
		}

	})

	httpClient, close := testingHTTPClient(h)
	defer close()

	defaultClient = &Driver{
		Client:   httpClient,
		Endpoint: "http://foobar.com",
	}

	tests := []struct {
		name         string
		value        int
		wantResponse string
	}{

		{
			name:         "should have a valid response, value 9",
			value:        9,
			wantResponse: "good",
		},
		{
			name:         "should have a valid response, value 15",
			value:        15,
			wantResponse: "good",
		},
		{
			name:         "should have a valid response, value 40",
			value:        40,
			wantResponse: "good",
		},
		{
			name:         "should have a invalid response, value 50",
			value:        51,
			wantResponse: "bad",
		},
		{
			name:         "should have a invalid response, value 90",
			value:        90,
			wantResponse: "bad",
		},
		{
			name:         "should have a invalid response, value 200",
			value:        200,
			wantResponse: "unknown",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			body := fmt.Sprintf(`{"value": %d}`, tt.value)
			res, err := defaultClient.PostNimbus(strings.NewReader(body))
			if err != nil {
				t.Fatalf("PostNimbus failed: %v", err)
			}

			var buf bytes.Buffer
			_, _ = io.Copy(&buf, res.Body)

			if buf.String() != tt.wantResponse {
				t.Fatalf("expected %s, got %s", tt.wantResponse, buf.String())
			}
		})
	}
}

func TestPostNimbusWithContext(t *testing.T) {
	h := http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		var tr testRequest
		err := json.NewDecoder(r.Body).Decode(&tr)
		if err != nil {
			t.Fatalf("NewDecoder failed to decode %v", err)
		}
		defer r.Body.Close()

		switch {
		case tr.Value < 10:
			w.Write([]byte("good"))
			return
		case tr.Value > 10 && tr.Value < 25:
			w.Write([]byte("good"))
			return
		case tr.Value > 25 && tr.Value < 50:
			w.Write([]byte("good"))
			return
		case tr.Value > 50 && tr.Value < 75:
			w.Write([]byte("bad"))
			return
		case tr.Value > 75 && tr.Value < 100:
			w.Write([]byte("bad"))
			return
		case tr.Value == 300:
			time.Sleep(time.Second * 3)
			w.Write([]byte("won't be written"))
			return
		default:
			w.Write([]byte("unknown"))
			return
		}

	})

	httpClient, close := testingHTTPClient(h)
	defer close()

	defaultClient = &Driver{
		Client:   httpClient,
		Endpoint: "http://foobar.com",
	}

	tests := []struct {
		name         string
		value        int
		ctx          context.Context
		wantResponse string
	}{

		{
			name:         "should have a valid response, value 9",
			ctx:          context.Background(),
			value:        9,
			wantResponse: "good",
		},
		{
			name:         "should have a valid response, value 15",
			ctx:          context.Background(),
			value:        15,
			wantResponse: "good",
		},
		{
			name:         "should have a valid response, value 40",
			ctx:          context.Background(),
			value:        40,
			wantResponse: "good",
		},
		{
			name:         "should have a invalid response, value 50",
			ctx:          context.Background(),
			value:        51,
			wantResponse: "bad",
		},
		{
			name:         "should have a invalid response, value 90",
			ctx:          context.Background(),
			value:        90,
			wantResponse: "bad",
		},
		{
			name:         "should have a invalid response, value 200",
			ctx:          context.Background(),
			value:        200,
			wantResponse: "unknown",
		},
		{
			name:         "should have a invalid response, request timed out",
			ctx:          context.Background(),
			value:        300,
			wantResponse: "",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			body := fmt.Sprintf(`{"value": %d}`, tt.value)

			if tt.value == 300 {
				var cancel func()
				tt.ctx, cancel = context.WithTimeout(tt.ctx, time.Second)
				defer cancel()
			}

			// was initialized in the above test, no need to reinit
			res, err := defaultClient.PostNimbusWithContext(tt.ctx, strings.NewReader(body))
			if err != nil {
				if tt.value != 300 {
					t.Fatalf("PostNimbus failed: %v", err)
				}
				return
			}

			var buf bytes.Buffer
			_, _ = io.Copy(&buf, res.Body)

			if buf.String() != tt.wantResponse {
				t.Fatalf("expected %s on value %d, got %s", tt.wantResponse, tt.value, buf.String())
			}
		})
	}
}

func TestPostNimbusTwoFiveRequest(t *testing.T) {

	h := http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		var tr twofive.Request
		err := json.NewDecoder(r.Body).Decode(&tr)
		if err != nil {
			w.WriteHeader(http.StatusInternalServerError)
		}
		defer r.Body.Close()

		if ok, _ := IsRequestValid(tr); !ok {
			w.WriteHeader(http.StatusBadRequest)
		}
		return
	})

	httpClient, close := testingHTTPClient(h)
	defer close()

	defaultClient = &Driver{
		Client:   httpClient,
		Endpoint: "http://foobar.com",
	}

	tests := []struct {
		name       string
		body       twofive.Request
		statusCode int
	}{

		{
			name: "should have a valid response",
			body: twofive.Request{
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
				Imp: []twofive.Imp{
					twofive.Imp{
						Banner: &twofive.Banner{
							BidFloor: twofive.FloatPointer(2.00),
							H:        480,
							W:        320,
							Pos:      7,
							Format: []twofive.Format{
								twofive.Format{H: 1, W: 2},
								twofive.Format{H: 3, W: 4},
								twofive.Format{H: 5, W: 6},
							},
							BAttr: []int{1, 2},
						},
						Video: &twofive.Video{
							BidFloor:    twofive.FloatPointer(3.00),
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
						Secure:   twofive.IntPointer(1),
						Ext: &twofive.ImpExt{
							APS: []twofive.APS{
								twofive.APS{
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
			statusCode: 200,
		},
		{
			name: "should have a invalid response, the body is invalid",
			body: twofive.Request{
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
				Imp: []twofive.Imp{
					twofive.Imp{
						Banner: &twofive.Banner{
							BidFloor: twofive.FloatPointer(2.00),
							Pos:      7,
							Format: []twofive.Format{
								twofive.Format{H: 1, W: 2},
								twofive.Format{H: 3, W: 4},
								twofive.Format{H: 5, W: 6},
							},
							BAttr: []int{1, 2},
						},
						Video: &twofive.Video{
							BidFloor:    twofive.FloatPointer(3.00),
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
						Secure:   twofive.IntPointer(1),
						Ext: &twofive.ImpExt{
							APS: []twofive.APS{
								twofive.APS{
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
						},
					},
				},
			},
			statusCode: 400,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {

			// was initialized in the above test, no need to reinit
			res, err := defaultClient.PostNimbusTwoFiveRequest(tt.body)
			if err != nil {
				t.Fatalf("PostNimbusTwoFiveRequest failed: %v", err)

			}

			if res.StatusCode != tt.statusCode {
				t.Fatalf("PostNimbusTwoFiveRequest expected status code %d got: %d", tt.statusCode, res.StatusCode)
			}

		})
	}
}

func TestPostNimbusTwoFiveRequestWithContext(t *testing.T) {
	h := http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		var tr twofive.Request
		err := json.NewDecoder(r.Body).Decode(&tr)
		if err != nil {
			w.WriteHeader(http.StatusInternalServerError)
		}
		defer r.Body.Close()

		if ok, _ := IsRequestValid(tr); !ok {
			w.WriteHeader(http.StatusBadRequest)
		}
		return
	})

	httpClient, close := testingHTTPClient(h)
	defer close()

	defaultClient = &Driver{
		Client:   httpClient,
		Endpoint: "http://foobar.com",
	}

	tests := []struct {
		name       string
		body       twofive.Request
		statusCode int
	}{

		{
			name: "should have a valid response",
			body: twofive.Request{
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
				Imp: []twofive.Imp{
					twofive.Imp{
						Banner: &twofive.Banner{
							BidFloor: twofive.FloatPointer(2.00),
							H:        480,
							W:        320,
							Pos:      7,
							Format: []twofive.Format{
								twofive.Format{H: 1, W: 2},
								twofive.Format{H: 3, W: 4},
								twofive.Format{H: 5, W: 6},
							},
							BAttr: []int{1, 2},
						},
						Video: &twofive.Video{
							BidFloor:    twofive.FloatPointer(3.00),
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
						Secure:   twofive.IntPointer(1),
						Ext: &twofive.ImpExt{
							APS: []twofive.APS{
								twofive.APS{
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
			statusCode: 200,
		},
		{
			name: "should have a invalid response, the body is invalid",
			body: twofive.Request{
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
				Imp: []twofive.Imp{
					twofive.Imp{
						Banner: &twofive.Banner{
							BidFloor: twofive.FloatPointer(2.00),
							Pos:      7,
							Format: []twofive.Format{
								twofive.Format{H: 1, W: 2},
								twofive.Format{H: 3, W: 4},
								twofive.Format{H: 5, W: 6},
							},
							BAttr: []int{1, 2},
						},
						Video: &twofive.Video{
							BidFloor:    twofive.FloatPointer(3.00),
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
						Secure:   twofive.IntPointer(1),
						Ext: &twofive.ImpExt{
							APS: []twofive.APS{
								twofive.APS{
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
						},
					},
				},
			},
			statusCode: 400,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			// was initialized in the above test, no need to reinit
			res, err := defaultClient.PostNimbusTwoFiveRequestWithContext(context.TODO(), tt.body)
			if err != nil {
				t.Fatalf("PostNimbusTwoFiveRequestWithContext failed: %v", err)

			}

			if res.StatusCode != tt.statusCode {
				t.Fatalf("PostNimbusTwoFiveRequestWithContext expected status code %d got: %d", tt.statusCode, res.StatusCode)
			}

		})
	}
}

func TestWithHeaders(t *testing.T) {
	type args struct {
		headers http.Header
		key     string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			name: "should add headers just fine",
			args: args{
				headers: http.Header(map[string][]string{"nimbus-sdkv": []string{"bar"}}),
				key:     "nimbus-sdkv",
			},
			want: "bar",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			req, _ := http.NewRequest(http.MethodPost, "", nil)
			option := WithHeaders(tt.args.headers)
			option(req)
			// https://golang.org/pkg/net/textproto/#MIMEHeader.Get
			if got, ok := req.Header[tt.args.key]; !ok || (got[0] != tt.want) {
				t.Errorf("WithHeaders() = %v, want %v", got, tt.want)
			}
		})
	}
}

func testingHTTPClient(handler http.Handler) (*http.Client, func()) {
	s := httptest.NewServer(handler)
	cli := &http.Client{
		Transport: &http.Transport{
			DialContext: func(_ context.Context, network, _ string) (net.Conn, error) {
				return net.Dial(network, s.Listener.Addr().String())
			},
			TLSClientConfig: &tls.Config{InsecureSkipVerify: true},
		},
		Timeout: 10 * time.Second,
	}
	return cli, s.Close
}
