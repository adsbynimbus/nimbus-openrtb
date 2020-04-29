package com.adsbynimbus.openrtb.targeting;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The data and segment objects together allow additional data about the related object (e.g., user,
 * content) to be specified. This data may be from multiple sources whether from the exchange itself or
 * third parties as specified by the id field. A bid request can mix data objects from multiple providers.
 * The specific data providers in use should be published by the exchange a priori to its bidders.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31">OpenRTB Section 3.2.21</a>
 */
public class Data {

    /**
     * Exchange-specific ID for the data provider.
     */
    @Nullable
    public String id;

    /**
     * Exchange-specific name for the data provider.
     */
    @Nullable
    public String name;

    /**
     * Array of {@link Segment}  objects that contain the actual data values.
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31">OpenRTB Section 3.2.22</a>
     */
    public Segment[] segment;

    /**
     * Builder for constructing a Data object
     *
     * @see Data
     */
    public interface Builder {

        /**
         * Sets the id of the data object.
         *
         * @param id any string
         * @return this builder instance
         * @see #id
         */
        @NotNull
        Builder id(@NotNull String id);

        /**
         * Sets the name of the data object.
         *
         * @param name any string
         * @return this builder instance
         * @see #name
         */
        @NotNull
        Builder name(@NotNull String name);

        /**
         * Sets segmenting data.
         *
         * @param segments array of segments describing this data object
         * @return this builder instance
         * @see #segment
         * @see Segment
         */
        @NotNull
        Builder segments(@NotNull Segment... segments);
    }
}
