package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.Geo;
import com.adsbynimbus.openrtb.request.Geo.LocationType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Geo builder implementation with Androidx annotations for validation
 */
public final class AndroidGeoBuilder implements Geo.Builder {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({LocationType.GPS, LocationType.IP_LOOKUP, LocationType.USER_PROVIDED})
    public @interface LocationTypeInt { }
    
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
    
    @Override @NonNull
    public AndroidGeoBuilder latitude(@FloatRange(from = -90f, to = 90f) float latitude) {
        geo.lat = latitude;
        return this;
    }

    @Override @NonNull
    public AndroidGeoBuilder country(@Nullable String countryCode) {
        geo.country = countryCode;
        return this;
    }

    @Override @NonNull
    public AndroidGeoBuilder longitude(@FloatRange(from = -180, to = 180) float longitude) {
        geo.lon = longitude;
        return this;
    }

    @Override @NonNull
    public AndroidGeoBuilder accuracy(int accuracy) {
        geo.accuracy = accuracy;
        return this;
    }

    @Override @NonNull
    public AndroidGeoBuilder locationType(@LocationTypeInt Integer locationType) {
        geo.type = locationType;
        return this;
    }

    @Override @NonNull
    public AndroidGeoBuilder city(@Nullable String city) {
        geo.city = city;
        return this;
    }

    @Override @NonNull
    public AndroidGeoBuilder metro(String metro) {
        geo.metro = metro;
        return this;
    }

    @Override @NonNull
    public AndroidGeoBuilder state(String state) {
        geo.state = state;
        return this;
    }
}
