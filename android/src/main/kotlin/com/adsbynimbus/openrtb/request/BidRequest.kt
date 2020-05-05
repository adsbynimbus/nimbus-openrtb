package com.adsbynimbus.openrtb.request

/**
 * The top-level bid request object contains a globally unique bid request or auction ID. This id attribute is
 * required as is at least one impression object (Section 3.2.4). Other attributes in this top-level object
 * establish rules and restrictions that apply to all impressions being offered.
 * There are also several subordinate objects that provide detailed data to potential buyers. Among these
 * are the Site and App objects, which describe the type of published media in which the impression(s)
 * appear. These objects are highly recommended, but only one applies to a given bid request depending
 * on whether the media is browser-based web content or a non-browser application, respectively.
 *
 * @see [OpenRTB Section 3.2.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=15)
 */
class BidRequest {
    /**
     * Array of impression objects representing the impressions offered. Only 1 impression object is supported.
     */
    @JvmField
    var imp: Array<Impression>? = null

    /**
     * Details about the publisher’s app (i.e., non-browser applications).
     */
    @JvmField
    var app: App? = null

    /**
     * Details about the user’s device to which the impression will be delivered.
     */
    @JvmField
    var device: Device? = null

    /**
     * This is not part of the spec, adding this here for convenience allows height and width to be passed without the
     * video/banner object to backwards support the GET
     */
    @JvmField
    var format: Format? = null

    /**
     * Details about the human user of the device; the advertising audience.
     */
    @JvmField
    var user: User? = null

    /**
     * Indicator of test mode in which auctions are not billable, where 0 = live mode, 1 = test mode
     */
    @JvmField
    var test: Int? = null

    /**
     * Maximum time in milliseconds the exchange allows for bids to be received including Internet latency to avoid
     * timeout. This value supersedes any a priori guidance from the exchange.
     *
     * <br></br>
     * If this value is omitted Nimbus will default to 500
     */
    @JvmField
    var tmax: Int? = null

    /**
     * A Regs object that specifies any industry, legal, or governmental regulations in force for this request.
     */
    @JvmField
    var regs: Regs? = null

    /**
     * A Source object that provides data about the inventory source and which entity makes the final decision.
     */
    @JvmField
    var source: Source? = null

    /**
     * Block list of advertisers by their domains (e.g., "ford.com").
     */
    @JvmField
    var badv: Array<String>? = null

    /**
     * Placeholder for exchange-specific extensions to OpenRTB.
     */
    @JvmField
    var ext: Extension? = null

    /**
     * BidRequest extension object unique to Nimbus
     */
    class Extension {
        /**
         * The publisher specific api key used to communicate with Nimbus
         */
        @JvmField
        var api_key: String? = null

        /**
         * Any unique string value to identify the session. Defaults to [UUID.randomUUID] when using the
         * Nimbus SDK
         */
        @JvmField
        var session_id: String? = null
    }

    /**
     * Builder for constructing a BidRequest object
     *
     * @see BidRequest
     */
    interface Builder {
        /**
         * Sets the impression for this request.
         *
         * @param impression an impression object to set or replace the value currently on this request. Will create the
         * impression array if it does not exist and replace the current value in imp[0] if one does.
         * @return this builder instance
         */
        fun impression(impression: Impression?): Builder?

        /**
         * Sets the app details for this request.
         *
         * @param app an app object to set or replace the value currently on this request.
         * @return this builder instance
         */
        fun app(app: App?): Builder?

        /**
         * Sets the device details of this request.
         *
         * @param device a device object to set or replace the value currently on this request.
         * @return this builder instance
         */
        fun device(device: Device?): Builder?

        /**
         * Sets the device size of this request in absolute pixels.
         *
         * @param width width of the device in pixels
         * @param height height of the device in pixels
         * @return this builder instance
         */
        fun deviceSize(width: Int, height: Int): Builder?

        /**
         * Set the user details of this request.
         *
         * @param user a user object to set or replace the value currently on this request
         * @return this builder instance
         */
        fun user(user: User?): Builder?

        /**
         * Marks this request as a test.
         *
         * @param enabled true if test mode is enabled, default is false
         * @return [Builder]
         */
        fun test(enabled: Boolean): Builder?

        /**
         * Sets the timeout of this request in ms.
         *
         * <br></br>
         * If this value is omitted Nimbus will default to 500
         *
         * @param timeout set or replace the timeout value on this request.
         * @return this builder instance
         */
        fun timeout(timeout: Int): Builder?

        /**
         * Sets the regs object of this request.
         *
         * @param regs a regs object to set or replace the value currently on this request
         * @return this builder instance
         */
        fun regs(regs: Regs?): Builder?

        /**
         * Sets the source object of this request.
         *
         * @param source a source object to set or replace the value currently on this request
         * @return this builder instance
         */
        fun source(source: Source?): Builder?

        /**
         * Sets a list of blocked advertisers by domains.
         *
         * @param domains a list of domain names to block
         * @return this builder instance
         */
        fun blockedDomains(vararg domains: String?): Builder?

        /**
         * Sets the Nimbus API key.
         *
         * @param apiKey the publisher specific api key provided by Nimbus
         * @return this builder instance
         */
        fun apiKey(apiKey: String?): Builder?

        /**
         * Sets the Nimbus session id.
         *
         * @param sessionId any unique identifier for this session. Recommend using [UUID.randomUUID]
         * @return this builder instance
         */
        fun sessionId(sessionId: String?): Builder?
    }
}