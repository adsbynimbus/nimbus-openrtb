package com.adsbynimbus.openrtb.targeting.user;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import com.adsbynimbus.openrtb.targeting.user.Geo;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link com.adsbynimbus.openrtb.targeting.user.Geo} for convenient building and serialization
 */
public class AndroidGeo extends ArrayMap<String, Object> implements com.adsbynimbus.openrtb.targeting.user.Geo, Geo.Builder {

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
    public Builder withLatitude(float latitude) {
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
    public Builder withCountry(@NonNull String countryCode) {
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
    @Override
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
    @Override
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
    @Override
    public Builder withCity(@NonNull String city) {
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
    public Builder withMetro(String metro) {
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
    public Builder withState(String state) {
        put(STATE, state);
        return this;
    }
}
