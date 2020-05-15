package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.request.Segment;

/**
 * Segment builder with Androidx annotations for validation
 */
public final class AndroidSegmentBuilder implements Segment.Builder {

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

    @Override @NonNull
    public AndroidSegmentBuilder id(String id) {
        segment.id = id;
        return this;
    }

    @Override @NonNull
    public AndroidSegmentBuilder name(String name) {
        segment.name = name;
        return this;
    }

    @Override @NonNull
    public AndroidSegmentBuilder value(String value) {
        segment.value = value;
        return this;
    }
}
