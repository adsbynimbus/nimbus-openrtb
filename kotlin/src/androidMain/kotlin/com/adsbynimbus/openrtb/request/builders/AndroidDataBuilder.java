package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.request.Data;
import com.adsbynimbus.openrtb.request.Segment;

/**
 * Data builder implementation with Androidx annotations for validation
 */
public final class AndroidDataBuilder implements Data.Builder {
    
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

    @Override @NonNull
    public AndroidDataBuilder id(String id) {
        data.id = id;
        return this;
    }

    @Override @NonNull
    public AndroidDataBuilder name(String name) {
        data.name = name;
        return this;
    }

    @Override @NonNull
    public AndroidDataBuilder segments(Segment... segments) {
        data.segment = segments;
        return this;
    }
}
