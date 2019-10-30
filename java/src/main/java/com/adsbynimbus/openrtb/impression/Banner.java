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
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=14">OpenRTB Section 3.2.6</a>
 */
public class Banner {

    /**
     * Minimum bid for this banner impression expressed in CPM. This value should be equal to or higher than the
     * value set on {@link Impression#bidfloor}. [Default: 2.0]
     */
    public Float bidfloor; // Server default is 2.0

    /**
     * Blocked creative attributes. Refer to {@link CreativeAttribute}
     */
    public int[] battr;

    /**
     * Array of {@link Format} objects (Section 3.2.10) representing the banner sizes permitted. If none are specified,
     * then use of the h and w attributes is required.
     */
    public Format[] format;

    /**
     * Exact width in device independent pixels (DIPS); required if no format objects are specified or if this
     * Banner object is configured for a banner size such as 320x50 or 300x50
     */
    public Integer w;

    /**
     * Exact height in device independent pixels (DIPS); required if no format objects are specified or if this
     * Banner object is configured for a banner size such as 320x50 or 300x50
     */
    public Integer h;

    /**
     * Ad position on screen. Refer to {@link Position}
     */
    public Integer pos;

    /**
     * List of supported API frameworks for this impression. Refer to {@link Api}. If an api is not explicitly listed,
     * it is assumed not to be supported.
     */
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
         * @see #format
         */
        Builder format(Format... format);

        /**
         * Set the exact size of this banner impression. Use of {@link Builder#format(Format...)} is recommended
         *
         * @param width exact width in density independent pixels of the requested banner
         * @param height exact height in density independent pixels of the requested banner
         * @return this builder instance
         * @see #w
         * @see #h
         */
        Builder size(int width, int height);

        /**
         * Set the position of this banner impression on the screen
         *
         * @param position position of this banner impression
         * @return this builder instance
         * @see #pos
         */
        Builder position(int position);

        /**
         * Set the bid floor of this banner impression [Default 2.0]
         *
         * @param bidFloor bid floor as expressed in CPM.
         * @return this builder instance
         * @see #bidfloor
         */
         Builder bidFloor(float bidFloor);

        /**
         * Set the supported apis for this banner impression. Nimbus supports [VPAID_2, MRAID_1, MRAID_2, MRAID_3]
         *
         * @param apis set of supported apis. Nimbus supports [VPAID_2, MRAID_1, MRAID_2, MRAID_3]
         * @return this builder instance
         * @see #api
         */
        Builder apis(int... apis);

        /**
         * Set creative attributes that should be blocked for this request
         *
         * @param battr set of creative attributes that should be blocked from this banner request.
         * @return this builder instance
         * @see #battr
         */
        Builder blockedAttributes(int... battr);
    }
}
