package requestutil

import (
	"context"
	"io"
	"net"
	"net/http"
	"sync"
	"time"
)

var (
	defaultClient    *NimbusClient
	createClientOnce sync.Once
)

// NimbusClient inits wrappers *http.Client with endpoint
type NimbusClient struct {
	Client   *http.Client
	Endpoint string
}

// NewNimbusClient creates a configured network client and stops recreatation of the client
// this prevents the mistake of creating many network clients to communicate with Nimbus preventing
// to proper recycling of TCP resources
func NewNimbusClient(endpoint string, options ...func(*NimbusClient)) *NimbusClient {
	createClientOnce.Do(func() {
		defaultClient = &NimbusClient{
			Endpoint: endpoint,
		}

		// apply settings
		for _, option := range options {
			option(defaultClient)
		}

		// if no network client is provided, supply a standard one, optimized to
		// reduce SSL handshake cost
		if defaultClient.Client == nil {
			defaultClient.Client = &http.Client{
				Transport: &http.Transport{
					Proxy: http.ProxyFromEnvironment,
					DialContext: (&net.Dialer{
						Timeout:   10 * time.Second,
						KeepAlive: 60 * time.Minute,
					}).DialContext,
					TLSHandshakeTimeout: 10 * time.Second,
					IdleConnTimeout:     10 * time.Second,
				},
				Timeout: 10 * time.Second,
			}
		}
	})
	return defaultClient
}

// PostNimbus sends a POST request to Nimbus
func (n NimbusClient) PostNimbus(body io.Reader) (*http.Response, error) {
	req, err := http.NewRequest(http.MethodPost, n.Endpoint, body)
	if err != nil {
		return nil, err
	}
	req.Header.Set("x-openrtb-version", "2.5")
	return n.Client.Do(req)
}

// PostNimbusWithContext sends a POST request to Nimbus with a context attached to the request
// this is great to adding a timeout to the request
func (n NimbusClient) PostNimbusWithContext(ctx context.Context, body io.Reader) (*http.Response, error) {
	req, err := http.NewRequest(http.MethodPost, n.Endpoint, body)
	if err != nil {
		return nil, err
	}
	req = req.WithContext(ctx)
	req.Header.Set("x-openrtb-version", "2.5")
	return n.Client.Do(req)
}
