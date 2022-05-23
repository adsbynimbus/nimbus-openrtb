using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Segment {
		[JsonProperty("id", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Id { get; set; }

		[JsonProperty("name", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Name { get; set; }

		[JsonProperty("value", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Value { get; set; }
	}
}