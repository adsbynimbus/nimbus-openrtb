package com.adsbynimbus.openrtb.impression;

public enum Position {
    POSITION_UNKNOWN(0),
    ABOVE_THE_FOLD(1),
    //DEPRECATED(2),
    BELOW_THE_FOLD(3),
    HEADER(4),
    FOOTER(5),
    SIDEBAR(6),
    FULL_SCREEN(7);

    public final int value;

    Position(int value) {
        this.value = value;
    }
}
