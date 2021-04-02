package client

import (
	"bytes"
	"context"
	"io"
	"net"
	"net/http"
	"sync"
	"time"

	twofive "github.com/timehop/nimbus-openrtb/go/request/rtb_twofive"
)

var (
	defaultClient    *Driver
	createClientOnce sync.Once
)

const (
	sdkHeader    = "Nimbus-Sdkv"
	guidHeader   = "Nimbus-Instance-Id"
	apiKeyHeader = "Nimbus-Api-Key"
)

const (
	contentTypeHeaderKey          = "Content-Type"
	defaultContentTypeHeaderValue = "application/json; charset=utf-8"
)

const (
	rtbHeaderVersionKey   = "X-Openrtb-Version"
	rtbHeaderVersionValue = "2.5"
)

// Nimbus interface defines a series of POST request helper methods to communicate s2s
type Nimbus interface {
	PostNimbus(body io.Reader, options ...func(*http.Request)) (*http.Response, error)
	PostNimbusWithContext(ctx context.Context, body io.Reader, options ...func(*http.Request)) (*http.Response, error)
	PostNimbusTwoFiveRequest(r twofive.Request, options ...func(*http.Request)) (*http.Response, error)
	PostNimbusTwoFiveRequestWithContext(ctx context.Context, r twofive.Request, options ...func(*http.Request)) (*http.Response, error)
}

// Driver inits wrappers *http.Client with endpoint
type Driver struct {
	Client   *http.Client
	Endpoint string
}

// ProxyNimbusSDKHeaders sets all the required Nimbus headers and proxies headers from the Nimbus SDK
func ProxyNimbusSDKHeaders(incomingRequest *http.Request) func(*http.Request) {
	return func(r *http.Request) {
		sdkVersionHeaderValue := incomingRequest.Header.Get(sdkHeader)
		guidHeaderValue := incomingRequest.Header.Get(guidHeader)
		apiKeyHeaderValue := incomingRequest.Header.Get(apiKeyHeader)

		headers := make(http.Header)
		headers.Set(sdkHeader, sdkVersionHeaderValue)
		headers.Set(guidHeader, guidHeaderValue)
		headers.Set(apiKeyHeader, apiKeyHeaderValue)
		headerUtil{headers}.setIfEmpty(contentTypeHeaderKey, defaultContentTypeHeaderValue)
		headerUtil{headers}.setIfEmpty(rtbHeaderVersionKey, rtbHeaderVersionValue)
		// set the Nimbus specific Headers
		r.Header = headers
	}
}

// NewNimbusDriver creates a configured network client and stops recreation of the client
// this prevents the mistake of creating many network clients to communicate with Nimbus preventing
// to proper recycling of TCP resources
func NewNimbusDriver(endpoint string, options ...func(*Driver)) *Driver {
	createClientOnce.Do(func() {
		defaultClient = &Driver{
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
func (d Driver) PostNimbus(body io.Reader, options ...func(*http.Request)) (*http.Response, error) {
	req, err := http.NewRequest(http.MethodPost, d.Endpoint, body)
	if err != nil {
		return nil, err
	}

	for _, option := range options {
		option(req)
	}

	headerUtil{req.Header}.setIfEmpty(contentTypeHeaderKey, defaultContentTypeHeaderValue)
	headerUtil{req.Header}.setIfEmpty(rtbHeaderVersionKey, rtbHeaderVersionValue)
	return d.Client.Do(req)
}

// PostNimbusWithContext sends a POST request to Nimbus with a context attached to the request
// this is great to adding a timeout to the request
func (d Driver) PostNimbusWithContext(ctx context.Context, body io.Reader, options ...func(*http.Request)) (*http.Response, error) {
	req, err := http.NewRequest(http.MethodPost, d.Endpoint, body)
	if err != nil {
		return nil, err
	}

	for _, option := range options {
		option(req)
	}

	req = req.WithContext(ctx)
	headerUtil{req.Header}.setIfEmpty(contentTypeHeaderKey, defaultContentTypeHeaderValue)
	headerUtil{req.Header}.setIfEmpty(rtbHeaderVersionKey, rtbHeaderVersionValue)
	return d.Client.Do(req)
}

// PostNimbusTwoFiveRequest sends a POST request to Nimbus but, allows only the passing of the RTB2.5 request
func (d Driver) PostNimbusTwoFiveRequest(r twofive.Request, options ...func(*http.Request)) (*http.Response, error) {
	body, err := MarshalBidRequest(&r)
	if err != nil {
		return nil, err
	}

	req, err := http.NewRequest(http.MethodPost, d.Endpoint, bytes.NewReader(body))
	if err != nil {
		return nil, err
	}

	for _, option := range options {
		option(req)
	}

	headerUtil{req.Header}.setIfEmpty(contentTypeHeaderKey, defaultContentTypeHeaderValue)
	headerUtil{req.Header}.setIfEmpty(rtbHeaderVersionKey, rtbHeaderVersionValue)
	return d.Client.Do(req)
}

// PostNimbusTwoFiveRequestWithContext sends a POST request to Nimbus, but allows only the passing of the RTB2.5 request. Addtionally context can be attached to the request
// this is great to adding a timeout to the request
func (d Driver) PostNimbusTwoFiveRequestWithContext(ctx context.Context, r twofive.Request, options ...func(*http.Request)) (*http.Response, error) {
	body, err := MarshalBidRequest(&r)
	if err != nil {
		return nil, err
	}

	req, err := http.NewRequest(http.MethodPost, d.Endpoint, bytes.NewReader(body))
	if err != nil {
		return nil, err
	}

	for _, option := range options {
		option(req)
	}

	req = req.WithContext(ctx)
	headerUtil{req.Header}.setIfEmpty(contentTypeHeaderKey, defaultContentTypeHeaderValue)
	headerUtil{req.Header}.setIfEmpty(rtbHeaderVersionKey, rtbHeaderVersionValue)
	return d.Client.Do(req)
}

type headerUtil struct {
	http.Header
}

// setIfEmpty provides a simple means set values without overriding
func (h headerUtil) setIfEmpty(key, value string) {
	if v := h.Get(key); len(v) == 0 {
		h.Set(key, value)
	}
}
