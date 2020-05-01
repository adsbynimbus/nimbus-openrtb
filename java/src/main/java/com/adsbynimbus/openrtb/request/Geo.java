package com.adsbynimbus.openrtb.request;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This object encapsulates various methods for specifying a geographic location. When subordinate to a
 * Device object, it indicates the location of the device which can also be interpreted as the user’s current
 * location. When subordinate to a User object, it indicates the location of the user’s home base (i.e., not
 * necessarily their current location).
 * The lat/lon attributes should only be passed if they conform to the accuracy depicted in the type
 * attribute. For example, the centroid of a geographic region such as postal code should not be passed.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=29">OpenRTB Section 3.2.19</a>
 */
public class Geo {

    /**
     * Indicates how the geographic information was determined.
     */
    public interface LocationType {

        /**
         * GPS/Location Services
         */
        int GPS = 1;

        /**
         * IP Address
         */
        int IP_LOOKUP = 2;

        /**
         * User provided (e.g., registration data)
         */
        int USER_PROVIDED = 3;
    }

    /**
     * Latitude from -90.0 to +90.0, where negative is south.
     */
    @Nullable
    public Float lat;

    /**
     * Longitude from -180.0 to +180.0, where negative is west
     */
    @Nullable
    public Float lon;

    /**
     * Source of location data; recommended when passing lat/lon.
     */
    @Nullable
    public Integer type;

    /**
     * Estimated location accuracy in meters; recommended when lat/lon are specified and derived from a
     * device’s location services (i.e., type = 1). Note that this is the accuracy as reported from the device.
     * Consult OS specific documentation (e.g., Android, iOS) for exact interpretation.
     */
    @Nullable
    public Integer accuracy;

    /**
     * Country code using ISO-3166-1-alpha-3.
     */
    @Nullable
    public String country;

    /**
     * City using United Nations Code for Trade &amp; Transport Locations.
     *
     * @see <a href="http://www.unece.org/cefact/locode/service/location.htm">United Nations Location Codes</a>
     */
    @Nullable
    public String city;

    /**
     * Google metro code; similar to but not exactly Nielsen DMAs.
     *
     * @see <a href="code.google.com/apis/adwords/docs/appendix/metrocodes.html">Google Metro codes</a>
     */
    @Nullable
    public String metro;

    /**
     * 2-letter state code.
     */
    @Nullable
    public String state;

    /**
     * Builder for constructing a Geo object
     *
     * @see Geo
     */
    public interface Builder {

        /**
         * Sets the latitude of this geo object.
         *
         * @param latitude latitude from -90 to +90
         * @return this builder instance
         * @see #lat
         */
        @NotNull
        Builder latitude(float latitude);

        /**
         * Sets the 3 letter country code of this geo object.
         *
         * @param countryCode 3 letter country code
         * @return this builder instance
         * @see #country
         */
        @NotNull
        Builder country(@Nullable String countryCode);

        /**
         * Sets the longitude of this geo object.
         *
         * @param longitude longitude from -180 to +180
         * @return this builder instance
         * @see #lon
         */
        @NotNull
        Builder longitude(float longitude);

        /**
         * Sets the accuracy of the location data as reported by the device.
         *
         * @param accuracy the accuracy reported by the device
         * @return this builder instance
         * @see #accuracy
         */
        @NotNull
        Builder accuracy(int accuracy);

        /**
         * Sets the location type of this geo object.
         *
         * @param locationType the location type
         * @return this builder instance
         * @see #type
         * @see LocationType
         */
        @NotNull
        Builder locationType(@Nullable Integer locationType);

        /**
         * Sets the city using the United Nations Code for Trade &amp; Transport Locations.
         *
         * @param city city code
         * @return this builder instance
         * @see #city
         */
        @NotNull
        Builder city(@Nullable String city);

        /**
         * Sets the Google metro code of this geo object.
         *
         * @param metro Google metro code
         * @return this builder instance
         * @see #metro
         */
        @NotNull
        Builder metro(@Nullable String metro);

        /**
         * Sets the 2 letter state code of this geo object.
         *
         * @param state 2 letter state code
         * @return this builder instance
         * @see #state
         */
        @NotNull
        Builder state(@Nullable String state);
    }
}
