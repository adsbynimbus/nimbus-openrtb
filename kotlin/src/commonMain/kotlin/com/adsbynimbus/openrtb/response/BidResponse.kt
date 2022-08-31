package com.adsbynimbus.openrtb.response

import com.adsbynimbus.openrtb.request.BidRequest
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * A winning bid response from Nimbus
 *
 * @property type The type of creative returned. This maps to one of "static", "video", or "native"
 * @property auction_id This unique auction id. Represented as a GUID.
 * @property adomain An optional list of the advertising domains associated with this ad.
 * @property bid_in_cents This winning auction's bid in cents.
 * @property bid_raw This winning auction's precise winning bid.
 * @property content_type The content type of this creative. "text/html" for static or a mime type
 *                        for video ads
 * @property crid The creative ID of this ad if known
 * @property height The height of the creative if available. Will not be set for Video or Native ads
 * @property width The width of the creative if available. Will not be set for Video or Native ads
 * @property is_interstitial Set to 1 if the original request was for an interstitial ad
 * @property markup The markup returned by Nimbus. Will be in the format of html for static or xml
 *                  VAST for video
 * @property network The network that won this auction
 * @property placement_id The winning placement id if the winning bid maps to a line item
 * @property is_mraid Set to 1 if Nimbus has determined the creative returned requests MRAID in the
 *                    creative markup
 * @property position The position from the request for this ad.
 * @property trackers Contains additional tracking urls for measurement.
 * @property duration The duration in seconds or 0 if unknown or another ad type.
 */
@Serializable
public class BidResponse(
    @JvmField @SerialName("type") public val type: String,
    @JvmField @SerialName("auction_id") public val auction_id: String,
    @JvmField @SerialName("adomain") public val adomain: Array<String>? = null,
    @JvmField @SerialName("bid_in_cents") public val bid_in_cents: Int = 0,
    @JvmField @SerialName("bid_raw") public val bid_raw: Float = 0f,
    @JvmField @SerialName("content_type") public val content_type: String? = null,
    @JvmField @SerialName("crid") public val crid: String? = null,
    @JvmField @SerialName("height") public val height: Int = 0,
    @JvmField @SerialName("width") public val width: Int = 0,
    @JvmField @SerialName("is_interstitial") public val is_interstitial: Byte = 0,
    @JvmField @SerialName("markup") public val markup: String,
    @JvmField @SerialName("network") public val network: String = "",
    @JvmField @SerialName("placement_id") public val placement_id: String? = null,
    @JvmField @SerialName("is_mraid") public val is_mraid: Byte = 0,
    @JvmField @SerialName("position") public val position: String,
    @JvmField @SerialName("trackers") public val trackers: Map<String, Array<String>> = emptyMap(),
    @JvmField @SerialName("duration") public val duration: Int = 0,
) {

    /** Urls to fire a request to when an impression is registered */
    public val impression_trackers: Array<String>? by trackers
    /** Urls to fire a request to when a click is registered */
    public val click_trackers: Array<String>? by trackers

    public companion object {
        /** Decodes a BidResponse from a Json string using the built in serializer */
        @JvmStatic
        public fun fromJson(
            json: String,
            jsonSerializer: Json = BidRequest.lenientSerializer,
        ): BidResponse = jsonSerializer.decodeFromString(serializer(), json)

        /** Encodes a BidResponse to a Json string using the built in serializer */
        @JvmStatic
        public fun toJson(
            response: BidResponse,
            jsonSerializer: Json = BidRequest.lenientSerializer,
        ): String = jsonSerializer.encodeToString(serializer(), response)
    }
}
