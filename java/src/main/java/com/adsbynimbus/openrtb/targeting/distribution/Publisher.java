package com.adsbynimbus.openrtb.targeting.distribution;

/**
 * This object describes the publisher of the media in which the ad will be displayed. The publisher is
 * typically the seller in an OpenRTB transaction.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=26">OpenRTB Section 3.2.15</a>
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
     * Array of IAB content categories that describe the publisher.
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39">OpenRTB Section 5.1</a>
     */
    public String[] cat;

    /**
     * Builder for constructing a Publisher object.
     *
     * @see Publisher
     */
    public interface Builder {

        /**
         * Sets the IAB content categories describing this publisher.
         *
         * @param categories list of IAB content categories
         * @return this builder instance
         * @see #cat
         */
        Builder categories(String... categories);

        /**
         * Sets the name of this publisher.
         *
         * @param name publisher name
         * @return this builder instance
         * @see #name
         */
        Builder name(String name);

        /**
         * Sets the top level domain of this publisher.
         *
         * @param domain the domain (e.g. "adsbynimbus.com")
         * @return this builder instance
         * @see #domain
         */
         Builder domain(String domain);
    }
}