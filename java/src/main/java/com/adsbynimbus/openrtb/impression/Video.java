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
        VAST_2(2),
        VAST_3(3),
        VAST_2_WRAPPER(5),
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
        IN_STREAM(1),
        IN_BANNER(2),
        IN_ARTICLE(3),
        IN_FEED(4),
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
        PAGE_LOAD_SOUND_ON(1),
        PAGE_LOAD_SOUND_OFF(2),
        CLICK_SOUND_ON(3),
        MOUSE_OVER_SOUND_ON(4),
        ENTER_VIEWPORT_SOUND_ON(5),
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
        LINEAR(1),
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
        STREAMING(1),
        PROGRESSIVE(2),
        DOWNLOAD(3);

        public final int value;

        DeliveryMethod(int value) {
            this.value = value;
        }
    }

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

    public Float bidfloor; // Server default 3
    public String[] mimes;
    public Integer minduration; // Server default 0
    public Integer maxduration; // Server default 60
    public EnumSet<Protocol> protocols;
    public int w;
    public int h;
    public Integer startdelay; // Server default 0;
    public Placement placement;
    public Linearity linearity;
    public Integer skip; // optional
    public EnumSet<DeliveryMethod> delivery;
    public Integer skipmin; // Server default 0
    public Integer skipafter; // Server default 0
    public Integer minbitrate; // Server default 0
    public Integer maxbitrate; // Server default 0
    public Position pos; // Optional
    public PlaybackMethod playbackmethod; // Server default 2;
    public EnumSet<Api> api;

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
        Builder position(Position position);

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
         * @param width width of the video player in density independent pixels
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
        Builder protocols(EnumSet<Protocol> protocols);

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
         *                        CLICK_SOUND_ON, MOUSE_OVER_SOUND_ON, ENTER_VIEWPORT_SOUND_OFF,
         *                        ENTER_VIEWPORT_SOUND_ON]
         * @return this builder instance
         */
        Builder playbackMethods(PlaybackMethod playbackMethod);

        /**
         * Set the placement type of this video impression
         *
         * @param placement [IN_STREAM, IN_BANNER, IN_ARTICLE, IN_FEED, INTERSTITIAL_SLIDER_FLOATING]
         * @return this builder instance
         */
        Builder placement(Placement placement);

        /**
         * Set the linearity of the video request
         *
         * @param linearity 1: linear; 2: non linear
         * @return this builder instance
         */
        Builder linearity(Linearity linearity);

        /**
         * Set the desired content delivery method
         *
         * @param deliveryMethod 1: streaming; 2: progressive; 3: download
         * @return this builder instance
         */
        Builder deliveryMethod(EnumSet<DeliveryMethod> deliveryMethod);

        /**
         * Set the requested api values
         *
         * @param apis 1: vpaid 1; 2: vpaid 2; 3: mraid 1; 4: ormma; 5: mraid 2; 6: mraid 3
         * @return this builder instance
         */
        Builder apis(EnumSet<Api> apis);
    }
}
