using Newtonsoft.Json;
using OpenRTB.Enumerations;

namespace OpenRTB.Request {
    public class Device {
        [JsonProperty("carrier", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Carrier;

        [JsonProperty("connectiontype")] public ConnectionType ConnectionType;

        [JsonProperty("devicetype", Required = Required.Always)]
        public DeviceType? DeviceType;

        [JsonProperty("dnt")] public int Dnt;

        [JsonProperty("ext", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public DeviceExt Ext;

        [JsonProperty("geo", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Geo Geo;

        [JsonProperty("h", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int H;

        [JsonProperty("hwv", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Hwv;

        [JsonProperty("ifa", Required = Required.Always)]
        public string Ifa;

        [JsonProperty("ip", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Ip;

        [JsonProperty("language", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Language;

        [JsonProperty("lmt")] public int Lmt;

        [JsonProperty("make", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Make;

        [JsonProperty("model", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Model;

        [JsonProperty("os", Required = Required.Always)]
        public string Os;

        [JsonProperty("osv", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Osv;

        [JsonProperty("ua", Required = Required.Always)]
        public string Ua;

        [JsonProperty("w", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int W;
    }

    public class DeviceExt {
        [JsonProperty("atts", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int Atts;

        [JsonProperty("ifv", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Ifv;
    }
}
