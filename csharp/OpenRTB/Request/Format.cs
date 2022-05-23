using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Format {
		[JsonProperty("w", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int W { get; set; }

		[JsonProperty("h", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int H { get; set; }
	}
}