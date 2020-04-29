package com.adsbynimbus.openrtb.android;

import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.targeting.Data;
import com.adsbynimbus.openrtb.targeting.Segment;

/**
 * Data builder implementation with Androidx annotations for validation
 *
 * @see Data
 */
public final class AndroidDataBuilder implements Data.Builder {

    /**
     * The data object this builder wraps
     */
    @NonNull
    private final Data data;

    /**
     * Constructs a builder that will edit the fields of the data object in place.
     *
     * @param data a data object
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
