using Newtonsoft.Json;
using OpenRTB.Enumerations;

namespace OpenRTB.Request {
	public struct Banner {
		[JsonProperty("bidfloor", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public float BidFloor { set; get; }

		[JsonProperty("battr", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public CreativeAttributes[] BAttr { set; get; }

		[JsonProperty("format", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Format[] Format { get; set; }

		[JsonProperty("w", Required = Required.Always)]
		public int? W { get; set; }

		[JsonProperty("h", Required = Required.Always)]
		public int? H { get; set; }

		[JsonProperty("pos", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Position Pos { get; set; }

		[JsonProperty("api", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Api[] Api { get; set; }

		[JsonProperty("vcm", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Vcm { get; set; }
	}
}