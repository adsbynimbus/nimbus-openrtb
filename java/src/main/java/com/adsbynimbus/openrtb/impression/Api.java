package com.adsbynimbus.openrtb.impression;

public enum Api {
    VPAID_1(1),
    VPAID_2(2),
    MRAID_1(3),
    ORMMA(4),
    MRAID_2(5),
    MRAID_3(6),
    OMID(7);

    public final int value;

    Api(int value) {
        this.value = value;
    }
}
