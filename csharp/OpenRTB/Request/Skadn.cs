using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Skadn {
		[JsonProperty("version", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Version { get; set; }

		[JsonProperty("sourceapp", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string SourceApp { get; set; }

		[JsonProperty("skadnetids", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] SkadnetIds { get; set; }
	}
}