package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This public class represents a native type impression.
 *
 * Native ad units are intended to blend seamlessly into the surrounding content (e.g., a sponsored
 * Twitter or Facebook post). As such, the response must be well-structured to afford the publisher
 * fine-grained control over rendering. The Native Subcommittee has developed a companion
 * specification to OpenRTB called the Dynamic Native Ads API. It defines the request parameters and
 * response markup structure of native ad units. This object provides the means of transporting
 * request parameters as an opaque string so that the specific parameters can evolve separately
 * under the auspices of the Dynamic Native Ads API. Similarly, the ad markup served will be
 * structured according to that specification. The presence of a Native as a subordinate of the Imp
 * object indicates that this impression is offered as a native type impression. At the publisher’s
 * discretion, that same impression may also be offered as banner, video, and/or audio by also
 * including as Imp subordinates objects of those types. However, any given bid for the impression
 * must conform to one of the offered types.
 *
 * [OpenRTB Section 3.2.9](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=23)
 *
 * @property bidfloor Minimum bid for this native impression expressed in CPM.
 * @property request Request payload complying with the Native Ad Specification
 * @property ver Version of the Dynamic Native Ads API to which request complies. Highly recommended
 *               for efficient parsing.
 * @property api List of supported API frameworks for this impression. If an API is not explicitly
 *               listed, it is assumed not to be supported.
 * @property battr Set of creative attributes to block.
 */
@Serializable
public class Native(
    @JvmField @SerialName("bidfloor") public val bidfloor: Float? = null,
    @JvmField @SerialName("request") public val request: String,
    @JvmField @SerialName("ver") public val ver: String = "",
    @JvmField @SerialName("api") public val api: ByteArray = ByteArray(0),
    @JvmField @SerialName("battr") public val battr: ByteArray = ByteArray(0),
)
