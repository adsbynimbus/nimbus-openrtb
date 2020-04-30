package com.adsbynimbus.openrtb.android;

import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.targeting.user.Geo;
import com.adsbynimbus.openrtb.targeting.user.Geo.LocationType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Geo builder implementation with Androidx annotations for validation
 *
 * @see Geo
 */
public final class AndroidGeoBuilder implements Geo.Builder {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({LocationType.GPS, LocationType.IP_LOOKUP, LocationType.USER_PROVIDED})
    public @interface LocationTypeInt { }

    /**
     * The geo object this builder wraps
     */
    @NonNull
    private final Geo geo;

    /**
     * Constructs a builder that will edit the fields of the geo object in place.
     *
     * @param geo a geo object
     */
    public AndroidGeoBuilder(@NonNull Geo geo) {
        this.geo = geo;
    }

    /**
     * {@inheritDoc}
     *
     * @param latitude {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidGeoBuilder latitude(@FloatRange(from = -90f, to = 90f) float latitude) {
        geo.lat = latitude;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param countryCode {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidGeoBuilder country(@Nullable String countryCode) {
        geo.country = countryCode;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param longitude {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidGeoBuilder longitude(@FloatRange(from = -180, to = 180) float longitude) {
        geo.lon = longitude;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param accuracy {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
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
    @Override @NonNull
    public AndroidGeoBuilder locationType(@Nullable @LocationTypeInt Integer locationType) {
        geo.type = locationType;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param city {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidGeoBuilder city(@Nullable String city) {
        geo.city = city;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param metro {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidGeoBuilder metro(@Nullable String metro) {
        geo.metro = metro;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param state {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidGeoBuilder state(@Nullable String state) {
        geo.state = state;
        return this;
    }
}
