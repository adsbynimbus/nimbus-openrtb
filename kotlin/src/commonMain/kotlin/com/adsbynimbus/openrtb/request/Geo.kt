package com.adsbynimbus.openrtb.request

import kotlin.jvm.JvmField

/**
 * This object encapsulates various methods for specifying a geographic location.
 *
 * When subordinate to a Device object, it indicates the location of the device which can also be
 * interpreted as the user’s current location. When subordinate to a User object, it indicates the
 * location of the user’s home base (i.e., not necessarily their current location).
 *
 * The lat/lon attributes should only be passed if they conform to the accuracy depicted in the type
 * attribute. For example, the centroid of a geographic region such as postal code should not be
 * passed.
 *
 * [OpenRTB Section 3.2.19](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=29)
 *
 * @property lat Latitude from -90.0 to +90.0, where negative is south.
 * @property lon Longitude from -180.0 to +180.0, where negative is west
 * @property type Source of location data; recommended when passing lat/lon.
 * @property accuracy Estimated location accuracy in meters.
 *                    Recommended when lat/lon are specified and derived from adevice’s location
 *                    services (i.e., type = 1). Note that this is the accuracy as reported from the
 *                    device. Consult OS specific documentation (e.g., Android, iOS) for exact
 *                    interpretation.
 * @property country Country code using ISO-3166-1-alpha-3.
 * @property city City using United Nations Code for Trade &amp; Transport Locations.
 * @property metro Google metro code; similar to but not exactly Nielsen DMAs.
 * @property state 2-letter state code.
 * @see [United Nations Location Codes](http://www.unece.org/cefact/locode/service/location.htm)
 * @see [Google Metro codes](code.google.com/apis/adwords/docs/appendix/metrocodes.html)
 */
class Geo(
    @JvmField var lat: Float? = null,
    @JvmField var lon: Float? = null,
    @JvmField var type: Int? = null,
    @JvmField var accuracy: Int? = null,
    @JvmField var country: String? = null,
    @JvmField var city: String? = null,
    @JvmField var metro: String? = null,
    @JvmField var state: String? = null,
) {

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
}