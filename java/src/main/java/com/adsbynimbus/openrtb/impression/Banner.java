package com.adsbynimbus.openrtb.impression;

/**
 * This object represents the most general type of impression. Although the term "banner" may have very
 * specific meaning in other contexts, here it can be many things including a simple static image, an
 * expandable ad unit, or even in-banner video (refer to the Video object in Section 3.2.7 for the more
 * generalized and full featured video ad units). An array of Banner objects can also appear within the
 * Video to describe optional companion ads defined in the VAST specification.
 * The presence of a Banner as a subordinate of the Imp object indicates that this impression is offered as
 * a banner type impression. At the publisher’s discretion, that same impression may also be offered as
 * video, audio, and/or native by also including as Imp subordinates objects of those types. However, any
 * given bid for the impression must conform to one of the offered types.
 */
public interface Banner extends Creative {

    String BLOCKED_ATTRIBUTES = "battr";

    /**
     * Builder for constructing a {@link Banner} object
     */
    interface Builder {

        /**
         * Set the requested formats of the ad.
         *
         * @param formats
         * @return this builder instance
         */
        Builder withFormats(Format... formats);

        /**
         * Set the device size in pixels independent of density
         *
         * @param width
         * @param height
         * @return this builder instance
         */
        Builder withDeviceIndependentSize(int width, int height);

        /**
         * Set the position of the Ad Unit.
         *
         * @param position
         * @return this builder instance
         */
        Builder withPosition(int position);

        /**
         * Set the bid floor. [Default 2.0]
         *
         * @param bidFloor
         * @return this builder instance
         */
         Builder withBidFloor(float bidFloor);

        /**
         * Set the supported creative types
         *
         * @param apis [VPAID_2, MRAID_1, MRAID_2, MRAID_3]
         * @return this builder instance
         */
        Builder withSupportedApis(int...apis);

        /**
         * Set blocked creative attributes
         *
         * @param attributes
         * @return this builder instance
         */
        Builder withBlockedAttributes(int... attributes);
    }

    /**
     * Definition of {@link Banner} with all public mutable fields
     */
    class MutableBanner implements Banner {
        public Float bidfloor; // Server default is 2.0
        public Format[] format;
        public Integer w;
        public Integer h;
        public Integer pos;
        public int[] api;
    }
}
