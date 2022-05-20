using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Geo {
		[JsonProperty("lat", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public float Lat { get; set; }

		[JsonProperty("lon", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public float Lon { get; set; }

		[JsonProperty("type", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Type { get; set; }

		[JsonProperty("ipservice", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int IpService { get; set; }

		[JsonProperty("country", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Country { get; set; }

		[JsonProperty("city", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string City { get; set; }

		[JsonProperty("metro", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Metro { get; set; }

		[JsonProperty("state", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string State { get; set; }
	}
}