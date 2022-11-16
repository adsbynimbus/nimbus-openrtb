using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Regs {
        [JsonProperty("coppa")] public int Coppa;

        [JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public RegExt Ext;
    }

    public class RegExt {
        [JsonProperty("gdpr", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int Gdpr;

        [JsonProperty("us_privacy", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string UsPrivacy;

        [JsonProperty("gpp")]
        public string GPP;

        [JsonProperty("gpp_sid")]
        public string GPPSIDs;
    }
}
