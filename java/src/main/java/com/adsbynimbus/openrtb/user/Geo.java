package com.adsbynimbus.openrtb.user;

/**
 * This object encapsulates various methods for specifying a geographic location. When subordinate to a
 * Device object, it indicates the location of the device which can also be interpreted as the user’s current
 * location. When subordinate to a User object, it indicates the location of the user’s home base (i.e., not
 * necessarily their current location).
 * The lat/lon attributes should only be passed if they conform to the accuracy depicted in the type
 * attribute. For example, the centroid of a geographic region such as postal code should not be passed.
 */
public interface Geo {

    String LATITUDE = "lat"; // Float
    String LONGITUDE = "lon"; // Float (optional)
    String TYPE = "type"; // Integer
    String ACCURACY = "accuracy"; // Integer
    String COUNTRY = "country";
    String CITY = "city";
    String METRO = "metro";
    String STATE = "state";

    // Location type
    int GPS = 1;
    int IP_LOOKUP = 2;
    int USER_PROVIDED = 3;

    /**
     * Builder for constructing a {@link Geo} object
     */
    interface Builder {

        /**
         * Set the latitude and accuracy
         *
         * @param latitude
         * @return this builder instance
         */
        Builder withLatitude(float latitude);

        /**
         * Set the country
         *
         * @param countryCode
         * @return this builder instance
         */
        Builder withCountry(String countryCode);

        /**
         * Set the longitude
         *
         * @param longitude
         * @return this builder instance
         */
        public Builder withLongitude(float longitude);

        /**
         * Set the accuracy of the location data as reported by the device
         *
         * @param accuracy
         * @return this builder instance
         */
        Builder withAccuracy(int accuracy);

        /**
         * Set the location type
         *
         * @param locationType
         * @return this builder instance
         */
        Builder withLocationType(int locationType);

        /**
         * Set the city
         *
         * @param city
         * @return this builder instance
         */
        Builder withCity(String city);

        /**
         * Set the metro
         *
         * @param metro
         * @return this builder instance
         */
        Builder withMetro(String metro);

        /**
         * Set the state
         *
         * @param state
         * @return this builder instance
         */
        Builder withState(String state);
    }

    /**
     * Definition of {@link Geo} with all public mutable fields
     */
    class MutableGeo implements Geo {
        public Float lat;
        public Float lon;
        public Integer type;
        public Integer accuracy;
        public String country;
        public String city;
        public String metro;
        public String state;
    }
}
