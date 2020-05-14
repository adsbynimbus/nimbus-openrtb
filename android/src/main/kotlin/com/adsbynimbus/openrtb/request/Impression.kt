package com.adsbynimbus.openrtb.request

/**
 * This object describes an ad placement or impression being auctioned.
 *
 * A single [BidRequest] can include multiple Impression objects, a use case for which might be an exchange that supports selling all ad positions
 * on a given page. Each [Impression] object has a required ID so that bids can reference them individually.
 * The presence of [Banner] (Section 3.2.6), [Video] (Section 3.2.7), subordinate to the Imp object
 * indicates the type of impression being offered. The publisher can choose one such type which is the typical case or
 * mix them at their discretion. However, any given bid for the impression must conform to one of the offered types.
 *
 * [OpenRTB Section 3.2.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=12)
 */
open class Impression {
    /**
     * A unique identifier for this impression within the context of the bid request (typically, starts with 1
     * and increments). This field is optional as only 1 impression object is currently supported by Nimbus.
     */
    @JvmField
    var id: String? = null

    /**
     * A banner object; required if this impression is offered as a banner ad opportunity or is used in the Nimbus
     * hybrid auction.
     */
    @JvmField
    var banner: Banner? = null

    /**
     * A video object; required if this impression is offered as a video ad opportunity or is used in Nimbus
     * hybrid auction.
     */
    @JvmField
    var video: Video? = null

    /**
     * A native object;  required if this impression is offered as a native ad opportunity or is used in a Nimbus
     * hybrid auction.
     *
     * This field is not exposed as a JvmField due to a keyword name clash when writing in Java
     */
    var native: Native? = null

    /**
     * An integer flag marking this impression object as an interstitial.
     *
     * * 1 = the ad is interstitial or full screen,
     * * 0 = not interstitial.
     *
     * If this value is omitted Nimbus will default to 0.
     */
    @JvmField
    var instl: Int? = null

    /**
     * Minimum bid for this impression expressed in CPM.
     *
     * If this value is omitted Nimbus defaults to 1.0.
     */
    @JvmField
    var bidfloor: Float? = null

    /**
     * Flag to indicate if the impression requires secure HTTPS URL creative assets and markup.
     *
     * * 0 = non-secure
     * * 1 = secure
     *
     * If this value is omitted Nimbus defaults to 1
     */
    @JvmField
    var secure: Int? = null

    /**
     * Placeholder for exchange-specific extensions to OpenRTB
     *
     * @see [Extension]
     */
    @JvmField
    var ext: Extension? = null

    /**
     * Impression extension unique to Nimbus
     *
     * @see [Impression]
     */
    open class Extension {
        /**
         * Required string identifying the name of the placement that will be displayed on the Nimbus dashboard.
         */
        @JvmField
        var position: String? = null

        /**
         * The identifier for this app provided by Facebook. Required if including Facebook demand in this request.
         */
        @JvmField
        var facebook_app_id: String? = null

        /**
         * The list of key value pairs provided by a DTBRequest from the APS library.
         */
        @JvmField
        var aps: List<*>? = null
    }

    /**
     * Builder for constructing an Impression object
     *
     * @see [Impression]
     */
    interface Builder {
        /**
         * Sets the id of the impression
         *
         * @param id an optional identifier
         * @return this builder instance
         * @see [Impression.id]
         */
        fun id(id: String?): Builder

        /**
         * Includes a banner in the auction for this impression
         *
         * @param banner a configured banner object
         * @return this builder instance
         * @see [Impression.banner]
         */
        fun banner(banner: Banner?): Builder

        /**
         * Includes a video in the auction for this impression
         *
         * @param video a configured video object
         * @return this builder instance
         * @see [Impression.video]
         */
        fun video(video: Video?): Builder

        /**
         * Sets the bid floor of this impression.
         *
         * If this value is omitted Nimbus will default to 1.0
         *
         * @param bidFloor bid floor represented in CPM
         * @return this builder instance
         * @see [Impression.bidfloor]
         */
        fun bidFloor(bidFloor: Float): Builder

        /**
         * Sets to true if this placement is an interstitial
         *
         * @param instl true if this placement is an interstitial
         * @return this builder instance
         * @see [Impression.instl]
         */
        fun interstitial(instl: Boolean): Builder

        /**
         * Set to true if this impression must be served over HTTPS, false to allow HTTP and HTTPS.
         *
         * This call is optional and Nimbus will default to only serving over HTTPS
         *
         * @param secure defaults to true signalling impression must be served over HTTPS. Set to false to allow HTTP
         * and HTTPS.
         * @return this builder instance
         * @see [Impression.secure]
         */
        fun secure(secure: Boolean): Builder

        /**
         * Sets the Facebook App id of this impression
         *
         * @param facebookAppId unique app identifier provided by Facebook
         * @return this builder instance
         * @see [Extension.facebook_app_id]
         */
        fun facebookAppId(facebookAppId: String?): Builder

        /**
         * Sets the APS params for this impression
         *
         * @param apsParams a list of key value pair maps from the APS sdk
         * @return this builder instance
         * @see [Extension.aps]
         */
        fun apsParams(apsParams: List<*>?): Builder
    }
}