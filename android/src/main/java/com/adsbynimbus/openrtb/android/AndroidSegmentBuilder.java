package com.adsbynimbus.openrtb.android;

import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.targeting.Segment;

/**
 * Segment builder with Androidx annotations for validation
 *
 * @see Segment
 */
public final class AndroidSegmentBuilder implements Segment.Builder {

    /**
     * The segment object this builder wraps
     */
    @NonNull
    private final Segment segment;

    /**
     * Constructs a builder that will edit the fields of the segment object in place.
     *
     * @param segment a segment object
     */
    public AndroidSegmentBuilder(@NonNull Segment segment) {
        this.segment = segment;
    }
    /**
     * {@inheritDoc}
     *
     * @param id {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidSegmentBuilder id(@NonNull String id) {
        segment.id = id;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param name {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidSegmentBuilder name(@NonNull String name) {
        segment.name = name;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param value {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidSegmentBuilder value(@NonNull String value) {
        segment.value = value;
        return this;
    }
}
