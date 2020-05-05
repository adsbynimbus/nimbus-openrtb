package com.adsbynimbus.openrtb.response

/**
 * A winning bid response from Nimbus
 */
open class NimbusResponse {
    
    /**
     * The type of creative returned.
     *
     * This maps to one of "static", "video", or "native"
     */
    @JvmField
    var type: String? = null

    /**
     * This unique auction id. Represented as a GUID
     */
    @JvmField
    var auction_id: String? = null

    /**
     * This winning auction's bid in cents
     */
    @JvmField
    var bid_in_cents = 0

    /**
     * This winning auction's precise winning bid
     */
    @JvmField
    var bid_raw = 0.0

    /**
     * The content type of this creative.
     *
     * "text/html" for static or a mime type for video ads
     */
    @JvmField
    var content_type: String? = null

    /**
     * The height of the creative if available. Will not be set for Video or Facebook ads
     */
    @JvmField
    var height = 0

    /**
     * The width of the creative if available. Will not be set for Video or Facebook ads
     */
    @JvmField
    var width = 0

    /**
     * Set to 1 if the original request was for an interstitial dd
     */
    @JvmField
    var is_interstitial = 0

    /**
     * The markup returned by Nimbus. Will be in the format of html for static or xml VAST for video
     */
    @JvmField
    var markup: String? = null

    /**
     * The network that won this auction
     */
    @JvmField
    var network: String? = null

    /**
     * An [Trackers] object containing additional urls for measurement
     */
    @JvmField
    var trackers: Trackers? = null

    /**
     * The winning placement id if the creative returned is Facebook or maps to a line item
     */
    @JvmField
    var placement_id: String? = null

    /**
     * Set to 1 if Nimbus has determined the creative returned requests MRAID in the top level markup
     */
    @JvmField
    var is_mraid = 0

    /**
     * Additional tracking urls
     */
    class Trackers {
        /**
         * A list of urls to fire a request to when an impression is registered
         */
        @JvmField
        var impression_trackers: Array<String>? = null

        /**
         * A list of urls to fire a request to when a click is registered
         */
        @JvmField
        var click_trackers: Array<String>? = null
    }
}