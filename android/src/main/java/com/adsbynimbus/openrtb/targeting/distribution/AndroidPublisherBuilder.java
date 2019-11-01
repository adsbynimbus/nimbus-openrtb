package com.adsbynimbus.openrtb.targeting.distribution;

import androidx.annotation.NonNull;

/**
 * Publisher builder implementation with Androidx annotations for validation
 *
 * @see Publisher
 */
public final class AndroidPublisherBuilder implements Publisher.Builder {

    /**
     * The publisher object this builder wraps
     */
    @NonNull
    public final Publisher publisher;

    /**
     * Constructs a builder that will edit the fields of the publisher object in place.
     *
     * @param publisher a publisher object
     */
    public AndroidPublisherBuilder(@NonNull Publisher publisher) {
        this.publisher = publisher;
    }

    /**
     * {@inheritDoc}
     *
     * @param categories {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidPublisherBuilder categories(String... categories) {
        publisher.cat = categories;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param name {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidPublisherBuilder name(@NonNull String name) {
        publisher.name = name;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param domain {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidPublisherBuilder domain(@NonNull String domain) {
        publisher.domain = domain;
        return this;
    }
}