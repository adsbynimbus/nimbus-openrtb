package com.adsbynimbus.openrtb.targeting;

import com.adsbynimbus.openrtb.BidRequest;

/**
 * The data and segment objects together allow additional data about the related object (e.g., user,
 * content) to be specified. This data may be from multiple sources whether from the exchange itself or
 * third parties as specified by the id field. A bid request can mix data objects from multiple providers.
 * The specific data providers in use should be published by the exchange a priori to its bidders.
 */
public class Data {

    public static final String ID = BidRequest.ID;
    public static final String NAME = "name";
    public static final String SEGMENT = "segment";

    public String id;
    public String name;
    public Segment[] segment;

    /**
     * Builder for constructing a {@link Data} object
     */
    public interface Builder {

        /**
         * Set the optional id of the data object
         *
         * @param id any string
         * @return this builder instance
         */
        Builder id(String id);

        /**
         * Set the optional name of the data object
         *
         * @param name any string
         * @return this builder instance
         */
        Builder name(String name);

        /**
         * Set segmenting data
         *
         * @param segments array of segments
         * @return this builder instance
         */
        Builder segments(Segment... segments);
    }
}
