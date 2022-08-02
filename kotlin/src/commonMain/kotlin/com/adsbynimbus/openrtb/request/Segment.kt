package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
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
 * @property ext Placeholder for exchange-specific extensions to OpenRTB
 */
@Serializable
public class Segment(
    @JvmField @SerialName("id") public val id: String? = null,
    @JvmField @SerialName("name") public val name: String? = null,
    @JvmField @SerialName("value") public val value: String? = null,
    @JvmField @SerialName("ext") public val ext: MutableMap<String, String> = mutableMapOf()
)


