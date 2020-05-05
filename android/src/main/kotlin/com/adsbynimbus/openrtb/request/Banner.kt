package com.adsbynimbus.openrtb.request

/**
 * This object represents the most general type of impression. Although the term "banner" may have very
 * specific meaning in other contexts, here it can be many things including a simple static image, an
 * expandable ad unit, or even in-banner video (refer to [Video] for generalized and full featured video
 * ad units). An array of [Banner] objects can also appear within the [Video] to describe optional
 * companion ads defined in the VAST specification. The presence of a [Banner] as a subordinate of the
 * [Impression] object indicates that this impression is offered as a banner type impression. At the publisher’s
 * discretion, that same impression may also be offered as video, audio, and/or native by also including as
 * [Impression] subordinates objects of those types. However, any given bid for the impression must conform to one
 * of the offered types.
 *
 * @see [OpenRTB Section 3.2.6](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=19)
 */
class Banner {

    /**
     * Minimum bid for this banner impression expressed in CPM. This value should be equal to or higher than the
     * value set on the [Impression] object.
     *
     * If this value is omitted Nimbus will default to 2.0
     */
    @JvmField
    var bidfloor: Float? = null

    /**
     * Set of creative attributes to block
     */
    @JvmField
    var battr: IntArray? = null

    /**
     * Array of Format objects representing the banner sizes permitted. If none are specified, then use of the
     * h and w attributes is required.
     */
    @JvmField
    var format: Array<Format>? = null

    /**
     * Exact width in device independent pixels (DIPS); required if the [Format] array is not specified or if this
     * object is configured for a banner size such as 320x50 or 300x50
     */
    @JvmField
    var w: Int? = null

    /**
     * Exact height in device independent pixels (DIPS); required if the [Banner] array are specified or if this
     * object is configured for a banner size such as 320x50 or 300x50
     */
    @JvmField
    var h: Int? = null

    /**
     * Ad position on screen
     */
    @JvmField
    var pos: Int? = null

    /**
     * Set of supported Api frameworks for this banner impression. If an Api is not explicitly listed,
     * it is assumed not to be supported.
     */
    @JvmField
    var api: IntArray? = null

    /**
     * Builder for constructing a Banner object
     *
     * @see Banner
     */
    interface Builder {
        /**
         * Sets the requested format of this banner impression. If this method is not called you must call
         * [Builder.size]
         *
         * @param format a permitted size for this banner impression
         * @return this builder instance
         * @see .format
         */
        fun format(vararg format: Format?): Builder?

        /**
         * Sets the exact size of this banner impression. Use of [Builder.format] is recommended
         *
         * @param width exact width in density independent pixels of the requested banner
         * @param height exact height in density independent pixels of the requested banner
         * @return this builder instance
         * @see .w
         *
         * @see .h
         */
        fun size(width: Int, height: Int): Builder?

        /**
         * Sets the position of this banner impression on the screen
         *
         * @param position position of this banner impression
         * @return this builder instance
         * @see .pos
         */
        fun position(position: Int): Builder?

        /**
         * Sets the bid floor of this banner impression
         *
         * @param bidFloor bid floor as expressed in CPM.
         * @return this builder instance
         * @see .bidfloor
         */
        fun bidFloor(bidFloor: Float): Builder?

        /**
         * Sets the supported apis for this banner impression.
         *
         * @param apis set of supported apis.
         * @return this builder instance
         * @see .api
         */
        fun apis(vararg apis: Int): Builder?

        /**
         * Sets creative attributes that should be blocked for this request
         *
         * @param battr set of creative attributes that should be blocked for this banner impression
         * @return this builder instance
         * @see .battr
         */
        fun blockedAttributes(vararg battr: Int): Builder?
    }
}