package com.adsbynimbus.openrtb.impression;

/**
 * Describes the position of the ad as a relative measure of visibility or prominence. This OpenRTB table has values
 * derived from the Inventory Quality Guidelines (IQG). Values 4 - 7 apply to apps.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51">OpenRTB Section 5.4</a>
 */
public enum Position {

    /**
     * Unknown
     */
    POSITION_UNKNOWN(0),

    /**
     * Above the Fold
     */
    ABOVE_THE_FOLD(1),
    //DEPRECATED(2),

    /**
     * Below the Fold
     */
    BELOW_THE_FOLD(3),

    /**
     * App Header
     */
    HEADER(4),

    /**
     * App Footer
     */
    FOOTER(5),

    /**
     * App Sidebar
     */
    SIDEBAR(6),

    /**
     * Full Screen
     */
    FULL_SCREEN(7);

    public final int value;

    Position(int value) {
        this.value = value;
    }
}
