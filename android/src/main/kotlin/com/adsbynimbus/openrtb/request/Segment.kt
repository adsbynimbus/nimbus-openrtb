package com.adsbynimbus.openrtb.request

/**
 * Segment objects are essentially key-value pairs that convey specific units of data.
 *
 * The parent Data object is a collection of such values from a given data provider. The specific segment names and value
 * options must be published by the exchange a priori to its bidders.
 *
 * [OpenRTB Section 3.2.22](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31)
 * @see [Data]
 */
open class Segment {
    /**
     * ID of the data segment specific to the data provider.
     */
    @JvmField
    var id: String? = null

    /**
     * Name of the data segment specific to the data provider.
     */
    @JvmField
    var name: String? = null

    /**
     * String representation of the data segment value.
     */
    @JvmField
    var value: String? = null

    /**
     * Builder for constructing a Segment object
     *
     * @see [Segment]
     */
    interface Builder {
        /**
         * Sets the id of this segment object.
         *
         * @param id any string representing the id of this segment
         * @return this builder instance
         * @see [Segment.id]
         */
        fun id(id: String?): Builder

        /**
         * Sets the name of this segment.
         *
         * @param name any string representing the name of this segment
         * @return this builder instance
         * @see [Segment.name]
         */
        fun name(name: String?): Builder

        /**
         * Sets the value of this segment.
         *
         * @param value any string representing this segment value
         * @return this builder instance
         * @see [Segment.value]
         */
        fun value(value: String?): Builder
    }
}