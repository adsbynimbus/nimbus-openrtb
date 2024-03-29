

# client
`import "github.com/adsbynimbus/nimbus-openrtb/go/client"`

* [Overview](#pkg-overview)
* [Index](#pkg-index)

## <a name="pkg-overview">Overview</a>



## <a name="pkg-index">Index</a>
* [func IsRequestValid(requestStructure interface{}) (bool, error)](#IsRequestValid)
* [func MarshalBidRequest(v interface{}) ([]byte, error)](#MarshalBidRequest)
* [type Driver](#Driver)
  * [func NewNimbusDriver(endpoint string, options ...func(*Driver)) *Driver](#NewNimbusDriver)
  * [func (d Driver) PostNimbus(body io.Reader) (*http.Response, error)](#Driver.PostNimbus)
  * [func (d Driver) PostNimbusTwoFiveRequest(r twofive.Request) (*http.Response, error)](#Driver.PostNimbusTwoFiveRequest)
  * [func (d Driver) PostNimbusTwoFiveRequestWithContext(ctx context.Context, r twofive.Request) (*http.Response, error)](#Driver.PostNimbusTwoFiveRequestWithContext)
  * [func (d Driver) PostNimbusWithContext(ctx context.Context, body io.Reader) (*http.Response, error)](#Driver.PostNimbusWithContext)
* [type Nimbus](#Nimbus)


#### <a name="pkg-files">Package files</a>
[client.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/client/client.go) [encode.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/client/encode.go) [validate-request.go](/src/github.com/adsbynimbus/nimbus-openrtb/go/client/validate-request.go) 





## <a name="IsRequestValid">func</a> [IsRequestValid](/src/target/validate-request.go?s=231:294#L8)
``` go
func IsRequestValid(requestStructure interface{}) (bool, error)
```
IsRequestValid will validate the structure
result will be equal to `false` if there are any errors
the error will contain a small description about the failure



## <a name="MarshalBidRequest">func</a> [MarshalBidRequest](/src/target/encode.go?s=187:240#L11)
``` go
func MarshalBidRequest(v interface{}) ([]byte, error)
```
MarshalBidRequest calls gojay to marshal data, if that fails we fallback to the standard package




## <a name="Driver">type</a> [Driver](/src/target/client.go?s=753:815#L30)
``` go
type Driver struct {
    Client   *http.Client
    Endpoint string
}
```
Driver inits wrappers *http.Client with endpoint







### <a name="NewNimbusDriver">func</a> [NewNimbusDriver](/src/target/client.go?s=1049:1120#L38)
``` go
func NewNimbusDriver(endpoint string, options ...func(*Driver)) *Driver
```
NewNimbusDriver creates a configured network client and stops recreatation of the client
this prevents the mistake of creating many network clients to communicate with Nimbus preventing
to proper recycling of TCP resources





### <a name="Driver.PostNimbus">func</a> (Driver) [PostNimbus](/src/target/client.go?s=1877:1943#L70)
``` go
func (d Driver) PostNimbus(body io.Reader) (*http.Response, error)
```
PostNimbus sends a POST request to Nimbus




### <a name="Driver.PostNimbusTwoFiveRequest">func</a> (Driver) [PostNimbusTwoFiveRequest](/src/target/client.go?s=2680:2763#L92)
``` go
func (d Driver) PostNimbusTwoFiveRequest(r twofive.Request) (*http.Response, error)
```
PostNimbusTwoFiveRequest sends a POST request to Nimbus but, allows only the passing of the RTB2.5 request




### <a name="Driver.PostNimbusTwoFiveRequestWithContext">func</a> (Driver) [PostNimbusTwoFiveRequestWithContext](/src/target/client.go?s=3257:3372#L108)
``` go
func (d Driver) PostNimbusTwoFiveRequestWithContext(ctx context.Context, r twofive.Request) (*http.Response, error)
```
PostNimbusTwoFiveRequestWithContext sends a POST request to Nimbus, but allows only the passing of the RTB2.5 request. Addtionally context can be attached to the request
this is great to adding a timeout to the request




### <a name="Driver.PostNimbusWithContext">func</a> (Driver) [PostNimbusWithContext](/src/target/client.go?s=2267:2365#L81)
``` go
func (d Driver) PostNimbusWithContext(ctx context.Context, body io.Reader) (*http.Response, error)
```
PostNimbusWithContext sends a POST request to Nimbus with a context attached to the request
this is great to adding a timeout to the request




## <a name="Nimbus">type</a> [Nimbus](/src/target/client.go?s=300:699#L21)
``` go
type Nimbus interface {
    NewNimbusClient(endpoint string, options ...func(*Driver)) *Driver
    PostNimbus(body io.Reader) (*http.Response, error)
    PostNimbusWithContext(ctx context.Context, body io.Reader) (*http.Response, error)
    PostNimbusTwoFiveRequest(r twofive.Request) (*http.Response, error)
    PostNimbusTwoFiveRequestWithContext(ctx context.Context, r twofive.Request) (*http.Response, error)
}
```
Nimbus interface defines a series of POST request helper methods to communicate s2s














- - -
Generated by [godoc2md](http://godoc.org/github.com/davecheney/godoc2md)
