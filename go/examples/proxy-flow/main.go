package main

import (
	"bytes"
	"context"
	"crypto/tls"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net"
	"net/http"
	"net/http/httptest"
	"time"

	"github.com/timehop/nimbus-openrtb/go/client"
	"github.com/timehop/nimbus-openrtb/go/decode"
	twofive "github.com/timehop/nimbus-openrtb/go/request/rtb_twofive"
	"github.com/timehop/nimbus-openrtb/go/response"
)

func main() {
	h := http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		var tr twofive.Request
		err := json.NewDecoder(r.Body).Decode(&tr)
		if err != nil {
			w.WriteHeader(http.StatusInternalServerError)
		}
		defer r.Body.Close()

		if ok, _ := client.IsRequestValid(tr); !ok {
			w.WriteHeader(http.StatusBadRequest)
		}
		w.Write([]byte(`{"type":"facebook","auction_id":"7d1a4f2b-b7b2-445e-b1f9-61e7ce56ef48","bid_in_cents":100,"content_type":"application/json; charset=utf-8","is_interstitial":1,"markup":"{\"type\":\"ID\",\"bid_id\":\"2762638018393877168\",\"placement_id\":\"IMG_16_9_LINK#191445434271484_1906402376109106\",\"resolved_placement_id\":\"IMG_16_9_LINK#191445434271484_1906402376109106\",\"sdk_version\":\"4.99.1\",\"device_id\":\"0F9DC9F9-C7E7-4579-A945-88A87BDF91E8\",\"template\":200,\"payload\":null}","network":"facebook","trackers":{"impression_trackers":["foobar.com"]},"height":480,"width":320,"placement_id":"IMG_16_9_LINK#191445434271484_1906402376109106"}`))
		return
	})

	httpClient, close := testingHTTPClient(h)
	defer close()

	clientOptional := func(d *client.Driver) {
		// check the endpoints every 20 minutes
		d.Client = httpClient
	}

	driver := client.NewNimbusDriver("http://foobar.com", clientOptional)

	// received a RTB request from the client
	bidRequestBody := []byte(`{"app":{"bundle":"com.foo","cat":["IAB14","IAB1","IAB9","IAB12","IAB16","IAB17","IAB18","IAB20"],"domain":"https://foobar.com","name":"Timehop","paid":0,"privacypolicy":1,"publisher":{"cat":["IAB14","IAB1","IAB9","IAB12","IAB16","IAB17","IAB18","IAB20"],"domain":"https://foobar.com","name":"Bar"},"storeurl":"https://play.google.com/store/apps/details?id=com.foo","ver":"4.2.4"},"device":{"connectiontype":6,"devicetype":1,"dnt":0,"geo":{"city":"New York","country":"USA","lat":40.7089,"lon":-74.0012,"type":2},"ifa":"13579176-e94e-4e6e-96ae-572b787af21c","ip":"71.125.59.151","language":"en","lmt":0,"make":"Pixel 2 XL","model":"Samsung","os":"android","osv":"4.2.4","ua":"Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36"},"ext":{"api_key":"9411ce59-9bcf-42d3-867b-ac543a02c3fa","platformid":"foobar","session_id":"1"},"imp":[{"banner":{"battr":[1,2],"format":[{"h":1,"w":2},{"h":3,"w":4},{"h":5,"w":6}],"h":480,"pos":7,"w":320},"bidfloor":0,"ext":{"aps":[{"amzn_b":["1"],"amzn_h":["3"],"amzn_vid":["2"],"amznp":["4"],"amznrdr":["5"],"amznslots":["6"],"dc":["7"]},{"amzn_b":["1"],"amzn_h":["3"],"amzn_vid":["2"],"amznp":["4"],"amznrdr":["5"],"amznslots":["6"],"dc":["7"]}],"facebook_app_id":"foobar","position":"test","viewability":100},"id":"th_unique_id","instl":0,"secure":1,"video":{"api":[2,3],"maxbitrate":200000,"maxduration":20000,"mimes":["foo","bar"],"minbitrate":1,"minduration":100,"pos":1,"skip":0,"startdelay":0,"h":480,"w":320}}],"regs":{"coppa":0,"ext":{"gdpr":1}},"source":{"ext":{"omidpn":"foo","omidpv":"bar"}},"user":{"ext":{"age":30,"consent":"BOgPp6-Of7sjSAAAABENCR-AAAAfbAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA","did_consent":1},"gender":"male","yob":1991},"format":{"h":480,"w":320}}`)
	incomingRequest := &http.Request{
		Body: ioutil.NopCloser(bytes.NewReader(bidRequestBody)),
	}

	var request twofive.Request
	err := decode.RequestToStruct(incomingRequest, &request)
	if err != nil {
		log.Fatal(err)
	}

	// augment the request if needed
	request.Imp[0].Banner.BidFloor = twofive.FloatPointer(5.00)

	// validate the structure, validation is slow, so it's not recomended to do it on every request
	if ok, err := client.IsRequestValid(request); !ok {
		log.Fatal(err)
	}

	// add a context for timing is wanted
	ctx, cancel := context.WithTimeout(context.Background(), 1*time.Second)
	defer cancel()

	res, err := driver.PostNimbusTwoFiveRequestWithContext(ctx, request)
	if err != nil {
		log.Fatal(err)
	}

	// load in the bid response
	var nimbusResponse response.Bid
	if res.StatusCode == http.StatusOK {
		err = decode.ResponseToStruct(res, &nimbusResponse)
		if err != nil {
			log.Fatal(err)
		}
	}

	// do stuff (besides printing lol)
	b, err := json.MarshalIndent(nimbusResponse, "", " ")
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println(string(b))

}

// for mocking a fake network call
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
