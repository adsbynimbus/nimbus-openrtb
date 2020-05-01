package com.adsbynimbus.openrtb.request;

import org.jetbrains.annotations.NotNull;

/**
 * Segment objects are essentially key-value pairs that convey specific units of data. The parent Data
 * object is a collection of such values from a given data provider. The specific segment names and value
 * options must be published by the exchange a priori to its bidders.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31">OpenRTB Section 3.2.22</a>
 */
public class Segment {

    /**
     * ID of the data segment specific to the data provider.
     */
    public String id;

    /**
     * Name of the data segment specific to the data provider.
     */
    public String name;

    /**
     * String representation of the data segment value.
     */
    public String value;

    /**
     * Builder for constructing a Segment object
     *
     * @see Segment
     */
    public interface Builder {

        /**
         * Sets the id of this segment object.
         *
         * @param id any string representing the id of this segment
         * @return this builder instance
         * @see #id
         */
        @NotNull
        Builder id(@NotNull String id);

        /**
         * Sets the name of this segment.
         *
         * @param name any string representing the name of this segment
         * @return this builder instance
         * @see #name
         */
        @NotNull
        Builder name(@NotNull String name);

        /**
         * Sets the value of this segment.
         *
         * @param value any string representing this segment value
         * @return this builder instance
         * @see #value
         */
        @NotNull
        Builder value(@NotNull String value);
    }
}