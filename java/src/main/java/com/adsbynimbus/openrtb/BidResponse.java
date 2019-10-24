package com.adsbynimbus.openrtb;

/**
 * A winning bid from Nimbus
 */
public class BidResponse {

    public static final String TYPE = "type";
    public static final String AUCTION_ID = "auction_id";
    public static final String BID_IN_CENTS = "bid_in_cents";
    public static final String CONTENT_TYPE = "content_type";
    public static final String HEIGHT = "height";
    public static final String WIDTH = "width";
    public static final String IS_INTERSTITIAL = "is_interstitial";
    public static final String MARKUP = "markup";
    public static final String NETWORK = "network";
    public static final String TRACKERS = "trackers";
    public static final String PLACEMENT_ID = "placement_id";
    public static final String IS_MRAID = "is_mraid";

    public String type;
    public String auction_id;
    public int bid_in_cents;
    public String content_type;
    public int height;
    public int width;
    public boolean is_interstitial;
    public String markup;
    public String network;
    public Trackers trackers;
    public String placement_id;
    public boolean is_mraid;

    /**
     * Tracking urls
     */
    public static class Trackers {

        public static final String IMPRESSION = "impression_trackers";

        public String[] impression_trackers;
    }
}
