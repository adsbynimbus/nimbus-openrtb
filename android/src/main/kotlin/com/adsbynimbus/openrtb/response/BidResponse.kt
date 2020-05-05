package com.adsbynimbus.openrtb.response

/**
 * A winning bid response from Nimbus
 */
class BidResponse {
    /**
     * The type of creative returned. ["static", "video", "facebook"]
     */
    var type: String? = null

    /**
     * This unique auction id. Represented as a GUID
     */
    var auction_id: String? = null

    /**
     * This winning auction's bid in cents
     */
    var bid_in_cents = 0

    /**
     * This winning auction's precise winning bid
     */
    var bid_raw = 0.0

    /**
     * The content type of this creative. "text/html" for static or a mime type for video ads
     */
    var content_type: String? = null

    /**
     * The height of the creative if available. Will not be set for Video or Facebook ads
     */
    var height = 0

    /**
     * The width of the creative if available. Will not be set for Video or Facebook ads
     */
    var width = 0

    /**
     * Set to 1 if the original request was for an interstitial dd
     */
    var is_interstitial = 0

    /**
     * The markup returned by Nimbus. Will be in the format of html for static or xml VAST for video
     */
    var markup: String? = null

    /**
     * The network that won this auction
     */
    var network: String? = null

    /**
     * An [Trackers] object containing additional urls for measurement
     */
    var trackers: Trackers? = null

    /**
     * The winning placement id if the creative returned is Facebook or maps to a line item
     */
    var placement_id: String? = null

    /**
     * Set to 1 if Nimbus has determined the creative returned requests MRAID in the top level markup
     */
    var is_mraid = 0

    /**
     * Additional tracking urls
     */
    class Trackers {
        /**
         * A list of urls to fire a request to when an impression is registered
         */
        var impression_trackers: Array<String>? = null

        /**
         * A list of urls to fire a request to when a click is registered
         */
        var click_trackers: Array<String>? = null
    }
}