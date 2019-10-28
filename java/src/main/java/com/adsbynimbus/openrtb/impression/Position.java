package com.adsbynimbus.openrtb.impression;

public interface Position {
    int POSITION_UNKNOWN = 0;
    int ABOVE_THE_FOLD = 1;
    //DEPRECATED(2),
    int BELOW_THE_FOLD = 3;
    int HEADER = 4;
    int FOOTER = 5;
    int SIDEBAR = 6;
    int FULL_SCREEN = 7;
}
