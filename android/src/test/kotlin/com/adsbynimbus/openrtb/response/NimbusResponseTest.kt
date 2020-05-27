package com.adsbynimbus.openrtb.response

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertTrue

object NimbusResponseTest : Spek({
    describe("NimbusResponse") {
        val testJsonReader = javaClass.classLoader?.getResourceAsStream("nimbus_response.json")?.bufferedReader()
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

        it("when deserialized has the correct values") {
            val response = gson.fromJson(testJsonReader, NimbusResponse::class.java)
            assertEquals(expected = "native", actual = response.type,
                    message = "response.type is not native")
            assertEquals(expected = "d07668d6-35ba-4870-a3cd-02b18fec1a12", actual = response.auction_id,
                    message = "response.auction_id is not d07668d6-35ba-4870-a3cd-02b18fec1a12")
            assertEquals(expected = 405, actual = response.bid_in_cents,
                    message = "response.bid_in_cents is not 405")
            assertEquals(expected = 4.0537236296054, actual = response.bid_raw,
                    message = "response.bid_raw is not 4.0537236296054")
            assertEquals(expected = "text/html; charset=utf-8", actual = response.content_type,
                    message = "response.content_type is not text/html; charset=utf-8")
            assertEquals(expected = 1, actual = response.is_interstitial,
                    message = "response.is_interstitial is not 1")
            assertEquals(expected = 0, actual = response.is_mraid,
                    message = "response.is_mraid is not 0")
            assertEquals(expected = "test_markup", actual = response.markup,
                    message = "response.markup is not test_markup")
            assertEquals(expected = "test_network", actual = response.network,
                    message = "response.network is not test_network")
            assertTrue(actual = response.trackers?.
                        impression_trackers?.contains("https://test.adsbynimbus.com/impression_tracker/")!!,
                    message = "impression_trackers does not contain https://test.adsbynimbus.com/impression_tracker/")
            assertTrue(actual = response.trackers?.
                        click_trackers?.contains("https://test.adsbynimbus.com/click_tracker/")!!,
                    message = "click_trackers does not contain https://test.adsbynimbus.com/click_tracker/")
            assertEquals(expected = "123456789", actual = response.placement_id,
                    message = "response.placement_id is not 123456789")
        }
    }
})