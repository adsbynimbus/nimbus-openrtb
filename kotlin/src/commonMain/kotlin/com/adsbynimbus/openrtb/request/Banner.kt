package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object represents the most general type of impression.
 *
 * Although the term "banner" may have very specific meaning in other contexts, here it can be many
 * things including a simple static image, an expandable ad unit, or even in-banner video (refer to
 * [Video] for generalized and full featured video ad units). An array of [Banner] objects can also
 * appear within the [Video] to describe optional companion ads defined in the VAST specification.
 * The presence of a [Banner] as a subordinate of the [Impression] object indicates that this
 * impression is offered as a banner type impression. At the publisher’s discretion, that same
 * impression may also be offered as video, audio, and/or native by also including as [Impression]
 * subordinates objects of those types. However, any given bid for the impression must conform to
 * one of the offered types.
 *
 * [OpenRTB Section 3.2.6](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=19)
 *
 * @property bidfloor Minimum bid for this banner impression expressed in CPM.
 * @property battr Set of creative attributes to block.
 * @property format Array of Format objects representing the banner sizes permitted.
 * @property w Exact width in device independent pixels (DIPS).
 * @property h Exact height in device independent pixels (DIPS).
 * @property pos Ad position on screen.
 * @property api Set of supported Api frameworks for this banner impression. If an Api is not
 *               explicitly listed, it is assumed not to be supported.
 * @property vcm The type of companion ad if used in a Video object. (0 - Concurrent, 1 - End Card)
 */
@Serializable
public class Banner(
    @JvmField @SerialName("w") public var w: Int,
    @JvmField @SerialName("h") public var h: Int,
    @JvmField @SerialName("format") public var format: Array<Format>? = null,
    @JvmField @SerialName("bidfloor") public var bidfloor: Float = 0f,
    @JvmField @SerialName("battr") public var battr: ByteArray? = null,
    @JvmField @SerialName("pos") public var pos: Byte = 0,
    @JvmField @SerialName("api") public var api: ByteArray? = null,
    @JvmField @SerialName("vcm") public var vcm: Byte? = null,
)
