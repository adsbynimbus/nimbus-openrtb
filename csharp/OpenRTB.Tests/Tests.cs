using System;
using System.Diagnostics;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using NUnit.Framework;
using OpenRTB.Enumerations;
using OpenRTB.Request;

namespace OpenRTB.Tests {
    [SetUpFixture]
    public class SetupTrace {
        [OneTimeSetUp]
        public void StartTest() {
            Trace.Listeners.Add(new ConsoleTraceListener());
        }

        [OneTimeTearDown]
        public void EndTest() {
            Trace.Flush();
        }
    }

    [TestFixture]
    public class Tests {
        [Test]
        public void TestValidateBidRequest() {
            var tests = new[] {
                new ValidateBidRequestTableData("request should be valid", new BidRequest {
                    App = new App {
                        Name = "foo",
                        Bundle = "com.foo",
                        Domain = "foo.com",
                        StoreUrl = "https://play.google.com/store/apps/details?id=com.foo",
                        Cat = new[] { "IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20" },
                        Publisher = new Publisher {
                            Name = "foo",
                            Cat = new[] { "IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20" },
                            Domain = "foo.com"
                        }
                    },
                    Device = new Device {
                        DeviceType = DeviceType.Phone,
                        Ua =
                            "Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36",
                        Ip = "71.125.59.151",
                        Make = "Pixel 2 XL",
                        Model = "Samsung",
                        Os = "android",
                        Osv = "4.2.4",
                        Language = "en",
                        ConnectionType = ConnectionType.Wifi,
                        Ifa = "13579176-e94e-4e6e-96ae-572b787af21c"
                    },
                    Format = new Format {
                        H = 1920,
                        W = 1080
                    },
                    User = new User {
                        Age = 30,
                        Yob = 1991,
                        Gender = "male"
                    },
                    Ext = new BidRequestExt {
                        ApiKey = "3b117631-538d-4315-bc47-d4e8ce6527e5",
                        SessionId = "fab5d528-5ac9-4082-a1ff-968a7f8fefc4"
                    },
                    Imp = new[] {
                        new Imp {
                            Banner = new Banner {
                                BidFloor = 2.00f,
                                H = 480,
                                W = 320,
                                Pos = Position.Fullscreen,
                                Format = new[] {
                                    new Format {
                                        H = 1920,
                                        W = 1080
                                    },
                                    new Format {
                                        H = 600,
                                        W = 300
                                    }
                                },
                                BAttr = new[]
                                    { CreativeAttributes.AudioAdAutoPlay, CreativeAttributes.AudioAdUserInitiated }
                            },
                            Video = new Video {
                                BidFloor = 3.00f,
                                Mimes = new[] { "foo", "bar" },
                                MinBitrate = 1,
                                MaxBitrate = 200000,
                                Pos = Position.Fullscreen,
                                MinDuration = 15,
                                MaxDuration = 60,
                                H = 1080,
                                W = 1920
                            },
                            Instl = 1,
                            Secure = 1,
                            Ext = new ImpExt {
                                Position = "App Open"
                            }
                        }
                    }
                }, false),
                new ValidateBidRequestTableData("request should be invalid the banner h and w are missing",
                    new BidRequest {
                        App = new App {
                            Name = "foo",
                            Bundle = "com.foo",
                            Domain = "foo.com",
                            StoreUrl = "https://play.google.com/store/apps/details?id=com.foo",
                            Cat = new[] { "IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20" },
                            Publisher = new Publisher {
                                Name = "foo",
                                Cat = new[] { "IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20" },
                                Domain = "foo.com"
                            }
                        },
                        Device = new Device {
                            DeviceType = DeviceType.Phone,
                            Ua =
                                "Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36",
                            Ip = "71.125.59.151",
                            Make = "Pixel 2 XL",
                            Model = "Samsung",
                            Os = "android",
                            Osv = "4.2.4",
                            Language = "en",
                            ConnectionType = ConnectionType.Wifi,
                            Ifa = "13579176-e94e-4e6e-96ae-572b787af21c"
                        },
                        Format = new Format {
                            H = 1920,
                            W = 1080
                        },
                        User = new User {
                            Age = 30,
                            Yob = 1991,
                            Gender = "male"
                        },
                        Ext = new BidRequestExt {
                            ApiKey = "3b117631-538d-4315-bc47-d4e8ce6527e5",
                            SessionId = "fab5d528-5ac9-4082-a1ff-968a7f8fefc4"
                        },
                        Imp = new[] {
                            new Imp {
                                Banner = new Banner {
                                    BidFloor = 2.00f,
                                    Pos = Position.Fullscreen,
                                    Format = new[] {
                                        new Format {
                                            H = 1920,
                                            W = 1080
                                        },
                                        new Format {
                                            H = 600,
                                            W = 300
                                        }
                                    },
                                    BAttr = new[]
                                        { CreativeAttributes.AudioAdAutoPlay, CreativeAttributes.AudioAdUserInitiated }
                                },
                                Video = new Video {
                                    BidFloor = 3.00f,
                                    H = 300,
                                    W = 600,
                                    Mimes = new[] { "foo", "bar" },
                                    MinBitrate = 1,
                                    MaxBitrate = 200000,
                                    Pos = Position.Fullscreen,
                                    MinDuration = 15,
                                    MaxDuration = 60
                                },
                                Instl = 1,
                                Secure = 1,
                                Ext = new ImpExt {
                                    Position = "App Open"
                                }
                            }
                        }
                    }, true)
            };

            foreach (var tt in tests) {
                Debug.WriteLine($"Running Test {tt.Name}");
                if (tt.WantError) {
                    void TestSerialize() {
                        JsonConvert.SerializeObject(tt.Request);
                    }

                    Assert.Throws<JsonSerializationException>(TestSerialize);
                    return;
                }

                // this method should be called with 0 exceptions thrown
                _ = JsonConvert.SerializeObject(tt.Request);
            }
        }

        [Test, Category("Serialization")]
        public void TestBidRequestSerialization() {
            const string expected =
                "{\"imp\":[{\"banner\":{\"bidfloor\":2.0,\"battr\":[1,2],\"format\":[{\"w\":1080,\"h\":1920},{\"w\":300,\"h\":600}],\"w\":320,\"h\":480,\"pos\":7},\"video\":{\"bidfloor\":3.0,\"mimes\":[\"foo\",\"bar\"],\"minduration\":15,\"maxduration\":60,\"w\":1920,\"h\":1080,\"startdelay\":0,\"skip\":0,\"pos\":7,\"minbitrate\":1,\"maxbitrate\":200000,\"ext\":{\"is_rewarded\":0}},\"instl\":1,\"secure\":1,\"ext\":{\"position\":\"App Open\"}}],\"app\":{\"name\":\"foo\",\"bundle\":\"com.foo\",\"domain\":\"foo.com\",\"storeurl\":\"https://play.google.com/store/apps/details?id=com.foo\",\"cat\":[\"IAB14\",\"IAB1\",\"IAB9\",\"IAB12\",\"IAB16\",\"IAB17\",\"IAB18\",\"IAB20\"],\"privacypolicy\":0,\"paid\":0,\"publisher\":{\"name\":\"foo\",\"cat\":[\"IAB14\",\"IAB1\",\"IAB9\",\"IAB12\",\"IAB16\",\"IAB17\",\"IAB18\",\"IAB20\"],\"domain\":\"foo.com\"}},\"device\":{\"ua\":\"Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36\",\"dnt\":0,\"lmt\":0,\"ip\":\"71.125.59.151\",\"devicetype\":4,\"make\":\"Pixel 2 XL\",\"model\":\"Samsung\",\"os\":\"android\",\"osv\":\"4.2.4\",\"language\":\"en\",\"connectiontype\":2,\"ifa\":\"13579176-e94e-4e6e-96ae-572b787af21c\"},\"format\":{\"w\":1080,\"h\":1920},\"user\":{\"age\":30,\"yob\":1991,\"gender\":\"male\"},\"test\":0,\"ext\":{\"api_key\":\"3b117631-538d-4315-bc47-d4e8ce6527e5\",\"session_id\":\"fab5d528-5ac9-4082-a1ff-968a7f8fefc4\"}}";

            var bidRequest = new BidRequest {
                App = new App {
                    Name = "foo",
                    Bundle = "com.foo",
                    Domain = "foo.com",
                    StoreUrl = "https://play.google.com/store/apps/details?id=com.foo",
                    Cat = new[] { "IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20" },
                    Publisher = new Publisher {
                        Name = "foo",
                        Cat = new[] { "IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20" },
                        Domain = "foo.com"
                    }
                },
                Device = new Device {
                    DeviceType = DeviceType.Phone,
                    Ua =
                        "Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36",
                    Ip = "71.125.59.151",
                    Make = "Pixel 2 XL",
                    Model = "Samsung",
                    Os = "android",
                    Osv = "4.2.4",
                    Language = "en",
                    ConnectionType = ConnectionType.Wifi,
                    Ifa = "13579176-e94e-4e6e-96ae-572b787af21c"
                },
                Format = new Format {
                    H = 1920,
                    W = 1080
                },
                User = new User {
                    Age = 30,
                    Yob = 1991,
                    Gender = "male"
                },
                Ext = new BidRequestExt {
                    ApiKey = "3b117631-538d-4315-bc47-d4e8ce6527e5",
                    SessionId = "fab5d528-5ac9-4082-a1ff-968a7f8fefc4"
                },
                Imp = new[] {
                    new Imp {
                        Banner = new Banner {
                            BidFloor = 2.00f,
                            H = 480,
                            W = 320,
                            Pos = Position.Fullscreen,
                            Format = new[] {
                                new Format {
                                    H = 1920,
                                    W = 1080
                                },
                                new Format {
                                    H = 600,
                                    W = 300
                                }
                            },
                            BAttr = new[]
                                { CreativeAttributes.AudioAdAutoPlay, CreativeAttributes.AudioAdUserInitiated }
                        },
                        Video = new Video {
                            BidFloor = 3.00f,
                            Mimes = new[] { "foo", "bar" },
                            MinBitrate = 1,
                            MaxBitrate = 200000,
                            Pos = Position.Fullscreen,
                            MinDuration = 15,
                            MaxDuration = 60,
                            H = 1080,
                            W = 1920,
                            Ext = new VideoExt {
                                IsRewarded = 0,
                            }
                        },
                        Instl = 1,
                        Secure = 1,
                        Ext = new ImpExt {
                            Position = "App Open"
                        }
                    }
                }
            };

            var jsonString = JsonConvert.SerializeObject(bidRequest);
            var json1 = JObject.Parse(jsonString);
            var json2 = JObject.Parse(expected);
            Assert.IsTrue(JToken.DeepEquals(json1, json2));
        }

        [Test, Category("Deserialization")]
        public void TestBidRequestDeserialization() {
            const string expected =
                "{\"imp\":[{\"banner\":{\"bidfloor\":2.0,\"battr\":[1,2],\"format\":[{\"w\":1080,\"h\":1920},{\"w\":300,\"h\":600}],\"w\":320,\"h\":480,\"pos\":7},\"video\":{\"bidfloor\":3.0,\"mimes\":[\"foo\",\"bar\"],\"minduration\":15,\"maxduration\":60,\"w\":1920,\"h\":1080,\"startdelay\":0,\"skip\":0,\"pos\":7,\"minbitrate\":1,\"maxbitrate\":200000,\"ext\":{\"is_rewarded\":0}},\"instl\":1,\"secure\":1,\"ext\":{\"position\":\"App Open\"}}],\"app\":{\"name\":\"foo\",\"bundle\":\"com.foo\",\"domain\":\"foo.com\",\"storeurl\":\"https://play.google.com/store/apps/details?id=com.foo\",\"cat\":[\"IAB14\",\"IAB1\",\"IAB9\",\"IAB12\",\"IAB16\",\"IAB17\",\"IAB18\",\"IAB20\"],\"privacypolicy\":0,\"paid\":0,\"publisher\":{\"name\":\"foo\",\"cat\":[\"IAB14\",\"IAB1\",\"IAB9\",\"IAB12\",\"IAB16\",\"IAB17\",\"IAB18\",\"IAB20\"],\"domain\":\"foo.com\"}},\"device\":{\"ua\":\"Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36\",\"dnt\":0,\"lmt\":0,\"ip\":\"71.125.59.151\",\"devicetype\":4,\"make\":\"Pixel 2 XL\",\"model\":\"Samsung\",\"os\":\"android\",\"osv\":\"4.2.4\",\"language\":\"en\",\"connectiontype\":2,\"ifa\":\"13579176-e94e-4e6e-96ae-572b787af21c\"},\"format\":{\"w\":1080,\"h\":1920},\"user\":{\"age\":30,\"yob\":1991,\"gender\":\"male\"},\"test\":0,\"ext\":{\"api_key\":\"3b117631-538d-4315-bc47-d4e8ce6527e5\",\"session_id\":\"fab5d528-5ac9-4082-a1ff-968a7f8fefc4\"}}";

            var bidRequestWant = new BidRequest {
                App = new App {
                    Name = "foo",
                    Bundle = "com.foo",
                    Domain = "foo.com",
                    StoreUrl = "https://play.google.com/store/apps/details?id=com.foo",
                    Cat = new[] { "IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20" },
                    Publisher = new Publisher {
                        Name = "foo",
                        Cat = new[] { "IAB14", "IAB1", "IAB9", "IAB12", "IAB16", "IAB17", "IAB18", "IAB20" },
                        Domain = "foo.com"
                    }
                },
                Device = new Device {
                    DeviceType = DeviceType.Phone,
                    Ua =
                        "Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36",
                    Ip = "71.125.59.151",
                    Make = "Pixel 2 XL",
                    Model = "Samsung",
                    Os = "android",
                    Osv = "4.2.4",
                    Language = "en",
                    ConnectionType = ConnectionType.Wifi,
                    Ifa = "13579176-e94e-4e6e-96ae-572b787af21c"
                },
                Format = new Format {
                    H = 1920,
                    W = 1080
                },
                User = new User {
                    Age = 30,
                    Yob = 1991,
                    Gender = "male"
                },
                Ext = new BidRequestExt {
                    ApiKey = "3b117631-538d-4315-bc47-d4e8ce6527e5",
                    SessionId = "fab5d528-5ac9-4082-a1ff-968a7f8fefc4"
                },
                Imp = new[] {
                    new Imp {
                        Banner = new Banner {
                            BidFloor = 2.00f,
                            H = 480,
                            W = 320,
                            Pos = Position.Fullscreen,
                            Format = new[] {
                                new Format {
                                    H = 1920,
                                    W = 1080
                                },
                                new Format {
                                    H = 600,
                                    W = 300
                                }
                            },
                            BAttr = new[]
                                { CreativeAttributes.AudioAdAutoPlay, CreativeAttributes.AudioAdUserInitiated }
                        },
                        Video = new Video {
                            BidFloor = 3.00f,
                            Mimes = new[] { "foo", "bar" },
                            MinBitrate = 1,
                            MaxBitrate = 200000,
                            Pos = Position.Fullscreen,
                            MinDuration = 15,
                            MaxDuration = 60,
                            H = 1080,
                            W = 1920,
                            Ext = new VideoExt {
                                IsRewarded = 0,
                            }
                        },
                        Instl = 1,
                        Secure = 1,
                        Ext = new ImpExt {
                            Position = "App Open"
                        }
                    }
                }
            };

            var bidRequestGot = JsonConvert.DeserializeObject<BidRequest>(expected);
            var jsonStringGot = JsonConvert.SerializeObject(bidRequestGot);
            var jsonStringWant = JsonConvert.SerializeObject(bidRequestWant);
            var json1 = JObject.Parse(jsonStringGot);
            var json2 = JObject.Parse(jsonStringWant);
            
            Assert.IsTrue(JToken.DeepEquals(json1, json2));
        }
    }

    public struct ValidateBidRequestTableData {
        public readonly string Name;
        public readonly BidRequest Request;
        public readonly bool WantError;

        public ValidateBidRequestTableData(string name, BidRequest request, bool wantError) {
            Name = name;
            Request = request;
            WantError = wantError;
        }
    }
}
