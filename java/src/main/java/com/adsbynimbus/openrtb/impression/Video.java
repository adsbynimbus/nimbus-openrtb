package com.adsbynimbus.openrtb.impression;

/**
 * This object represents an in-stream video impression. Many of the fields are non-essential for minimally viable
 * transactions, but are included to offer fine control when needed. Video in OpenRTB generally assumes compliance with
 * the VAST standard. As such, the notion of companion ads is supported by optionally including an array of
 * {@link Banner} objects that define these companion ads. The presence of a {@link Video} as a subordinate of the
 * {@link Impression} object indicates that this impression is offered as a video type impression. At the publisher’s
 * discretion, that same impression may also be offered as banner, audio, and/or native by also including as Imp
 * subordinates objects of those types. However, any given bid for the impression must conform to one of the offered
 * types.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=20">OpenRTB Section 3.2.7</a>
 */
public class Video {

    /**
     * Protocols
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52">OpenRTB Section 5.8</a>
     */
    public interface Protocol {

        /**
         * Vast 2.0
         */
        int VAST_2 = 2;

        /**
         * Vast 3.0
         */
        int VAST_3 = 3;

        /**
         * Vast 2.0 Wrapper
         */
        int VAST_2_WRAPPER = 5;

        /**
         * Vast 3.0 Wrapper
         */
        int VAST_3_WRAPPER = 6;
    }

    /**
     * Placements
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52">OpenRTB Section 5.9</a>
     */
    public interface Placement {

        /**
         * Played before, during or after the streaming video content that the consumer has requested
         * (e.g., Pre-roll, Mid-roll, Post-roll).
         */
        int IN_STREAM = 1;

        /**
         * Exists within a web banner that leverages the banner space to deliver a video experience as
         * opposed to another static or rich media format. The format relies on the existence of display
         * ad inventory on the page for its delivery
         */
        int IN_BANNER = 2;

        /**
         * Loads and plays dynamically between paragraphs of editorial content; existing as a standalone
         * branded message
         */
        int IN_ARTICLE = 3;

        /**
         * Found in content, social, or product feeds.
         */
        int IN_FEED = 4;

        /**
         * Covers the entire or a portion of screen area, but is always on screen while displayed (i.e.
         * cannot be scrolled out of view). Note that a full-screen interstitial (e.g., in mobile) can be
         * distinguished from a floating/slider unit by the {@link Impression#instl} field.
         */
        int INTERSTITIAL_SLIDER_FLOATING = 5;
    }

    /**
     * Playback methods
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=53">OpenRTB Section 5.10</a>
     */
    public interface PlaybackMethod {

        /**
         * Initiates on Page Load with Sound On
         */
        int PAGE_LOAD_SOUND_ON = 1;

        /**
         * Initiates on Page Load with Sound Off by Default
         */
        int PAGE_LOAD_SOUND_OFF = 2;

        /**
         * Initiates on Click with Sound On
         */
        int CLICK_SOUND_ON = 3;

        /**
         * Initiates on Mouse-Over with Sound On
         */
        int MOUSE_OVER_SOUND_ON = 4;

        /**
         * Initiates on Entering Viewport with Sound On
         */
        int ENTER_VIEWPORT_SOUND_ON = 5;

        /**
         * Initiates on Entering Viewport with Sound Off by default
         */
        int ENTER_VIEWPORT_SOUND_OFF = 6;
    }

    /**
     * Linearity
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52">OpenRTB Section 5.7</a>
     */
    public interface Linearity {

        /**
         * Linear / In-Stream
         */
        int LINEAR = 1;

        /**
         * Non-Linear / Overlay
         */
        int NON_LINEAR = 2;
    }

    /**
     * Content Delivery
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=53">OpenRTB Section 5.10</a>
     */
    public interface DeliveryMethod {

        /**
         * Streaming
         */
        int STREAMING = 1;

        /**
         * Progressive
         */
        int PROGRESSIVE = 2;

        /**
         * Download
         */
        int DOWNLOAD = 3;
    }

    /**
     * Minimum bid for this video impression expressed in CPM.
     * <p><br>
     * If this value is omitted Nimbus will default to 3.0
     */
    public Float bidfloor;

    /**
     * Content MIME types supported (e.g., "video/3gp", "video/mp4").
     */
    public String[] mimes;

    /**
     * Minimum video ad duration in seconds.
     * <p><br>
     * If this value is omitted Nimbus defaults to 0
     */
    public Integer minduration;

    /**
     * Maximum video ad duration in seconds.
     * <p><br>
     * If this value is omitted Nimbus defaults to 60
     */
    public Integer maxduration;

    /**
     * Set of supported video protocols
     */
    public int[] protocols;

    /**
     * Width of the video player in device independent pixels (DIPS).
     */
    public int w;

    /**
     * Height of the video player in device independent pixels (DIPS).
     */
    public int h;

    /**
     * Indicates the start delay in seconds for pre-roll, mid-roll, or post-roll ad placements.
     * <ul>
     *     <li>&gt; 0: Mid roll where the value indicates the start delay</li>
     *     <li>0: pre roll </li>
     *     <li>-1: generic mid roll</li>
     *     <li>-2: generic post roll</li>
     * </ul>
     */
    public Integer startdelay;

    /**
     * Placement type for this video impression
     */
    public Integer placement;

    /**
     * Indicates if the impression must be linear, nonlinear, etc. If none specified, assume all are allowed.
     */
    public Integer linearity;

    /**
     * Indicates if the player will allow the video to be skipped, where 0 = no, 1 = yes. If a bidder sends
     * markup/creative that is itself skippable, the Bid object should include the attr array with an element of
     * {@link CreativeAttribute#HAS_SKIP_BUTTON} indicating skippable video. Refer to {@link CreativeAttribute}.
     */
    public Integer skip;

    /**
     * Supported delivery methods; if none specified, assume all are supported.
     */
    public int[] delivery;

    /**
     * Videos of total duration greater than this number of seconds can be skippable; only applicable if the ad is
     * skippable.
     * <p><br>
     * If this value is omitted Nimbus defaults to 0
     */
    public Integer skipmin;

    /**
     * Number of seconds a video must play before skipping is enabled; only applicable if the ad is skippable.
     * <p><br>
     * If this value is omitted Nimbus defaults to 0
     */
    public Integer skipafter;

    /**
     * Minimum bit rate in Kbps.
     * <p><br>
     * If this value is omitted Nimbus defaults to 0
     */
    public Integer minbitrate;

    /**
     * Maximum bit rate in Kbps.
     * <p><br>
     * If this value is omitted Nimbus defaults to 0
     */
    public Integer maxbitrate;

    /**
     * Ad position on screen.
     */
    public Integer pos;

    /**
     * The event that causes playback to start
     */
    public int[] playbackmethod;

    /**
     * Set of supported API frameworks for this impression. If an API is not explicitly listed,
     * it is assumed not to be supported.
     */
    public int[] api;

    /**
     * Builder for constructing a Video object
     *
     * @see Video
     */
    public interface Builder {

        /**
         * Sets the position of this Video impression
         *
         * @param position the position on screen
         * @return this builder instance
         * @see #pos
         * @see Position
         */
        Builder position(Integer position);

        /**
         * Sets the supported video mimeTypes
         *
         * @param mimeTypes the list of requested mime types
         * @return this builder instance
         * @see #mimes
         */
        Builder mimes(String... mimeTypes);

        /**
         * Sets the bid floor for this Video impression
         * <p><br>
         * If this value is omitted Nimbus defaults to 3.0
         *
         * @param bidFloor bid floor represented in CPM
         * @return this builder instance
         * @see #bidfloor
         */
        Builder bidFloor(float bidFloor);

        /**
         * Sets duration constraints for this Video impression
         *
         * @param minDuration Minimum length this video impression can be
         * @param maxDuration Maximum length this video impression can be
         * @return this builder instance
         * @see #minduration
         * @see #maxduration
         */
        Builder duration(int minDuration, int maxDuration);

        /**
         * Sets a bitrate constraints for this video impression
         *
         * @param minBitrate Minimum bit rate this video impression can be
         * @param maxBitrate Maximum bit rate this video impression can be
         * @return this builder instance
         * @see #minbitrate
         * @see #maxbitrate
         */
        Builder bitrate(int minBitrate, int maxBitrate);

        /**
         * Sets the video player width and height in density independent pixels
         *
         * @param width  width of the video player in density independent pixels
         * @param height height of the video player in density independent pixels
         * @return {@link Builder}
         * @see #w
         * @see #h
         */
        Builder playerSize(int width, int height);

        /**
         * Sets the supported protocols of this video impression
         *
         * @param protocols a set of supported protocols
         * @return this builder instance
         * @see #protocols
         * @see Protocol
         */
        Builder protocols(int... protocols);

        /**
         * Sets if the video is skippable. Not calling this function assumes it is not skippable.
         *
         * @param skipMin   minimum duration in seconds of video length before skip is enabled
         * @param skipAfter minimum duration video must be watched to skip
         * @return this builder instance
         * @see #skip
         * @see #skipmin
         * @see #skipafter
         */
        Builder skipEnabled(int skipMin, int skipAfter);

        /**
         * Sets the start delay of this video impression
         *
         * @param startDelay start delay in seconds
         * @return this builder instance
         * @see #startdelay
         */
        Builder startDelay(int startDelay);

        /**
         * Sets the playback method of this video impression.
         *
         * @param playbackMethod the method that starts the video playback
         * @return this builder instance
         * @see #playbackmethod
         * @see PlaybackMethod
         */
        Builder playbackMethod(int... playbackMethod);

        /**
         * Sets the placement type of this video impression.
         *
         * @param placement the placement of the video for this impression
         * @return this builder instance
         * @see #placement
         * @see Placement
         */
        Builder placement(Integer placement);

        /**
         * Sets the linearity of this video impression.
         *
         * @param linearity the linearity of this video impression
         * @return this builder instance
         * @see #linearity
         */
        Builder linearity(Integer linearity);

        /**
         * Set the desired content delivery method.
         *
         * @param deliveryMethod the desired delivery method
         * @return this builder instance
         * @see #delivery
         * @see DeliveryMethod
         */
        Builder deliveryMethod(int... deliveryMethod);

        /**
         * Sets the supported api values
         *
         * @param apis set of supported api values
         * @return this builder instance
         * @see #api
         * @see Api
         */
        Builder apis(int... apis);
    }
}
