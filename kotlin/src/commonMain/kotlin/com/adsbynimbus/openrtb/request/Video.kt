package com.adsbynimbus.openrtb.request

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
class Video(
    @JvmField var bidfloor: Float? = 3f,
    @JvmField var mimes: Array<String>? = null,
    @JvmField var minduration: Int? = 0,
    @JvmField var maxduration: Int? = 60,
    @JvmField var protocols: IntArray? = null,
    @JvmField var w: Int = 0,
    @JvmField var h: Int = 0,
    @JvmField var startdelay: Int? = null,
    @JvmField var placement: Int? = null,
    @JvmField var linearity: Int? = null,
    @JvmField var skip: Int? = null,
    @JvmField var delivery: IntArray? = null,
    @JvmField var skipmin: Int? = 0,
    @JvmField var skipafter: Int? = 0,
    @JvmField var minbitrate: Int? = 0,
    @JvmField var maxbitrate: Int? = 0,
    @JvmField var pos: Int? = null,
    @JvmField var playbackmethod: IntArray? = null,
    @JvmField var api: IntArray? = null,
    @JvmField var companionad: Array<Banner>? = null,
    @JvmField var companiontype: IntArray? = null,
    @JvmField var ext: Extension? = null,
) {
    /**
     * Video extensions
     *
     * @property is_rewarded Indicates this video request is for a rewarded video
     */
    open class Extension(
        @JvmField var is_rewarded: Boolean? = null,
    )

    /**
     * Protocols
     *
     * [OpenRTB Section 5.8](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
     */
    interface Protocol {
        companion object {
            /**
             * Vast 2.0
             */
            const val VAST_2 = 2

            /**
             * Vast 3.0
             */
            const val VAST_3 = 3

            /**
             * Vast 2.0 Wrapper
             */
            const val VAST_2_WRAPPER = 5

            /**
             * Vast 3.0 Wrapper
             */
            const val VAST_3_WRAPPER = 6
        }
    }

    /**
     * Placements
     *
     * [OpenRTB Section 5.9](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
     */
    interface Placement {
        companion object {
            /**
             * Played before, during or after the streaming video content that the consumer has requested
             * (e.g., Pre-roll, Mid-roll, Post-roll).
             */
            const val IN_STREAM = 1

            /**
             * Exists within a web banner that leverages the banner space to deliver a video experience as
             * opposed to another static or rich media format. The format relies on the existence of display
             * ad inventory on the page for its delivery
             */
            const val IN_BANNER = 2

            /**
             * Loads and plays dynamically between paragraphs of editorial content; existing as a standalone
             * branded message
             */
            const val IN_ARTICLE = 3

            /**
             * Found in content, social, or product feeds.
             */
            const val IN_FEED = 4

            /**
             * Covers the entire or a portion of screen area, but is always on screen while displayed (i.e.
             * cannot be scrolled out of view). Note that a full-screen interstitial (e.g., in mobile) can be
             * distinguished from a floating/slider unit by the [Impression.instl] field.
             */
            const val INTERSTITIAL_SLIDER_FLOATING = 5
        }
    }

    /**
     * Playback methods
     *
     * [OpenRTB Section 5.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=53)
     */
    interface PlaybackMethod {
        companion object {
            /**
             * Initiates on Page Load with Sound On
             */
            const val PAGE_LOAD_SOUND_ON = 1

            /**
             * Initiates on Page Load with Sound Off by Default
             */
            const val PAGE_LOAD_SOUND_OFF = 2

            /**
             * Initiates on Click with Sound On
             */
            const val CLICK_SOUND_ON = 3

            /**
             * Initiates on Mouse-Over with Sound On
             */
            const val MOUSE_OVER_SOUND_ON = 4

            /**
             * Initiates on Entering Viewport with Sound On
             */
            const val ENTER_VIEWPORT_SOUND_ON = 5

            /**
             * Initiates on Entering Viewport with Sound Off by default
             */
            const val ENTER_VIEWPORT_SOUND_OFF = 6
        }
    }

    /**
     * Linearity
     *
     * [OpenRTB Section 5.7](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
     */
    interface Linearity {
        companion object {
            /**
             * Linear / In-Stream
             */
            const val LINEAR = 1

            /**
             * Non-Linear / Overlay
             */
            const val NON_LINEAR = 2
        }
    }

    /**
     * Content Delivery
     *
     * [OpenRTB Section 5.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=53)
     */
    interface DeliveryMethod {
        companion object {
            /**
             * Streaming
             */
            const val STREAMING = 1

            /**
             * Progressive
             */
            const val PROGRESSIVE = 2

            /**
             * Download
             */
            const val DOWNLOAD = 3
        }
    }

    /**
     * CompanionType
     *
     * [OpenRTB Section 5.14](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=54)
     */
    interface CompanionType {
        companion object {
            /**
             * URI to a static resource such as an image
             */
            const val STATIC = 1

            /**
             * HTML to display the companion element
             */
            const val HTML = 2

            /**
             * URI source for an IFrame to display the companion element
             */
            const val IFRAME = 3
        }
    }

    /**
     * Builder for constructing a Video object
     *
     * @see [Video]
     */
    interface Builder {
        /**
         * Sets the position of this Video impression
         *
         * @param position the position on screen
         * @return this builder instance
         * @see [Video.pos]
         * @see [Position]
         */
        fun position(position: Int?): Builder

        /**
         * Sets the supported video mimeTypes
         *
         * @param mimeTypes the list of requested mime types
         * @return this builder instance
         * @see [Video.mimes]
         */
        fun mimes(vararg mimeTypes: String?): Builder

        /**
         * Sets the bid floor for this Video impression
         *
         * If this value is omitted Nimbus defaults to 3.0
         *
         * @param bidFloor bid floor represented in CPM
         * @return this builder instance
         * @see [Video.bidfloor]
         */
        fun bidFloor(bidFloor: Float): Builder

        /**
         * Sets duration constraints for this Video impression
         *
         * @param minDuration Minimum length this video impression can be
         * @param maxDuration Maximum length this video impression can be
         * @return this builder instance
         * @see [Video.minduration]
         * @see [Video.maxduration]
         */
        fun duration(minDuration: Int, maxDuration: Int): Builder

        /**
         * Sets a bitrate constraints for this video impression
         *
         * @param minBitrate Minimum bit rate this video impression can be
         * @param maxBitrate Maximum bit rate this video impression can be
         * @return this builder instance
         * @see [Video.minbitrate]
         * @see [Video.maxbitrate]
         */
        fun bitrate(minBitrate: Int, maxBitrate: Int): Builder

        /**
         * Sets the video player width and height in density independent pixels
         *
         * @param width  width of the video player in density independent pixels
         * @param height height of the video player in density independent pixels
         * @return this builder instance
         * @see [Video.w]
         * @see [Video.h]
         */
        fun playerSize(width: Int, height: Int): Builder

        /**
         * Sets the supported protocols of this video impression
         *
         * @param protocols a set of supported protocols
         * @return this builder instance
         * @see [Video.protocols]
         * @see [Protocol]
         */
        fun protocols(vararg protocols: Int): Builder

        /**
         * Sets if the video is skippable. Not calling this function assumes it is not skippable.
         *
         * @param skipMin   minimum duration in seconds of video length before skip is enabled
         * @param skipAfter minimum duration video must be watched to skip
         * @return this builder instance
         * @see [Video.skip]
         * @see [Video.skipmin]
         * @see [Video.skipafter]
         */
        fun skipEnabled(skipMin: Int, skipAfter: Int): Builder

        /**
         * Sets the start delay of this video impression
         *
         * @param startDelay start delay in seconds
         * @return this builder instance
         * @see [Video.startdelay]
         */
        fun startDelay(startDelay: Int): Builder

        /**
         * Sets the playback method of this video impression.
         *
         * @param playbackMethod the method that starts the video playback
         * @return this builder instance
         * @see [Video.playbackmethod]
         * @see [PlaybackMethod]
         */
        fun playbackMethod(vararg playbackMethod: Int): Builder

        /**
         * Sets the placement type of this video impression.
         *
         * @param placement the placement of the video for this impression
         * @return this builder instance
         * @see [Video.placement]
         * @see [Placement]
         */
        fun placement(placement: Int?): Builder

        /**
         * Sets the linearity of this video impression.
         *
         * @param linearity the linearity of this video impression
         * @return this builder instance
         * @see [Video.linearity]
         */
        fun linearity(linearity: Int?): Builder

        /**
         * Set the desired content delivery method.
         *
         * @param deliveryMethod the desired delivery method
         * @return this builder instance
         * @see [Video.delivery]
         * @see [DeliveryMethod]
         */
        fun deliveryMethod(vararg deliveryMethod: Int): Builder

        /**
         * Sets the supported api values
         *
         * @param apis set of supported api values
         * @return this builder instance
         * @see [Video.api]
         * @see [Api]
         */
        fun apis(vararg apis: Int): Builder

        /**
         * Sets the list of support companion ads
         *
         * @param companionAds list of request companion ads
         * @return this builder instance
         */
        fun companionAds(vararg companionAds: Banner?): Builder

        /**
         * Sets the supported companion ad types
         *
         * @param companionAdTypes set of supported api values
         * @return this builder instance
         * @see [CompanionType]
         */
        fun companionAdTypes(vararg companionAdTypes: Int): Builder

        /**
         * Sets the rewarded flag for this video object
         */
        fun rewarded(rewarded: Boolean): Builder
    }
}