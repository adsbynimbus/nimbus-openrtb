using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct App {
		[JsonProperty("name", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Name { get; set; }

		[JsonProperty("bundle", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Bundle { get; set; }

		[JsonProperty("domain", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Domain { get; set; }

		[JsonProperty("storeurl", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string StoreUrl { get; set; }

		[JsonProperty("cat", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] Cat { get; set; }

		[JsonProperty("sectioncat", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] SectionCat { get; set; }

		[JsonProperty("pagecat", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string[] PageCat { get; set; }

		[JsonProperty("ver", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Ver { get; set; }

		[JsonProperty("privacypolicy")] public int PrivacyPolicy { get; set; }

		[JsonProperty("paid")] public int Paid { get; set; }

		[JsonProperty("publisher", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Publisher Publisher { get; set; }
	}
}