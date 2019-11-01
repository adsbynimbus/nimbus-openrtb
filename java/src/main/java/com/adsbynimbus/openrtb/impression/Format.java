package com.adsbynimbus.openrtb.impression;

/**
 * This object represents an allowed size (i.e., height and width combination)
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=23">OpenRTB Section 3.2.10</a>
 */
public class Format {

    /**
     * Named format for a 320 x 480 portrait interstitial
     */
    public static final Format INTERSTITIAL_PORT = new Format(320, 480);

    /**
     * Named format for a 480 x 320 landscape interstitial
     */
    public static final Format INTERSTITIAL_LAND = new Format(480, 320);

    /**
     * Named format for a 300 x 50 banner. Prefer {@link Format#BANNER_320_50} over this.
     */
    public static final Format BANNER_300_50 = new Format(300, 50);

    /**
     * Named format for a 330 x 50 banner. Prefer this over {@link Format#BANNER_300_50}.
     */
    public static final Format BANNER_320_50 = new Format(320,50);

    /**
     * Named format for a 300 x 250 banner.
     */
    public static final Format LETTERBOX = new Format(300, 250);

    /**
     * Named format for a 300 x 600 banner.
     */
    public static final Format HALF_SCREEN = new Format(300, 600);

    /**
     * Named format for a 728 x 90 banner.
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
