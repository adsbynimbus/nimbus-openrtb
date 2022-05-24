using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Source {
        [JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public SourceExt Ext;
    }

    public class SourceExt {
        [JsonProperty("omidpn", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Omidpn;

        [JsonProperty("omidpv", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Omidpv;
    }
}
