@file:Suppress("RedundantVisibilityModifier")

package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * The data and segment objects together allow additional data about the related object (e.g., user,
 * content) to be specified. This data may be from multiple sources whether from the exchange itself
 * or third parties as specified by the id field. A bid request can mix data objects from multiple
 * providers. The specific data providers in use should be published by the exchange a priori to its bidders.
 *
 * [OpenRTB Section 3.2.21](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31)
 *
 * @property id Exchange-specific ID for the data provider.
 * @property name Exchange-specific name for the data provider.
 * @property segment Array of [Segment] objects that contain the actual data values.
 * @see [OpenRTB Section 3.2.22](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31)
 */
@Serializable
public class Data(
    @JvmField @SerialName("id") public var id: String? = null,
    @JvmField @SerialName("name") public var name: String? = null,
    @JvmField @SerialName("segment") public var segment: Collection<Segment>? = null,
)
