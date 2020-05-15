package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.Publisher;

/**
 * Publisher builder implementation with Androidx annotations for validation
 */
public final class AndroidPublisherBuilder implements Publisher.Builder {

    /**
     * The publisher object this builder wraps
     */
    @NonNull
    private final Publisher publisher;

    /**
     * Constructs a builder that will edit the fields of the publisher object in place.
     *
     * @param publisher a publisher object
     */
    public AndroidPublisherBuilder(@NonNull Publisher publisher) {
        this.publisher = publisher;
    }

    @Override @NonNull
    public AndroidPublisherBuilder categories(String... categories) {
        publisher.cat = categories;
        return this;
    }

    @Override @NonNull
    public AndroidPublisherBuilder name(@Nullable String name) {
        publisher.name = name;
        return this;
    }

    @Override @NonNull
    public AndroidPublisherBuilder domain(@Nullable String domain) {
        publisher.domain = domain;
        return this;
    }
}