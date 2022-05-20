using Newtonsoft.Json;
using OpenRTB.Enumerations;

namespace OpenRTB.Request {
	public struct Device {
		[JsonProperty("ua", Required = Required.Always)]
		public string Ua { get; set; }

		[JsonProperty("geo", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public Geo Geo { get; set; }

		[JsonProperty("dnt")] public int Dnt { get; set; }
		[JsonProperty("lmt")] public int Lmt { get; set; }

		[JsonProperty("ip", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Ip { get; set; }

		[JsonProperty("devicetype", Required = Required.Always)]
		public DeviceType? DeviceType { get; set; }

		[JsonProperty("make", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Make { get; set; }

		[JsonProperty("model", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Model { get; set; }

		[JsonProperty("hwv", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Hwv { get; set; }

		[JsonProperty("os", Required = Required.Always)]
		public string Os { get; set; }

		[JsonProperty("osv", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Osv { get; set; }

		[JsonProperty("h", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int H { get; set; }

		[JsonProperty("w", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int W { get; set; }

		[JsonProperty("language", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Language { get; set; }

		[JsonProperty("carrier", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Carrier { get; set; }

		[JsonProperty("connectiontype")] public ConnectionType ConnectionType { get; set; }

		[JsonProperty("ifa", Required = Required.Always)]
		public string Ifa { get; set; }

		[JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public DeviceExt Ext { get; set; }
	}

	public struct DeviceExt {
		[JsonProperty("atts", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public int Atts { get; set; }

		[JsonProperty("ifv", DefaultValueHandling = DefaultValueHandling.Ignore)]
		public string Ifv { get; set; }
	}
}