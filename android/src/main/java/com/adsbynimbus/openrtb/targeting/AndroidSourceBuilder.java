package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.NonNull;

/**
 * Implementation of {@link Source.Builder} with Androidx annotations for validation
 */
public final class AndroidSourceBuilder implements Source.Builder {

    @NonNull
    public final Source source;

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