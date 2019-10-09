package com.adsbynimbus.openrtb.user;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link Geo} for convenient building and serialization
 */
public class AndroidGeo extends ArrayMap<String, Object> implements Geo, Geo.Builder {

    @Retention(SOURCE)
    @StringDef({LATITUDE, LONGITUDE, TYPE, ACCURACY, COUNTRY, CITY})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({GPS, IP_LOOKUP, USER_PROVIDED})
    public @interface LocationType { }


    /**
     * {@inheritDoc}
     *
     * @param latitude {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Builder forLatitude(float latitude) {
        put(LATITUDE, latitude);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param countryCode {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Builder forCountry(@NonNull String countryCode) {
        put(COUNTRY, countryCode);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param longitude {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Builder withLongitude(float longitude) {
        put(LONGITUDE, longitude);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param accuracy {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Builder withAccuracy(int accuracy) {
        put(ACCURACY, accuracy);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param locationType {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Builder withLocationType(@LocationType int locationType) {
        put(TYPE, locationType);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param city {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Builder withCity(@NonNull String city) {
        put(CITY, city);
        return this;
    }
}
