package com.adsbynimbus.openrtb.targeting;

/**
 * Segment objects are essentially key-value pairs that convey specific units of data. The parent Data
 * object is a collection of such values from a given data provider. The specific segment names and value
 * options must be published by the exchange a priori to its bidders.
 */
public class Segment {

    public static final String VALUE = "value";

    public String id;
    public String name;
    public String value;

    /**
     * Builder for constructing a {@link Segment} object
     */
    public interface Builder {
        /**
         * Set the id of the segment object
         *
         * @param id any string
         * @return this builder instance
         */
        Builder id(String id);

        /**
         * Set the name of the segment
         *
         * @param name any string
         * @return this builder instance
         */
        Builder name(String name);

        /**
         * Set the value of the segment
         *
         * @param value any string
         * @return this builder instance
         */
        Builder value(String value);
    }
}
