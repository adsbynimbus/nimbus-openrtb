using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Regs {
		[JsonProperty("coppa")] public int Coppa { get; set; }

		[JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public RegExt Ext { get; set; }
	}

	public struct RegExt {
		[JsonProperty("gdpr", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Gdpr { get; set; }

		[JsonProperty("us_privacy", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string UsPrivacy { get; set; }
	}
}