package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object represents an in-stream video impression.
 *
 * Many of the fields are non-essential for minimally viable transactions, but are included to offer
 * fine control when needed. Video in OpenRTB generally assumes compliance with the VAST standard.
 * As such, the notion of companion ads is supported by optionally including an array of Banner
 * objects that define these companion ads. The presence of a Video as a subordinate of the
 * Impression object indicates that this impression is offered as a video type impression. At the
 * publisher’s discretion, that same impression may also be offered as banner, audio, and/or native
 * by also including as Imp subordinates objects of those types. However, any given bid for the
 * impression must conform to one of the offered types.
 *
 * [OpenRTB Section 3.2.7](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=20)
 *
 * @property bidfloor Minimum bid for this video impression expressed in CPM.
 * @property mimes Content MIME types supported (e.g., "video/3gp", "video/mp4").
 * @property minduration Minimum video ad duration in seconds.
 * @property maxduration Maximum video ad duration in seconds.
 * @property protocols Set of supported video protocols
 * @property w Width of the video player in device independent pixels (DIPS).
 * @property h Height of the video player in device independent pixels (DIPS).
 * @property startdelay Indicates the start delay in seconds for pre-roll, mid-roll, or post-roll ad
 *                      placements.
 *                      >0: Mid roll where the value indicates the start delay
 *                      0: pre roll
 *                      -1: generic mid roll
 *                      -2: generic post roll
 * @property placement Placement type for this video impression
 * @property linearity Indicates if the impression must be linear, nonlinear, etc.
 *                     If none specified, assume all are allowed.
 * @property skip Indicates if the player will allow the video to be skipped. If a bidder sends
 *                markup/creative that is itself skippable, the Bid object should include the attr
 *                array with an element of [CreativeAttribute.HAS_SKIP_BUTTON] indicating skippable
 *                video. Refer to [CreativeAttribute].
 *                0 = no
 *                1 = yes.
 * @property delivery Supported delivery methods; if none specified, assume all are supported.
 * @property skipmin Videos of total duration greater than this number of seconds can be skippable.
 *                   Only applicable if the ad is skippable.
 * @property skipafter Number of seconds a video must play before skipping is enabled; only
 *                     applicable if the ad is skippable.
 * @property minbitrate Minimum bit rate in Kbps.
 * @property maxbitrate Maximum bit rate in Kbps.
 * @property pos Ad position on screen.
 * @property playbackmethod The event that causes playback to start
 * @property api Set of supported API frameworks for this impression. If an API is not explicitly
 *               listed, it is assumed not to be supported.
 * @property companionad Array of Banner objects if companion ads are available
 * @property companiontype Supported VAST companion ad types. Recommended if requesting companion
 *                         ads.
 * @property ext Video extensions
 */
@Serializable
public class Video(
    @JvmField @SerialName("bidfloor") public var bidfloor: Float = 0f,
    @JvmField @SerialName("mimes") public var mimes: Array<String>? = null,
    @JvmField @SerialName("minduration") public var minduration: Int = 0,
    @JvmField @SerialName("maxduration") public var maxduration: Int = 60,
    @JvmField @SerialName("protocols") public var protocols: ByteArray? = null,
    @JvmField @SerialName("w") public var w: Int = 0,
    @JvmField @SerialName("h") public var h: Int = 0,
    @JvmField @SerialName("startdelay") public var startdelay: Int = 0,
    @JvmField @SerialName("placement") public var placement: Byte = 0,
    @JvmField @SerialName("linearity") public var linearity: Byte = 0,
    @JvmField @SerialName("skip") public var skip: Byte = 0,
    @JvmField @SerialName("delivery") public var delivery: ByteArray? = null,
    @JvmField @SerialName("skipmin") public var skipmin: Int = 0,
    @JvmField @SerialName("skipafter") public var skipafter: Int = 0,
    @JvmField @SerialName("minbitrate") public var minbitrate: Int = 0,
    @JvmField @SerialName("maxbitrate") public var maxbitrate: Int = 0,
    @JvmField @SerialName("pos") public var pos: Byte = 0,
    @JvmField @SerialName("playbackmethod") public var playbackmethod: ByteArray? = null,
    @JvmField @SerialName("api") public var api: ByteArray? = null,
    @JvmField @SerialName("companionad") public var companionad: Array<Banner>? = null,
    @JvmField @SerialName("companiontype") public var companiontype: ByteArray? = null,
    @JvmField @SerialName("ext") public var ext: MutableMap<String, Byte> = mutableMapOf(
        "is_rewarded" to 0
    ),
) {

    /** Indicates this video request is for a rewarded video */
    public inline var is_rewarded: Byte
        get() = ext["is_rewarded"] ?: 0
        set(value) { ext["is_rewarded"] = value }
}
