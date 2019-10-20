package com.adsbynimbus.openrtb.targeting.distribution;

/**
 * This object describes the publisher of the media in which the ad will be displayed. The publisher is
 * typically the seller in an OpenRTB transaction.
 */
public interface Publisher {

    /**
     * Builder for constructing a {@link Publisher} object
     */
    interface Builder {

        /**
         * Set the IAB categories of this publisher
         *
         * @param categories
         * @return this builder instance
         */
        Builder categories(String... categories);

        /**
         * Set the name of this publisher
         *
         * @param name
         * @return this builder instance
         */
        Builder name(String name);

        /**
         * Set the domain of this publisher
         *
         * @param domain
         * @return this builder instance
         */
         Builder domain(String domain);
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