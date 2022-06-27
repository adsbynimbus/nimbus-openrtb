using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class Geo {
        [JsonProperty("city", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string City;

        [JsonProperty("country", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Country;

        [JsonProperty("ipservice", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int IpService;

        [JsonProperty("lat", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public float Lat;

        [JsonProperty("lon", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public float Lon;

        [JsonProperty("metro", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Metro;

        [JsonProperty("state", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string State;

        [JsonProperty("type", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public int Type;
    }
}
