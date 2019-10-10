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
         * Set categories
         *
         * @param categories
         * @return this builder instance
         */
        Builder withCategories(String... categories);

        /**
         * Set the publisher name
         *
         * @param name
         * @return this builder instance
         */
        Builder withName(String name);

        /**
         * Set the publisher domain
         *
         * @param domain
         * @return this builder instance
         */
         Builder withDomain(String domain);
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