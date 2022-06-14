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
 * @property ext Placeholder for exchange-specific extensions to OpenRTB.
 * @see [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39)
 */
@Serializable
public class Publisher(
    @JvmField @SerialName("name") public var name: String? = null,
    @JvmField @SerialName("domain") public var domain: String? = null,
    @JvmField @SerialName("cat") public var cat: Array<String>? = null,
    @JvmField @SerialName("ext") public var ext: Extension? = null,
)
