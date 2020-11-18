package com.adsbynimbus.openrtb.request

/**
 * API frameworks supported by the publisher for a [Banner] impression
 *
 * [OpenRTB Section 5.6](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
 */
interface Api {
    companion object {
        /**
         * VPAID 1
         */
        const val VPAID_1 = 1

        /**
         * VPAID 2
         */
        const val VPAID_2 = 2

        /**
         * MRAID 1
         */
        const val MRAID_1 = 3

        /**
         * ORMMA
         */
        const val ORMMA = 4

        /**
         * MRAID 2
         */
        const val MRAID_2 = 5

        /**
         * MRAID 3
         */
        const val MRAID_3 = 6
    }
}