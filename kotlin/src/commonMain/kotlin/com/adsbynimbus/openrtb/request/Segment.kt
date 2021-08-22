package com.adsbynimbus.openrtb.request

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * Segment objects are essentially key-value pairs that convey specific units of data.
 *
 * The parent [Data] object is a collection of such values from a given data provider. The specific
 * segment names and value options must be published by the exchange a priori to its bidders.
 *
 * [OpenRTB Section 3.2.22](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31)
 *
 * @property id ID of the data segment specific to the data provider.
 * @property name Name of the data segment specific to the data provider.
 * @property value String representation of the data segment value.
 */
@Serializable
class Segment(
    @JvmField val id: String,
    @JvmField val name: String,
    @JvmField val value: String,
)