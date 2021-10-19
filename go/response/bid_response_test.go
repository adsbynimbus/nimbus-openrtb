package response

import (
	"encoding/json"
	"testing"

	"github.com/francoispqt/gojay"

	"github.com/google/go-cmp/cmp"
)

func TestBidResponseUnmarshaling(t *testing.T) {
	tests := []struct {
		name               string
		ResponseJSONString string
	}{
		{
			name:               "json marshal and gojay marshal should output the same way",
			ResponseJSONString: `{"adomain":["foo.com","bar.com"],"auction_id":"f6bf21ae-a923-4d7f-9944-af220ff789f6","bid_in_cents":100,"bid_raw":1.00,"content_type":"text/html; charset=utf-8","height":480,"is_interstitial":1,"is_mraid":1,"markup":"<HTML>...</HTML>","network":"test_demand","placement_id":"foo_placement","trackers":{"click_trackers":["https://dev.adsbynimbus.com/impression_tracker/bHEyNl8xMHZGU2RUTX6nKs1xDYGt0LspHN22KlZAD2DbeF002MMW2lY2gFkdW8tB91X-2MjKc7valkCGwaYlnJRaP_h6ngrJAI2gDWLJAhhw6bgYrp_-HGGwMvt2wW6eqSXRu4flNA-mZKpldTv6O7Q7QHVh6qwLzXSS5U2Ie0EVRTVixxKY77q8wGA1fRMw_0vnUvpW3Wfm8oJb4bDK4RANmrPKB0t1aZgQ0zxnCsirFb3FwnxM-CMLrXpCOXBOBU9EptcNz2D6C2sMN7EShZt1J-6KP8YLDAJze2HO9lnonh-qc_ZZ3AoHRfz9XnVbWNTwg71uUXYqQ6EsJnPiGZqm7_8JxZCRy8uVh_H7KhpnRu-icu6AJan3CdObcLX453VkGtFIIB8egQ0JJN5Lxxho1jiovynn6xbwqY_BOSMg4pnq9jpGJ7b4zTGnVfLynGXBl1ROTZdvASkBPvaB-lrJNBOPUNLeGUrhLxvv5IHFKXl19Voah7RLn8csMiDl6NyqogjWZM8v4oJWv-jKJJ2a0ZNmE2QtATcm0u5SlnkUpaK6RuGimoe_6SwrNLAJC87NQQGQp5PYQK94Pa4Dq5dVf54gFnaVsuVzak3n9YWrdBFvtaGY5W_t8wqc_f8-E1QvPI1zUTEgh-PDt-MzhbOKN2hPgbMw1Lj8iygd5RLEbtZGHqJ0V-dR467mnAE1CFXuvyrKbB3mxFTgp1a5jHl4-dqilu2XASwqi1BPPadkgeBm_IWCBIGpq3WTZdR7ZDosqqYQpg7WJicWCiBCJR8_F5nToqCLETCqLJlTA0ygz8t7yW3m3fIz5qzhC3GLeCvtqwN_9tW4aVIY1eRUSBb96d8twt9bdcT1x_thMiN3-ZWxSPuUkLqEygcrAZiBEby4Xq9nvvfsVRcTE4bpLVNAaKr35EfQIGVcJIYGyg0I4nC1Wk4VLd2bypAiWsjzqvhPVFsMnIGNMcYIIQqF0-oPd2p3Fq8S8kSY67OvoBlq3dxIV-Em8-QdPaw_gIPeNVR-S5t6SPgFW8L4xuQyGgGMHiRu1PKu1xVEJxhUcFMEE4Sd9SUAWiriKwFFm9d4JH9jQKiMEfxaGhG1t3w1Ipxpp-W_yTkrW7Jrt8qilSruf7fD8_IJ-vTkLhP83-xafFT_87lIPHxU9uy16KslJBEKROF7jRI0LRuIuck6qiNdb96R0C5BUKRPvauoGiXxFbiY15yB9MqSXBHPRK6_8NrPAWYsHpZQhNwOxVDjEpfbX0ghsQwczGTxEcjezVun0viICD4sYWq9vG_25qWw0GuhQKrSEtPCSUFEnTykP2fOwYx8QejRKZ2q-NuYHWUF53e_prcVg5vq3"],"impression_trackers":["https://dev.adsbynimbus.com/impression_tracker/OTVBZ1Fxdy1LclR5PYbemr27sca0vxLUcB4qpILD6LYcBniyWMPDXNCGubAZHxF4j3uNAzYyvU39vgdfYT1KRIyVsm5se-qR15JoJCvEkfFDIl11w7q-0gxAxuAivR8C25v3lJJoyBnbCeA5D0eZBsX36yk4ajHA5D-X9yEeYN6BTqHC-CF571SccCFUAwLs1YVT4Qadgl_ZQtiwA_haP8wyd9U6M-QFULPxnNb824_l-uWzKn5yLpKvliMP_15nL7RYdZMFh8dfzSBDQ1rQ5lX5gQkaDDR3ZZ-cGAg-Sq-z_IBLz-j6-pxXBSvQehL7xKC16dgG5Lzr8mLP0Gualns49T56240OSmikICmNNBpadV_9UtCwmDpcuzCbjS-ANNlr6jHrNzfqmaxHqIAMZ1gr97U3lXDlHqEwDUi9YTsnDpTkmlYarcsA_HGgf22Wm6QhIsh9nGjQCbDJFFIg4BKzGqFrGBDivBJzd0V4nl6wmW_jw_WWF93pnYr4zo_173FWVt8y68dstAxF6NR-2gLbmtl5o7LMUPne8zbkC6fR9XsEeIvmFvcU8i9xdj-K4ly7CT4DVHG_N-IzYYx2-GKLa5bPqISc8OLI7FMPegoMz25bZer3i3UDFs6R5unSHAAnT68iuNmJYyue86j7qmX9TiCwHG_AQkcNQugv5BnJ1vAkvVGwWQZl0AE9cPPJ5hxUDMPMCpXphRUM6gqvDYP8Tr5qJlbs6vJZPymMrIRFHGrqCjkXLilyVLlTSIkp4MF0KykxFcPhRaNUeWkW3jLveUbyn6YlfBGWKEEoPOC0-b4LR-6_7rnM2TWtvgcqTIdPBWb_T3vKJYAZ0VkD-7j4M8KT2o4rU2-oxa3whlFVK6hYuoQj74Ky4dw2WZfrq0yHKgTnaUacyUsELs9ZNiVcGN7QmF4QFv6HxXTkJUVStiDEvLoTBlHCZA_pdnnc0Q0fjY7euhByh-irBA_-EWo4bwsLgFT6PNEhJI28inTGlAeuiW6XBYcj-WSdDLJ-J_dZRY2mzuTvb32c-tZCEsMMXQM-HF-wVxI_KeC8wZrKvMMjqNmVxKEea6-07y-sTna4e4wCwSnTkVy0vCXrFdqcpy7Sj5omiZT4rRjEpnyZ6bOpecuL4L3zIqghDNxuFUUGJI7yn57VkLihUFHVPO0V9U0nD6noyAzG2CDOTrcYQJvXJsSOJibUXjGk1AfzNFTWth3nzk9SKvd0j7DLoky6FL1TThcKMch30r8epx6qlfzPuv54qeSUoxL8EJZsTJzwsvpxNXEzcphCil7MX6TQJq3WjMcZOoSKOw-Iim5gxXl8MmlguHuL0VRVIH3dOv3Ne"]},"type":"static","width":320}`,
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {

			var regJSON Bid
			err := json.Unmarshal([]byte(tt.ResponseJSONString), &regJSON)
			if err != nil {
				t.Fatalf("json.Marshal failed %v", err)
			}

			var gojayJSON Bid
			gojay.UnmarshalJSONObject([]byte(tt.ResponseJSONString), &gojayJSON)
			if !cmp.Equal(regJSON, gojayJSON) {
				t.Errorf("TestBidRequestMarshalling()\ndiff\n %+v", cmp.Diff(regJSON, gojayJSON))
			}
		})
	}
}
