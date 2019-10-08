package com.adsbynimbus.openrtb.impression;

/**
 * Defines constants shared between children of the {@link Impression} object
 */
interface Creative {

    String BID_FLOOR = "bidfloor"; //float
    String POSITION = "pos"; // int
    String MIME_TYPES = "mimes"; // String[]
    String SUPPORTED_APIS = "api"; // int[]

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
}
