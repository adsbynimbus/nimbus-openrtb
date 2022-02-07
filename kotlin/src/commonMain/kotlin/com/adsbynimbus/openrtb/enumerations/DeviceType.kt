package com.adsbynimbus.openrtb.enumerations

/**
 * Type of device from which the impression originated.
 *
 * [OpenRTB Section 5.21](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56)
 */
public object DeviceType {
    /** Interchangeable with Phone and Tablet */
    public const val MOBILE_TABLET: Byte = 1
    public const val PERSONAL_COMPUTER: Byte = 2
    public const val CONNECTED_TV: Byte = 3

    /** Interchangeable with MobileTablet */
    public const val PHONE: Byte = 4

    /** Interchangeable with MobileTablet */
    public const val TABLET: Byte = 5
    public const val CONNECTED_DEVICE: Byte = 6
    public const val SET_TOP_BOX: Byte = 7
}
