using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Skadn {
        [JsonProperty("skadnetids", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] SkadnetIds;

        [JsonProperty("sourceapp", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string SourceApp;

        [JsonProperty("version", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Version;
    }
}
