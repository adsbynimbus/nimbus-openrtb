using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct BidRequest {
		[JsonProperty("imp", Required = Required.Always)]
		public Imp[] Imp { get; set; }

		[JsonProperty("app", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public App App { get; set; }

		[JsonProperty("device", Required = Required.Always)]
		public Device Device { get; set; }

		[JsonProperty("format", Required = Required.Always)]
		public Format Format { get; set; }

		[JsonProperty("user", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public User User { get; set; }

		[JsonProperty("test")] public int Test { get; set; }

		[JsonProperty("wseat", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] WSeat { get; set; }

		[JsonProperty("bseat", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] BSeat { get; set; }

		[JsonProperty("wlang", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] BLang { get; set; }

		[JsonProperty("bcat", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] BCat { get; set; }

		[JsonProperty("badv", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] BAdv { get; set; }

		[JsonProperty("bapp", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] BApp { get; set; }

		[JsonProperty("source", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Source Source { get; set; }

		[JsonProperty("regs", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Regs Regs { get; set; }

		[JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public BidRequestExt Ext { get; set; }
	}

	public class BidRequestExt {
		[JsonProperty("api_key", Required = Required.Always)]
		public string ApiKey { get; set; }

		[JsonProperty("session_id", Required = Required.Always)]
		public string SessionId { get; set; }
	}
}