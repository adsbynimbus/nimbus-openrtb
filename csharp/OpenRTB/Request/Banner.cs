using Newtonsoft.Json;
using OpenRTB.Enumerations;

namespace OpenRTB.Request {
    public class Banner {
        [JsonProperty("api", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Api[] Api;

        [JsonProperty("format", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Format[] Format;

        [JsonProperty("h", Required = Required.Always)]
        public int? H;

        [JsonProperty("pos", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Position Pos;

        [JsonProperty("vcm", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int Vcm;

        [JsonProperty("w", Required = Required.Always)]
        public int? W;

        [JsonProperty("bidfloor", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public float BidFloor;

        [JsonProperty("battr", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public CreativeAttributes[] BAttr;
    }
}
