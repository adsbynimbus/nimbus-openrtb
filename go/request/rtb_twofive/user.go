package twofive

import "github.com/francoispqt/gojay"

// User object contains information known or derived about the human user of the device (i.e., the
// audience for advertising). The user id is an exchange artifact and may be subject to rotation or other
// privacy policies. However, this user ID must be stable long enough to serve reasonably as the basis for
// frequency capping and retargeting.
type User struct {
	Age        int      `json:"age,omitempty"         valid:"optional"`
	BuyerUID   string   `json:"buyeruid,omitempty"    valid:"optional"`
	YOB        int      `json:"yob,omitempty"         valid:"optional"`
	Gender     string   `json:"gender,omitempty"      valid:"in(male|female),optional"`
	Keywords   string   `json:"keywords,omitempty"    valid:"optional"`
	CustomData string   `json:"custom_data,omitempty" valid:"optional"`
	Data       []Data   `json:"data,omitempty"        valid:"optional"`
	Ext        *UserExt `json:"ext"                   valid:"optional"`
}

// UserExt being used for GDPR
type UserExt struct {
	Consent       string `json:"consent,omitempty"        valid:"base64rawstring,optional"` // if a publisher has their own cpm they can supply thier own GDPR consent string
	DidConsent    int    `json:"did_consent,omitempty"    valid:"range(0|1),optional"`      // Allows a publisher to let Nimbus know thier user has consent to thier data use policy for ads
	UnityBuyerUID string `json:"unity_buyeruid,omitempty" valid:"-"`                        // buyer id that is generated from the unity sdk and passed to nimbus in the rtb request
}

// MarshalJSONObject implements MarshalerJSONObject
func (u *User) MarshalJSONObject(enc *gojay.Encoder) {
	enc.IntKeyOmitEmpty("age", u.Age)
	enc.StringKeyOmitEmpty("buyeruid", u.BuyerUID)
	enc.IntKeyOmitEmpty("yob", u.YOB)
	enc.StringKeyOmitEmpty("gender", u.Gender)
	enc.StringKeyOmitEmpty("keywords", u.Keywords)
	enc.StringKeyOmitEmpty("custom_data", u.CustomData)
	var dataSlice = Datas(u.Data)
	enc.ArrayKeyOmitEmpty("data", dataSlice)
	enc.ObjectKeyNullEmpty("ext", u.Ext)
}

// IsNil checks if instance is nil
func (u *User) IsNil() bool {
	return u == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (u *User) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {
	case "age":
		return dec.Int(&u.Age)

	case "buyeruid":
		return dec.String(&u.BuyerUID)

	case "yob":
		return dec.Int(&u.YOB)

	case "gender":
		return dec.String(&u.Gender)

	case "keywords":
		return dec.String(&u.Keywords)

	case "custom_data":
		return dec.String(&u.CustomData)

	case "data":
		var aSlice = Datas{}
		err := dec.Array(&aSlice)
		if err == nil && len(aSlice) > 0 {
			u.Data = []Data(aSlice)
		}
		return err

	case "ext":
		var userExt UserExt
		err := dec.Object(&userExt)
		if err == nil {
			u.Ext = &userExt
		}
		return err

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (u *User) NKeys() int { return 0 }

// MarshalJSONObject implements MarshalerJSONObject
func (e *UserExt) MarshalJSONObject(enc *gojay.Encoder) {
	enc.StringKeyOmitEmpty("consent", e.Consent)
	enc.IntKeyOmitEmpty("did_consent", e.DidConsent)
	enc.StringKeyOmitEmpty("unity_buyeruid", e.UnityBuyerUID)
}

// IsNil checks if instance is nil
func (e *UserExt) IsNil() bool {
	return e == nil
}

// UnmarshalJSONObject implements gojay's UnmarshalerJSONObject
func (e *UserExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error {

	switch k {

	case "consent":
		return dec.String(&e.Consent)

	case "did_consent":
		return dec.Int(&e.DidConsent)

	case "unity_buyeruid":
		return dec.String(&e.UnityBuyerUID)

	}
	return nil
}

// NKeys returns the number of keys to unmarshal
func (e *UserExt) NKeys() int { return 0 }
