package com.adsbynimbus.openrtb.impression;

/**
 * Defines constants shared between children of the {@link Impression} object
 */
public abstract class Creative {

    public static final String BID_FLOOR = "bidfloor"; //float
    public static final String POSITION = "pos"; // int
    public static final String MIME_TYPES = "mimes"; // String[]
    public static final String API = "api"; // int[]

    /* Supported APIS [See OpenRTB 2.5 Section 5.6] */
    public static final int VPAID_1 = 1;
    public static final int VPAID_2 = 2;
    public static final int MRAID_1 = 3;
    public static final int ORMMA = 4;
    public static final int MRAID_2 = 5;
    public static final int MRAID_3 = 6;

    //Ad Positions
    public static final int POSITION_UNKNOWN = 0;
    public static final int ABOVE_THE_FOLD = 1;
    //public static final int DEPRECATED = 2;
    public static final int BELOW_THE_FOLD = 3;
    public static final int HEADER = 4;
    public static final int FOOTER = 5;
    public static final int SIDEBAR = 6;
    public static final int FULL_SCREEN = 7;

    //Share API version
    public static final int OMID = 7;

    public static final int AUDIO_AD_AUTO_PLAY = 1;
    public static final int AUDIO_AD_USER_INITIATED = 2;
    public static final int EXPANDABLE_AUTOMATIC = 3;
    public static final int EXPANDABLE_USER_CLICK = 4;
    public static final int EXPANDABLE_USER_ROLLOVER = 5;
    public static final int BANNER_VIDEO_AUTO_PLAY = 6;
    public static final int BANNER_VIDEO_USER_INITIATED = 7;
    public static final int HAS_POPUP = 8;
    public static final int PROVOCATIVE_OR_SUGGESTIVE = 9;
    public static final int EXTREME_ANIMATION = 10;
    public static final int SURVEYS = 11;
    public static final int TEXT_ONLY = 12;
    public static final int USER_INTERACTIVE_AND_GAMES = 13;
    public static final int DIALOG_OR_ALERT_STYLE = 14;
    public static final int HAS_VOLUME_TOGGLE = 15;
    public static final int HAS_SKIP_BUTTON = 16;
    public static final int ADOBE_FLASH = 17;
}
