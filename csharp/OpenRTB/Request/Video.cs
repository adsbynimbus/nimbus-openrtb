using Newtonsoft.Json;
using OpenRTB.Enumerations;

namespace OpenRTB.Request {
	public struct Video {
		[JsonProperty("bidfloor", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public float BidFloor { set; get; }

		[JsonProperty("companionad", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Banner[] CompanionAd { set; get; }

		[JsonProperty("companiontype", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public CompanionTypes[] CompanionType { set; get; }

		[JsonProperty("mimes", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] Mimes { get; set; }

		[JsonProperty("minduration", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int MinDuration { get; set; }

		[JsonProperty("maxduration", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int MaxDuration { get; set; }

		[JsonProperty("protocols", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Protocols[] Protocols { get; set; }

		[JsonProperty("w", Required = Required.Always)]
		public int? W { get; set; }

		[JsonProperty("h", Required = Required.Always)]
		public int? H { get; set; }

		[JsonProperty("startdelay")] public int StartDelay { get; set; }

		[JsonProperty("placement", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public PlacementType Placement { get; set; }

		[JsonProperty("linearity", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Linearity Linearity { get; set; }

		[JsonProperty("playbackmethod", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public PlaybackMethods[] PlaybackMethod { get; set; }

		[JsonProperty("skip")] public int Skip { get; set; }

		[JsonProperty("delivery", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public DeliveryMethods[] Delivery { get; set; }

		[JsonProperty("pos")] public Position Pos { get; set; }

		[JsonProperty("api", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Api[] Api { get; set; }

		[JsonProperty("minbitrate", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int MinBitrate { get; set; }

		[JsonProperty("maxbitrate", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int MaxBitrate { get; set; }

		[JsonProperty("ext", NullValueHandling = NullValueHandling.Ignore)]
		public VideoExt Ext { get; set; }
	}

	public struct VideoExt {
		[JsonProperty("is_rewarded")] public int IsRewarded { get; set; }
	}
}