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
public class Banner {

    public Float bidfloor; // Server default is 2.0
    public int[] battr;
    public Format[] format;
    public Integer w;
    public Integer h;
    public Integer pos;
    public int[] api;

    /**
     * Builder for constructing a {@link Banner} object
     */
    public interface Builder {

        /**
         * Set the requested formats of this banner impression. If this method is not called you must call
         * {@link Builder#size(int, int)}
         *
         * @param format a permitted size for this banner impression
         * @return this builder instance
         */
        Builder format(Format... format);

        /**
         * Set the exact size of this banner impression. Use of {@link Builder#format(Format...)} is recommended
         *
         * @param width exact width in density independent pixels of the requested banner
         * @param height exact height in density independent pixels of the requested banner
         * @return this builder instance
         */
        Builder size(int width, int height);

        /**
         * Set the position of the banner impression on the screen
         *
         * @param position
         * @return this builder instance
         */
        Builder position(int position);

        /**
         * Set the bid floor of this banner impression [Default 2.0]
         *
         * @param bidFloor
         * @return this builder instance
         */
         Builder bidFloor(float bidFloor);

        /**
         * Set the supported apis for this banner impression
         *
         * @param apis [VPAID_2, MRAID_1, MRAID_2, MRAID_3]
         * @return this builder instance
         */
        Builder apis(int... apis);

        /**
         * Set creative attributes that should be blocked
         *
         * @param battr
         * @return this builder instance
         */
        Builder blockedAttributes(int... battr);
    }
}
