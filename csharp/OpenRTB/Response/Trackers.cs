using Newtonsoft.Json;

namespace OpenRTB.Response {
    public struct Trackers {
        [JsonProperty("impression_trackers", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] ImpressionTrackers;

        [JsonProperty("click_trackers", DefaultValueHandling = DefaultValueHandling.Ignore)]
        public string[] ClickTrackers;
    }
}
