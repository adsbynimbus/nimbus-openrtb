using Newtonsoft.Json;

namespace OpenRTB.Response {
	public struct BidResponse {
		[JsonProperty("type")] public string Type { get; set; }
		[JsonProperty("auction_id")] public string AuctionId { get; set; }

		[JsonProperty("adomain", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] Adomain { get; set; }

		[JsonProperty("bid_in_cents")] public int BidInCents { get; set; }
		[JsonProperty("bid_raw")] public float BidRaw { get; set; }
		[JsonProperty("content_type")] public string ContentType { get; set; }

		[JsonProperty("crid", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Crid { get; set; }

		[JsonProperty("height", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Height { get; set; }

		[JsonProperty("width", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Width { get; set; }

		[JsonProperty("is_interstitial")] public int IsInterstitial { get; set; }
		[JsonProperty("is_mraid")] public int IsMraid { get; set; }
		[JsonProperty("markup")] public string Markup { get; set; }
		[JsonProperty("network")] public string Network { get; set; }

		[JsonProperty("trackers", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Trackers[] Trackers { get; set; }

		[JsonProperty("placement_id", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string PlacementId { get; set; }

		[JsonProperty("duration", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Duration { get; set; }

		[JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public BidExt Ext { get; set; }
	}

	public struct BidExt {
		[JsonProperty("skadn", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public SkadnResponse Skadn { get; set; }
	}
}