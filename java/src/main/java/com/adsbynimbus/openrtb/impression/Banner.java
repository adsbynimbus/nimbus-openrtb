package com.adsbynimbus.openrtb.impression;

import java.util.EnumSet;

/**
 * This object represents the most general type of impression. Although the term "banner" may have very
 * specific meaning in other contexts, here it can be many things including a simple static image, an
 * expandable ad unit, or even in-banner video (refer to {@link Video} for generalized and full featured video
 * ad units). An array of {@link Banner} objects can also appear within the {@link Video} to describe optional
 * companion ads defined in the VAST specification. The presence of a {@link Banner} as a subordinate of the
 * {@link Impression} object indicates that this impression is offered as a banner type impression. At the publisher’s
 * discretion, that same impression may also be offered as video, audio, and/or native by also including as
 * {@link Impression} subordinates objects of those types. However, any given bid for the impression must conform to one
 * of the offered types.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=19">OpenRTB Section 3.2.6</a>
 */
public class Banner {

    /**
     * <p>
     * Minimum bid for this banner impression expressed in CPM. This value should be equal to or higher than the
     * value set on the {@link Impression} object.
     * <p><br>
     * If this value is omitted Nimbus will default to 2.0
     */
    public Float bidfloor;

    /**
     * Set of creative attributes to block
     */
    public EnumSet<CreativeAttribute> battr;

    /**
     * Array of Format objects representing the banner sizes permitted. If none are specified, then use of the
     * h and w attributes is required.
     */
    public Format[] format;

    /**
     * Exact width in device independent pixels (DIPS); required if the {@link Format} array is not specified or if this
     * object is configured for a banner size such as 320x50 or 300x50
     */
    public Integer w;

    /**
     * Exact height in device independent pixels (DIPS); required if the {@link Banner} array are specified or if this
     * object is configured for a banner size such as 320x50 or 300x50
     */
    public Integer h;

    /**
     * Ad position on screen
     */
    public Position pos;

    /**
     * Set of supported Api frameworks for this banner impression. If an Api is not explicitly listed,
     * it is assumed not to be supported.
     */
    public EnumSet<Api> api;

    /**
     * Builder for constructing a Banner object
     *
     * @see Banner
     */
    public interface Builder {

        /**
         * Sets the requested format of this banner impression. If this method is not called you must call
         * {@link Builder#size(int, int)}
         *
         * @param format a permitted size for this banner impression
         * @return this builder instance
         * @see #format
         */
        Builder format(Format... format);

        /**
         * Sets the exact size of this banner impression. Use of {@link Builder#format(Format...)} is recommended
         *
         * @param width exact width in density independent pixels of the requested banner
         * @param height exact height in density independent pixels of the requested banner
         * @return this builder instance
         * @see #w
         * @see #h
         */
        Builder size(int width, int height);

        /**
         * Sets the position of this banner impression on the screen
         *
         * @param position position of this banner impression
         * @return this builder instance
         * @see #pos
         */
        Builder position(Position position);

        /**
         * Sets the bid floor of this banner impression
         *
         * @param bidFloor bid floor as expressed in CPM.
         * @return this builder instance
         * @see #bidfloor
         */
         Builder bidFloor(float bidFloor);

        /**
         * Sets the supported apis for this banner impression.
         *
         * @param apis set of supported apis.
         * @return this builder instance
         * @see #api
         */
        Builder apis(EnumSet<Api> apis);

        /**
         * Sets creative attributes that should be blocked for this request
         *
         * @param battr set of creative attributes that should be blocked for this banner impression
         * @return this builder instance
         * @see #battr
         */
        Builder blockedAttributes(EnumSet<CreativeAttribute> battr);
    }
}
