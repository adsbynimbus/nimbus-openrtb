package com.adsbynimbus.openrtb.impression;

/**
 * Describes the position of the ad as a relative measure of visibility or prominence. This OpenRTB table has values
 * derived from the Inventory Quality Guidelines (IQG). Values 4 - 7 apply to apps.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51">OpenRTB Section 5.4</a>
 */
public interface Position {

    /**
     * Unknown
     */
    int POSITION_UNKNOWN = 0;

    /**
     * Above the Fold
     */
    int ABOVE_THE_FOLD = 1;
    //DEPRECATED(2),

    /**
     * Below the Fold
     */
    int BELOW_THE_FOLD = 3;

    /**
     * App Header
     */
    int HEADER = 4;

    /**
     * App Footer
     */
    int FOOTER = 5;

    /**
     * App Sidebar
     */
    int SIDEBAR = 6;

    /**
     * Full Screen
     */
    int FULL_SCREEN = 7;
}