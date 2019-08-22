package requestutil

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
	httpClient, _ := testingHTTPClient(h)

	clientOptional := func(n *NimbusClient) {
		// check the endpoints every 20 minutes
		n.Client = httpClient
	}
	nc := NewNimbusClient("http://foobar.com", clientOptional)

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
			res, err := nc.PostNimbus(strings.NewReader(body))
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
