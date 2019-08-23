package twofive

import (
	"bytes"
	"encoding/json"
	"strings"

	"github.com/francoispqt/gojay"
)

// UnmarshalJSON handles mixed content from APS SDK, this silently fails so that Nimbus's auctions are uneffected if APS changes the data structures underneath
func (a *APS) UnmarshalJSON(b []byte) error {
	var rawData map[string]interface{}
	err := json.Unmarshal(b, &rawData)
	if err != nil {
		return nil
	}

	writeJSON := func(buf *bytes.Buffer, key string, value []interface{}) {
		buf.WriteString(`"` + key + `":[`)
		for i, v := range value {
			buf.WriteString(`"` + v.(string) + `"`)
			if i+1 < len(value) {
				buf.WriteByte(',')
			}
		}
		buf.WriteString(`]`)
	}

	// allocate the buffer upfront
	buf := bytes.NewBuffer(make([]byte, 0, len(b)))
	buf.WriteByte('{')

	i, keysN := 1, len(rawData)
	for key, value := range rawData {
		switch rawData[key].(type) {
		case []interface{}:
			writeJSON(buf, key, value.([]interface{}))
		case string:
			// handle the case where the SDK sends seperated values
			parts := strings.Split(value.(string), ",")
			if len(parts) == 1 && len(parts[0]) == 0 {
				parts = []string{}
			}

			// create an interface slice for the method, for the most part this will always be a slice of 1
			slice := make([]interface{}, len(parts))
			for i := 0; i < len(parts); i++ {
				slice[i] = parts[i]
			}
			writeJSON(buf, key, slice)
		}
		if i < keysN {
			buf.WriteByte(',')
			i++
		}
	}
	buf.WriteByte('}')

	err = gojay.UnmarshalJSONObject(buf.Bytes(), a)
	if err != nil {
		// avoid infinate recursion, create a type alias
		type temp APS
		var tempAPS temp
		err = json.Unmarshal(buf.Bytes(), &tempAPS)
		if err != nil {
			return nil
		}
		// mutate a
		*a = APS(tempAPS)
	}
	return nil
}
