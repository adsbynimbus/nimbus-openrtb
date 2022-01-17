package com.adsbynimbus.openrtb.request

/**
 * Describes the position of the ad as a relative measure of visibility or prominence.
 *
 * This OpenRTB table has values derived from the Inventory Quality Guidelines (IQG).
 * Values 4 - 7 apply to apps.
 *
 * [OpenRTB Section 5.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
 */
public object Position {
    public const val POSITION_UNKNOWN: Int = 0
    public const val ABOVE_THE_FOLD: Int = 1
    public const val BELOW_THE_FOLD: Int = 3
    public const val HEADER: Int = 4
    public const val FOOTER: Int = 5
    public const val SIDEBAR: Int = 6
    public const val FULL_SCREEN: Int = 7
}