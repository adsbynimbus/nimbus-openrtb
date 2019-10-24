package com.adsbynimbus.openrtb.impression;

/**
 * This object represents an allowed size (i.e., height and width combination) or Flex Ad parameters for a
 * banner impression. These are typically used in an array where multiple sizes are permitted. It is
 * recommended that either the w/h pair or the wratio/hratio/wmin set (i.e., for Flex Ads) be specified.
 */
public class Format {

    //Ad Format Names
    public static final int INTERSTITIAL_PORT = 0;
    public static final int INTERSTITIAL_LAND = 1;
    public static final int BANNER_300_50 = 2;
    public static final int BANNER_320_50 = 3;
    public static final int LETTERBOX = 4;
    public static final int HALF_SCREEN = 5;
    public static final int LEADERBOARD = 6;

    //Ad format parameter
    public static final String FORMAT = "format";

    public static final String WIDTH = "w";
    public static final String HEIGHT = "h";

    public int w;
    public int h;
}
