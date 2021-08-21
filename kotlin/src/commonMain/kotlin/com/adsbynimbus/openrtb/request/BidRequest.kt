package com.adsbynimbus.openrtb.request

import kotlin.jvm.JvmField

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
 * @property app Details about the publisher’s app (i.e., non-browser applications).
 * @property device Details about the user’s device to which the impression will be delivered.
 * @property format A [Format] object representing the width and height of the device.
 *                  This is not part of the spec, adding this here for convenience allows height and
 *                  width to be passed without the video/banner object to backwards support the GET
 * @property user Details about the human user of the device; the advertising audience.
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
class BidRequest(
    @JvmField val imp: Array<Impression>,
    @JvmField val app: App,
    @JvmField val device: Device,
    @JvmField val format: Format,
    @JvmField val user: User? = null,
    @JvmField val test: Int = 0,
    @JvmField val tmax: Int = 500,
    @JvmField val regs: Regs? = null,
    @JvmField val source: Source? = null,
    @JvmField val badv: Array<String> = emptyArray(),
    @JvmField val ext: Extension? = null
) {

    /**
     * BidRequest extension object unique to Nimbus
     *
     * @property session_id Any unique string value to identify the session. Defaults to a random
     *                      UUID when using the Nimbus SDK
     */
    open class Extension(
        @JvmField val session_id: String,
    )
}

/**
 * Required header for all requests to Nimbus defining the OpenRTB version
 */
const val HEADER_OPEN_RTB = "X-Openrtb-Version"

/**
 * The current supported OpenRTB version by this request object
 */
const val OPEN_RTB_VERSION = "2.5"