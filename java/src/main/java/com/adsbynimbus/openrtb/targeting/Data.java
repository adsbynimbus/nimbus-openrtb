package com.adsbynimbus.openrtb.targeting;

import com.adsbynimbus.openrtb.BidRequest;

/**
 * The data and segment objects together allow additional data about the related object (e.g., user,
 * content) to be specified. This data may be from multiple sources whether from the exchange itself or
 * third parties as specified by the id field. A bid request can mix data objects from multiple providers.
 * The specific data providers in use should be published by the exchange a priori to its bidders.
 */
public interface Data {

    String ID = BidRequest.ID;
    String NAME = "name";
    String SEGMENT = "segment";

    /**
     * Builder for constructing a {@link Data} object
     */
    interface Builder {

        /**
         * Set the optional id of the data object
         *
         * @param id any string
         * @return this builder instance
         */
        Builder withId(String id);

        /**
         * Set the optional name of the data object
         *
         * @param name any string
         * @return this builder instance
         */
        Builder withName(String name);

        /**
         * Set segmenting data
         *
         * @param segments array of segments
         * @return this builder instance
         */
        Builder withSegments(Segment... segments);
    }

    /**
     * Definition of {@link Data} with all public mutable fields
     */
    class MutableData implements Data {
        public String id;
        public String name;
        public Segment[] segment;
    }
}
