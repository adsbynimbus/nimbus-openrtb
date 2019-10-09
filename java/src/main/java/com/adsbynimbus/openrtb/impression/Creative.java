package com.adsbynimbus.openrtb.impression;

/**
 * Defines constants shared between children of the {@link Impression} object
 */
interface Creative {

    String BID_FLOOR = "bidfloor"; //float
    String POSITION = "pos"; // int
    String MIME_TYPES = "mimes"; // String[]
    String API = "api"; // int[]

    /* Supported APIS [See OpenRTB 2.5 Section 5.6] */
    int VPAID_1 = 1;
    int VPAID_2 = 2;
    int MRAID_1 = 3;
    int ORMMA = 4;
    int MRAID_2 = 5;
    int MRAID_3 = 6;

    //Ad Positions
    int POSITION_UNKNOWN = 0;
    int ABOVE_THE_FOLD = 1;
    //int DEPRECATED = 2;
    int BELOW_THE_FOLD = 3;
    int HEADER = 4;
    int FOOTER = 5;
    int SIDEBAR = 6;
    int FULL_SCREEN = 7;

    //Share API version
    int OMID = 7;

    int AUDIO_AD_AUTO_PLAY = 1;
    int AUDIO_AD_USER_INITIATED = 2;
    int EXPANDABLE_AUTOMATIC = 3;
    int EXPANDABLE_USER_CLICK = 4;
    int EXPANDABLE_USER_ROLLOVER = 5;
    int BANNER_VIDEO_AUTO_PLAY = 6;
    int BANNER_VIDEO_USER_INITIATED = 7;
    int HAS_POPUP = 8;
    int PROVOCATIVE_OR_SUGGESTIVE = 9;
    int EXTREME_ANIMATION = 10;
    int SURVEYS = 11;
    int TEXT_ONLY = 12;
    int USER_INTERACTIVE_AND_GAMES = 13;
    int DIALOG_OR_ALERT_STYLE = 14;
    int HAS_VOLUME_TOGGLE = 15;
    int HAS_SKIP_BUTTON = 16;
    int ADOBE_FLASH = 17;
}
