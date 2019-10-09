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
public interface Video extends Creative {

    /* Protocols [See ORTB 2.5 Section 5.8] */
    int VAST_2 = 2;
    int VAST_3 = 3;
    int VAST_2_WRAPPER = 5;
    int VAST_3_WRAPPER = 6;

    /* Placements [See ORTB 2.5 Section 5.9] */
    int IN_STREAM = 1;
    int IN_BANNER = 2;
    int IN_ARTICLE = 3;
    int IN_FEED = 4;
    int INTERSTITIAL_SLIDER_FLOATING = 5;

    /* Playback methods [See ORTB 2.5 Section 5.10] */
    int PAGE_LOAD_SOUND_ON = 1;
    int PAGE_LOAD_SOUND_OFF = 2;
    int CLICK_SOUND_ON = 3;
    int MOUSE_OVER_SOUND_ON = 4;
    int ENTER_VIEWPORT_SOUND_ON = 5;
    int ENTER_VIEWPORT_SOUND_OFF = 6;

    /* Linearity */
    int LINEAR = 1;
    int NON_LINEAR = 2;

    /* Content Delivery [See ORTB 2.5 Section 5.10] */
    int STREAMING = 1;
    int PROGRESSIVE = 2;
    int DOWNLOAD = 3;

    /* Property Names */
    String DELIVERY = "delivery";
    String LINEARITY = "linearity"; // int 1: linear; 2: non linear
    String MIN_DURATION = "minduration"; // int default 0
    String MAX_DURATION = "maxduration"; // int default 60
    String PROTOCOLS = "protocols"; // int[]
    String PLACEMENT = "placement";
    String START_DELAY = "startdelay"; // int default 0
    String SKIP = "skip"; // int (0 = no, 1 = can skip)
    String SKIP_MIN = "skipmin"; //int default 0;
    String SKIP_AFTER = "skipafter"; //int default 0;
    String MIN_BITRATE = "minbitrate"; // int default 0;
    String MAX_BITRATE = "maxbitrate"; // int default 20000
    String PLAYBACK_METHOD = "playbackmethod"; // int default 2

    /**
     * Builder for constructing a {@link Video} object
     */
    interface Builder {

        /**
         * Set the position of the Ad Unit
         *
         * @param position
         * @return this builder instance
         */
        Builder withPosition(int position);

        /**
         * Set the requested mimeTypes. [Default: "video/mp4"]
         *
         * @param mimeTypes
         * @return this builder instance
         */
        Builder withMimes(String... mimeTypes);

        /**
         * Set the bid floor. [Default: 3.0]
         *
         * @param bidFloor bid floor [Default: 3.0]
         * @return this builder instance
         */
        Builder withBidFloor(float bidFloor);

        /**
         * Set a duration constraint for a {@link Video} impression
         *
         * @param minDuration [Default: 0]
         * @param maxDuration [Default: 60]
         * @return this builder instance
         */
        Builder withDurationConstraint(int minDuration, int maxDuration);

        /**
         * Set a bitrate constraint for a {@link Video} impression
         *
         * @param minBitrate [Default: 0]
         * @param maxBitrate [Default: 20000]
         * @return this builder instance
         */
        Builder withBitrateConstraint(int minBitrate, int maxBitrate);

        /**
         * Set the device width and height
         *
         * @param width  device width in absolute pixels
         * @param height device height in absolute pixels
         * @return {@link Builder}
         */
        Builder withDeviceSize(int width, int height);

        /**
         * Set the supported protocols
         *
         * @param protocols [VAST_2, VAST_2_WRAPPER, VAST_3, VAST_3_WRAPPER]
         * @return this builder instance
         */
        Builder withProtocols(int... protocols);

        /**
         * Set if the video asset is skippable. Not calling this function assumes it is not skippable
         *
         * @param skipMin   - minimum duration in seconds of video length before skip is enabled
         * @param skipAfter - minimum duration video must be watched to skip
         * @return this builder instance
         */
        Builder withSkipEnabled(int skipMin, int skipAfter);

        /**
         * Set video start delay
         *
         * @param startDelay [Default: 0]
         * @return this builder instance
         */
        Builder withStartDelay(int startDelay);

        /**
         * Set the playback method.
         *
         * @param playbackMethods [PAGE_LOAD_SOUND_ON, PAGE_LOAD_SOUND_OFF,
         *                        CLICK_SOUND_ON, MOUSE_OVER_SOUND_ON, ENTER_VIEWPORT_SOUND_OFF,
         *                        ENTER_VIEWPORT_SOUND_ON]
         * @return this builder instance
         */
        Builder withPlaybackMethods(int... playbackMethods);

        /**
         * Set the placement of the ad
         *
         * @param placement [IN_STREAM, IN_BANNER, IN_ARTICLE, IN_FEED, INTERSTITIAL_SLIDER_FLOATING]
         * @return this builder instance
         */
        Builder withPlacement(int placement);

        /**
         * Set the linearity of the video request
         *
         * @param linearity 1: linear; 2: non linear
         * @return this builder instance
         */
        Builder withLinearity(int linearity);

        /**
         * Set the desired content delivery method
         *
         * @param deliveryMethod 1: streaming; 2: progressive; 3: download
         * @return this builder instance
         */
        Builder withDeliveryMethod(int... deliveryMethod);

        /**
         * Set the requested api values
         *
         * @param apis 1: vpaid 1; 2: vpaid 2; 3: mraid 1; 4: ormma; 5: mraid 2; 6: mraid 3
         * @return this builder instance
         */
        Builder withApis(int... apis);
    }

    /**
     * Definition of {@link Video} with all public mutable fields
     */
    class MutableVideo implements Video {
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
    }
}
