package com.adsbynimbus.openrtb.enumerations

/** Indicates how the geographic information was determined. */
public object LocationType {
    public const val GPS: Byte = 1
    public const val IP_LOOKUP: Byte = 2
    public const val USER_PROVIDED: Byte = 3
}
