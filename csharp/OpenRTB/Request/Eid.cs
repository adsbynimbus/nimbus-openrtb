using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Eid {
		[JsonProperty("source", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Source { get; set; }

		[JsonProperty("uids", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Uid[] Uids { get; set; }
	}

	public struct Uid {
		[JsonProperty("id", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Id { get; set; }

		[JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public UidExt UidExt { get; set; }
	}

	public struct UidExt {
		[JsonProperty("rtiPartner", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string RtiPartner { get; set; }
	}
}