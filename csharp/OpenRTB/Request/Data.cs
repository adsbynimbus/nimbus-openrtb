using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Data {
        [JsonProperty("id", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Id;

        [JsonProperty("name", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Name;

        [JsonProperty("segment", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Segment[] Segment;
    }
}
