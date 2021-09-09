@file:Suppress("RedundantVisibilityModifier")

package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object describes the publisher of the media in which the ad will be displayed.
 *
 * The publisher is typically the seller in an OpenRTB transaction.
 *
 * [OpenRTB Section 3.2.15](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=26)
 *
 * @property name Publisher name (may be aliased at the publisher’s request).
 * @property domain Highest level domain of the publisher (e.g., "adsbynimbus.com").
 * @property cat Array of IAB content categories that describe the publisher.
 * @see [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39)
 */
@Serializable
public class Publisher(
    @JvmField @SerialName("name") public val name: String,
    @JvmField @SerialName("domain") public val domain: String,
    @JvmField @SerialName("cat") public val cat: Array<String> = emptyArray(),
)