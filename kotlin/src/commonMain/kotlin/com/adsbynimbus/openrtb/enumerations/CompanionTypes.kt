package com.adsbynimbus.openrtb.enumerations

/**
 * Companion Ad Type
 *
 * [OpenRTB Section 5.14](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=54)
 */
public object CompanionTypes {
    /** URI to a static resource such as an image */
    public const val STATIC: Byte = 1

    /** HTML to display the companion element */
    public const val HTML: Byte = 2

    /** URI source for an IFrame to display the companion element */
    public const val IFRAME: Byte = 3
}
