package com.adsbynimbus.openrtb.android;

import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.targeting.Source;

/**
 * Source builder implementation with Androidx annotations for validation
 *
 * @see Source
 */
public final class AndroidSourceBuilder implements Source.Builder {

    /**
     * The source object this builder wraps
     */
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

    /**
     * {@inheritDoc}
     *
     * @param partnerName {@inheritDoc}
     * @param sdkVersion {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidSourceBuilder omSdk(@NonNull String partnerName, @NonNull String sdkVersion) {
        if (source.ext == null) {
            source.ext = new Source.Extension();
        }
        source.ext.omidpn = partnerName;
        source.ext.omidpv = sdkVersion;
        return this;
    }
}