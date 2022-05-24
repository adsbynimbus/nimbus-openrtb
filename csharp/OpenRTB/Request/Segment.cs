using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Segment {
        [JsonProperty("id", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Id;

        [JsonProperty("name", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Name;

        [JsonProperty("value", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Value;
    }
}
