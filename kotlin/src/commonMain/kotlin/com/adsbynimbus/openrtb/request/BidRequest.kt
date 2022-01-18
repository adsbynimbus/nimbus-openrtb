@file:JvmName("OpenRTB")

package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

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
 * @property device Details about the user’s device to which the impression will be delivered.
 * @property format A [Format] object representing the width and height of the device.
 *                  This is not part of the spec, adding this here for convenience allows height and
 *                  width to be passed without the video/banner object to backwards support the GET
 * @property user Details about the human user of the device; the advertising audience.
 * @property app Details about the publisher’s app (i.e., non-browser applications).
 * @property test Indicator of test mode in which auctions are not billable (0: live, 1: test)
 * @property tmax Maximum time in milliseconds the exchange allows for bids to be received including
 *                Internet latency to avoid timeout.
 *                This value supersedes any a priori guidance from the exchange. If this value is
 *                omitted Nimbus will default to 500.
 * @property regs A Regs object that specifies any industry, legal, or governmental regulations in
 *                force for this request.
 * @property source A Source object that provides data about the inventory source and which entity
 *                  makes the final decision.
 * @property badv   Block list of advertisers by their domains (e.g., "ford.com").
 * @property ext Placeholder for exchange-specific extensions to OpenRTB.
 */
@Serializable
public class BidRequest(
    @JvmField @SerialName("imp") public val imp: Array<Impression>,
    @JvmField @SerialName("device") public val device: Device,
    @JvmField @SerialName("format") public val format: Format = Format(device.w, device.h),
    @JvmField @SerialName("user") public val user: User? = null,
    @JvmField @SerialName("app") public val app: App? = null,
    @JvmField @SerialName("test") public val test: Int = 0,
    @JvmField @SerialName("tmax") public val tmax: Int = 500,
    @JvmField @SerialName("regs") public val regs: Regs? = null,
    @JvmField @SerialName("source") public val source: Source? = null,
    @JvmField @SerialName("badv") public val badv: Array<String> = emptyArray(),
    @JvmField @SerialName("ext") public val ext: Extension,
) {

    /**
     * BidRequest extension object unique to Nimbus
     *
     * @property session_id Any unique string value to identify the session. Defaults to a random
     *                      UUID when using the Nimbus SDK
     */
    @Serializable
    public class Extension(
        @JvmField @SerialName("session_id") public val session_id: String,
    )
}

/**
 * Required header for all requests to Nimbus defining the OpenRTB version
 */
public const val VERSION_HEADER: String = "X-Openrtb-Version"

/**
 * The current supported OpenRTB version by this request object
 */
public const val VERSION: String = "2.5"
