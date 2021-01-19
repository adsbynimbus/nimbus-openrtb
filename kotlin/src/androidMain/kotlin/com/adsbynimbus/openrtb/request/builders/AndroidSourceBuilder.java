package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.Source;

/**
 * Source builder implementation with Androidx annotations for validation
 */
public final class AndroidSourceBuilder implements Source.Builder {

    @NonNull
    private final Source source;

    /**
     * Constructs a builder that will edit the fields of the source object in place.
     *
     * @param source a source object
     */
    public AndroidSourceBuilder(@NonNull Source source) {
        this.source = source;
    }

    @Override @NonNull
    public AndroidSourceBuilder omSdk(@Nullable String partnerName, @Nullable String sdkVersion) {
        if (source.ext == null) {
            source.ext = new Source.Extension();
        }
        source.ext.omidpn = partnerName;
        source.ext.omidpv = sdkVersion;
        return this;
    }
}