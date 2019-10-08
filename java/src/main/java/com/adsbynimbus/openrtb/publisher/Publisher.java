package com.adsbynimbus.openrtb.publisher;

/**
 * This object describes the publisher of the media in which the ad will be displayed. The publisher is
 * typically the seller in an OpenRTB transaction.
 */
public interface Publisher {

    String NAME = "name";
    String DOMAIN = "domain";
    String CONTENT_CATEGORIES = "cat"; // String[]

    /**
     * Builder for constructing a {@link Publisher} object
     */
    interface Builder {

    }

    /**
     * Definition of {@link Publisher} with all public mutable fields
     */
    class MutablePublisher implements Publisher {
        public String name;
        public String domain;
        public String[] cat;
    }
}