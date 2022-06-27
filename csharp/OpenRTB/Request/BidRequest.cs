using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class BidRequest {
        [JsonProperty("app", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public App App;

        [JsonProperty("badv", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] BAdv;

        [JsonProperty("bapp", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] BApp;

        [JsonProperty("bcat", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] BCat;

        [JsonProperty("wlang", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] BLang;

        [JsonProperty("bseat", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] BSeat;

        [JsonProperty("device", Required = Required.Always)]
        public Device Device;

        [JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public BidRequestExt Ext;

        [JsonProperty("format", Required = Required.Always)]
        public Format Format;

        [JsonProperty("imp", Required = Required.Always)]
        public Imp[] Imp;

        [JsonProperty("regs", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Regs Regs;

        [JsonProperty("source", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Source Source;

        [JsonProperty("test")] public int Test;

        [JsonProperty("user", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public User User;

        [JsonProperty("wseat", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] WSeat;
    }

    public class BidRequestExt {
        // this is required, however servers are allowed to send this in a header to Nimbus
        [JsonProperty("api_key", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string ApiKey;

        [JsonProperty("session_id", Required = Required.Always)]
        public string SessionId;
    }
}
