package com.adsbynimbus.openrtb.request

import kotlin.jvm.JvmField

/**
 * This object encapsulates various methods for specifying a geographic location.
 *
 * When subordinate to a Device object, it indicates the location of the device which can also be interpreted as the
 * user’s current location. When subordinate to a User object, it indicates the location of the user’s home base
 * (i.e., not necessarily their current location).
 *
 * The lat/lon attributes should only be passed if they conform to the accuracy depicted in the type attribute.
 * For example, the centroid of a geographic region such as postal code should not be passed.
 *
 * [OpenRTB Section 3.2.19](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=29)
 */
open class Geo {

    /**
     * Indicates how the geographic information was determined.
     */
    interface LocationType {
        companion object {
            /**
             * GPS/Location Services
             */
            const val GPS = 1

            /**
             * IP Address
             */
            const val IP_LOOKUP = 2

            /**
             * User provided (e.g., registration data)
             */
            const val USER_PROVIDED = 3
        }
    }

    /**
     * Latitude from -90.0 to +90.0, where negative is south.
     */
    @JvmField
    var lat: Float? = null

    /**
     * Longitude from -180.0 to +180.0, where negative is west
     */
    @JvmField
    var lon: Float? = null

    /**
     * Source of location data; recommended when passing lat/lon.
     */
    @JvmField
    var type: Int? = null

    /**
     * Estimated location accuracy in meters.
     *
     * Recommended when lat/lon are specified and derived from adevice’s location services (i.e., type = 1).
     * Note that this is the accuracy as reported from the device. Consult OS specific documentation
     * (e.g., Android, iOS) for exact interpretation.
     */
    @JvmField
    var accuracy: Int? = null

    /**
     * Country code using ISO-3166-1-alpha-3.
     */
    @JvmField
    var country: String? = null

    /**
     * City using United Nations Code for Trade &amp; Transport Locations.
     *
     * @see [United Nations Location Codes](http://www.unece.org/cefact/locode/service/location.htm)
     */
    @JvmField
    var city: String? = null

    /**
     * Google metro code; similar to but not exactly Nielsen DMAs.
     *
     * @see [Google Metro codes](code.google.com/apis/adwords/docs/appendix/metrocodes.html)
     */
    @JvmField
    var metro: String? = null

    /**
     * 2-letter state code.
     */
    @JvmField
    var state: String? = null

    /**
     * Builder for constructing a Geo object
     *
     * @see [Geo]
     */
    interface Builder {
        /**
         * Sets the latitude of this geo object.
         *
         * @param latitude latitude from -90 to +90
         * @return this builder instance
         * @see [Geo.lat]
         */
        fun latitude(latitude: Float): Builder

        /**
         * Sets the 3 letter country code of this geo object.
         *
         * @param countryCode 3 letter country code
         * @return this builder instance
         * @see [Geo.country]
         */
        fun country(countryCode: String?): Builder

        /**
         * Sets the longitude of this geo object.
         *
         * @param longitude longitude from -180 to +180
         * @return this builder instance
         * @see [Geo.lon]
         */
        fun longitude(longitude: Float): Builder

        /**
         * Sets the accuracy of the location data as reported by the device.
         *
         * @param accuracy the accuracy reported by the device
         * @return this builder instance
         * @see [Geo.accuracy]
         */
        fun accuracy(accuracy: Int): Builder

        /**
         * Sets the location type of this geo object.
         *
         * @param locationType the location type
         * @return this builder instance
         * @see [Geo.type]
         * @see [LocationType]
         */
        fun locationType(locationType: Int?): Builder

        /**
         * Sets the city using the United Nations Code for Trade & Transport Locations.
         *
         * @param city city code
         * @return this builder instance
         * @see [Geo.city]
         */
        fun city(city: String?): Builder

        /**
         * Sets the Google metro code of this geo object.
         *
         * @param metro Google metro code
         * @return this builder instance
         * @see [Geo.metro]
         */
        fun metro(metro: String?): Builder

        /**
         * Sets the 2 letter state code of this geo object.
         *
         * @param state 2 letter state code
         * @return this builder instance
         * @see [Geo.state]
         */
        fun state(state: String?): Builder
    }
}