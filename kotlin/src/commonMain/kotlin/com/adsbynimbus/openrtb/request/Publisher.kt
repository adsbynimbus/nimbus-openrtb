package com.adsbynimbus.openrtb.request

import kotlin.jvm.JvmField

/**
 * This object describes the publisher of the media in which the ad will be displayed.
 *
 * The publisher is typically the seller in an OpenRTB transaction.
 *
 * [OpenRTB Section 3.2.15](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=26)
 *
 * @property name Publisher name (may be aliased at the publisher’s request).
 * @property domain Highest level domain of the publisher (e.g., "adsbynimbus.com").
 * @property cat Array of IAB content categories that describe the publisher.
 * @see [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39)
 */
class Publisher(
    @JvmField var name: String? = null,
    @JvmField var domain: String? = null,
    @JvmField var cat: Array<String>? = null,
) {
    /**
     * Builder for constructing a Publisher object.
     *
     * @see [Publisher]
     */
    interface Builder {
        /**
         * Sets the IAB content categories describing this publisher.
         *
         * @param categories list of IAB content categories
         * @return this builder instance
         * @see [Publisher.cat]
         */
        fun categories(vararg categories: String?): Builder

        /**
         * Sets the name of this publisher.
         *
         * @param name publisher name
         * @return this builder instance
         * @see [Publisher.name]
         */
        fun name(name: String?): Builder

        /**
         * Sets the top level domain of this publisher.
         *
         * @param domain the domain (e.g. "adsbynimbus.com")
         * @return this builder instance
         * @see [Publisher.domain]
         */
        fun domain(domain: String?): Builder
    }
}