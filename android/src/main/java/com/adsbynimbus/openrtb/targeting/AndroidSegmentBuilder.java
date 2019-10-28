package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.NonNull;

/**
 * Implementation of {@link Segment.Builder} with Androidx annotations for validation
 */
public final class AndroidSegmentBuilder implements Segment.Builder {

    @NonNull
    public final Segment segment;

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
