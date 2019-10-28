package com.adsbynimbus.openrtb.targeting.user;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.targeting.user.Geo.LocationType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Implementation of {@link Geo.Builder} with Androidx annotations for validation
 */
public class AndroidGeoBuilder implements Geo.Builder {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({LocationType.GPS, LocationType.IP_LOOKUP, LocationType.USER_PROVIDED})
    public @interface LocationTypeInt { }

    public final Geo geo;

    public AndroidGeoBuilder(Geo geo) {
        this.geo = geo;
    }

    /**
     * {@inheritDoc}
     *
     * @param latitude {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidGeoBuilder latitude(float latitude) {
        geo.lat = latitude;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param countryCode {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidGeoBuilder country(@NonNull String countryCode) {
        geo.country = countryCode;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param longitude {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidGeoBuilder longitude(float longitude) {
        geo.lon = longitude;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param accuracy {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidGeoBuilder accuracy(int accuracy) {
        geo.accuracy = accuracy;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param locationType {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidGeoBuilder locationType(@LocationTypeInt Integer locationType) {
        geo.type = locationType;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param city {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidGeoBuilder city(@NonNull String city) {
        geo.city = city;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param metro {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidGeoBuilder metro(String metro) {
        geo.metro = metro;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param state {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidGeoBuilder state(String state) {
        geo.state = state;
        return this;
    }
}
