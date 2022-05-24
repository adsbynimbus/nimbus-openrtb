using Newtonsoft.Json;

namespace OpenRTB.Response {
    public struct SkadnResponse {
        [JsonProperty("version", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Version;

        [JsonProperty("network", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Network;

        [JsonProperty("campaign", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Campaign;

        [JsonProperty("itunesitem", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Itunesitem;

        [JsonProperty("nonce", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Nonce;

        [JsonProperty("sourceapp", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Sourceapp;

        [JsonProperty("timestamp", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Timestamp;

        [JsonProperty("signature", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Signature;
    }
}
