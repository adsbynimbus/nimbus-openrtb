package com.adsbynimbus.openrtb.enumerations

/**
 * Protocols
 *
 * [OpenRTB Section 5.8](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
 */
public object Protocols {
    /** Vast 2.0 */
    public const val VAST_2: Byte = 2

    /** Vast 3.0 */
    public const val VAST_3: Byte = 3

    /** Vast 2.0 Wrapper */
    public const val VAST_2_WRAPPER: Byte = 5

    /** Vast 3.0 Wrapper */
    public const val VAST_3_WRAPPER: Byte = 6

    /** Vast 4.0 */
    public const val VAST_4: Byte = 7

    /** Vast 4.0 Wrapper */
    public const val VAST_4_WRAPPER: Byte = 8
}
