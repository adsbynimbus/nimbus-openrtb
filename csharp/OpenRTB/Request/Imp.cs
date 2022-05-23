using Newtonsoft.Json;

namespace OpenRTB.Request {
	public struct Imp {
		[JsonProperty("id", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Id { get; set; }

		[JsonProperty("banner", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Banner Banner { get; set; }

		[JsonProperty("video", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Video Video { get; set; }

		[JsonProperty("instl")] public int Instl { get; set; }

		[JsonProperty("secure", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Secure { get; set; }

		[JsonProperty("ext", Required = Required.Always)]
		public ImpExt Ext { get; set; }
	}

	public struct ImpExt {
		[JsonProperty("position", Required = Required.Always)]
		public string Position { get; set; }

		[JsonProperty("skadn", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Skadn Skadn { get; set; }
	}
}