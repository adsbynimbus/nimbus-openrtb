package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.NonNull;

/**
 * Implementation of {@link Data.Builder} with Androidx annotations for validation
 *
 * @see Data
 */
public final class AndroidDataBuilder implements Data.Builder {

    /**
     * The {@link Data} object this builder wraps
     */
    @NonNull
    public final Data data;

    /**
     * Constructs a {@link AndroidDataBuilder} that will edit the fields of the {@link Data} object in place
     *
     * @param data a non null data object
     */
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
