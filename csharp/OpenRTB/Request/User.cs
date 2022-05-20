using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct User {
		[JsonProperty("age", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Age { get; set; }

		[JsonProperty("buyeruid", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string BuyerId { get; set; }

		[JsonProperty("yob", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Yob { get; set; }

		[JsonProperty("gender", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Gender { get; set; }

		[JsonProperty("keywords", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Keywords { get; set; }

		[JsonProperty("custom_data", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string CustomData { get; set; }

		[JsonProperty("data", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Data Data { get; set; }

		[JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public UserExt Ext { get; set; }
	}

	public struct UserExt {
		[JsonProperty("consent", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Consent { get; set; }

		[JsonProperty("did_consent")] public int DidConsent { get; set; }

		[JsonProperty("eids", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Eid[] Eids { get; set; }
	}
}