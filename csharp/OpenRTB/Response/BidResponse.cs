using Newtonsoft.Json;

namespace OpenRTB.Response {
    public struct BidResponse {
        [JsonProperty("type")] public string Type;
        [JsonProperty("auction_id")] public string AuctionId;

        [JsonProperty("adomain", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] Adomain;

        [JsonProperty("bid_in_cents")] public int BidInCents;
        [JsonProperty("bid_raw")] public float BidRaw;
        [JsonProperty("content_type")] public string ContentType;

        [JsonProperty("crid", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Crid;

        [JsonProperty("height", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int Height;

        [JsonProperty("width", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int Width;

        [JsonProperty("is_interstitial")] public int IsInterstitial;
        [JsonProperty("is_mraid")] public int IsMraid;
        [JsonProperty("markup")] public string Markup;
        [JsonProperty("network")] public string Network;
        [JsonProperty("position")] public string Position;

        [JsonProperty("trackers", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Trackers Trackers;

        [JsonProperty("placement_id", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string PlacementId;

        [JsonProperty("duration", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int Duration;

        [JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public BidExt Ext;
    }

    public struct BidExt {
        [JsonProperty("skadn", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public SkadnResponse Skadn;
    }
}
