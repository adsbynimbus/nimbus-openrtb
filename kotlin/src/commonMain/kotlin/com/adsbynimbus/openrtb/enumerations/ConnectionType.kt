package com.adsbynimbus.openrtb.enumerations

/**
 * Options for the type of device connectivity
 *
 * [OpenRTB Section 5.22](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56)
 */
public object ConnectionType {
    public const val ETHERNET: Byte = 1
    public const val WIFI: Byte = 2
    public const val CELLULAR_UNKNOWN: Byte = 3
    public const val CELLULAR_2G: Byte = 4
    public const val CELLULAR_3G: Byte = 5
    public const val CELLULAR_4G: Byte = 6
}
