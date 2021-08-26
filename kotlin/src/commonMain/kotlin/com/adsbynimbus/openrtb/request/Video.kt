@file:Suppress("RedundantVisibilityModifier", "INLINE_CLASS_DEPRECATED")

package com.adsbynimbus.openrtb.request

import com.adsbynimbus.openrtb.request.Creative.Position.Companion.Unknown
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
    @JvmField @SerialName("bidfloor") public val bidfloor: Float = 3f,
    @JvmField @SerialName("mimes") public val mimes: Array<String> = emptyArray(),
    @JvmField @SerialName("minduration") public val minduration: Int = 0,
    @JvmField @SerialName("maxduration") public val maxduration: Int = 60,
    @JvmField @SerialName("protocols") public val protocols: IntArray? = null,
    @JvmField @SerialName("w") public val w: Int = 0,
    @JvmField @SerialName("h") public val h: Int = 0,
    @JvmField @SerialName("startdelay") public val startdelay: Int = 0,
    @JvmField @SerialName("placement") public val placement: Int,
    @JvmField @SerialName("linearity") public val linearity: Int? = null,
    @JvmField @SerialName("skip") public val skip: Int,
    @JvmField @SerialName("delivery") public val delivery: IntArray? = null,
    @JvmField @SerialName("skipmin") public val skipmin: Int? = 0,
    @JvmField @SerialName("skipafter") public val skipafter: Int? = 0,
    @JvmField @SerialName("minbitrate") public val minbitrate: Int? = 0,
    @JvmField @SerialName("maxbitrate") public val maxbitrate: Int? = 0,
    @JvmField @SerialName("pos") public val pos: Int = Unknown,
    @JvmField @SerialName("playbackmethod") public val playbackmethod: IntArray? = null,
    @JvmField @SerialName("api") public val api: IntArray? = null,
    @JvmField @SerialName("companionad") public val companionad: Array<Banner>? = null,
    @JvmField @SerialName("companiontype") public val companiontype: IntArray? = null,
    @JvmField @SerialName("ext") public val ext: Extension? = null,
) {
    /**
     * Video extensions
     *
     * @property is_rewarded Indicates this video request is for a rewarded video
     */
    @Serializable
    public open class Extension(
        @JvmField @SerialName("is_rewarded") public val is_rewarded: Boolean = false,
    )

    /**
     * Protocols
     *
     * [OpenRTB Section 5.8](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
     */
    public inline class Protocol(public val value: Int) {
        public companion object {
            public const val Vast2: Int = 2
            public const val Vast3: Int = 3
            public const val Vast2Wrapper: Int = 5
            public const val Vast3Wrapper: Int = 6
            public const val Vast4: Int = 7
            public const val Vast4Wrapper: Int = 8
        }
    }


    /**
     * Placements
     *
     * [OpenRTB Section 5.9](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
     */
    public inline class Placement(public val value: Int) {
        public companion object {
            /**
             * Played before, during or after the streaming video content that the consumer has requested
             * (e.g., Pre-roll, Mid-roll, Post-roll).
             */
            public const val InStream: Int = 1

            /**
             * Exists within a web banner that leverages the banner space to deliver a video experience as
             * opposed to another static or rich media format. The format relies on the existence of display
             * ad inventory on the page for its delivery
             */
            public const val InBanner: Int = 2

            /**
             * Loads and plays dynamically between paragraphs of editorial content; existing as a standalone
             * branded message
             */
            public const val InArticle: Int = 3

            /**
             * Found in content, social, or product feeds.
             */
            public const val InFeed: Int = 4

            /**
             * Covers the entire or a portion of screen area, but is always on screen while displayed (i.e.
             * cannot be scrolled out of view). Note that a full-screen interstitial (e.g., in mobile) can be
             * distinguished from a floating/slider unit by the [Impression.instl] field.
             */
            public const val InterstitialSliderFloating: Int = 5
        }
    }

    /**
     * Playback Methods
     *
     * [OpenRTB Section 5.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=53)
     */
    public inline class PlaybackMethod(public val value: Int) {
        public companion object {
            public const val PageLoadSoundOn: Int = 1
            public const val PageLoadSoundOff: Int = 2
            public const val ClickSoundOn: Int = 3
            public const val MouseOverSoundOn: Int = 4
            public const val EnterViewportSoundOn: Int = 5
            public const val EnterViewportSoundOff: Int = 6
        }
    }


    /**
     * Linearity
     *
     * [OpenRTB Section 5.7](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
     */
    public inline class Linearity(public val value: Int) {
        public companion object {
            /** In-Stream */
            public const val Linear: Int = 1

            /** Overlay */
            public const val NonLinear: Int = 2
        }
    }


    /**
     * Content Delivery
     *
     * [OpenRTB Section 5.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=53)
     */
    public inline class ContentDelivery(public val value: Int) {
        public companion object {
            public const val Streaming: Int = 1
            public const val Progressive: Int = 2
            public const val Download: Int = 3
        }
    }


    /**
     * CompanionType
     *
     * [OpenRTB Section 5.14](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=54)
     */
    public inline class CompanionType(public val value: Int) {
        public companion object {
            /** URI to a static resource such as an image */
            public const val Static: Int = 1
            /** HTML to display the companion element */
            public const val Html: Int = 2
            /** URI source for an IFrame to display the companion element */
            public const val IFrame: Int = 3
        }
    }
}