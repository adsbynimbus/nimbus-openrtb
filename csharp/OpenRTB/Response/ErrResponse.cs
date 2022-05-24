using Newtonsoft.Json;

namespace OpenRTB.Response {
    public struct ErrResponse {
        [JsonProperty("id")] public string Id;
        [JsonProperty("status_code")] public int StatusCode;
        [JsonProperty("nbr")] public int Nrb;
        [JsonProperty("message")] public string Message;
    }
}
