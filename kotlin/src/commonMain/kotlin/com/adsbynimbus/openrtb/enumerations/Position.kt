package com.adsbynimbus.openrtb.enumerations

/**
 * Describes the position of the ad as a relative measure of visibility or prominence.
 *
 * This OpenRTB table has values derived from the Inventory Quality Guidelines (IQG).
 * Values 4 - 7 apply to apps.
 *
 * [OpenRTB Section 5.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
 */
public object Position {
    public const val UNKNOWN: Byte = 0
    public const val ABOVE_THE_FOLD: Byte = 1
    public const val BELOW_THE_FOLD: Byte = 3
    public const val HEADER: Byte = 4
    public const val FOOTER: Byte = 5
    public const val SIDEBAR: Byte = 6
    public const val FULLSCREEN: Byte = 7
}
