using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Publisher {
        [JsonProperty("cat", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] Cat;

        [JsonProperty("domain", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Domain;

        [JsonProperty("name", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Name;
    }
}
