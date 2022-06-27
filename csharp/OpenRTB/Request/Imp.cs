using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Imp {
        [JsonProperty("banner", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Banner Banner;

        [JsonProperty("ext", Required = Required.Always)]
        public ImpExt Ext;

        [JsonProperty("id", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Id;

        [JsonProperty("instl")] public int Instl;

        [JsonProperty("secure", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int Secure;

        [JsonProperty("video", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Video Video;
    }

    public class ImpExt {
        [JsonProperty("position", Required = Required.Always)]
        public string Position;

        [JsonProperty("skadn", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Skadn Skadn;
    }
}
