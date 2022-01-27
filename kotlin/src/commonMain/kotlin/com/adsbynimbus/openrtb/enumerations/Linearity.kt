package com.adsbynimbus.openrtb.enumerations

/**
 * Linearity
 *
 * [OpenRTB Section 5.7](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
 */
public object Linearity {
    /** Linear / In-Stream Video */
    public const val LINEAR: Byte = 1

    /** Non-Linear / Overlay Video*/
    public const val NON_LINEAR: Byte = 2
}
