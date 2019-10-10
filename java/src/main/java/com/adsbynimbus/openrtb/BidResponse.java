package com.adsbynimbus.openrtb;

/**
 * A winning bid from Nimbus
 */
public interface BidResponse {

    String TYPE = "type";
    String AUCTION_ID = "auction_id";
    String BID_IN_CENTS = "bid_in_cents";
    String CONTENT_TYPE = "content_type";
    String HEIGHT = "height";
    String WIDTH = "width";
    String IS_INTERSTITIAL = "is_interstitial";
    String MARKUP = "markup";
    String NETWORK = "network";
    String TRACKERS = "trackers";
    String PLACEMENT_ID = "placement_id";
    String IS_MRAID = "is_mraid";

    /**
     * Tracking url keys
     */
    interface Trackers {

        String IMPRESSION = "impression_trackers";
    }

    /**
     * Definition of {@link BidResponse} with all public mutable fields
     */
    class MutableBidResponse implements BidResponse {

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
    }

    /**
     * Definition of {@link Trackers} with all public mutable fields
     */
    class MutableTrackers implements Trackers {
        public String[] impression_trackers;
    }
}
