using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Format {
        [JsonProperty("h", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int H;

        [JsonProperty("w", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int W;
    }
}
