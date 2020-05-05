package com.adsbynimbus.openrtb.request

/**
 * This object represents an in-stream video impression. Many of the fields are non-essential for minimally viable
 * transactions, but are included to offer fine control when needed. Video in OpenRTB generally assumes compliance with
 * the VAST standard. As such, the notion of companion ads is supported by optionally including an array of
 * [Banner] objects that define these companion ads. The presence of a [Video] as a subordinate of the
 * [Impression] object indicates that this impression is offered as a video type impression. At the publisher’s
 * discretion, that same impression may also be offered as banner, audio, and/or native by also including as Imp
 * subordinates objects of those types. However, any given bid for the impression must conform to one of the offered
 * types.
 *
 * @see [OpenRTB Section 3.2.7](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=20)
 */
class Video {
    /**
     * Protocols
     *
     * @see [OpenRTB Section 5.8](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=52)
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
     * @see [OpenRTB Section 5.9](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=52)
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
     * @see [OpenRTB Section 5.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=53)
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
     * @see [OpenRTB Section 5.7](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=52)
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
     * @see [OpenRTB Section 5.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=53)
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
     * Minimum bid for this video impression expressed in CPM.
     *
     * <br></br>
     * If this value is omitted Nimbus will default to 3.0
     */
    var bidfloor: Float? = null

    /**
     * Content MIME types supported (e.g., "video/3gp", "video/mp4").
     */
    var mimes: Array<String>? = null

    /**
     * Minimum video ad duration in seconds.
     *
     * <br></br>
     * If this value is omitted Nimbus defaults to 0
     */
    var minduration: Int? = null

    /**
     * Maximum video ad duration in seconds.
     *
     * <br></br>
     * If this value is omitted Nimbus defaults to 60
     */
    var maxduration: Int? = null

    /**
     * Set of supported video protocols
     */
    var protocols: IntArray? = null

    /**
     * Width of the video player in device independent pixels (DIPS).
     */
    var w = 0

    /**
     * Height of the video player in device independent pixels (DIPS).
     */
    var h = 0

    /**
     * Indicates the start delay in seconds for pre-roll, mid-roll, or post-roll ad placements.
     *
     *  * &gt; 0: Mid roll where the value indicates the start delay
     *  * 0: pre roll
     *  * -1: generic mid roll
     *  * -2: generic post roll
     *
     */
    var startdelay: Int? = null

    /**
     * Placement type for this video impression
     */
    var placement: Int? = null

    /**
     * Indicates if the impression must be linear, nonlinear, etc. If none specified, assume all are allowed.
     */
    var linearity: Int? = null

    /**
     * Indicates if the player will allow the video to be skipped, where 0 = no, 1 = yes. If a bidder sends
     * markup/creative that is itself skippable, the Bid object should include the attr array with an element of
     * [CreativeAttribute.HAS_SKIP_BUTTON] indicating skippable video. Refer to [CreativeAttribute].
     */
    var skip: Int? = null

    /**
     * Supported delivery methods; if none specified, assume all are supported.
     */
    var delivery: IntArray? = null

    /**
     * Videos of total duration greater than this number of seconds can be skippable; only applicable if the ad is
     * skippable.
     *
     * <br></br>
     * If this value is omitted Nimbus defaults to 0
     */
    var skipmin: Int? = null

    /**
     * Number of seconds a video must play before skipping is enabled; only applicable if the ad is skippable.
     *
     * <br></br>
     * If this value is omitted Nimbus defaults to 0
     */
    var skipafter: Int? = null

    /**
     * Minimum bit rate in Kbps.
     *
     * <br></br>
     * If this value is omitted Nimbus defaults to 0
     */
    var minbitrate: Int? = null

    /**
     * Maximum bit rate in Kbps.
     *
     * <br></br>
     * If this value is omitted Nimbus defaults to 0
     */
    var maxbitrate: Int? = null

    /**
     * Ad position on screen.
     */
    var pos: Int? = null

    /**
     * The event that causes playback to start
     */
    var playbackmethod: IntArray? = null

    /**
     * Set of supported API frameworks for this impression. If an API is not explicitly listed,
     * it is assumed not to be supported.
     */
    var api: IntArray? = null

    /**
     * Builder for constructing a Video object
     *
     * @see Video
     */
    interface Builder {
        /**
         * Sets the position of this Video impression
         *
         * @param position the position on screen
         * @return this builder instance
         * @see .pos
         *
         * @see Position
         */
        fun position(position: Int?): Builder?

        /**
         * Sets the supported video mimeTypes
         *
         * @param mimeTypes the list of requested mime types
         * @return this builder instance
         * @see .mimes
         */
        fun mimes(vararg mimeTypes: String?): Builder?

        /**
         * Sets the bid floor for this Video impression
         *
         * <br></br>
         * If this value is omitted Nimbus defaults to 3.0
         *
         * @param bidFloor bid floor represented in CPM
         * @return this builder instance
         * @see .bidfloor
         */
        fun bidFloor(bidFloor: Float): Builder?

        /**
         * Sets duration constraints for this Video impression
         *
         * @param minDuration Minimum length this video impression can be
         * @param maxDuration Maximum length this video impression can be
         * @return this builder instance
         * @see .minduration
         *
         * @see .maxduration
         */
        fun duration(minDuration: Int, maxDuration: Int): Builder?

        /**
         * Sets a bitrate constraints for this video impression
         *
         * @param minBitrate Minimum bit rate this video impression can be
         * @param maxBitrate Maximum bit rate this video impression can be
         * @return this builder instance
         * @see .minbitrate
         *
         * @see .maxbitrate
         */
        fun bitrate(minBitrate: Int, maxBitrate: Int): Builder?

        /**
         * Sets the video player width and height in density independent pixels
         *
         * @param width  width of the video player in density independent pixels
         * @param height height of the video player in density independent pixels
         * @return [Builder]
         * @see .w
         *
         * @see .h
         */
        fun playerSize(width: Int, height: Int): Builder?

        /**
         * Sets the supported protocols of this video impression
         *
         * @param protocols a set of supported protocols
         * @return this builder instance
         * @see .protocols
         *
         * @see Protocol
         */
        fun protocols(vararg protocols: Int): Builder?

        /**
         * Sets if the video is skippable. Not calling this function assumes it is not skippable.
         *
         * @param skipMin   minimum duration in seconds of video length before skip is enabled
         * @param skipAfter minimum duration video must be watched to skip
         * @return this builder instance
         * @see .skip
         *
         * @see .skipmin
         *
         * @see .skipafter
         */
        fun skipEnabled(skipMin: Int, skipAfter: Int): Builder?

        /**
         * Sets the start delay of this video impression
         *
         * @param startDelay start delay in seconds
         * @return this builder instance
         * @see .startdelay
         */
        fun startDelay(startDelay: Int): Builder?

        /**
         * Sets the playback method of this video impression.
         *
         * @param playbackMethod the method that starts the video playback
         * @return this builder instance
         * @see .playbackmethod
         *
         * @see PlaybackMethod
         */
        fun playbackMethod(vararg playbackMethod: Int): Builder?

        /**
         * Sets the placement type of this video impression.
         *
         * @param placement the placement of the video for this impression
         * @return this builder instance
         * @see .placement
         *
         * @see Placement
         */
        fun placement(placement: Int?): Builder?

        /**
         * Sets the linearity of this video impression.
         *
         * @param linearity the linearity of this video impression
         * @return this builder instance
         * @see .linearity
         */
        fun linearity(linearity: Int?): Builder?

        /**
         * Set the desired content delivery method.
         *
         * @param deliveryMethod the desired delivery method
         * @return this builder instance
         * @see .delivery
         *
         * @see DeliveryMethod
         */
        fun deliveryMethod(vararg deliveryMethod: Int): Builder?

        /**
         * Sets the supported api values
         *
         * @param apis set of supported api values
         * @return this builder instance
         * @see .api
         *
         * @see Api
         */
        fun apis(vararg apis: Int): Builder?
    }
}