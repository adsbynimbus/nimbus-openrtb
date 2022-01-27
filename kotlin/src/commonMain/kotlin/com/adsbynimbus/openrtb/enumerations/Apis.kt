package com.adsbynimbus.openrtb.enumerations

/**
 * API frameworks supported by the publisher for a creative.
 *
 * [OpenRTB Section 5.6](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
 */
public object Apis {

    /** Supports VPAID 1 (Unused) **/
    public const val VPAID_1: Byte = 1

    /** Supports VPAID 2 (Unused) **/
    public const val VPAID_2: Byte = 2

    /** Supports MRAID 1 **/
    public const val MRAID_1: Byte = 3

    /** Supports ORMMA */
    public const val ORMMA: Byte = 4

    /** Supports MRAID 2 **/
    public const val MRAID_2: Byte = 5

    /** Supports MRAID 3 **/
    public const val MRAID_3: Byte = 6

    /** Supports OM SDK **/
    public const val OMID: Byte = 7
}
