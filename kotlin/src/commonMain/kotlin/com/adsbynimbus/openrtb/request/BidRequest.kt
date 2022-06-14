package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Type alias for the ext field present on all OpenRTB objects.
 *
 * Extensions defined by Nimbus are implemented as extension properties on the [JsonObject].
 */
public typealias Extension = JsonObject

/**
 * The top-level bid request object contains a globally unique bid request or auction ID.
 *
 * This id attribute is required as is at least one impression object (Section 3.2.4). Other
 * attributes in this top-level object establish rules and restrictions that apply to all
 * impressions being offered. There are also several subordinate objects that provide detailed data
 * to potential buyers. Among these are the Site and App objects, which describe the type of
 * published media in which the impression(s) appear. These objects are highly recommended, but only
 * one applies to a given bid request depending on whether the media is browser-based web content or
 * a non-browser application, respectively.
 *
 * [OpenRTB Section 3.2.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=15)
 *
 * @property imp Array of impression objects representing the impressions offered.
 *               Only 1 impression object is supported.
 *  @property app Details about the publisher’s app (i.e., non-browser applications).
 * @property device Details about the user’s device to which the impression will be delivered.
 * @property format A format object representing the width and height of the device.
 *                  This is not part of the spec, adding this here for convenience allows height and
 *                  width to be passed without the video/banner object to backwards support the GET
 * @property user Details about the human user of the device; the advertising audience.
 * @property test Indicator of test mode in which auctions are not billable (0: live, 1: test)
 * @property tmax Maximum time in milliseconds the exchange allows for bids to be received including
 *                Internet latency to avoid timeout.
 *                This value supersedes any a priori guidance from the exchange. If this value is
 *                omitted Nimbus will default to 500.
 * @property badv Block list of advertisers by their domains (e.g., "ford.com").
 * @property source A Source object that provides data about the inventory source and which entity
 *                  makes the final decision.
 * @property regs A Regs object that specifies any industry, legal, or governmental regulations in
 *                force for this request.
 * @property ext Placeholder for exchange-specific extensions to OpenRTB.
 */
@Serializable
public class BidRequest(
    @JvmField @SerialName("imp") public var imp: Array<Impression> = emptyArray(),
    @JvmField @SerialName("app") public var app: App? = null,
    @JvmField @SerialName("device") public var device: Device? = null,
    @JvmField @SerialName("format") public var format: Format = Format(0, 0),
    @JvmField @SerialName("user") public var user: User? = null,
    @JvmField @SerialName("test") public var test: Byte = 0,
    @JvmField @SerialName("tmax") public var tmax: Int = 500,
    @JvmField @SerialName("badv") public var badv: Array<String>? = null,
    @JvmField @SerialName("source") public var source: Source? = null,
    @JvmField @SerialName("regs") public var regs: Regs? = null,
    @JvmField @SerialName("ext") public var ext: Extension? = null,
) {
    public companion object {
        /** Required header for all requests to Nimbus defining the OpenRTB version */
        public const val OPENRTB_HEADER: String = "x-openrtb-version"

        /** The current supported OpenRTB version by this request object */
        public const val OPENRTB_VERSION: String = "2.5"

        @JvmField
        public val lenientSerializer: Json = Json {
            coerceInputValues = true
            explicitNulls = false
            ignoreUnknownKeys = true
        }

        /** Encodes a BidRequest to a Json string using the built in serializer */
        @JvmStatic @JvmOverloads
        public fun BidRequest.toJson(jsonSerializer: Json = lenientSerializer): String =
            jsonSerializer.encodeToString(serializer(), this)

        /** Decodes a BidRequest from a Json string using the built in serializer */
        @JvmStatic @JvmOverloads
        public fun fromJson(json: String, jsonSerializer: Json = lenientSerializer): BidRequest =
            jsonSerializer.decodeFromString(serializer(), json)
    }
}

/** The API key used to authenticate with Nimbus. */
public var BidRequest.api_key: String?
    get() = ext?.get("api_key")?.jsonPrimitive?.contentOrNull
    set(value) {
        ext = buildJsonObject {
            ext?.forEach { put(it.key, it.value) }
            put("api_key", value)
        }
    }

/** Any unique string value to identify the session; when used in the Nimbus SDK will be a UUID */
public var BidRequest.session_id: String?
    get() = ext?.get("session_id")?.jsonPrimitive?.contentOrNull
    set(value) {
        ext = buildJsonObject {
            ext?.forEach { put(it.key, it.value) }
            put("session_id", value)
        }
    }


