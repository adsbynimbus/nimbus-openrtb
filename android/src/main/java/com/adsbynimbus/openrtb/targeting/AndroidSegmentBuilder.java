package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.NonNull;

/**
 * Implementation of {@link Segment.Builder} with Androidx annotations for validation
 *
 * @see Segment
 */
public final class AndroidSegmentBuilder implements Segment.Builder {

    /**
     * The {@link Segment} object this builder wraps
     */
    @NonNull
    public final Segment segment;

    /**
     * Constructs a {@link AndroidSegmentBuilder} that will edit the fields of the {@link Segment} object in place
     *
     * @param segment a non null segment object
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
