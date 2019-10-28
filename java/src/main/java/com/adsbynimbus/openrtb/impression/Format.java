package com.adsbynimbus.openrtb.impression;

/**
 * This object represents an allowed size (i.e., height and width combination) or Flex Ad parameters for a
 * banner impression. These are typically used in an array where multiple sizes are permitted. It is
 * recommended that either the w/h pair or the wratio/hratio/wmin set (i.e., for Flex Ads) be specified.
 */
public class Format {

    //Ad Format Names
    public static final Format INTERSTITIAL_PORT = new Format(320, 480);
    public static final Format INTERSTITIAL_LAND = new Format(480, 320);
    public static final Format BANNER_300_50 = new Format(300, 50);
    public static final Format BANNER_320_50 = new Format(320,50);
    public static final Format LETTERBOX = new Format(300, 250);
    public static final Format HALF_SCREEN = new Format(300, 600);
    public static final Format LEADERBOARD = new Format(728, 90);

    public final int w;
    public final int h;

    public Format(int width, int height) {
        this.w = width;
        this.h = height;
    }
}
