package com.adsbynimbus.openrtb.enumerations

/**
 * Content Delivery Method
 *
 * [OpenRTB Section 5.15](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=54)
 */
public object DeliveryMethods {
    /** Streaming Media */
    public const val STREAMING: Byte = 1

    /** Progressive Media */
    public const val PROGRESSIVE: Byte = 2

    /** Downloaded Media */
    public const val DOWNLOAD: Byte = 3
}
