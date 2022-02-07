package com.adsbynimbus.openrtb.response

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

const val testJson = """
{
  "type": "native",
  "auction_id": "d07668d6-35ba-4870-a3cd-02b18fec1a12",
  "bid_in_cents": 405,
  "bid_raw": 4.0537236296054,
  "content_type": "text/html; charset=utf-8",
  "is_interstitial": 1,
  "is_mraid": 0,
  "markup": "test_markup",
  "network": "test_network",
  "position": "test_position",
  "trackers": {
    "impression_trackers": [
      "https://test.adsbynimbus.com/impression_tracker/"
    ],
    "click_trackers": [
      "https://test.adsbynimbus.com/click_tracker/"
    ]
  },
  "placement_id": "123456789"
}
"""

class BidResponseTest : StringSpec({
    "NimbusResponse when deserialized should contain" {
        Json.decodeFromString<BidResponse>(testJson).run {
            type shouldBe "native"
            auction_id shouldBe "d07668d6-35ba-4870-a3cd-02b18fec1a12"
            bid_in_cents shouldBe 405
            bid_raw shouldBe 4.0537236296054f
            content_type shouldBe "text/html; charset=utf-8"
            is_interstitial shouldBe 1
            is_mraid shouldBe 0
            markup shouldBe "test_markup"
            network shouldBe "test_network"
            placement_id shouldBe "123456789"
            position shouldBe "test_position"
            click_trackers?.shouldContain("https://test.adsbynimbus.com/click_tracker/")
            impression_trackers?.shouldContain("https://test.adsbynimbus.com/impression_tracker/")
        }
    }
})
