package com.adsbynimbus.openrtb.impression;

/**
 * This object represents an allowed size (i.e., height and width combination) or Flex Ad parameters for a
 * banner impression. These are typically used in an array where multiple sizes are permitted. It is
 * recommended that either the w/h pair or the wratio/hratio/wmin set (i.e., for Flex Ads) be specified.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=18">OpenRTB Section 3.2.10</a>
 */
public class Format {

    /**
     * Named {@link Format} for a portrait Interstitial [w: 320, h: 480]
     */
    public static final Format INTERSTITIAL_PORT = new Format(320, 480);

    /**
     * Named {@link Format} for a landscape Interstitial [w: 480, h: 320]
     */
    public static final Format INTERSTITIAL_LAND = new Format(480, 320);

    /**
     * Named {@link Format} for a 300 x 50 banner. Prefer {@link Format#BANNER_320_50} over this. [w: 300, h: 50]
     */
    public static final Format BANNER_300_50 = new Format(300, 50);

    /**
     * Named {@link Format} for a 330 x 50 banner. Prefer this over {@link Format#BANNER_300_50}. [w: 320, h: 50]
     */
    public static final Format BANNER_320_50 = new Format(320,50);

    /**
     * Named {@link Format} for a 300 x 250 banner. [w: 300, h: 250]
     */
    public static final Format LETTERBOX = new Format(300, 250);

    /**
     * Named {@link Format} for a 300 x 600 banner. [w: 300, h: 600]
     */
    public static final Format HALF_SCREEN = new Format(300, 600);

    /**
     * Named {@link Format} for a 728 x 90 banner. [w: 728, h: 90]
     */
    public static final Format LEADERBOARD = new Format(728, 90);

    /**
     * Width in device independent pixels (DIPS).
     */
    public final int w;

    /**
     * Height in device independent pixels (DIPS).
     */
    public final int h;

    /**
     * Constructor
     *
     * @param width width in device independent pixels (DIPS).
     * @param height height in device independent pixels (DIPS).
     */
    public Format(int width, int height) {
        this.w = width;
        this.h = height;
    }
}
