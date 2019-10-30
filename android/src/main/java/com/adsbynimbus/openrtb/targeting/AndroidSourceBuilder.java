package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.NonNull;

/**
 * Implementation of {@link Source.Builder} with Androidx annotations for validation
 *
 * @see Source
 */
public final class AndroidSourceBuilder implements Source.Builder {

    /**
     * The {@link Source} object this builder wraps
     */
    @NonNull
    public final Source source;

    /**
     * Constructs a {@link AndroidSourceBuilder} that will edit the fields of the {@link Source} object in place
     *
     * @param source a non null source object
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
    @Override
    public AndroidSourceBuilder omSdk(@NonNull String partnerName, @NonNull String sdkVersion) {
        if (source.ext == null) {
            source.ext = new Source.Extension();
        }
        source.ext.omidpn = partnerName;
        source.ext.omidpv = sdkVersion;
        return this;
    }
}