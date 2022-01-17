package com.adsbynimbus.openrtb.enumerations

/**
 * Options for the type of device connectivity
 *
 * [OpenRTB Section 5.22](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56)
 */
public object ConnectionType {
    public const val ETHERNET: Int = 1
    public const val WIFI: Int = 2
    public const val CELLULAR_UNKNOWN: Int = 3
    public const val CELLULAR_2G: Int = 4
    public const val CELLULAR_3G: Int = 5
    public const val CELLULAR_4G: Int = 6
}

/**
 * Type of device from which the impression originated.
 *
 * [OpenRTB Section 5.21](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56)
 */
public object DeviceType {
    /** Interchangeable with Phone and Tablet */
    public const val MOBILE_TABLET: Int = 1
    public const val PERSONAL_COMPUTER: Int = 2
    public const val CONNECTED_TV: Int = 3

    /** Interchangeable with MobileTablet */
    public const val PHONE: Int = 4

    /** Interchangeable with MobileTablet */
    public const val TABLET: Int = 5
    public const val CONNECTED_DEVICE: Int = 6
    public const val SET_TOP_BOX: Int = 7
}

/**
 * Indicates how the geographic information was determined.
 */
public object LocationType {
    public const val GPS: Int = 1
    public const val IP_LOOKUP: Int = 2
    public const val USER_PROVIDED: Int = 3
}