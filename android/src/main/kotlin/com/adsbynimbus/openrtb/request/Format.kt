package com.adsbynimbus.openrtb.request

/**
 * This object represents an allowed size (i.e., height and width combination)
 *
 * @see [OpenRTB Section 3.2.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=23)
 */
class Format
/**
 * Constructor
 *
 * @param width width in device independent pixels (DIPS).
 * @param height height in device independent pixels (DIPS).
 */(
        /**
         * Width in device independent pixels (DIPS).
         */
        val w: Int,
        /**
         * Height in device independent pixels (DIPS).
         */
        val h: Int) {

    companion object {
        /**
         * Named format for a 320 x 480 portrait interstitial
         */
        val INTERSTITIAL_PORT = Format(320, 480)

        /**
         * Named format for a 480 x 320 landscape interstitial
         */
        val INTERSTITIAL_LAND = Format(480, 320)

        /**
         * Named format for a 300 x 50 banner. Prefer [Format.BANNER_320_50] over this.
         */
        val BANNER_300_50 = Format(300, 50)

        /**
         * Named format for a 330 x 50 banner. Prefer this over [Format.BANNER_300_50].
         */
        val BANNER_320_50 = Format(320, 50)

        /**
         * Named format for a 300 x 250 banner.
         */
        val LETTERBOX = Format(300, 250)

        /**
         * Named format for a 300 x 600 banner.
         */
        val HALF_SCREEN = Format(300, 600)

        /**
         * Named format for a 728 x 90 banner.
         */
        val LEADERBOARD = Format(728, 90)
    }

}