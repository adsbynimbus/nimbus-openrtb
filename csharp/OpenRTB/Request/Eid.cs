using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Eid {
        [JsonProperty("source", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Source;

        [JsonProperty("uids", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Uid[] Uids;
    }

    public class Uid {
        [JsonProperty("id", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Id;

        [JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public UidExt UidExt;
    }

    public class UidExt {
        [JsonProperty("rtiPartner", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string RtiPartner;
    }
}
