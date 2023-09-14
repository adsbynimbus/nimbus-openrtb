

# twofive
`import "github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive"`

* [Overview](#pkg-overview)
* [Index](#pkg-index)

## <a name="pkg-overview">Overview</a>



## <a name="pkg-index">Index</a>
* [Constants](#pkg-constants)
* [func FloatPointer(f float64) *float64](#FloatPointer)
* [func IntPointer(i int) *int](#IntPointer)
* [type APS](#APS)
  * [func (s *APS) IsNil() bool](#APS.IsNil)
  * [func (s *APS) MarshalJSONObject(enc *gojay.Encoder)](#APS.MarshalJSONObject)
  * [func (s *APS) NKeys() int](#APS.NKeys)
  * [func (a *APS) UnmarshalJSON(b []byte) error](#APS.UnmarshalJSON)
  * [func (s *APS) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#APS.UnmarshalJSONObject)
* [type APSs](#APSs)
  * [func (s APSs) IsNil() bool](#APSs.IsNil)
  * [func (s APSs) MarshalJSONArray(enc *gojay.Encoder)](#APSs.MarshalJSONArray)
  * [func (s *APSs) UnmarshalJSONArray(dec *gojay.Decoder) error](#APSs.UnmarshalJSONArray)
* [type App](#App)
  * [func (a *App) IsNil() bool](#App.IsNil)
  * [func (a *App) MarshalJSONObject(enc *gojay.Encoder)](#App.MarshalJSONObject)
  * [func (a *App) NKeys() int](#App.NKeys)
  * [func (a *App) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#App.UnmarshalJSONObject)
* [type Banner](#Banner)
  * [func (b *Banner) IsNil() bool](#Banner.IsNil)
  * [func (b *Banner) MarshalJSONObject(enc *gojay.Encoder)](#Banner.MarshalJSONObject)
  * [func (b *Banner) NKeys() int](#Banner.NKeys)
  * [func (b *Banner) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Banner.UnmarshalJSONObject)
* [type Banners](#Banners)
  * [func (s Banners) IsNil() bool](#Banners.IsNil)
  * [func (s Banners) MarshalJSONArray(enc *gojay.Encoder)](#Banners.MarshalJSONArray)
  * [func (s *Banners) UnmarshalJSONArray(dec *gojay.Decoder) error](#Banners.UnmarshalJSONArray)
* [type Data](#Data)
  * [func (d *Data) IsNil() bool](#Data.IsNil)
  * [func (d *Data) MarshalJSONObject(enc *gojay.Encoder)](#Data.MarshalJSONObject)
  * [func (d *Data) NKeys() int](#Data.NKeys)
  * [func (d *Data) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Data.UnmarshalJSONObject)
* [type Datas](#Datas)
  * [func (s Datas) IsNil() bool](#Datas.IsNil)
  * [func (s Datas) MarshalJSONArray(enc *gojay.Encoder)](#Datas.MarshalJSONArray)
  * [func (s *Datas) UnmarshalJSONArray(dec *gojay.Decoder) error](#Datas.UnmarshalJSONArray)
* [type Device](#Device)
  * [func (d *Device) IsNil() bool](#Device.IsNil)
  * [func (d *Device) MarshalJSONObject(enc *gojay.Encoder)](#Device.MarshalJSONObject)
  * [func (d *Device) NKeys() int](#Device.NKeys)
  * [func (d *Device) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Device.UnmarshalJSONObject)
* [type Format](#Format)
  * [func (f *Format) IsNil() bool](#Format.IsNil)
  * [func (f *Format) MarshalJSONObject(enc *gojay.Encoder)](#Format.MarshalJSONObject)
  * [func (f *Format) NKeys() int](#Format.NKeys)
  * [func (f *Format) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Format.UnmarshalJSONObject)
* [type Formats](#Formats)
  * [func (s Formats) IsNil() bool](#Formats.IsNil)
  * [func (s Formats) MarshalJSONArray(enc *gojay.Encoder)](#Formats.MarshalJSONArray)
  * [func (s *Formats) UnmarshalJSONArray(dec *gojay.Decoder) error](#Formats.UnmarshalJSONArray)
* [type Geo](#Geo)
  * [func (g *Geo) IsNil() bool](#Geo.IsNil)
  * [func (g *Geo) MarshalJSONObject(enc *gojay.Encoder)](#Geo.MarshalJSONObject)
  * [func (g *Geo) NKeys() int](#Geo.NKeys)
  * [func (g *Geo) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Geo.UnmarshalJSONObject)
* [type Imp](#Imp)
  * [func (i *Imp) IsNil() bool](#Imp.IsNil)
  * [func (i *Imp) MarshalJSONObject(enc *gojay.Encoder)](#Imp.MarshalJSONObject)
  * [func (i *Imp) NKeys() int](#Imp.NKeys)
  * [func (i *Imp) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Imp.UnmarshalJSONObject)
* [type ImpExt](#ImpExt)
  * [func (e *ImpExt) IsNil() bool](#ImpExt.IsNil)
  * [func (e *ImpExt) MarshalJSONObject(enc *gojay.Encoder)](#ImpExt.MarshalJSONObject)
  * [func (e *ImpExt) NKeys() int](#ImpExt.NKeys)
  * [func (e *ImpExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#ImpExt.UnmarshalJSONObject)
* [type Imps](#Imps)
  * [func (s Imps) IsNil() bool](#Imps.IsNil)
  * [func (s Imps) MarshalJSONArray(enc *gojay.Encoder)](#Imps.MarshalJSONArray)
  * [func (s *Imps) UnmarshalJSONArray(dec *gojay.Decoder) error](#Imps.UnmarshalJSONArray)
* [type Ints](#Ints)
  * [func (a Ints) IsNil() bool](#Ints.IsNil)
  * [func (a Ints) MarshalJSONArray(enc *gojay.Encoder)](#Ints.MarshalJSONArray)
  * [func (a *Ints) UnmarshalJSONArray(dec *gojay.Decoder) error](#Ints.UnmarshalJSONArray)
* [type Publisher](#Publisher)
  * [func (p *Publisher) IsNil() bool](#Publisher.IsNil)
  * [func (p *Publisher) MarshalJSONObject(enc *gojay.Encoder)](#Publisher.MarshalJSONObject)
  * [func (p *Publisher) NKeys() int](#Publisher.NKeys)
  * [func (p *Publisher) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Publisher.UnmarshalJSONObject)
* [type Regs](#Regs)
  * [func (r *Regs) IsNil() bool](#Regs.IsNil)
  * [func (r *Regs) MarshalJSONObject(enc *gojay.Encoder)](#Regs.MarshalJSONObject)
  * [func (r *Regs) NKeys() int](#Regs.NKeys)
  * [func (r *Regs) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Regs.UnmarshalJSONObject)
* [type RegsExt](#RegsExt)
  * [func (e *RegsExt) IsNil() bool](#RegsExt.IsNil)
  * [func (e *RegsExt) MarshalJSONObject(enc *gojay.Encoder)](#RegsExt.MarshalJSONObject)
  * [func (e *RegsExt) NKeys() int](#RegsExt.NKeys)
  * [func (e *RegsExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#RegsExt.UnmarshalJSONObject)
* [type Request](#Request)
  * [func (r *Request) IsNil() bool](#Request.IsNil)
  * [func (r *Request) MarshalJSONObject(enc *gojay.Encoder)](#Request.MarshalJSONObject)
  * [func (r *Request) NKeys() int](#Request.NKeys)
  * [func (r *Request) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Request.UnmarshalJSONObject)
* [type RequestExt](#RequestExt)
  * [func (e *RequestExt) IsNil() bool](#RequestExt.IsNil)
  * [func (e *RequestExt) MarshalJSONObject(enc *gojay.Encoder)](#RequestExt.MarshalJSONObject)
  * [func (e *RequestExt) NKeys() int](#RequestExt.NKeys)
  * [func (e *RequestExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#RequestExt.UnmarshalJSONObject)
* [type Segment](#Segment)
  * [func (s *Segment) IsNil() bool](#Segment.IsNil)
  * [func (s *Segment) MarshalJSONObject(enc *gojay.Encoder)](#Segment.MarshalJSONObject)
  * [func (s *Segment) NKeys() int](#Segment.NKeys)
  * [func (s *Segment) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Segment.UnmarshalJSONObject)
* [type Segments](#Segments)
  * [func (s Segments) IsNil() bool](#Segments.IsNil)
  * [func (s Segments) MarshalJSONArray(enc *gojay.Encoder)](#Segments.MarshalJSONArray)
  * [func (s *Segments) UnmarshalJSONArray(dec *gojay.Decoder) error](#Segments.UnmarshalJSONArray)
* [type Source](#Source)
  * [func (s *Source) IsNil() bool](#Source.IsNil)
  * [func (s *Source) MarshalJSONObject(enc *gojay.Encoder)](#Source.MarshalJSONObject)
  * [func (s *Source) NKeys() int](#Source.NKeys)
  * [func (s *Source) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Source.UnmarshalJSONObject)
* [type SourceExt](#SourceExt)
  * [func (s *SourceExt) IsNil() bool](#SourceExt.IsNil)
  * [func (s *SourceExt) MarshalJSONObject(enc *gojay.Encoder)](#SourceExt.MarshalJSONObject)
  * [func (s *SourceExt) NKeys() int](#SourceExt.NKeys)
  * [func (s *SourceExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#SourceExt.UnmarshalJSONObject)
* [type Strings](#Strings)
  * [func (a Strings) IsNil() bool](#Strings.IsNil)
  * [func (a Strings) MarshalJSONArray(enc *gojay.Encoder)](#Strings.MarshalJSONArray)
  * [func (a *Strings) UnmarshalJSONArray(dec *gojay.Decoder) error](#Strings.UnmarshalJSONArray)
* [type User](#User)
  * [func (u *User) IsNil() bool](#User.IsNil)
  * [func (u *User) MarshalJSONObject(enc *gojay.Encoder)](#User.MarshalJSONObject)
  * [func (u *User) NKeys() int](#User.NKeys)
  * [func (u *User) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#User.UnmarshalJSONObject)
* [type UserExt](#UserExt)
  * [func (e *UserExt) IsNil() bool](#UserExt.IsNil)
  * [func (e *UserExt) MarshalJSONObject(enc *gojay.Encoder)](#UserExt.MarshalJSONObject)
  * [func (e *UserExt) NKeys() int](#UserExt.NKeys)
  * [func (e *UserExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#UserExt.UnmarshalJSONObject)
* [type Video](#Video)
  * [func (v *Video) IsNil() bool](#Video.IsNil)
  * [func (v *Video) MarshalJSONObject(enc *gojay.Encoder)](#Video.MarshalJSONObject)
  * [func (v *Video) NKeys() int](#Video.NKeys)
  * [func (v *Video) UnmarshalJSONObject(dec *gojay.Decoder, k string) error](#Video.UnmarshalJSONObject)


#### <a name="pkg-files">Package files</a>
[app.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/app.go) [aps.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/aps.go) [aps_custom_unmarshaller.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/aps_custom_unmarshaller.go) [banner.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/banner.go) [data.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/data.go) [device.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/device.go) [format.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/format.go) [geo.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/geo.go) [imp.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/imp.go) [primitives-to-references.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/primitives-to-references.go) [primitives.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/primitives.go) [publisher.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/publisher.go) [regs.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/regs.go) [request.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/request.go) [segment.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/segment.go) [source.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/source.go) [user.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/user.go) [video.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/request/rtb_twofive/video.go) 


## <a name="pkg-constants">Constants</a>
``` go
const (
    Header  = "x-openrtb-version"
    Version = "2.5"

    EncodingHeader = "Content-Encoding"
    EncodingValue  = "gzip"
)
```
Header required in RTB requests




## <a name="FloatPointer">func</a> [FloatPointer](/src/target/primitives-to-references.go?s=90:127#L4)
``` go
func FloatPointer(f float64) *float64
```
FloatPointer is a utility function to return a reference of a float64



## <a name="IntPointer">func</a> [IntPointer](/src/target/primitives-to-references.go?s=211:238#L9)
``` go
func IntPointer(i int) *int
```
IntPointer is a utility function to return a reference of a int




## <a name="APS">type</a> [APS](/src/target/aps.go?s=108:526#L6)
``` go
type APS struct {
    AmznB     []string `json:"amzn_b"     valid:"optional"`
    AmznVid   []string `json:"amzn_vid"   valid:"optional"`
    AmznH     []string `json:"amzn_h"     valid:"optional"`
    Amznp     []string `json:"amznp"      valid:"optional"`
    Amznrdr   []string `json:"amznrdr"    valid:"optional"`
    Amznslots []string `json:"amznslots"  valid:"optional"`
    Dc        []string `json:"dc"         valid:"optional"`
}
```
APS is the response Object the APS sdk generates










### <a name="APS.IsNil">func</a> (\*APS) [IsNil](/src/target/aps.go?s=1185:1211#L35)
``` go
func (s *APS) IsNil() bool
```
IsNil checks if instance is nil




### <a name="APS.MarshalJSONObject">func</a> (\*APS) [MarshalJSONObject](/src/target/aps.go?s=580:631#L17)
``` go
func (s *APS) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="APS.NKeys">func</a> (\*APS) [NKeys](/src/target/aps.go?s=2534:2559#L104)
``` go
func (s *APS) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="APS.UnmarshalJSON">func</a> (\*APS) [UnmarshalJSON](/src/target/aps_custom_unmarshaller.go?s=259:302#L12)
``` go
func (a *APS) UnmarshalJSON(b []byte) error
```
UnmarshalJSON handles mixed content from APS SDK, this silently fails so that Nimbus's auctions are uneffected if APS changes the data structures underneath




### <a name="APS.UnmarshalJSONObject">func</a> (\*APS) [UnmarshalJSONObject](/src/target/aps.go?s=1298:1367#L40)
``` go
func (s *APS) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="APSs">type</a> [APSs](/src/target/aps.go?s=2586:2601#L107)
``` go
type APSs []APS
```
APSs ...










### <a name="APSs.IsNil">func</a> (APSs) [IsNil](/src/target/aps.go?s=2945:2971#L127)
``` go
func (s APSs) IsNil() bool
```
IsNil ...




### <a name="APSs.MarshalJSONArray">func</a> (APSs) [MarshalJSONArray](/src/target/aps.go?s=2833:2883#L120)
``` go
func (s APSs) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




### <a name="APSs.UnmarshalJSONArray">func</a> (\*APSs) [UnmarshalJSONArray](/src/target/aps.go?s=2629:2688#L110)
``` go
func (s *APSs) UnmarshalJSONArray(dec *gojay.Decoder) error
```
UnmarshalJSONArray ...




## <a name="App">type</a> [App](/src/target/app.go?s=354:1228#L8)
``` go
type App struct {
    Name          string    `json:"name"                 valid:"required"`
    Bundle        string    `json:"bundle"               valid:"required"`
    Domain        string    `json:"domain"               valid:"required"`
    StoreURL      string    `json:"storeurl"             valid:"required"`
    Cat           []string  `json:"cat,omitempty"        valid:"optional"`
    SectionCat    []string  `json:"sectioncat,omitempty" valid:"optional"`
    PageCat       []string  `json:"pagecat,omitempty"    valid:"optional"`
    Ver           string    `json:"ver,omitempty"        valid:"optional"`
    PrivacyPolicy int       `json:"privacypolicy"        valid:"range(0|1),optional"` // no policy 0 policy 1
    Paid          int       `json:"paid"                 valid:"range(0|1),optional"` // free 0 paid 1
    Publisher     Publisher `json:"publisher"            valid:"required"`
}
```
App object should be included if the ad supported content is a non-browser application (typically in
mobile) as opposed to a website. A bid request must not contain both an App and a Site object. At a
minimum, it is useful to provide an App ID or bundle, but this is not strictly required










### <a name="App.IsNil">func</a> (\*App) [IsNil](/src/target/app.go?s=1925:1951#L41)
``` go
func (a *App) IsNil() bool
```
IsNil checks if instance is nil




### <a name="App.MarshalJSONObject">func</a> (\*App) [MarshalJSONObject](/src/target/app.go?s=1282:1333#L23)
``` go
func (a *App) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="App.NKeys">func</a> (\*App) [NKeys](/src/target/app.go?s=3060:3085#L103)
``` go
func (a *App) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="App.UnmarshalJSONObject">func</a> (\*App) [UnmarshalJSONObject](/src/target/app.go?s=2038:2107#L46)
``` go
func (a *App) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Banner">type</a> [Banner](/src/target/banner.go?s=553:1588#L12)
``` go
type Banner struct {
    BidFloor *float64 `json:"bidfloor,omitempty" valid:"optional"`
    BAttr    []int    `json:"battr,omitempty"    valid:"optional"`
    Format   []Format `json:"format,omitempty"   valid:"optional"`
    W        int      `json:"w"                  valid:"required"`
    H        int      `json:"h"                  valid:"required"`
    API      []int    `json:"api,omitempty"      valid:"inintarr(1|2|3|4|5|6),optional"` // 3,5,6 -> mraid1, 2, and 3
    Pos      int      `json:"pos,omitempty"      valid:"range(0|7),optional"`            // 0,1,2,3,4,5,6,7 -> Unknown, Above the Fold, DEPRECATED - May or may not be initially visible depending on screen size/resolution.,Below the Fold,Header,Footer,Sidebar,Full Screen
    Vcm      int      `json:"vcm,omitempty"      valid:"optional"`                       // Relevant only for Banner objects used with a Video object (Section 3.2.7) in an array of companion ads. Indicates the  companion banner rendering mode relative to the associated video, where 0 = concurrent, 1 = end-card.
}
```
Banner represents the most general type of impression. Although the term “banner” may have very
specific meaning in other contexts, here it can be many things including a simple static image, an
expandable ad unit, or even in-banner video (refer to the Video object in Section 3.2.4 for the more
generalized and full featured video ad units). An array of Banner objects can also appear within the
Video to describe optional companion ads defined in the VAST specification.










### <a name="Banner.IsNil">func</a> (\*Banner) [IsNil](/src/target/banner.go?s=2174:2203#L41)
``` go
func (b *Banner) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Banner.MarshalJSONObject">func</a> (\*Banner) [MarshalJSONObject](/src/target/banner.go?s=1642:1696#L24)
``` go
func (b *Banner) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Banner.NKeys">func</a> (\*Banner) [NKeys](/src/target/banner.go?s=3165:3193#L99)
``` go
func (b *Banner) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Banner.UnmarshalJSONObject">func</a> (\*Banner) [UnmarshalJSONObject](/src/target/banner.go?s=2290:2362#L46)
``` go
func (b *Banner) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Banners">type</a> [Banners](/src/target/banner.go?s=3223:3244#L102)
``` go
type Banners []Banner
```
Banners ...










### <a name="Banners.IsNil">func</a> (Banners) [IsNil](/src/target/banner.go?s=3597:3626#L122)
``` go
func (s Banners) IsNil() bool
```
IsNil ...




### <a name="Banners.MarshalJSONArray">func</a> (Banners) [MarshalJSONArray](/src/target/banner.go?s=3482:3535#L115)
``` go
func (s Banners) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




### <a name="Banners.UnmarshalJSONArray">func</a> (\*Banners) [UnmarshalJSONArray](/src/target/banner.go?s=3272:3334#L105)
``` go
func (s *Banners) UnmarshalJSONArray(dec *gojay.Decoder) error
```
UnmarshalJSONArray ...




## <a name="Data">type</a> [Data](/src/target/data.go?s=439:648#L9)
``` go
type Data struct {
    ID      string    `json:"id,omitempty"      valid:"optional"`
    Name    string    `json:"name,omitempty"    valid:"optional"`
    Segment []Segment `json:"segment,omitempty" valid:"optional"`
}
```
Data and Segment objects together allow additional data about the user to be specified. This data
may be from multiple sources whether from the exchange itself or third party providers as specified by
the id field. A bid request can mix data objects from multiple providers. The specific data providers in
use should be published by the exchange a priori to its bidders.










### <a name="Data.IsNil">func</a> (\*Data) [IsNil](/src/target/data.go?s=959:986#L24)
``` go
func (d *Data) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Data.MarshalJSONObject">func</a> (\*Data) [MarshalJSONObject](/src/target/data.go?s=702:754#L16)
``` go
func (d *Data) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Data.NKeys">func</a> (\*Data) [NKeys](/src/target/data.go?s=1469:1495#L51)
``` go
func (d *Data) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Data.UnmarshalJSONObject">func</a> (\*Data) [UnmarshalJSONObject](/src/target/data.go?s=1073:1143#L29)
``` go
func (d *Data) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Datas">type</a> [Datas](/src/target/data.go?s=1523:1540#L54)
``` go
type Datas []Data
```
Datas ...










### <a name="Datas.IsNil">func</a> (Datas) [IsNil](/src/target/data.go?s=1887:1914#L74)
``` go
func (s Datas) IsNil() bool
```
IsNil ...




### <a name="Datas.MarshalJSONArray">func</a> (Datas) [MarshalJSONArray](/src/target/data.go?s=1774:1825#L67)
``` go
func (s Datas) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




### <a name="Datas.UnmarshalJSONArray">func</a> (\*Datas) [UnmarshalJSONArray](/src/target/data.go?s=1568:1628#L57)
``` go
func (s *Datas) UnmarshalJSONArray(dec *gojay.Decoder) error
```
UnmarshalJSONArray ...




## <a name="Device">type</a> [Device](/src/target/device.go?s=344:1756#L8)
``` go
type Device struct {
    Ua             string `json:"ua"                        valid:"required"`
    Geo            *Geo   `json:"geo,omitempty"             valid:"optional"`
    Dnt            int    `json:"dnt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking is restricted
    Lmt            int    `json:"lmt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking must be limited by commercial guidelines
    IP             string `json:"ip"                        valid:"ipv4,optional"`
    DeviceType     int    `json:"devicetype,omitempty"      valid:"required"`
    Make           string `json:"make,omitempty"            valid:"optional"`
    Model          string `json:"model,omitempty"           valid:"optional"`
    OS             string `json:"os,omitempty"              valid:"in(android|ios),required"`
    OSV            string `json:"osv,omitempty"             valid:"optional"`
    H              int    `json:"h,omitempty"               valid:"optional"`
    W              int    `json:"w,omitempty"               valid:"optional"`
    Language       string `json:"language,omitempty"        valid:"optional"`
    Carrier        string `json:"carrier,omitempty"         valid:"optional"`
    ConnectionType int    `json:"connectiontype,omitempty"  valid:"optional"`
    Ifa            string `json:"ifa"                       valid:"required"`
}
```
Device object provides information pertaining to the device through which the user is interacting. Device
information includes its hardware, platform, location, and carrier data. The device can refer to a mobile
handset, a desktop computer, set top box, or other digital device.










### <a name="Device.IsNil">func</a> (\*Device) [IsNil](/src/target/device.go?s=2487:2516#L48)
``` go
func (d *Device) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Device.MarshalJSONObject">func</a> (\*Device) [MarshalJSONObject](/src/target/device.go?s=1810:1864#L28)
``` go
func (d *Device) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Device.NKeys">func</a> (\*Device) [NKeys](/src/target/device.go?s=3520:3548#L113)
``` go
func (d *Device) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Device.UnmarshalJSONObject">func</a> (\*Device) [UnmarshalJSONObject](/src/target/device.go?s=2603:2675#L53)
``` go
func (d *Device) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Format">type</a> [Format](/src/target/format.go?s=256:358#L7)
``` go
type Format struct {
    W int `json:"w"      valid:"required"`
    H int `json:"h"      valid:"required"`
}
```
Format object represents an allowed size (i.e., height and width combination) for a banner impression.
These are typically used in an array for an impression where multiple sizes are permitted.










### <a name="Format.IsNil">func</a> (\*Format) [IsNil](/src/target/format.go?s=569:598#L19)
``` go
func (f *Format) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Format.MarshalJSONObject">func</a> (\*Format) [MarshalJSONObject](/src/target/format.go?s=412:466#L13)
``` go
func (f *Format) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Format.NKeys">func</a> (\*Format) [NKeys](/src/target/format.go?s=910:938#L38)
``` go
func (f *Format) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Format.UnmarshalJSONObject">func</a> (\*Format) [UnmarshalJSONObject](/src/target/format.go?s=685:757#L24)
``` go
func (f *Format) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Formats">type</a> [Formats](/src/target/format.go?s=968:989#L41)
``` go
type Formats []Format
```
Formats ...










### <a name="Formats.IsNil">func</a> (Formats) [IsNil](/src/target/format.go?s=1342:1371#L61)
``` go
func (s Formats) IsNil() bool
```
IsNil ...




### <a name="Formats.MarshalJSONArray">func</a> (Formats) [MarshalJSONArray](/src/target/format.go?s=1227:1280#L54)
``` go
func (s Formats) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




### <a name="Formats.UnmarshalJSONArray">func</a> (\*Formats) [UnmarshalJSONArray](/src/target/format.go?s=1017:1079#L44)
``` go
func (s *Formats) UnmarshalJSONArray(dec *gojay.Decoder) error
```
UnmarshalJSONArray ...




## <a name="Geo">type</a> [Geo](/src/target/geo.go?s=422:1182#L9)
``` go
type Geo struct {
    Lat       float64 `json:"lat,omitempty"       valid:"required"`
    Lon       float64 `json:"lon,omitempty"       valid:"required"`
    Type      int     `json:"type,omitempty"      valid:"range(1|3),optional"`    // 1,2,3 -> GPS/Location Services, IP Address, User provided (e.g., registration data)
    IPService int     `json:"ipservice,omitempty" valid:"range(1|4),optional"`    // 1,2,3,4 -> ip2location, Neustar (Quova), MaxMind, NetAcuity (Digital Element)
    Country   string  `json:"country,omitempty"   valid:"ISO3166Alpha3,optional"` // alpha 3
    City      string  `json:"city,omitempty"      valid:"optional"`
    Metro     string  `json:"metro,omitempty"     valid:"optional"`
    State     string  `json:"state,omitempty"     valid:"optional"`
}
```
Geo object encapsulates various methods for specifying a geographic location. When subordinate to a
Device object, it indicates the location of the device which can also be interpreted as the user’s current
location. When subordinate to a User object, it indicates the location of the user’s home base (i.e., not
necessarily their current location).










### <a name="Geo.IsNil">func</a> (\*Geo) [IsNil](/src/target/geo.go?s=1660:1686#L33)
``` go
func (g *Geo) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Geo.MarshalJSONObject">func</a> (\*Geo) [MarshalJSONObject](/src/target/geo.go?s=1236:1287#L21)
``` go
func (g *Geo) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Geo.NKeys">func</a> (\*Geo) [NKeys](/src/target/geo.go?s=2289:2314#L70)
``` go
func (g *Geo) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Geo.UnmarshalJSONObject">func</a> (\*Geo) [UnmarshalJSONObject](/src/target/geo.go?s=1773:1842#L38)
``` go
func (g *Geo) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Imp">type</a> [Imp](/src/target/imp.go?s=364:972#L10)
``` go
type Imp struct {
    ID       string  `json:"id,omitempty"                   valid:"optional"`
    Banner   *Banner `json:"banner,omitempty"               valid:"optional"`
    Video    *Video  `json:"video,omitempty"                valid:"optional"`
    Instl    int     `json:"instl"                          valid:"range(0|1),optional"` // 0 = not interstitial, 1 = interstitial
    BidFloor float64 `json:"bidfloor"                       valid:"optional"`
    Secure   *int    `json:"secure"                         valid:"range(0|1),optional"`
    Ext      *ImpExt `json:"ext,omitempty"                  valid:"optional"`
}
```
Imp describes an ad placement or impression being auctioned. A single bid request can include
multiple Imp objects, a use case for which might be an exchange that supports selling all ad positions on
a given page. Each Imp object has a required ID so that bids can reference them individually.










### <a name="Imp.IsNil">func</a> (\*Imp) [IsNil](/src/target/imp.go?s=1812:1838#L41)
``` go
func (i *Imp) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Imp.MarshalJSONObject">func</a> (\*Imp) [MarshalJSONObject](/src/target/imp.go?s=1431:1482#L28)
``` go
func (i *Imp) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Imp.NKeys">func</a> (\*Imp) [NKeys](/src/target/imp.go?s=2690:2715#L98)
``` go
func (i *Imp) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Imp.UnmarshalJSONObject">func</a> (\*Imp) [UnmarshalJSONObject](/src/target/imp.go?s=1925:1994#L46)
``` go
func (i *Imp) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="ImpExt">type</a> [ImpExt](/src/target/imp.go?s=988:1377#L21)
``` go
type ImpExt struct {
    APS           []APS  `json:"aps,omitempty"             valid:"optional"`
    FacebookAppID string `json:"facebook_app_id,omitempty" valid:"optional"` // needed for pubs that have FB hybrid SDK solution in thier stack
    Position      string `json:"position,omitempty"        valid:"required"` // flexible optional field for publishers to track on ad position performance
}
```
ImpExt ...










### <a name="ImpExt.IsNil">func</a> (\*ImpExt) [IsNil](/src/target/imp.go?s=3053:3082#L109)
``` go
func (e *ImpExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="ImpExt.MarshalJSONObject">func</a> (\*ImpExt) [MarshalJSONObject](/src/target/imp.go?s=2782:2836#L101)
``` go
func (e *ImpExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="ImpExt.NKeys">func</a> (\*ImpExt) [NKeys](/src/target/imp.go?s=3583:3611#L136)
``` go
func (e *ImpExt) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="ImpExt.UnmarshalJSONObject">func</a> (\*ImpExt) [UnmarshalJSONObject](/src/target/imp.go?s=3169:3241#L114)
``` go
func (e *ImpExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Imps">type</a> [Imps](/src/target/imp.go?s=3638:3653#L139)
``` go
type Imps []Imp
```
Imps ...










### <a name="Imps.IsNil">func</a> (Imps) [IsNil](/src/target/imp.go?s=3997:4023#L159)
``` go
func (s Imps) IsNil() bool
```
IsNil ...




### <a name="Imps.MarshalJSONArray">func</a> (Imps) [MarshalJSONArray](/src/target/imp.go?s=3885:3935#L152)
``` go
func (s Imps) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




### <a name="Imps.UnmarshalJSONArray">func</a> (\*Imps) [UnmarshalJSONArray](/src/target/imp.go?s=3681:3740#L142)
``` go
func (s *Imps) UnmarshalJSONArray(dec *gojay.Decoder) error
```
UnmarshalJSONArray ...




## <a name="Ints">type</a> [Ints](/src/target/primitives.go?s=118:133#L10)
``` go
type Ints []int
```
Ints ...










### <a name="Ints.IsNil">func</a> (Ints) [IsNil](/src/target/primitives.go?s=547:573#L30)
``` go
func (a Ints) IsNil() bool
```
IsNil checks if array is nil




### <a name="Ints.MarshalJSONArray">func</a> (Ints) [MarshalJSONArray](/src/target/primitives.go?s=414:464#L23)
``` go
func (a Ints) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray encodes arrays into JSON




### <a name="Ints.UnmarshalJSONArray">func</a> (\*Ints) [UnmarshalJSONArray](/src/target/primitives.go?s=196:255#L13)
``` go
func (a *Ints) UnmarshalJSONArray(dec *gojay.Decoder) error
```
UnmarshalJSONArray decodes JSON array elements into slice




## <a name="Publisher">type</a> [Publisher](/src/target/publisher.go?s=216:412#L7)
``` go
type Publisher struct {
    Name   string   `json:"name"          valid:"required"`
    Cat    []string `json:"cat,omitempty" valid:"optional"`
    Domain string   `json:"domain"        valid:"required"`
}
```
Publisher object describes the publisher of the media in which the ad will be displayed. The publisher is
typically the seller in an OpenRTB transaction.










### <a name="Publisher.IsNil">func</a> (\*Publisher) [IsNil](/src/target/publisher.go?s=701:733#L22)
``` go
func (p *Publisher) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Publisher.MarshalJSONObject">func</a> (\*Publisher) [MarshalJSONObject](/src/target/publisher.go?s=466:523#L14)
``` go
func (p *Publisher) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Publisher.NKeys">func</a> (\*Publisher) [NKeys](/src/target/publisher.go?s=1219:1250#L49)
``` go
func (p *Publisher) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Publisher.UnmarshalJSONObject">func</a> (\*Publisher) [UnmarshalJSONObject](/src/target/publisher.go?s=820:895#L27)
``` go
func (p *Publisher) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Regs">type</a> [Regs](/src/target/regs.go?s=363:490#L8)
``` go
type Regs struct {
    Coppa int      `json:"coppa" valid:"range(0|1),optional"`
    Ext   *RegsExt `json:"ext"   valid:"optional"`
}
```
Regs object contains any legal, governmental, or industry regulations that apply to the request. The
coppa flag signals whether or not the request falls under the United States Federal Trade Commission’s
regulations for the United States Children’s Online Privacy Protection Act (“COPPA”).










### <a name="Regs.IsNil">func</a> (\*Regs) [IsNil](/src/target/regs.go?s=907:934#L26)
``` go
func (r *Regs) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Regs.MarshalJSONObject">func</a> (\*Regs) [MarshalJSONObject](/src/target/regs.go?s=746:798#L20)
``` go
func (r *Regs) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Regs.NKeys">func</a> (\*Regs) [NKeys](/src/target/regs.go?s=1338:1364#L50)
``` go
func (r *Regs) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Regs.UnmarshalJSONObject">func</a> (\*Regs) [UnmarshalJSONObject](/src/target/regs.go?s=1021:1091#L31)
``` go
func (r *Regs) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="RegsExt">type</a> [RegsExt](/src/target/regs.go?s=544:692#L14)
``` go
type RegsExt struct {
    GDPR      int    `json:"gdpr" valid:"range(0|1),optional"`
    USPrivacy string `json:"us_privacy,omitempty" valid:"optional"`
    GPP       string `json:"gpp,omitempty" valid:"optional"`
	GPPSIDs   string `json:"gpp_sid,omitempty" valid:"optional"`
}
```
RegsExt being used for GDPR, CCPA as US Privacy, and any regulations via the Global Privacy Platform (GPP)
string. The relevant regulations are specified within the GPP string and GPP Section ID (SID) list.
GPPSIDs is a comma-separated list of GPP Section IDs.










### <a name="RegsExt.IsNil">func</a> (\*RegsExt) [IsNil](/src/target/regs.go?s=1606:1636#L59)
``` go
func (e *RegsExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="RegsExt.MarshalJSONObject">func</a> (\*RegsExt) [MarshalJSONObject](/src/target/regs.go?s=1431:1486#L53)
``` go
func (e *RegsExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="RegsExt.NKeys">func</a> (\*RegsExt) [NKeys](/src/target/regs.go?s=1973:2002#L76)
``` go
func (e *RegsExt) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="RegsExt.UnmarshalJSONObject">func</a> (\*RegsExt) [UnmarshalJSONObject](/src/target/regs.go?s=1723:1796#L64)
``` go
func (e *RegsExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Request">type</a> [Request](/src/target/request.go?s=241:1377#L15)
``` go
type Request struct {
    Imp    []Imp      `json:"imp"               valid:"required"`
    App    App        `json:"app"               valid:"required"`
    Device Device     `json:"device"            valid:"required"`
    Format *Format    `json:"format"            valid:"required"` // this is not part of the spec, adding this here for convience allows h and width to be passed without the video/banner object to backwards support the GET
    User   User       `json:"user,omitempty"    valid:"optional"`
    Test   int        `json:"test,omitempty"    valid:"range(0|1),optional"`
    WSeat  []string   `json:"wseat,omitempty"   valid:"optional"`
    BSeat  []string   `json:"bseat,omitempty"   valid:"optional"`
    Wlang  []string   `json:"wlang,omitempty"   valid:"optional"`
    Bcat   []string   `json:"bcat,omitempty"    valid:"optional"`
    BAdv   []string   `json:"badv,omitempty"    valid:"optional"`
    BApp   []string   `json:"bapp,omitempty"    valid:"optional"`
    Source Source     `json:"source,omitempty"  valid:"optional"`
    Regs   Regs       `json:"regs,omitempty"    valid:"optional"`
    Ext    RequestExt `json:"ext,omitempty"     valid:"required"`
}
```
Request openRTB 2.5 spec










### <a name="Request.IsNil">func</a> (\*Request) [IsNil](/src/target/request.go?s=2577:2607#L66)
``` go
func (r *Request) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Request.MarshalJSONObject">func</a> (\*Request) [MarshalJSONObject](/src/target/request.go?s=1665:1720#L40)
``` go
func (r *Request) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Request.NKeys">func</a> (\*Request) [NKeys](/src/target/request.go?s=4423:4452#L178)
``` go
func (r *Request) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Request.UnmarshalJSONObject">func</a> (\*Request) [UnmarshalJSONObject](/src/target/request.go?s=2694:2767#L71)
``` go
func (r *Request) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="RequestExt">type</a> [RequestExt](/src/target/request.go?s=1446:1611#L34)
``` go
type RequestExt struct {
    APIKey    string `json:"api_key,omitempty"     valid:"uuidv4,required"`
    SessionID string `json:"session_id,omitempty"  valid:"required"`
}
```
RequestExt used to communicate the publishers api key to nimbus










### <a name="RequestExt.IsNil">func</a> (\*RequestExt) [IsNil](/src/target/request.go?s=4714:4747#L187)
``` go
func (e *RequestExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="RequestExt.MarshalJSONObject">func</a> (\*RequestExt) [MarshalJSONObject](/src/target/request.go?s=4519:4577#L181)
``` go
func (e *RequestExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="RequestExt.NKeys">func</a> (\*RequestExt) [NKeys](/src/target/request.go?s=5097:5129#L206)
``` go
func (e *RequestExt) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="RequestExt.UnmarshalJSONObject">func</a> (\*RequestExt) [UnmarshalJSONObject](/src/target/request.go?s=4834:4910#L192)
``` go
func (e *RequestExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Segment">type</a> [Segment](/src/target/segment.go?s=350:541#L8)
``` go
type Segment struct {
    ID    string `json:"id,omitempty"    valid:"optional"`
    Name  string `json:"name,omitempty"  valid:"optional"`
    Value string `json:"value,omitempty" valid:"optional"`
}
```
Segment objects are essentially key-value pairs that convey specific units of data about the user. The
parent Data object is a collection of such values from a given data provider. The specific segment
names and value options must be published by the exchange a priori to its bidders.










### <a name="Segment.IsNil">func</a> (\*Segment) [IsNil](/src/target/segment.go?s=1260:1290#L47)
``` go
func (s *Segment) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Segment.MarshalJSONObject">func</a> (\*Segment) [MarshalJSONObject](/src/target/segment.go?s=1046:1101#L40)
``` go
func (s *Segment) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Segment.NKeys">func</a> (\*Segment) [NKeys](/src/target/segment.go?s=1663:1692#L69)
``` go
func (s *Segment) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Segment.UnmarshalJSONObject">func</a> (\*Segment) [UnmarshalJSONObject](/src/target/segment.go?s=1377:1450#L52)
``` go
func (s *Segment) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Segments">type</a> [Segments](/src/target/segment.go?s=559:582#L15)
``` go
type Segments []Segment
```
Segments ...










### <a name="Segments.IsNil">func</a> (Segments) [IsNil](/src/target/segment.go?s=938:968#L35)
``` go
func (s Segments) IsNil() bool
```
IsNil ...




### <a name="Segments.MarshalJSONArray">func</a> (Segments) [MarshalJSONArray](/src/target/segment.go?s=822:876#L28)
``` go
func (s Segments) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




### <a name="Segments.UnmarshalJSONArray">func</a> (\*Segments) [UnmarshalJSONArray](/src/target/segment.go?s=610:673#L18)
``` go
func (s *Segments) UnmarshalJSONArray(dec *gojay.Decoder) error
```
UnmarshalJSONArray ...




## <a name="Source">type</a> [Source](/src/target/source.go?s=565:645#L10)
``` go
type Source struct {
    Ext SourceExt `json:"ext,omitempty"    valid:"optional"`
}
```
Source describes the nature and behavior of the entity that is the source of the bid request
upstream from the exchange. The primary purpose of this object is to define post-auction or upstream
decisioning when the exchange itself does not control the final decision. A common example of this is
header bidding, but it can also apply to upstream server entities such as another RTB exchange, a
mediation platform, or an ad server combines direct campaigns with 3rd party demand in decisioning.










### <a name="Source.IsNil">func</a> (\*Source) [IsNil](/src/target/source.go?s=1192:1221#L26)
``` go
func (s *Source) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Source.MarshalJSONObject">func</a> (\*Source) [MarshalJSONObject](/src/target/source.go?s=1058:1112#L21)
``` go
func (s *Source) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Source.NKeys">func</a> (\*Source) [NKeys](/src/target/source.go?s=1505:1533#L42)
``` go
func (s *Source) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Source.UnmarshalJSONObject">func</a> (\*Source) [UnmarshalJSONObject](/src/target/source.go?s=1308:1380#L31)
``` go
func (s *Source) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="SourceExt">type</a> [SourceExt](/src/target/source.go?s=710:1004#L15)
``` go
type SourceExt struct {
    Omidpn string `json:"omidpn,omitempty" valid:"optional"` // identifier of the OM SDK integration, this is the same as the "name" parameter of the OMID Partner object
    Omidpv string `json:"omidpv,omitempty" valid:"optional"` // (optional) Version of the OM SDK version
}
```
SourceExt also for OM SDK extensions to be passed to demand










### <a name="SourceExt.IsNil">func</a> (\*SourceExt) [IsNil](/src/target/source.go?s=1786:1818#L51)
``` go
func (s *SourceExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="SourceExt.MarshalJSONObject">func</a> (\*SourceExt) [MarshalJSONObject](/src/target/source.go?s=1600:1657#L45)
``` go
func (s *SourceExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="SourceExt.NKeys">func</a> (\*SourceExt) [NKeys](/src/target/source.go?s=2159:2190#L70)
``` go
func (s *SourceExt) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="SourceExt.UnmarshalJSONObject">func</a> (\*SourceExt) [UnmarshalJSONObject](/src/target/source.go?s=1905:1980#L56)
``` go
func (s *SourceExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Strings">type</a> [Strings](/src/target/primitives.go?s=614:635#L35)
``` go
type Strings []string
```
Strings ...










### <a name="Strings.IsNil">func</a> (Strings) [IsNil](/src/target/primitives.go?s=1064:1093#L55)
``` go
func (a Strings) IsNil() bool
```
IsNil checks if array is nil




### <a name="Strings.MarshalJSONArray">func</a> (Strings) [MarshalJSONArray](/src/target/primitives.go?s=925:978#L48)
``` go
func (a Strings) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray encodes arrays into JSON




### <a name="Strings.UnmarshalJSONArray">func</a> (\*Strings) [UnmarshalJSONArray](/src/target/primitives.go?s=698:760#L38)
``` go
func (a *Strings) UnmarshalJSONArray(dec *gojay.Decoder) error
```
UnmarshalJSONArray decodes JSON array elements into slice




## <a name="User">type</a> [User](/src/target/user.go?s=406:994#L9)
``` go
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
```
User object contains information known or derived about the human user of the device (i.e., the
audience for advertising). The user id is an exchange artifact and may be subject to rotation or other
privacy policies. However, this user ID must be stable long enough to serve reasonably as the basis for
frequency capping and retargeting.










### <a name="User.IsNil">func</a> (\*User) [IsNil](/src/target/user.go?s=1916:1943#L40)
``` go
func (u *User) IsNil() bool
```
IsNil checks if instance is nil




### <a name="User.MarshalJSONObject">func</a> (\*User) [MarshalJSONObject](/src/target/user.go?s=1449:1501#L27)
``` go
func (u *User) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="User.NKeys">func</a> (\*User) [NKeys](/src/target/user.go?s=2738:2764#L87)
``` go
func (u *User) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="User.UnmarshalJSONObject">func</a> (\*User) [UnmarshalJSONObject](/src/target/user.go?s=2030:2100#L45)
``` go
func (u *User) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="UserExt">type</a> [UserExt](/src/target/user.go?s=1027:1395#L21)
``` go
type UserExt struct {
    Consent    string `json:"consent,omitempty"     valid:"base64rawstring,optional"` // if a publisher has their own cpm they can supply thier own GDPR consent string
    DidConsent int    `json:"did_consent,omitempty" valid:"range(0|1),optional"`      // Allows a publisher to let Nimbus know thier user has consent to thier data use policy for ads
}
```
UserExt being used for GDPR










### <a name="UserExt.IsNil">func</a> (\*UserExt) [IsNil](/src/target/user.go?s=3023:3053#L96)
``` go
func (e *UserExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="UserExt.MarshalJSONObject">func</a> (\*UserExt) [MarshalJSONObject](/src/target/user.go?s=2831:2886#L90)
``` go
func (e *UserExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="UserExt.NKeys">func</a> (\*UserExt) [NKeys](/src/target/user.go?s=3401:3430#L116)
``` go
func (e *UserExt) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="UserExt.UnmarshalJSONObject">func</a> (\*UserExt) [UnmarshalJSONObject](/src/target/user.go?s=3140:3213#L101)
``` go
func (e *UserExt) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject




## <a name="Video">type</a> [Video](/src/target/video.go?s=500:3074#L10)
``` go
type Video struct {
    BidFloor       *float64 `json:"bidfloor,omitempty"       valid:"optional"`
    CompanionAd    []Banner `json:"companionad,omitempty"    valid:"optional"`
    CompanionType  []int    `json:"companiontype,omitempty"  valid:"optional"` //1, 2, 3 -> Static Resource, HTM Resource, iframe Resource
    Mimes          []string `json:"mimes,omitempty"          valid:"optional"`
    Minduration    int      `json:"minduration"              valid:"optional"`
    Maxduration    int      `json:"maxduration,omitempty"    valid:"optional"`
    Protocols      []int    `json:"protocols,omitempty"      valid:"inintarr(2|3|5|6),optional"` // 1,2,3,4,5,6,7,8,9,10 -> VAST 1.0,VAST 2.0,VAST 3.0,VAST 1.0 Wrapper,VAST 2.0 Wrapper,VAST 3.0 Wrapper,VAST 4.0,VAST 4.0 Wrapper,DAAST 1.0,DAAST 1.0 Wrapper
    W              int      `json:"w,omitempty"              valid:"required"`
    H              int      `json:"h,omitempty"              valid:"required"`
    StartDelay     int      `json:"startdelay"               valid:"optional"`
    Placement      int      `json:"placement,omitempty"      valid:"range(1|5),optional"`            // 1,2,3,4,5 -> In-Stream, In-Banner, In-Article, In-Feed - Found in content, social, or product feeds, Interstitial/Slider/Floating
    Linearity      int      `json:"linearity,omitempty"      valid:"range(1|2),optional"`            // 1,2 -> linear, non linear
    Playbackmethod []int    `json:"playbackmethod,omitempty" valid:"inintarr(1|2|3|4|5|6),optional"` // 1,2,3,4,5,6 - > Initiates on Page Load with Sound On, Initiates on Page Load with Sound Off by Default, Initiates on Click with Sound On, Initiates on Mouse-Over with Sound On, Initiates on Entering Viewport with Sound On, Initiates on Entering Viewport with Sound Off by Default
    Skip           int      `json:"skip"                     valid:"range(0|1),optional"`            // 0 no 1 yes
    Delivery       []int    `json:"delivery,omitempty"       valid:"range(0|3),optional"`            // 0,1,2,3 -> Unknown, Professionally Produced, Prosumer, User Generated (UGC)
    Pos            int      `json:"pos,omitempty"            valid:"range(0|7),optional"`            // 0,1,2,3,4,5,6,7 -> Unknown,Above the Fold,DEPRECATED - May or may not be initially visible depending on screen size/resolution.,Below the Fold,Header,Footer,Sidebar,Full Screen
    API            []int    `json:"api,omitempty"            valid:"inintarr(1|2|3|4|5|6),optional"`
    MinBitRate     int      `json:"minbitrate,omitempty"     valid:"optional"`
    MaxBitRate     int      `json:"maxbitrate,omitempty"     valid:"optional"`
}
```
Video object represents an in-stream video impression. Many of the fields are non-essential for minimally
viable transactions, but are included to offer fine control when needed. Video in OpenRTB generally
assumes compliance with the VAST standard. As such, the notion of companion ads is supported by
optionally including an array of Banner objects (refer to the Banner object in Section 3.2.3) that define
these companion ads.










### <a name="Video.IsNil">func</a> (\*Video) [IsNil](/src/target/video.go?s=4390:4418#L65)
``` go
func (v *Video) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Video.MarshalJSONObject">func</a> (\*Video) [MarshalJSONObject](/src/target/video.go?s=3128:3181#L33)
``` go
func (v *Video) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




### <a name="Video.NKeys">func</a> (\*Video) [NKeys](/src/target/video.go?s=6403:6430#L175)
``` go
func (v *Video) NKeys() int
```
NKeys returns the number of keys to unmarshal




### <a name="Video.UnmarshalJSONObject">func</a> (\*Video) [UnmarshalJSONObject](/src/target/video.go?s=4505:4576#L70)
``` go
func (v *Video) UnmarshalJSONObject(dec *gojay.Decoder, k string) error
```
UnmarshalJSONObject implements gojay's UnmarshalerJSONObject








- - -
Generated by [godoc2md](http://godoc.org/github.com/davecheney/godoc2md)
