package com.adsbynimbus.openrtb.targeting.user;

/**
 * This object encapsulates various methods for specifying a geographic location. When subordinate to a
 * Device object, it indicates the location of the device which can also be interpreted as the user’s current
 * location. When subordinate to a User object, it indicates the location of the user’s home base (i.e., not
 * necessarily their current location).
 * The lat/lon attributes should only be passed if they conform to the accuracy depicted in the type
 * attribute. For example, the centroid of a geographic region such as postal code should not be passed.
 */
public class Geo {

    public static final String LATITUDE = "lat"; // Float
    public static final String LONGITUDE = "lon"; // Float (optional)
    public static final String TYPE = "type"; // Integer
    public static final String ACCURACY = "accuracy"; // Integer
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String METRO = "metro";
    public static final String STATE = "state";

    // Location type
    public static final int GPS = 1;
    public static final int IP_LOOKUP = 2;
    public static final int USER_PROVIDED = 3;

    public Float lat;
    public Float lon;
    public Integer type;
    public Integer accuracy;
    public String country;
    public String city;
    public String metro;
    public String state;

    /**
     * Builder for constructing a {@link Geo} object
     */
    public interface Builder {

        /**
         * Set the latitude of this Geo object
         *
         * @param latitude
         * @return this builder instance
         */
        Builder latitude(float latitude);

        /**
         * Set the country
         *
         * @param countryCode
         * @return this builder instance
         */
        Builder country(String countryCode);

        /**
         * Set the longitude
         *
         * @param longitude
         * @return this builder instance
         */
        Builder longitude(float longitude);

        /**
         * Set the accuracy of the location data as reported by the device
         *
         * @param accuracy
         * @return this builder instance
         */
        Builder accuracy(int accuracy);

        /**
         * Set the location type
         *
         * @param locationType
         * @return this builder instance
         */
        Builder locationType(int locationType);

        /**
         * Set the city
         *
         * @param city
         * @return this builder instance
         */
        Builder city(String city);

        /**
         * Set the metro
         *
         * @param metro
         * @return this builder instance
         */
        Builder metro(String metro);

        /**
         * Set the state
         *
         * @param state
         * @return this builder instance
         */
        Builder state(String state);
    }
}
