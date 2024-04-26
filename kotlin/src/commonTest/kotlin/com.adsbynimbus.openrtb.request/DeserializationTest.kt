package com.adsbynimbus.openrtb.request

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldContain
import io.kotest.matchers.maps.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

const val testJson = """
{
    "imp":[{
        "banner":{
            "bidfloor":2,
            "battr":[1,2,9],
            "format":[
                {"w":480,"h":320},
                {"w":320,"h":480},
                {"w":300,"h":250},
                {"w":1080,"h":1920},
                {"w":640,"h":1136},
                {"w":1024,"h":768},
                {"w":300,"h":600},
                {"w":320,"h":320},
                {"w":300,"h":400},
                {"w":400,"h":400},
                {"w":320,"h":568},
                {"w":375,"h":667},
                {"w":300,"h":450},
                {"w":240,"h":400},
                {"w":336,"h":280},
                {"w":960,"h":640},
                {"w":640,"h":960},
                {"w":600,"h":500},
                {"w":768,"h":1024},
                {"w":728,"h":984},
                {"w":1536,"h":2048},
                {"w":2048,"h":1536},
                {"w":250,"h":300}
            ],
            "w":320,
            "h":480,
            "api":[3,5],
            "pos":7
        },
        "video":{
            "bidfloor":3,
            "companionad":[{"w":320,"h":480,"vcm":1}],
            "companiontype":[1,2,9],
            "mimes":["video/mp4","video/webm","video/3gpp","application/x-mpegurl","video/mpeg","video/ogg","video/x-flv"],
            "minduration":0,
            "maxduration":60,
            "protocols":[2,3,5,6],
            "startdelay":0,
            "playbackmethod":[2],
            "skip":0,
            "minbitrate":1,
            "maxbitrate":20000,
            "ext":null
        },
        "native":{
            "bidfloor":1,
            "request":"{\"assets\":[{\"id\":1,\"img\":{\"hmin\":250,\"type\":3,\"wmin\":300,\"mimes\":[\"image/jpeg\",\"image/png\",\"image/gif\"]},\"title\":{\"len\":140},\"data\":{\"type\":2,\"len\":140},\"required\":1}],\"plcmttype\":1,\"plcmtcnt\":1,\"required\":1,\"ver\":\"1.1\"}",
            "ver":"1.1",
            "ext": {
                "nimbus_native": {
                    "ver": "1.2",
                    "plcmttype": 1,
                    "context": 1,
                    "contextsubtype": 11,
                     "assets": [
                      {
                        "id": 1,
                        "required": 1,
                        "title": {
                          "len": 140
                        }
                      },
                      {
                        "id": 2,
                        "img": {
                          "h": 250,
                          "type": 3,
                          "w": 300
                        },
                        "required": 1
                      },
                      {
                        "data": {
                          "len": 140,
                          "type": 2
                        },
                        "id": 3,
                        "required": 1
                      }
                    ]
                }
            }
        },
        "instl":1,
        "bidfloor":1,
        "secure":1,
        "ext":{
            "facebook_app_id":"test_facebook_app_id",
            "position":"5",
            "skadn":null
        }
    }],
    "app":{
        "name":"OpenRTB",
        "bundle":"com.adsbynimbus.openrtb",
        "domain":"https://adsbynimbus.com",
        "storeurl":"https://play.google.com/store/apps/details?id=com.adsbynimbus.openrtb",
        "cat":["IAB14","IAB1","IAB9","IAB12","IAB16","IAB17","IAB18","IAB20"],
        "ver":"0.8.3",
        "privacypolicy":1,
        "paid":0,
        "publisher":{
            "name":"Adsbynimbus",
            "domain":"https://adsbynimbus.com"
        }
    },
    "device":{
        "ua":"test-ua-string",
        "dnt":0,
        "lmt":0,
        "ip":"255.255.255.0",
        "devicetype":1,
        "make":"Google",
        "model":"Pixel 6 Pro",
        "os":"android",
        "osv":"12.0.0",
        "h":480,
        "w":320,
        "pxratio":"4.0",
        "language":"en",
        "ifa":"00000000-0000-0000-0000-000000000000"
    },
    "format":{"w":320,"h":480},
    "user":{
        "age":3,
        "yob":2019,
        "gender":"male",
        "ext":{
            "did_consent":1,
            "eids": [
                {
                    "source": "vendor1.com",
                    "uids": [
                        {
                            "id": "XY1000bIVBVah9ium-sZ3ykhPiXQbEcUpn4GjCtxrrw2BRDGM",
                            "ext": {
                                "rtiPartner": "idl"
                            }
                         }
                    ]
                },
                {
                    "source": "adserver.org",
                    "uids": [
                        {
                            "id": "6bca7f6b-a98a-46c0-be05-6020f7604598",
                            "atype": 1,
                            "ext": {
                                "rtiPartner": "TDID"
                            }
                        }
                    ]
                }
            ]
        }
    },
    "source":{"ext":{}},
    "regs":{
        "coppa":0,
        "ext":{
            "gdpr":0,
            "us_privacy":"1YNN",
            "gpp": "DBABMA~CPXxRfAPXxRfAAfKABENB-CgAAAAAAAAAAYgAAAAAAAA",
            "gpp_sid": "2"
        }
    },
    "ext":{"api_key":"12345678-4321-1234-0000-6c5b91b1eac6","session_id":"session1"}
}
"""

class DeserializationTest : StringSpec({

    val request = BidRequest.fromJson(testJson)

    "BidResponse fromJson deserializes the impression array" {
        request.imp shouldHaveSize 1
    }

    "BidResponse fromJson deserializes the app object" {
        request.app.shouldNotBeNull()
    }

    "BidResponse fromJson deserializes the device object" {
        request.device.shouldNotBeNull()
        request.device?.run {
            ua shouldBe "test-ua-string"
            ip shouldBe "255.255.255.0"
            ifa shouldBe "00000000-0000-0000-0000-000000000000"
            pxratio shouldBe 4.0
        }
    }

    "BidResponse fromJson deserializes the format object" {
        request.format.w shouldBe 320
        request.format.h shouldBe 480
    }

    "BidResponse fromJson deserializes the user object" {
        request.user.shouldNotBeNull()
    }

    "BidResponse fromJson deserializes the source object" {
        request.source.shouldNotBeNull()
    }

    "BidResponse fromJson deserializes the regs object" {
        request.regs.shouldNotBeNull()
    }

    "BidResponse fromJson deserializes the regs ext object" {
        request.regs?.ext.shouldNotBeNull()
        request.regs?.ext?.gdpr shouldBe 0
        request.regs?.ext?.us_privacy shouldBe "1YNN"
        request.regs?.ext?.gpp shouldBe "DBABMA~CPXxRfAPXxRfAAfKABENB-CgAAAAAAAAAAYgAAAAAAAA"
        request.regs?.ext?.gpp_sids shouldBe "2"
    }

    "BidResponse fromJson deserializes the ext object" {
        request.ext.shouldNotBeEmpty()
        request.ext.shouldContain("api_key", "12345678-4321-1234-0000-6c5b91b1eac6")
        request.session_id shouldBe "session1"
    }

    "BidResponse fromJson deserialized EIDS" {
        request.user?.ext?.eids.shouldNotBeNull()
        request.user?.ext?.eids?.run {
            size shouldBe 2
            val eid1 = first { it.source == "vendor1.com"}.uids.first()
            eid1.id shouldBe "XY1000bIVBVah9ium-sZ3ykhPiXQbEcUpn4GjCtxrrw2BRDGM"
            eid1.ext.shouldContain("rtiPartner", "idl")

            val eid2 = first { it.source == "adserver.org" }.uids.first()
            eid2.id shouldBe "6bca7f6b-a98a-46c0-be05-6020f7604598"
            eid2.atype shouldBe 1
            eid2.ext.shouldContain("rtiPartner", "TDID")
        }
    }

    "BidResponse fromJson deserialized native extension" {
        request.imp[0].native?.ext?.nimbusNative?.run {
            assets shouldHaveSize 3
            context shouldBe 1
            contextsubtype shouldBe 11
            plcmttype shouldBe 1
        }
    }
})
