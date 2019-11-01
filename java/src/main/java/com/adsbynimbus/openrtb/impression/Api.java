package com.adsbynimbus.openrtb.impression;

/**
 * API frameworks supported by the publisher for a {@link Banner} impression
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51">OpenRTB Section 5.6</a>
 */
public interface Api {

    /**
     * VPAID 1
     */
    int VPAID_1 = 1;

    /**
     * VPAID 2
     */
    int VPAID_2 = 2;

    /**
     * MRAID 1
     */
    int MRAID_1 = 3;

    /**
     * ORMMA
     */
    int ORMMA = 4;

    /**
     * MRAID 2
     */
    int MRAID_2 = 5;

    /**
     * MRAID 3
     */
    int MRAID_3 = 6;
}
