package com.adsbynimbus.openrtb.impression;

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
    public interface Protocol {
        int VAST_2 = 2;
        int VAST_3 = 3;
        int VAST_2_WRAPPER = 5;
        int VAST_3_WRAPPER = 6;
    }

    /**
     * Placements [See ORTB 2.5 Section 5.9]
     */
    public interface Placement {
        int IN_STREAM = 1;
        int IN_BANNER = 2;
        int IN_ARTICLE = 3;
        int IN_FEED = 4;
        int INTERSTITIAL_SLIDER_FLOATING = 5;
    }

    /**
     * Playback methods [See ORTB 2.5 Section 5.10]
     */
    public interface PlaybackMethod {
        int PAGE_LOAD_SOUND_ON = 1;
        int PAGE_LOAD_SOUND_OFF = 2;
        int CLICK_SOUND_ON = 3;
        int MOUSE_OVER_SOUND_ON = 4;
        int ENTER_VIEWPORT_SOUND_ON = 5;
        int ENTER_VIEWPORT_SOUND_OFF = 6;
    }

    /**
     * Linearity
     */
    public interface Linearity {
        int LINEAR = 1;
        int NON_LINEAR = 2;
    }

    /**
     * Content Delivery [See ORTB 2.5 Section 5.10]
     */
    public interface DeliveryMethod {
        int STREAMING = 1;
        int PROGRESSIVE = 2;
        int DOWNLOAD = 3;
    }

    public Float bidfloor; // Server default 3
    public String[] mimes;
    public Integer minduration; // Server default 0
    public Integer maxduration; // Server default 60
    public int[] protocols;
    public int w;
    public int h;
    public Integer startdelay; // Server default 0;
    public Integer placement;
    public Integer linearity;
    public Integer skip; // optional
    public int[] delivery;
    public Integer skipmin; // Server default 0
    public Integer skipafter; // Server default 0
    public Integer minbitrate; // Server default 0
    public Integer maxbitrate; // Server default 0
    public Integer pos; // Optional
    public Integer playbackmethod; // Server default 2;
    public int[] api;

    /**
     * Builder for constructing a {@link Video} object
     */
    public interface Builder {

        /**
         * Set the position of the Ad Unit
         *
         * @param position
         * @return this builder instance
         */
        Builder position(Integer position);

        /**
         * Set the requested mimeTypes. [Default: "video/mp4"]
         *
         * @param mimeTypes
         * @return this builder instance
         */
        Builder mimes(String... mimeTypes);

        /**
         * Set the bid floor for this video impression [Default: 3.0]
         *
         * @param bidFloor bid floor [Default: 3.0]
         * @return this builder instance
         */
        Builder bidFloor(float bidFloor);

        /**
         * Set a duration constraint for this video impression
         *
         * @param minDuration [Default: 0]
         * @param maxDuration [Default: 60]
         * @return this builder instance
         */
        Builder duration(int minDuration, int maxDuration);

        /**
         * Set a bitrate constraint for this video impression
         *
         * @param minBitrate [Default: 0]
         * @param maxBitrate [Default: 20000]
         * @return this builder instance
         */
        Builder bitrate(int minBitrate, int maxBitrate);

        /**
         * Set the video player width and height
         *
         * @param width  width of the video player in density independent pixels
         * @param height height of the video player in density independent pixels
         * @return {@link Builder}
         */
        Builder playerSize(int width, int height);

        /**
         * Set the supported protocols of this video impression
         *
         * @param protocols [VAST_2, VAST_2_WRAPPER, VAST_3, VAST_3_WRAPPER]
         * @return this builder instance
         */
        Builder protocols(int... protocols);

        /**
         * Set if the video asset is skippable. Not calling this function assumes it is not skippable
         *
         * @param skipMin   - minimum duration in seconds of video length before skip is enabled
         * @param skipAfter - minimum duration video must be watched to skip
         * @return this builder instance
         */
        Builder skipEnabled(int skipMin, int skipAfter);

        /**
         * Set the start delay of this video impression
         *
         * @param startDelay [Default: 0]
         * @return this builder instance
         */
        Builder startDelay(int startDelay);

        /**
         * Set the playback method of this video impression
         *
         * @param playbackMethod [PAGE_LOAD_SOUND_ON, PAGE_LOAD_SOUND_OFF,
         *                       CLICK_SOUND_ON, MOUSE_OVER_SOUND_ON, ENTER_VIEWPORT_SOUND_OFF,
         *                       ENTER_VIEWPORT_SOUND_ON]
         * @return this builder instance
         */
        Builder playbackMethod(Integer playbackMethod);

        /**
         * Set the placement type of this video impression
         *
         * @param placement [IN_STREAM, IN_BANNER, IN_ARTICLE, IN_FEED, INTERSTITIAL_SLIDER_FLOATING]
         * @return this builder instance
         */
        Builder placement(Integer placement);

        /**
         * Set the linearity of the video request
         *
         * @param linearity 1: linear; 2: non linear
         * @return this builder instance
         */
        Builder linearity(Integer linearity);

        /**
         * Set the desired content delivery method
         *
         * @param deliveryMethod 1: streaming; 2: progressive; 3: download
         * @return this builder instance
         */
        Builder deliveryMethod(int... deliveryMethod);

        /**
         * Set the requested api values
         *
         * @param apis 1: vpaid 1; 2: vpaid 2; 3: mraid 1; 4: ormma; 5: mraid 2; 6: mraid 3
         * @return this builder instance
         */
        Builder apis(int... apis);
    }
}
