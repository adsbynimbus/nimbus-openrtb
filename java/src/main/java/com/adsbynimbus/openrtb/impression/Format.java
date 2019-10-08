package com.adsbynimbus.openrtb.impression;

/**
 * This object represents an allowed size (i.e., height and width combination) or Flex Ad parameters for a
 * banner impression. These are typically used in an array where multiple sizes are permitted. It is
 * recommended that either the w/h pair or the wratio/hratio/wmin set (i.e., for Flex Ads) be specified.
 */
public interface Format {

    //Ad Format Names
    int INTERSTITIAL_PORT = 0;
    int INTERSTITIAL_LAND = 1;
    int BANNER_300_50 = 2;
    int BANNER_320_50 = 3;
    int LETTERBOX = 4;
    int HALF_SCREEN = 5;
    int LEADERBOARD = 6;

    //Ad format parameter
    String FORMAT = "format";

    String WIDTH = "w";
    String HEIGHT = "h";

    /**
     * Builder for constructing a {@link Format} object
     */
    interface Builder {

    }

    /**
     * Definition of {@link Format} with all public mutable fields
     */
    class MutableFormat implements Format {
        public int w;
        public int h;
    }
}
