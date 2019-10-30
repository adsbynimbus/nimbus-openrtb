package com.adsbynimbus.openrtb.impression;

import java.util.EnumSet;

/**
 * This object represents an in-stream video impression. Many of the fields are non-essential for minimally
 * viable transactions, but are included to offer fine control when needed. Video in OpenRTB generally
 * assumes compliance with the VAST standard. As such, the notion of companion ads is supported by
 * optionally including an array of Banner objects (refer to the Banner object in Section 3.2.6) that define
 * these companion ads.
 * The presence of a Video as a subordinate of the Imp object indicates that this impression is offered as a
 * video type impression. At the publisher’s discretion, that same impression may also be offered as
 * banner, audio, and/or native by also including as Imp subordinates objects of those types. However,
 * any given bid for the impression must conform to one of the offered types.
 */
public class Video {

    /**
     * Protocols [See ORTB 2.5 Section 5.8]
     */
    public enum Protocol {
        /**
         * Vast 2.0
         */
        VAST_2(2),

        /**
         * Vast 3.0
         */
        VAST_3(3),

        /**
         * Vast 2.0 Wrapper
         */
        VAST_2_WRAPPER(5),

        /**
         * Vast 3.0 Wrapper
         */
        VAST_3_WRAPPER(6);

        public final int value;

        Protocol(int value) {
            this.value = value;
        }
    }

    /**
     * Placements [See ORTB 2.5 Section 5.9]
     */
    public enum Placement {

        /**
         * Played before, during or after the streaming video content that the consumer has requested
         * (e.g., Pre-roll, Mid-roll, Post-roll).
         */
        IN_STREAM(1),

        /**
         * Exists within a web banner that leverages the banner space to deliver a video experience as
         * opposed to another static or rich media format. The format relies on the existence of display
         * ad inventory on the page for its delivery
         */
        IN_BANNER(2),

        /**
         * Loads and plays dynamically between paragraphs of editorial content; existing as a standalone
         * branded message
         */
        IN_ARTICLE(3),

        /**
         * Found in content, social, or product feeds.
         */
        IN_FEED(4),

        /**
         * Covers the entire or a portion of screen area, but is always on screen while displayed (i.e.
         * cannot be scrolled out of view). Note that a full-screen interstitial (e.g., in mobile) can be
         * distinguished from a floating/slider unit by the {@link Impression#instl} field.
         */
        INTERSTITIAL_SLIDER_FLOATING(5);

        public final int value;

        Placement(int value) {
            this.value = value;
        }
    }

    /**
     * Playback methods [See ORTB 2.5 Section 5.10]
     */
    public enum PlaybackMethod {

        /**
         * Initiates on Page Load with Sound On
         */
        PAGE_LOAD_SOUND_ON(1),

        /**
         * Initiates on Page Load with Sound Off by Default
         */
        PAGE_LOAD_SOUND_OFF(2),

        /**
         * Initiates on Click with Sound On
         */
        CLICK_SOUND_ON(3),

        /**
         * Initiates on Mouse-Over with Sound On
         */
        MOUSE_OVER_SOUND_ON(4),

        /**
         * Initiates on Entering Viewport with Sound On
         */
        ENTER_VIEWPORT_SOUND_ON(5),

        /**
         * Initiates on Entering Viewport with Sound Off by default
         */
        ENTER_VIEWPORT_SOUND_OFF(6);

        public final int value;

        PlaybackMethod(int value) {
            this.value = value;
        }
    }

    /**
     * Linearity
     */
    public enum Linearity {

        /**
         * Linear / In-Stream
         */
        LINEAR(1),

        /**
         * Non-Linear / Overlay
         */
        NON_LINEAR(2);

        public final int value;

        Linearity(int value) {
            this.value = value;
        }
    }

    /**
     * Content Delivery [See ORTB 2.5 Section 5.10]
     */
    public enum DeliveryMethod {

        /**
         * Streaming
         */
        STREAMING(1),

        /**
         * Progressive
         */
        PROGRESSIVE(2),

        /**
         * Download
         */
        DOWNLOAD(3);

        public final int value;

        DeliveryMethod(int value) {
            this.value = value;
        }
    }

    /**
     * Minimum bid for this video impression expressed in CPM. This value should be equal to or higher than the
     * value set on {@link Impression#bidfloor}. [Default: 3.0]
     */
    public Float bidfloor;

    /**
     * Content MIME types supported (e.g., "video/3gp", "video/mp4").
     */
    public String[] mimes;

    /**
     * Optional minimum video ad duration in seconds. [Default: 0]
     */
    public Integer minduration; // Server default 0

    /**
     * Optional maximum video ad duration in seconds. [Default: 60]
     */
    public Integer maxduration;

    /**
     * Array of supported video protocols. Refer to {@link Protocol}. At least one supported protocol must be specified
     * in this array.
     */
    public EnumSet<Protocol> protocols;

    /**
     * Width of the video player in device independent pixels (DIPS).
     */
    public int w;

    /**
     * Height of the video player in device independent pixels (DIPS).
     */
    public int h;

    /**
     * Indicates the start delay in seconds for pre-roll, mid-roll, or post-roll ad placements. > 0 Mid roll where the
     * value indicates the start delay, 0 pre roll, -1 generic mid roll, -2 generic post roll. [Default: 0]
     */
    public Integer startdelay;

    /**
     * {@link Placement} type for this video impression
     */
    public Placement placement;

    /**
     * Indicates if the impression must be linear, nonlinear, etc. If none specified, assume all are allowed.
     * Refer to {@link Linearity}.
     */
    public Linearity linearity;

    /**
     * Indicates if the player will allow the video to be skipped, where 0 = no, 1 = yes. If a bidder sends
     * markup/creative that is itself skippable, the Bid object should include the attr array with an element of
     * {@link Attribute#HAS_SKIP_BUTTON} indicating skippable video. Refer to {@link Attribute}.
     */
    public Integer skip; // optional

    /**
     * Supported delivery methods (e.g., streaming, progressive). If none specified, assume all are supported.
     * Refer to {@link DeliveryMethod}
     */
    public EnumSet<DeliveryMethod> delivery;

    /**
     * Videos of total duration greater than this number of seconds can be skippable;
     * only applicable if the ad is skippable. [Default: 0]
     */
    public Integer skipmin;

    /**
     * Optional number of seconds a video must play before skipping is enabled; only applicable if the ad is skippable.
     * [Default: 0]
     */
    public Integer skipafter;

    /**
     * Optional minimum bit rate in Kbps. [Default: 0]
     */
    public Integer minbitrate;

    /**
     * Optional maximum bit rate in Kbps. [Default: 0]
     */
    public Integer maxbitrate; // Server default 0

    /**
     * Ad position on screen. Refer to {@link Position}
     */
    public Position pos; // Optional

    /**
     * The event that causes playback to end. Refer to {@link PlaybackMethod}.
     * [Default: 2 - {@link PlaybackMethod#PAGE_LOAD_SOUND_OFF}]
     */
    public PlaybackMethod playbackmethod;

    /**
     * Set of supported API frameworks for this impression. Refer to {@link Api}. If an API is not explicitly listed,
     * it is assumed not to be supported.
     */
    public EnumSet<Api> api;

    /**
     * Builder for constructing a {@link Video} object
     */
    public interface Builder {

        /**
         * Set the position of this video impression
         *
         * @param position the position on screen
         * @return this builder instance
         * @see #pos
         */
        Builder position(Position position);

        /**
         * Set the requested mimeTypes. [Default: "video/mp4"]
         *
         * @param mimeTypes the list of requested mime types
         * @return this builder instance
         * @see #mimes
         */
        Builder mimes(String... mimeTypes);

        /**
         * Set the bid floor for this video impression [Default: 3.0]
         *
         * @param bidFloor bid floor represented in CPM[Default: 3.0]
         * @return this builder instance
         * @see #bidfloor
         */
        Builder bidFloor(float bidFloor);

        /**
         * Set a duration constraints for this video impression
         *
         * @param minDuration [Default: 0]
         * @param maxDuration [Default: 60]
         * @return this builder instance
         * @see #minduration
         * @see #maxduration
         */
        Builder duration(int minDuration, int maxDuration);

        /**
         * Set a bitrate constraints for this video impression
         *
         * @param minBitrate [Default: 0]
         * @param maxBitrate [Default: 20000]
         * @return this builder instance
         * @see #minbitrate
         * @see #maxbitrate
         */
        Builder bitrate(int minBitrate, int maxBitrate);

        /**
         * Set the video player width and height in density independent pixels
         *
         * @param width width of the video player in density independent pixels
         * @param height height of the video player in density independent pixels
         * @return {@link Builder}
         * @see #w
         * @see #h
         */
        Builder playerSize(int width, int height);

        /**
         * Set the supported protocols of this video impression
         *
         * @param protocols supported protocols [VAST_2, VAST_2_WRAPPER, VAST_3, VAST_3_WRAPPER]
         * @return this builder instance
         * @see #protocols
         */
        Builder protocols(EnumSet<Protocol> protocols);

        /**
         * Set if the video asset is skippable. Not calling this function assumes it is not skippable
         *
         * @param skipMin   - minimum duration in seconds of video length before skip is enabled
         * @param skipAfter - minimum duration video must be watched to skip
         * @return this builder instance
         * @see #skip
         * @see #skipmin
         * @see #skipafter
         */
        Builder skipEnabled(int skipMin, int skipAfter);

        /**
         * Set the start delay of this video impression
         *
         * @param startDelay -2 generic post roll, -1 generic midroll, 0 pre roll, > 0 mid roll start delay [Default: 0]
         * @return this builder instance
         * @see #startdelay
         */
        Builder startDelay(int startDelay);

        /**
         * Set the playback method of this video impression
         *
         * @param playbackMethod one of [PAGE_LOAD_SOUND_ON, PAGE_LOAD_SOUND_OFF,
         *                        CLICK_SOUND_ON, MOUSE_OVER_SOUND_ON, ENTER_VIEWPORT_SOUND_OFF,
         *                        ENTER_VIEWPORT_SOUND_ON]
         * @return this builder instance
         * @see #playbackmethod
         */
        Builder playbackMethods(PlaybackMethod playbackMethod);

        /**
         * Set the placement type of this video impression
         *
         * @param placement one of [IN_STREAM, IN_BANNER, IN_ARTICLE, IN_FEED, INTERSTITIAL_SLIDER_FLOATING]
         * @return this builder instance
         * @see #placement
         */
        Builder placement(Placement placement);

        /**
         * Set the linearity of this video request
         *
         * @param linearity 1: linear; 2: non linear
         * @return this builder instance
         * @see #linearity
         */
        Builder linearity(Linearity linearity);

        /**
         * Set the desired content delivery method
         *
         * @param deliveryMethod 1: streaming; 2: progressive; 3: download
         * @return this builder instance
         * @see #delivery
         */
        Builder deliveryMethod(EnumSet<DeliveryMethod> deliveryMethod);

        /**
         * Set the requested api values
         *
         * @param apis 1: vpaid 1; 2: vpaid 2; 3: mraid 1; 4: ormma; 5: mraid 2; 6: mraid 3
         * @return this builder instance
         * @see #api
         */
        Builder apis(EnumSet<Api> apis);
    }
}
