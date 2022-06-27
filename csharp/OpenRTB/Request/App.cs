using Newtonsoft.Json;

namespace OpenRTB.Request {
    public class App {
        [JsonProperty("bundle", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Bundle;

        [JsonProperty("cat", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] Cat;

        [JsonProperty("domain", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Domain;

        [JsonProperty("name", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Name;

        [JsonProperty("pagecat", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] PageCat;

        [JsonProperty("paid")] public int Paid;

        [JsonProperty("privacypolicy")] public int PrivacyPolicy;

        [JsonProperty("publisher", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public Publisher Publisher;

        [JsonProperty("sectioncat", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] SectionCat;

        [JsonProperty("storeurl", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string StoreUrl;

        [JsonProperty("ver", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string Ver;
    }
}
