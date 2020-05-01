package com.adsbynimbus.openrtb.android;

import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.request.Data;
import com.adsbynimbus.openrtb.request.Segment;

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
    @Override @NonNull
    public AndroidDataBuilder id(@NonNull String id) {
        data.id = id;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param name {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidDataBuilder name(@NonNull String name) {
        data.name = name;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param segments {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidDataBuilder segments(@NonNull Segment... segments) {
        data.segment = segments;
        return this;
    }
}
