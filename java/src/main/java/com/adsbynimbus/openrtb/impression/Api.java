package com.adsbynimbus.openrtb.impression;

/**
 * API frameworks supported by the publisher
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=46">OpenRTB Section 5.6</a>
 */
public enum Api {

    /**
     * VPAID 1
     */
    VPAID_1(1),

    /**
     * VPAID 2
     */
    VPAID_2(2),

    /**
     * MRAID 1
     */
    MRAID_1(3),

    /**
     * ORMMA
     */
    ORMMA(4),

    /**
     * MRAID 2
     */
    MRAID_2(5),

    /**
     * MRAID 3
     */
    MRAID_3(6),

    /**
     * OM SDK - Nimbus extension
     */
    OMID(7);

    public final int value;

    Api(int value) {
        this.value = value;
    }
}
