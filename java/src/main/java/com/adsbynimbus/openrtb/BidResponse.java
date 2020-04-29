package com.adsbynimbus.openrtb;

import org.jetbrains.annotations.Nullable;

/**
 * A winning bid response from Nimbus
 */
public class BidResponse {

    /**
     * The type of creative returned. ["static", "video", "facebook"]
     */
    public String type;

    /**
     * This unique auction id. Represented as a GUID
     */
    public String auction_id;

    /**
     * This winning auction's bid in cents
     */
    public int bid_in_cents;

    /**
     * This winning auction's precise winning bid
     */
    public double bid_raw;

    /**
     * The content type of this creative. "text/html" for static or a mime type for video ads
     */
    @Nullable
    public String content_type;

    /**
     * The height of the creative if available. Will not be set for Video or Facebook ads
     */
    public int height;

    /**
     * The width of the creative if available. Will not be set for Video or Facebook ads
     */
    public int width;

    /**
     * Set to 1 if the original request was for an interstitial dd
     */
    public int is_interstitial;

    /**
     * The markup returned by Nimbus. Will be in the format of html for static or xml VAST for video
     */
    public String markup;

    /**
     * The network that won this auction
     */
    public String network;

    /**
     * An {@link Trackers} object containing additional urls for measurement
     */
    @Nullable
    public Trackers trackers;

    /**
     * The winning placement id if the creative returned is Facebook or maps to a line item
     */
    @Nullable
    public String placement_id;

    /**
     * Set to 1 if Nimbus has determined the creative returned requests MRAID in the top level markup
     */
    public int is_mraid;

    /**
     * Additional tracking urls
     */
    public static class Trackers {

        /**
         * A list of urls to fire a request to when an impression is registered
         */
        @Nullable
        public String[] impression_trackers;

        /**
         * A list of urls to fire a request to when a click is registered
         */
        @Nullable
        public String[] click_trackers;
    }
}
