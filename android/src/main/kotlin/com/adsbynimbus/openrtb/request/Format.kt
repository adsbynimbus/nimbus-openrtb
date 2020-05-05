package com.adsbynimbus.openrtb.request

/**
 * This object represents an allowed size (i.e., height and width combination)
 *
 * @param w width in device independent pixels (DIPS).
 * @param h height in device independent pixels (DIPS).
 * [OpenRTB Section 3.2.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=23)
 */
open class Format(@JvmField val w: Int, @JvmField val h: Int) {

    companion object {
        /**
         * Named format for a 320 x 480 portrait interstitial
         */
        @JvmField
        val INTERSTITIAL_PORT = Format(320, 480)

        /**
         * Named format for a 480 x 320 landscape interstitial
         */
        @JvmField
        val INTERSTITIAL_LAND = Format(480, 320)

        /**
         * Named format for a 300 x 50 banner. Prefer BANNER_320_5 over this.
         */
        @JvmField
        val BANNER_300_50 = Format(300, 50)

        /**
         * Named format for a 330 x 50 banner. Prefer this over BANNER_300_50.
         */
        @JvmField
        val BANNER_320_50 = Format(320, 50)

        /**
         * Named format for a 300 x 250 banner.
         */
        @JvmField
        val LETTERBOX = Format(300, 250)

        /**
         * Named format for a 300 x 600 banner.
         */
        @JvmField
        val HALF_SCREEN = Format(300, 600)

        /**
         * Named format for a 728 x 90 banner.
         */
        @JvmField
        val LEADERBOARD = Format(728, 90)
    }

}