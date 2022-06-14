package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import kotlin.jvm.JvmField

/**
 * This object describes an ad placement or impression being auctioned.
 *
 * A single [BidRequest] can include multiple Impression objects, a use case for which might be an
 * exchange that supports selling all ad positions on a given page. Each [Impression] object has a
 * required ID so that bids can reference them individually. The presence of [Banner], [Video], or
 * [Native], subordinate to the Imp object indicates the type of impression being offered. The
 * publisher can choose one such type which is the typical case or mix them at their discretion.
 * However, any given bid for the impression must conform to one of the offered types.
 *
 * [OpenRTB Section 3.2.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=12)
 *
 * @property banner A banner object; required if this impression is offered as a banner ad
 *                  opportunity or is used in the Nimbus hybrid auction.
 * @property video A video object; required if this impression is offered as a video ad opportunity
 *                 or is used in Nimbus hybrid auction.
 * @property native A native object;  required if this impression is offered as a native ad
 *                  opportunity or is used in a Nimbus hybrid auction.
 * @property instl  An integer flag marking this impression object as an interstitial.
 *                  1 = the ad is interstitial or full screen,
 *                  0 = not interstitial.
 * @property secure Flag to indicate if the impression requires secure HTTPS URL creative assets and
 *                  markup.
 *                  0 = non-secure
 *                  1 = secure
 * @property ext Placeholder for exchange-specific extensions to OpenRTB.
 */
@Serializable
public class Impression(
    @JvmField @SerialName("banner") public var banner: Banner? = null,
    @JvmField @SerialName("video") public var video: Video? = null,
    @JvmField @SerialName("native") public var native: Native? = null,
    @JvmField @SerialName("instl") public var instl: Byte = 0,
    @JvmField @SerialName("secure") public var secure: Byte = 1,
    @JvmField @SerialName("ext") public var ext: Extension? = null,
)

/** Type alias for the key value params provided by the APS SDK. */
public typealias ApsParams = Map<String, List<String>>

/** Extension for converting ApsParams to a serializable JsonObject. */
public inline val ApsParams.jsonObject: JsonObject
    get() = buildJsonObject {
        forEach { kv -> putJsonArray(kv.key) { kv.value.forEach { param -> add(param) } } }
    }

/** Required name of the placement that will be displayed on the Nimbus dashboard. */
public var Impression.position: String?
    get() = ext?.get("position")?.jsonPrimitive?.contentOrNull
    set(value) {
        ext = buildJsonObject {
            ext?.forEach { put(it.key, it.value) }
            put("position", value)
        }
    }

/** The list of key value pairs provided by a DTBRequest from the APS library. */
public var Impression.aps: List<ApsParams>
    get() = ext?.get("aps")?.jsonArray?.map { bids ->
        bids.jsonObject.mapValues { params ->
            params.value.jsonArray.map { value -> value.jsonPrimitive.content }
        }
    } ?: emptyList()
    set(value) {
        ext = buildJsonObject {
            ext?.forEach { put(it.key, it.value) }
            putJsonArray("aps") { value.map { it.jsonObject } }
        }
    }

/** The Facebook provided app identifier if including Audience Network demand. */
public var Impression.facebook_app_id: String?
    get() = ext?.get("facebook_app_id")?.jsonPrimitive?.contentOrNull
    set(value) {
        ext = buildJsonObject {
            ext?.forEach { put(it.key, it.value) }
            put("facebook_app_id", value)
        }
    }

/**
 * An optional ad type to force a test response for validating integrations.
 *
 * @see [Facebook Testing](https://developers.facebook.com/docs/audience-network/overview/in-house-mediation/server-to-server/testing)
 */
public var Impression.facebook_test_ad_type: String?
    get() = ext?.get("facebook_test_ad_type")?.jsonPrimitive?.contentOrNull
    set(value) {
        ext = buildJsonObject {
            ext?.forEach { put(it.key, it.value) }
            put("facebook_test_ad_type", value)
        }
    }
