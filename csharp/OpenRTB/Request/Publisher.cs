using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Publisher {
		[JsonProperty("name", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Name { get; set; }

		[JsonProperty("cat", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] Cat { get; set; }

		[JsonProperty("domain", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Domain { get; set; }
	}
}