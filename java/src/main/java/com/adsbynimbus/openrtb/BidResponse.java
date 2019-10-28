package com.adsbynimbus.openrtb;

/**
 * A winning bid from Nimbus
 */
public class BidResponse {

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

        public String[] impression_trackers;
    }
}
