package com.adsbynimbus.openrtb.response

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldStartWith

const val testJson = """
{
  "type": "native",
  "auction_id": "d07668d6-35ba-4870-a3cd-02b18fec1a12",
  "bid_in_cents": 405,
  "bid_raw": 4.053723,
  "content_type": "text/html; charset=utf-8",
  "is_interstitial": 1,
  "is_mraid": 1,
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
  "placement_id": "123456789",
  "duration": 15,
  "exp": 30,
  "external_notifications": {
    "win_response": "https://test.adsbynimbus.com/win_response/",
    "loss_response": "https://test.adsbynimbus.com/loss_response/auctionPrice=[AUCTION_PRICE]&auctionMinToWin=[AUCTION_MIN_TO_WIN]&winningSource=[WINNING_SOURCE]"
  },
  "ext": {
    "use_new_renderer": true
  }
}
"""

class DeserializationTest : StringSpec({

    val response = BidResponse.fromJson(testJson)

    "BidResponse fromJson deserializes the type field" {
        response.type shouldBe "native"
    }

    "BidResponse fromJson deserializes the auction_id field" {
        response.auction_id shouldBe "d07668d6-35ba-4870-a3cd-02b18fec1a12"
    }

    "BidResponse fromJson deserializes the bid_in_cents field" {
        response.bid_in_cents shouldBe 405
    }

    "BidResponse fromJson deserializes the bid_raw field" {
        response.bid_raw shouldBe 4.053723f
    }

    "BidResponse fromJson deserializes the content_type field" {
        response.content_type shouldBe "text/html; charset=utf-8"
    }

    "BidResponse fromJson deserializes the is_interstitial field" {
        response.is_interstitial shouldBe 1
    }

    "BidResponse fromJson deserializes the is_mraid field" {
        response.is_mraid shouldBe 1
    }

    "BidResponse fromJson deserializes the markup field" {
        response.markup shouldBe "test_markup"
    }

    "BidResponse fromJson deserializes the network field" {
        response.network shouldBe "test_network"
    }

    "BidResponse fromJson deserializes the placement_id field" {
        response.placement_id shouldBe "123456789"
    }

    "BidResponse fromJson deserializes the position field" {
        response.position shouldBe "test_position"
    }

    "BidResponse fromJson deserializes click_trackers" {
        response.click_trackers!! shouldContain "https://test.adsbynimbus.com/click_tracker/"
    }

    "BidResponse fromJson deserializes impression_trackers" {
        response.impression_trackers!! shouldContain "https://test.adsbynimbus.com/impression_tracker/"
    }

    "BidResponse fromJson deserializes the duration field" {
        response.duration shouldBe 15
    }

    "BidResponse fromJson deserializes the exp field" {
        response.duration shouldBe 15
    }

    "BidResponse fromJson deserializes win urls" {
        response.win_response shouldBe "https://test.adsbynimbus.com/win_response/"
    }

    "BidResponse fromJson deserializes use_new_renderer" {
        response.useNewRenderer shouldBe true
    }

    "BidResponse fromJson deserializes loss urls" {
        response.loss_response shouldStartWith "https://test.adsbynimbus.com/loss_response/"
        response.loss_response shouldContain "auctionPrice=[AUCTION_PRICE]"
        response.loss_response shouldContain "auctionMinToWin=[AUCTION_MIN_TO_WIN]"
        response.loss_response shouldContain "winningSource=[WINNING_SOURCE]"
    }
})
