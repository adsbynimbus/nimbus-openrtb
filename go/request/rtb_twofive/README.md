

# twofive
`import "github.com/timehop/nimbus-openrtb/go/request/rtb_twofive"`

* [Overview](#pkg-overview)
* [Index](#pkg-index)

## <a name="pkg-overview">Overview</a>



## <a name="pkg-index">Index</a>
* [Constants](#pkg-constants)
* [type APS](#APS)
  * [func (s *APS) IsNil() bool](#APS.IsNil)
  * [func (s *APS) MarshalJSONObject(enc *gojay.Encoder)](#APS.MarshalJSONObject)
* [type APSs](#APSs)
  * [func (s APSs) IsNil() bool](#APSs.IsNil)
  * [func (s APSs) MarshalJSONArray(enc *gojay.Encoder)](#APSs.MarshalJSONArray)
* [type App](#App)
  * [func (a *App) IsNil() bool](#App.IsNil)
  * [func (a *App) MarshalJSONObject(enc *gojay.Encoder)](#App.MarshalJSONObject)
* [type Banner](#Banner)
  * [func (b *Banner) IsNil() bool](#Banner.IsNil)
  * [func (b *Banner) MarshalJSONObject(enc *gojay.Encoder)](#Banner.MarshalJSONObject)
* [type Banners](#Banners)
  * [func (s Banners) IsNil() bool](#Banners.IsNil)
  * [func (s Banners) MarshalJSONArray(enc *gojay.Encoder)](#Banners.MarshalJSONArray)
* [type Data](#Data)
  * [func (d *Data) IsNil() bool](#Data.IsNil)
  * [func (d *Data) MarshalJSONObject(enc *gojay.Encoder)](#Data.MarshalJSONObject)
* [type Datas](#Datas)
  * [func (s Datas) IsNil() bool](#Datas.IsNil)
  * [func (s Datas) MarshalJSONArray(enc *gojay.Encoder)](#Datas.MarshalJSONArray)
* [type Device](#Device)
  * [func (d *Device) IsNil() bool](#Device.IsNil)
  * [func (d *Device) MarshalJSONObject(enc *gojay.Encoder)](#Device.MarshalJSONObject)
* [type Format](#Format)
  * [func (f *Format) IsNil() bool](#Format.IsNil)
  * [func (f *Format) MarshalJSONObject(enc *gojay.Encoder)](#Format.MarshalJSONObject)
* [type Formats](#Formats)
  * [func (s Formats) IsNil() bool](#Formats.IsNil)
  * [func (s Formats) MarshalJSONArray(enc *gojay.Encoder)](#Formats.MarshalJSONArray)
* [type Geo](#Geo)
  * [func (g *Geo) IsNil() bool](#Geo.IsNil)
  * [func (g *Geo) MarshalJSONObject(enc *gojay.Encoder)](#Geo.MarshalJSONObject)
* [type Imp](#Imp)
  * [func (i *Imp) IsNil() bool](#Imp.IsNil)
  * [func (i *Imp) MarshalJSONObject(enc *gojay.Encoder)](#Imp.MarshalJSONObject)
* [type ImpExt](#ImpExt)
  * [func (e *ImpExt) IsNil() bool](#ImpExt.IsNil)
  * [func (e *ImpExt) MarshalJSONObject(enc *gojay.Encoder)](#ImpExt.MarshalJSONObject)
* [type Imps](#Imps)
  * [func (s Imps) IsNil() bool](#Imps.IsNil)
  * [func (s Imps) MarshalJSONArray(enc *gojay.Encoder)](#Imps.MarshalJSONArray)
* [type Ints](#Ints)
  * [func (a Ints) IsNil() bool](#Ints.IsNil)
  * [func (a Ints) MarshalJSONArray(enc *gojay.Encoder)](#Ints.MarshalJSONArray)
* [type Publisher](#Publisher)
  * [func (p *Publisher) IsNil() bool](#Publisher.IsNil)
  * [func (p *Publisher) MarshalJSONObject(enc *gojay.Encoder)](#Publisher.MarshalJSONObject)
* [type Regs](#Regs)
  * [func (r *Regs) IsNil() bool](#Regs.IsNil)
  * [func (r *Regs) MarshalJSONObject(enc *gojay.Encoder)](#Regs.MarshalJSONObject)
* [type RegsExt](#RegsExt)
  * [func (e *RegsExt) IsNil() bool](#RegsExt.IsNil)
  * [func (e *RegsExt) MarshalJSONObject(enc *gojay.Encoder)](#RegsExt.MarshalJSONObject)
* [type Request](#Request)
  * [func (r *Request) IsNil() bool](#Request.IsNil)
  * [func (r *Request) MarshalJSONObject(enc *gojay.Encoder)](#Request.MarshalJSONObject)
* [type RequestExt](#RequestExt)
  * [func (e *RequestExt) IsNil() bool](#RequestExt.IsNil)
  * [func (e *RequestExt) MarshalJSONObject(enc *gojay.Encoder)](#RequestExt.MarshalJSONObject)
* [type Segment](#Segment)
  * [func (s *Segment) IsNil() bool](#Segment.IsNil)
  * [func (s *Segment) MarshalJSONObject(enc *gojay.Encoder)](#Segment.MarshalJSONObject)
* [type Segments](#Segments)
  * [func (s Segments) IsNil() bool](#Segments.IsNil)
  * [func (s Segments) MarshalJSONArray(enc *gojay.Encoder)](#Segments.MarshalJSONArray)
* [type Source](#Source)
  * [func (s *Source) IsNil() bool](#Source.IsNil)
  * [func (s *Source) MarshalJSONObject(enc *gojay.Encoder)](#Source.MarshalJSONObject)
* [type SourceExt](#SourceExt)
  * [func (s *SourceExt) IsNil() bool](#SourceExt.IsNil)
  * [func (s *SourceExt) MarshalJSONObject(enc *gojay.Encoder)](#SourceExt.MarshalJSONObject)
* [type Strings](#Strings)
  * [func (a Strings) IsNil() bool](#Strings.IsNil)
  * [func (a Strings) MarshalJSONArray(enc *gojay.Encoder)](#Strings.MarshalJSONArray)
* [type User](#User)
  * [func (u *User) IsNil() bool](#User.IsNil)
  * [func (u *User) MarshalJSONObject(enc *gojay.Encoder)](#User.MarshalJSONObject)
* [type UserExt](#UserExt)
  * [func (e *UserExt) IsNil() bool](#UserExt.IsNil)
  * [func (e *UserExt) MarshalJSONObject(enc *gojay.Encoder)](#UserExt.MarshalJSONObject)
* [type Video](#Video)
  * [func (v *Video) IsNil() bool](#Video.IsNil)
  * [func (v *Video) MarshalJSONObject(enc *gojay.Encoder)](#Video.MarshalJSONObject)


#### <a name="pkg-files">Package files</a>
[app.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/app.go) [aps.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/aps.go) [banner.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/banner.go) [data.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/data.go) [device.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/device.go) [format.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/format.go) [geo.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/geo.go) [imp.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/imp.go) [primitives.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/primitives.go) [publisher.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/publisher.go) [regs.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/regs.go) [request.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/request.go) [segment.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/segment.go) [source.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/source.go) [user.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/user.go) [video.go](/src/github.com/timehop/nimbus-openrtb/go/request/rtb_twofive/video.go) 


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




## <a name="APSs">type</a> [APSs](/src/target/aps.go?s=1246:1261#L40)
``` go
type APSs []APS
```
APSs ...










### <a name="APSs.IsNil">func</a> (APSs) [IsNil](/src/target/aps.go?s=1399:1425#L50)
``` go
func (s APSs) IsNil() bool
```
IsNil ...




### <a name="APSs.MarshalJSONArray">func</a> (APSs) [MarshalJSONArray](/src/target/aps.go?s=1287:1337#L43)
``` go
func (s APSs) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




## <a name="App">type</a> [App](/src/target/app.go?s=354:1206#L8)
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
    PrivacyPolicy int       `json:"privacypolicy"        valid:"optional"` // no policy 0 policy 1
    Paid          int       `json:"paid"                 valid:"optional"` // free 0 paid 1
    Publisher     Publisher `json:"publisher"            valid:"required"`
}
```
App object should be included if the ad supported content is a non-browser application (typically in
mobile) as opposed to a website. A bid request must not contain both an App and a Site object. At a
minimum, it is useful to provide an App ID or bundle, but this is not strictly required










### <a name="App.IsNil">func</a> (\*App) [IsNil](/src/target/app.go?s=1903:1929#L41)
``` go
func (a *App) IsNil() bool
```
IsNil checks if instance is nil




### <a name="App.MarshalJSONObject">func</a> (\*App) [MarshalJSONObject](/src/target/app.go?s=1260:1311#L23)
``` go
func (a *App) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="Banner">type</a> [Banner](/src/target/banner.go?s=553:1278#L12)
``` go
type Banner struct {
    BidFloor *float64 `json:"bidfloor,omitempty" valid:"optional"`
    BAttr    []int    `json:"battr,omitempty"    valid:"optional"`
    Format   []Format `json:"format,omitempty"   valid:"optional"`
    W        int      `json:"w"                  valid:"required"`
    H        int      `json:"h"                  valid:"required"`
    API      []int    `json:"api,omitempty"      valid:"inintarr(1|2|3|4|5|6),optional"` // 3,5,6 -> mraid1, 2, and 3
    Pos      int      `json:"pos,omitempty"      valid:"range(0|7),optional"`            // 0,1,2,3,4,5,6,7 -> Unknown, Above the Fold, DEPRECATED - May or may not be initially visible depending on screen size/resolution.,Below the Fold,Header,Footer,Sidebar,Full Screen
}
```
Banner represents the most general type of impression. Although the term “banner” may have very
specific meaning in other contexts, here it can be many things including a simple static image, an
expandable ad unit, or even in-banner video (refer to the Video object in Section 3.2.4 for the more
generalized and full featured video ad units). An array of Banner objects can also appear within the
Video to describe optional companion ads defined in the VAST specification.










### <a name="Banner.IsNil">func</a> (\*Banner) [IsNil](/src/target/banner.go?s=1829:1858#L39)
``` go
func (b *Banner) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Banner.MarshalJSONObject">func</a> (\*Banner) [MarshalJSONObject](/src/target/banner.go?s=1332:1386#L23)
``` go
func (b *Banner) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="Banners">type</a> [Banners](/src/target/banner.go?s=1896:1917#L44)
``` go
type Banners []Banner
```
Banners ...










### <a name="Banners.IsNil">func</a> (Banners) [IsNil](/src/target/banner.go?s=2058:2087#L54)
``` go
func (s Banners) IsNil() bool
```
IsNil ...




### <a name="Banners.MarshalJSONArray">func</a> (Banners) [MarshalJSONArray](/src/target/banner.go?s=1943:1996#L47)
``` go
func (s Banners) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




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




## <a name="Datas">type</a> [Datas](/src/target/data.go?s=1022:1039#L29)
``` go
type Datas []Data
```
Datas ...










### <a name="Datas.IsNil">func</a> (Datas) [IsNil](/src/target/data.go?s=1178:1205#L39)
``` go
func (s Datas) IsNil() bool
```
IsNil ...




### <a name="Datas.MarshalJSONArray">func</a> (Datas) [MarshalJSONArray](/src/target/data.go?s=1065:1116#L32)
``` go
func (s Datas) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




## <a name="Device">type</a> [Device](/src/target/device.go?s=344:1757#L8)
``` go
type Device struct {
    Ua             string `json:"ua"                        valid:"required"`
    Geo            *Geo   `json:"geo,omitempty"             valid:"optional"`
    Dnt            int    `json:"dnt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking is restricted
    Lmt            int    `json:"lmt"                       valid:"range(0|1),optional"` // 0 = tracking is unrestricted, 1 = tracking must be limited by commericial guidelines
    IP             string `json:"ip"                        valid:"ipv4,optional"`
    DeviceType     int    `json:"devicetype,omitempty"      valid:"optional"`
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










### <a name="Device.IsNil">func</a> (\*Device) [IsNil](/src/target/device.go?s=2497:2526#L48)
``` go
func (d *Device) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Device.MarshalJSONObject">func</a> (\*Device) [MarshalJSONObject](/src/target/device.go?s=1811:1865#L28)
``` go
func (d *Device) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="Format">type</a> [Format](/src/target/format.go?s=256:358#L7)
``` go
type Format struct {
    W int `json:"w"      valid:"required"`
    H int `json:"h"      valid:"required"`
}
```
Format object represents an allowed size (i.e., height and width combination) for a banner impression.
These are typically used in an array for an impression where multiple sizes are permitted.










### <a name="Format.IsNil">func</a> (\*Format) [IsNil](/src/target/format.go?s=551:580#L19)
``` go
func (f *Format) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Format.MarshalJSONObject">func</a> (\*Format) [MarshalJSONObject](/src/target/format.go?s=412:466#L13)
``` go
func (f *Format) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="Formats">type</a> [Formats](/src/target/format.go?s=618:639#L24)
``` go
type Formats []Format
```
Formats ...










### <a name="Formats.IsNil">func</a> (Formats) [IsNil](/src/target/format.go?s=780:809#L34)
``` go
func (s Formats) IsNil() bool
```
IsNil ...




### <a name="Formats.MarshalJSONArray">func</a> (Formats) [MarshalJSONArray](/src/target/format.go?s=665:718#L27)
``` go
func (s Formats) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




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




## <a name="Imp">type</a> [Imp](/src/target/imp.go?s=364:961#L10)
``` go
type Imp struct {
    ID       string  `json:"id,omitempty"                   valid:"optional"`
    Banner   *Banner `json:"banner,omitempty"               valid:"optional"`
    Video    *Video  `json:"video,omitempty"                valid:"optional"`
    Instl    int     `json:"instl"                          valid:"range(0|1),optional"` // 0 = not interstitial, 1 = interstitial
    BidFloor float64 `json:"bidfloor"                       valid:"optional"`
    Secure   *int    `json:"secure"                         valid:"optional"`
    Ext      *ImpExt `json:"ext,omitempty"                  valid:"optional"`
}
```
Imp describes an ad placement or impression being auctioned. A single bid request can include
multiple Imp objects, a use case for which might be an exchange that supports selling all ad positions on
a given page. Each Imp object has a required ID so that bids can reference them individually.










### <a name="Imp.IsNil">func</a> (\*Imp) [IsNil](/src/target/imp.go?s=1888:1914#L42)
``` go
func (i *Imp) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Imp.MarshalJSONObject">func</a> (\*Imp) [MarshalJSONObject](/src/target/imp.go?s=1507:1558#L29)
``` go
func (i *Imp) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="ImpExt">type</a> [ImpExt](/src/target/imp.go?s=977:1453#L21)
``` go
type ImpExt struct {
    APS           []APS  `json:"aps,omitempty"             valid:"optional"`
    FacebookAppID string `json:"facebook_app_id,omitempty" valid:"optional"` // needed for pubs that have FB hybrid SDK solution in thier stack
    Position      string `json:"position,omitempty"        valid:"required"` // flexible optional field for publishers to track on ad position performance
    Viewability   int    `json:"viewability,omitempty"     valid:"range(0|100),optional"`
}
```
ImpExt ...










### <a name="ImpExt.IsNil">func</a> (\*ImpExt) [IsNil](/src/target/imp.go?s=2311:2340#L56)
``` go
func (e *ImpExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="ImpExt.MarshalJSONObject">func</a> (\*ImpExt) [MarshalJSONObject](/src/target/imp.go?s=1989:2043#L47)
``` go
func (e *ImpExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="Imps">type</a> [Imps](/src/target/imp.go?s=2375:2390#L61)
``` go
type Imps []Imp
```
Imps ...










### <a name="Imps.IsNil">func</a> (Imps) [IsNil](/src/target/imp.go?s=2528:2554#L71)
``` go
func (s Imps) IsNil() bool
```
IsNil ...




### <a name="Imps.MarshalJSONArray">func</a> (Imps) [MarshalJSONArray](/src/target/imp.go?s=2416:2466#L64)
``` go
func (s Imps) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




## <a name="Ints">type</a> [Ints](/src/target/primitives.go?s=135:150#L10)
``` go
type Ints []int
```
Ints is an alias of []int










### <a name="Ints.IsNil">func</a> (Ints) [IsNil](/src/target/primitives.go?s=330:356#L20)
``` go
func (a Ints) IsNil() bool
```
IsNil checks if array is nil




### <a name="Ints.MarshalJSONArray">func</a> (Ints) [MarshalJSONArray](/src/target/primitives.go?s=197:247#L13)
``` go
func (a Ints) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray encodes arrays into JSON




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




## <a name="Regs">type</a> [Regs](/src/target/regs.go?s=363:479#L8)
``` go
type Regs struct {
    Coppa int      `json:"coppa" valid:"optional"`
    Ext   *RegsExt `json:"ext"   valid:"optional"`
}
```
Regs object contains any legal, governmental, or industry regulations that apply to the request. The
coppa flag signals whether or not the request falls under the United States Federal Trade Commission’s
regulations for the United States Children’s Online Privacy Protection Act (“COPPA”).










### <a name="Regs.IsNil">func</a> (\*Regs) [IsNil](/src/target/regs.go?s=791:818#L25)
``` go
func (r *Regs) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Regs.MarshalJSONObject">func</a> (\*Regs) [MarshalJSONObject](/src/target/regs.go?s=630:682#L19)
``` go
func (r *Regs) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="RegsExt">type</a> [RegsExt](/src/target/regs.go?s=512:576#L14)
``` go
type RegsExt struct {
    GDPR int `json:"gdpr" valid:"optional"`
}
```
RegsExt being used for GDPR










### <a name="RegsExt.IsNil">func</a> (\*RegsExt) [IsNil](/src/target/regs.go?s=1017:1047#L35)
``` go
func (e *RegsExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="RegsExt.MarshalJSONObject">func</a> (\*RegsExt) [MarshalJSONObject](/src/target/regs.go?s=893:948#L30)
``` go
func (e *RegsExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="Request">type</a> [Request](/src/target/request.go?s=241:1366#L15)
``` go
type Request struct {
    Imp    []Imp      `json:"imp"               valid:"required"`
    App    App        `json:"app"               valid:"required"`
    Device Device     `json:"device"            valid:"required"`
    Format *Format    `json:"format,omitempty"  valid:"required"` // this is not part of the spec, adding this here for convience allows h and width to be passed without the video/banner object to backwards support the GET
    User   User       `json:"user"              valid:"optional"`
    Test   int        `json:"test,omitempty"    valid:"optional"`
    WSeat  []string   `json:"wseat,omitempty"   valid:"optional"`
    BSeat  []string   `json:"bseat,omitempty"   valid:"optional"`
    Wlang  []string   `json:"wlang,omitempty"   valid:"optional"`
    Bcat   []string   `json:"bcat,omitempty"    valid:"optional"`
    BAdv   []string   `json:"badv,omitempty"    valid:"optional"`
    BApp   []string   `json:"bapp,omitempty"    valid:"optional"`
    Source Source     `json:"source,omitempty"  valid:"optional"`
    Regs   Regs       `json:"regs"              valid:"optional"`
    Ext    RequestExt `json:"ext,omitempty"     valid:"required"`
}
```
Request openRTB 2.5 spec










### <a name="Request.IsNil">func</a> (\*Request) [IsNil](/src/target/request.go?s=2557:2587#L66)
``` go
func (r *Request) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Request.MarshalJSONObject">func</a> (\*Request) [MarshalJSONObject](/src/target/request.go?s=1654:1709#L40)
``` go
func (r *Request) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="RequestExt">type</a> [RequestExt](/src/target/request.go?s=1435:1600#L34)
``` go
type RequestExt struct {
    APIKey    string `json:"api_key,omitempty"     valid:"uuidv4,required"`
    SessionID string `json:"session_id,omitempty"  valid:"required"`
}
```
RequestExt used to communicate the publishers api key to nimbus










### <a name="RequestExt.IsNil">func</a> (\*RequestExt) [IsNil](/src/target/request.go?s=2857:2890#L77)
``` go
func (e *RequestExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="RequestExt.MarshalJSONObject">func</a> (\*RequestExt) [MarshalJSONObject](/src/target/request.go?s=2662:2720#L71)
``` go
func (e *RequestExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




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










### <a name="Segment.IsNil">func</a> (\*Segment) [IsNil](/src/target/segment.go?s=1046:1076#L37)
``` go
func (s *Segment) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Segment.MarshalJSONObject">func</a> (\*Segment) [MarshalJSONObject](/src/target/segment.go?s=832:887#L30)
``` go
func (s *Segment) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="Segments">type</a> [Segments](/src/target/segment.go?s=559:582#L15)
``` go
type Segments []Segment
```
Segments ...










### <a name="Segments.IsNil">func</a> (Segments) [IsNil](/src/target/segment.go?s=724:754#L25)
``` go
func (s Segments) IsNil() bool
```
IsNil ...




### <a name="Segments.MarshalJSONArray">func</a> (Segments) [MarshalJSONArray](/src/target/segment.go?s=608:662#L18)
``` go
func (s Segments) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray ...




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










### <a name="Source.IsNil">func</a> (\*Source) [IsNil](/src/target/source.go?s=1183:1212#L26)
``` go
func (s *Source) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Source.MarshalJSONObject">func</a> (\*Source) [MarshalJSONObject](/src/target/source.go?s=1058:1112#L21)
``` go
func (s *Source) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="SourceExt">type</a> [SourceExt](/src/target/source.go?s=710:1004#L15)
``` go
type SourceExt struct {
    Omidpn string `json:"omidpn,omitempty" valid:"optional"` // identifier of the OM SDK integration, this is the same as the "name" parameter of the OMID Partner object
    Omidpv string `json:"omidpv,omitempty" valid:"optional"` // (optional) Version of the OM SDK version
}
```
SourceExt also for OM SDK extensions to be passed to demand










### <a name="SourceExt.IsNil">func</a> (\*SourceExt) [IsNil](/src/target/source.go?s=1473:1505#L37)
``` go
func (s *SourceExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="SourceExt.MarshalJSONObject">func</a> (\*SourceExt) [MarshalJSONObject](/src/target/source.go?s=1287:1344#L31)
``` go
func (s *SourceExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="Strings">type</a> [Strings](/src/target/primitives.go?s=417:438#L25)
``` go
type Strings []string
```
Strings is an alias of []string










### <a name="Strings.IsNil">func</a> (Strings) [IsNil](/src/target/primitives.go?s=624:653#L35)
``` go
func (a Strings) IsNil() bool
```
IsNil checks if array is nil




### <a name="Strings.MarshalJSONArray">func</a> (Strings) [MarshalJSONArray](/src/target/primitives.go?s=485:538#L28)
``` go
func (a Strings) MarshalJSONArray(enc *gojay.Encoder)
```
MarshalJSONArray encodes arrays into JSON




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










### <a name="User.IsNil">func</a> (\*User) [IsNil](/src/target/user.go?s=1835:1862#L41)
``` go
func (u *User) IsNil() bool
```
IsNil checks if instance is nil




### <a name="User.MarshalJSONObject">func</a> (\*User) [MarshalJSONObject](/src/target/user.go?s=1368:1420#L28)
``` go
func (u *User) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="UserExt">type</a> [UserExt](/src/target/user.go?s=1027:1314#L21)
``` go
type UserExt struct {
    Age        int    `json:"age,omitempty"         valid:"_"` // age used incase year of birth can't be passed and age can
    Consent    string `json:"consent,omitempty"     valid:"base64rawstring,optional"`
    DidConsent int    `json:"did_consent,omitempty" valid:"-"`
}
```
UserExt being used for GDPR










### <a name="UserExt.IsNil">func</a> (\*UserExt) [IsNil](/src/target/user.go?s=2164:2194#L53)
``` go
func (e *UserExt) IsNil() bool
```
IsNil checks if instance is nil




### <a name="UserExt.MarshalJSONObject">func</a> (\*UserExt) [MarshalJSONObject](/src/target/user.go?s=1937:1992#L46)
``` go
func (e *UserExt) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject




## <a name="Video">type</a> [Video](/src/target/video.go?s=500:2862#L10)
``` go
type Video struct {
    BidFloor       *float64 `json:"bidfloor,omitempty"       valid:"optional"`
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
    Delivery       []int    `json:"Delivery,omitempty"       valid:"range(0|3),optional"`            // 0,1,2,3 -> Unknown, Professionally Produced, Prosumer, User Generated (UGC)
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










### <a name="Video.IsNil">func</a> (\*Video) [IsNil](/src/target/video.go?s=3977:4005#L59)
``` go
func (v *Video) IsNil() bool
```
IsNil checks if instance is nil




### <a name="Video.MarshalJSONObject">func</a> (\*Video) [MarshalJSONObject](/src/target/video.go?s=2916:2969#L31)
``` go
func (v *Video) MarshalJSONObject(enc *gojay.Encoder)
```
MarshalJSONObject implements MarshalerJSONObject








- - -
Generated by [godoc2md](http://godoc.org/github.com/davecheney/godoc2md)
