using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Source {
		[JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public SourceExt Ext { get; set; }
	}

	public struct SourceExt {
		[JsonProperty("omidpn", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Omidpn { get; set; }

		[JsonProperty("omidpv", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Omidpv { get; set; }
	}
}