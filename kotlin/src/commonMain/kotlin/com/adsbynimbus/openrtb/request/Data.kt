package com.adsbynimbus.openrtb.request

import kotlin.jvm.JvmField

/**
 * The data and segment objects together allow additional data about the related object (e.g., user,
 * content) to be specified. This data may be from multiple sources whether from the exchange itself or
 * third parties as specified by the id field. A bid request can mix data objects from multiple providers.
 * The specific data providers in use should be published by the exchange a priori to its bidders.
 *
 * [OpenRTB Section 3.2.21](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31)
 */
open class Data {
    /**
     * Exchange-specific ID for the data provider.
     */
    @JvmField
    var id: String? = null

    /**
     * Exchange-specific name for the data provider.
     */
    @JvmField
    var name: String? = null

    /**
     * Array of [Segment] objects that contain the actual data values.
     *
     * [OpenRTB Section 3.2.22](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31)
     */
    @JvmField
    var segment: Array<Segment>? = null

    /**
     * Builder for constructing a Data object
     *
     * @see [Data]
     */
    interface Builder {
        /**
         * Sets the id of the data object.
         *
         * @param id any string
         * @return this builder instance
         * @see [Data.id]
         */
        fun id(id: String?): Builder

        /**
         * Sets the name of the data object.
         *
         * @param name any string
         * @return this builder instance
         * @see [Data.name]
         */
        fun name(name: String?): Builder

        /**
         * Sets segmenting data.
         *
         * @param segments array of segments describing this data object
         * @return this builder instance
         * @see [Data.segment]
         * @see [Segment]
         */
        fun segments(vararg segments: Segment?): Builder
    }
}