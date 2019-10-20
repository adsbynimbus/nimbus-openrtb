package com.adsbynimbus.openrtb.targeting.user;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import com.adsbynimbus.openrtb.targeting.user.Geo;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link Geo} for convenient building and serialization
 */
public class AndroidGeo extends ArrayMap<String, Object> implements Geo, Geo.Builder {

    @Retention(SOURCE)
    @StringDef({LATITUDE, LONGITUDE, TYPE, ACCURACY, COUNTRY, CITY, METRO, STATE})
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
    @Override
    public Builder latitude(float latitude) {
        put(LATITUDE, latitude);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param countryCode {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder country(@NonNull String countryCode) {
        put(COUNTRY, countryCode);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param longitude {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder longitude(float longitude) {
        put(LONGITUDE, longitude);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param accuracy {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder accuracy(int accuracy) {
        put(ACCURACY, accuracy);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param locationType {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder locationType(@LocationType int locationType) {
        put(TYPE, locationType);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param city {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder city(@NonNull String city) {
        put(CITY, city);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param metro {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder metro(String metro) {
        put(METRO, metro);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param state {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder state(String state) {
        put(STATE, state);
        return this;
    }
}
