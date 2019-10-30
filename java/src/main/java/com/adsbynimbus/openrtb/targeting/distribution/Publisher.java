package com.adsbynimbus.openrtb.targeting.distribution;

/**
 * This object describes the publisher of the media in which the ad will be displayed. The publisher is
 * typically the seller in an OpenRTB transaction.
 */
public class Publisher {

    /**
     * Publisher name (may be aliased at the publisher’s request).
     */
    public String name;

    /**
     * Highest level domain of the publisher (e.g., "adsbynimbus.com").
     */
    public String domain;

    /**
     * Array of IAB content categories that describe the publisher. Refer to List 5.1.
     */
    public String[] cat;

    /**
     * Builder for constructing a {@link Publisher} object
     */
    public interface Builder {

        /**
         * Set the IAB content categories describing this publisher
         *
         * @param categories list of IAB content categories
         * @return this builder instance
         * @see #cat
         */
        Builder categories(String... categories);

        /**
         * Set the name of this publisher
         *
         * @param name publisher name
         * @return this builder instance
         * @see #name
         */
        Builder name(String name);

        /**
         * Set the top level domain of this publisher
         *
         * @param domain the domain (e.g. "adsbynimbus.com")
         * @return this builder instance
         * @see #domain
         */
         Builder domain(String domain);
    }
}