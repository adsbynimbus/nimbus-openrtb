package com.adsbynimbus.openrtb.user;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidGeo extends ArrayMap<String, Object> implements Geo {

    @Retention(SOURCE)
    @StringDef({LATITUDE, LONGITUDE, TYPE, ACCURACY, COUNTRY, CITY})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({GPS, IP_LOOKUP, USER_PROVIDED})
    public @interface LocationType { }

    public static class Builder implements Geo.Builder {

        protected final AndroidGeo values = new AndroidGeo();

        @Override
        public AndroidGeo build() {
            return values;
        }

        @Override
        public Map<String, Object> getValues() {
            return values;
        }

        /**
         * Manually set a value on the builder object
         *
         * @param property - {@link Values}
         * @param value    - {@link Object}
         * @return {@link Builder}
         */
        public Builder setValue(@Values String property, Object value) {
            values.put(property, value);
            return this;
        }

        /**
         * Set the latitude and accuracy
         *
         * @param latitude - float
         * @return {@link Builder}
         */
        public Builder forLatitude(float latitude) {
            values.put(LATITUDE, latitude);
            return this;
        }

        /**
         * Set the country
         *
         * @param countryCode - {@link String}
         * @return {@link Builder}
         */
        public Builder forCountry(@NonNull String countryCode) {
            values.put(COUNTRY, countryCode);
            return this;
        }

        /**
         * Set the longitude
         *
         * @param longitude - float
         * @return {@link Builder}
         */
        public Builder withLongitude(float longitude) {
            values.put(LONGITUDE, longitude);
            return this;
        }

        /**
         * Set the accuracy of the location data as reported by the device
         *
         * @param accuracy - int
         * @return {@link Builder}
         */
        public Builder withAccuracy(int accuracy) {
            values.put(ACCURACY, accuracy);
            return this;
        }

        /**
         * Set the location type
         *
         * @param locationType - {@link LocationType} [GPS, IP_LOOKUP, USER_PROVIDED]
         * @return {@link Builder}
         */
        public Builder withLocationType(@LocationType int locationType) {
            values.put(TYPE, locationType);
            return this;
        }

        /**
         * Set the city
         *
         * @param city - {@link String}
         * @return {@link Builder}
         */
        public Builder withCity(@NonNull String city) {
            values.put(CITY, city);
            return this;
        }
    }
}
