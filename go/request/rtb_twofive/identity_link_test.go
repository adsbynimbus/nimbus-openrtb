package twofive

import (
	"bytes"
	"encoding/json"
	"testing"

	"github.com/francoispqt/gojay"
	"github.com/google/go-cmp/cmp"
)

// https://github.com/Advertising-ID-Consortium/IdentityLink-in-RTB
var _dataExample = `
[
    {
      "source": "liveramp.com",
      "uids": [
        {
          "id": "XY1000bIVBVah9ium-sZ3ykhPiXQbEcUpn4GjCtxrrw2BRDGM",
          "ext": {
            "rtiPartner": "idl"
          }
        }
      ]
    },
      {
        "source": "adserver.org",
        "uids": [
          {
            "id": "6bca7f6b-a98a-46c0-be05-6020f7604598",
            "ext": {
              "rtiPartner": "TDID"
            }
          }
        ]
      }
    ]
`

func TestIdentityLinkSerialization(t *testing.T) {
	var eidsJSON EIDS
	if jErr := json.Unmarshal([]byte(_dataExample), &eidsJSON); jErr != nil {
		t.Fatalf("TestIdentityLinkSerialization() Unable to json.Unmarshal %v", eidsJSON)
	}

	var eidsGojay EIDS
	if jErr := gojay.UnmarshalJSONArray([]byte(_dataExample), &eidsGojay); jErr != nil {
		t.Fatalf("TestIdentityLinkSerialization() Unable to gojay.Unmarshal %v", eidsGojay)
	}

	if !cmp.Equal(eidsJSON, eidsGojay) {
		t.Errorf("TestIdentityLinkSerialization() gojay != standard lib = diff\n %+v", cmp.Diff(eidsJSON, eidsGojay))
	}

	b := new(bytes.Buffer)
	enc := gojay.BorrowEncoder(b)
	encodeErr := enc.Encode(&eidsGojay)
	defer enc.Release()
	if encodeErr != nil {
		t.Fatalf("TestIdentityLinkSerialization() gojay.Marshal failed %v", encodeErr)
	}
	gojayBytes := b.Bytes()
	wantBytes := bytes.Replace([]byte(_dataExample), []byte(" "), []byte(""), -1)
	wantBytes = bytes.Replace(wantBytes, []byte("\n"), []byte(""), -1)
	if !cmp.Equal(gojayBytes, wantBytes) {
		t.Errorf("TestIdentityLinkSerialization() encoded bytes don't match the expectations diff\n %+v", cmp.Diff(gojayBytes, wantBytes))
	}
}
