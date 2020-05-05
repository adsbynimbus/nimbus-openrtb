package com.adsbynimbus.openrtb.request

/**
 * Describes the position of the ad as a relative measure of visibility or prominence. This OpenRTB table has values
 * derived from the Inventory Quality Guidelines (IQG). Values 4 - 7 apply to apps.
 *
 * @see [OpenRTB Section 5.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=51)
 */
interface Position {
    companion object {
        /**
         * Unknown
         */
        const val POSITION_UNKNOWN = 0

        /**
         * Above the Fold
         */
        const val ABOVE_THE_FOLD = 1
        //DEPRECATED(2),
        /**
         * Below the Fold
         */
        const val BELOW_THE_FOLD = 3

        /**
         * App Header
         */
        const val HEADER = 4

        /**
         * App Footer
         */
        const val FOOTER = 5

        /**
         * App Sidebar
         */
        const val SIDEBAR = 6

        /**
         * Full Screen
         */
        const val FULL_SCREEN = 7
    }
}