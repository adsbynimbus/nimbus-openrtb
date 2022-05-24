using Newtonsoft.Json;
using OpenRTB.Enumerations;

namespace OpenRTB.Request {
    public class Video {
        [JsonProperty("api", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Api[] Api;

        [JsonProperty("delivery", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public DeliveryMethods[] Delivery;

        [JsonProperty("ext", NullValueHandling = NullValueHandling.Ignore)]
        public VideoExt Ext;

        [JsonProperty("h", Required = Required.Always)]
        public int? H;

        [JsonProperty("linearity", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Linearity Linearity;

        [JsonProperty("maxbitrate", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int MaxBitrate;

        [JsonProperty("maxduration", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int MaxDuration;

        [JsonProperty("mimes", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] Mimes;

        [JsonProperty("minbitrate", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int MinBitrate;

        [JsonProperty("minduration", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int MinDuration;

        [JsonProperty("placement", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public PlacementType Placement;

        [JsonProperty("playbackmethod", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public PlaybackMethods[] PlaybackMethod;

        [JsonProperty("pos")] public Position Pos;

        [JsonProperty("protocols", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Protocols[] Protocols;

        [JsonProperty("skip")] public int Skip;

        [JsonProperty("startdelay")] public int StartDelay;

        [JsonProperty("w", Required = Required.Always)]
        public int? W;

        [JsonProperty("bidfloor", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public float BidFloor;

        [JsonProperty("companionad", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Banner[] CompanionAd;

        [JsonProperty("companiontype", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public CompanionTypes[] CompanionType;
    }

    public class VideoExt {
        [JsonProperty("is_rewarded")] public int IsRewarded;
    }
}
