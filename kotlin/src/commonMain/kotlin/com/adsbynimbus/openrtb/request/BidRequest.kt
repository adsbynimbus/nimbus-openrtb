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
    @JvmField var imp: Array<Impression>? = null,
    @JvmField var app: App? = null,
    @JvmField var device: Device? = null,
    @JvmField var format: Format? = null,
    @JvmField var user: User? = null,
    @JvmField var test: Int? = null,
    @JvmField var tmax: Int? = null,
    @JvmField var regs: Regs? = null,
    @JvmField var source: Source? = null,
    @JvmField var badv: Array<String>? = null,
    @JvmField var ext: Extension? = null
) {

    /**
     * BidRequest extension object unique to Nimbus
     *
     * @property session_id Any unique string value to identify the session. Defaults to a random
     *                      UUID when using the Nimbus SDK
     */
    open class Extension(
        @JvmField var session_id: String? = null
    )


    companion object {

        /**
         * Required header for all requests to Nimbus defining the OpenRTB version
         */
        const val HEADER_OPEN_RTB = "X-Openrtb-Version"

        /**
         * The current supported OpenRTB version by this request object
         */
        const val OPEN_RTB_VERSION = "2.5"
    }

    /**
     * Builder for constructing a BidRequest object
     *
     * @see [BidRequest]
     */
    interface Builder {
        /**
         * Sets the impression for this request.
         *
         * @param impression an impression object to set or replace the value currently on this request. Will create the
         * impression array if it does not exist and replace the current value at index 0 if one does.
         * @return this builder instance
         */
        fun impression(impression: Impression?): Builder

        /**
         * Sets the app details for this request.
         *
         * @param app an app object to set or replace the value currently on this request.
         * @return this builder instance
         */
        fun app(app: App?): Builder

        /**
         * Sets the device details of this request.
         *
         * @param device a device object to set or replace the value currently on this request.
         * @return this builder instance
         */
        fun device(device: Device?): Builder

        /**
         * Sets the device size of this request in absolute pixels.
         *
         * @param width width of the device in pixels
         * @param height height of the device in pixels
         * @return this builder instance
         */
        fun deviceSize(width: Int, height: Int): Builder

        /**
         * Set the user details of this request.
         *
         * @param user a user object to set or replace the value currently on this request
         * @return this builder instance
         */
        fun user(user: User?): Builder

        /**
         * Marks this request as a test.
         *
         * @param enabled true if test mode is enabled, default is false
         * @return [Builder]
         */
        fun test(enabled: Boolean): Builder

        /**
         * Sets the timeout of this request in ms.
         *
         * If this value is omitted Nimbus will default to 500
         *
         * @param timeout set or replace the timeout value on this request.
         * @return this builder instance
         */
        fun timeout(timeout: Int): Builder

        /**
         * Sets the regs object of this request.
         *
         * @param regs a regs object to set or replace the value currently on this request
         * @return this builder instance
         */
        fun regs(regs: Regs?): Builder

        /**
         * Sets the source object of this request.
         *
         * @param source a source object to set or replace the value currently on this request
         * @return this builder instance
         */
        fun source(source: Source?): Builder

        /**
         * Sets a list of blocked advertisers by domains.
         *
         * @param domains a list of domain names to block
         * @return this builder instance
         */
        fun blockedDomains(vararg domains: String?): Builder

        /**
         * Sets the Nimbus session id.
         *
         * @param sessionId any unique identifier for this session. Recommend using a random UUID
         * @return this builder instance
         */
        fun sessionId(sessionId: String?): Builder
    }
}