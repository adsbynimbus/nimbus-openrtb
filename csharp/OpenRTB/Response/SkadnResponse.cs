using Newtonsoft.Json;

namespace OpenRTB.Response {
	public struct SkadnResponse {
		[JsonProperty("version", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Version { get; set; }

		[JsonProperty("network", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Network { get; set; }

		[JsonProperty("campaign", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Campaign { get; set; }

		[JsonProperty("itunesitem", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Itunesitem { get; set; }

		[JsonProperty("nonce", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Nonce { get; set; }

		[JsonProperty("sourceapp", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Sourceapp { get; set; }

		[JsonProperty("timestamp", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Timestamp { get; set; }

		[JsonProperty("signature", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Signature { get; set; }
	}
}