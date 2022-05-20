using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Data {
		[JsonProperty("id", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Id { get; set; }

		[JsonProperty("name", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Name { get; set; }

		[JsonProperty("segment", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Segment[] Segment { get; set; }
	}
}