package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.NonNull;

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
    @Override
    public AndroidSegmentBuilder id(String id) {
        segment.id = id;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param name {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidSegmentBuilder name(String name) {
        segment.name = name;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param value {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidSegmentBuilder value(String value) {
        segment.value = value;
        return this;
    }
}
