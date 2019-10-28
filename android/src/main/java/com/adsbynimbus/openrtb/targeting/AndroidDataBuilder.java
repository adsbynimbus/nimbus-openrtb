package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.NonNull;

/**
 * Implementation of {@link Data.Builder} with Androidx annotations for validation
 */
public final class AndroidDataBuilder implements Data.Builder {

    @NonNull
    public final Data data;

    public AndroidDataBuilder(@NonNull Data data) {
        this.data = data;
    }

    /**
     * {@inheritDoc}
     *
     * @param id {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDataBuilder id(String id) {
        data.id = id;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param name {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDataBuilder name(String name) {
        data.name = name;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param segments {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDataBuilder segments(Segment... segments) {
        data.segment = segments;
        return this;
    }
}
