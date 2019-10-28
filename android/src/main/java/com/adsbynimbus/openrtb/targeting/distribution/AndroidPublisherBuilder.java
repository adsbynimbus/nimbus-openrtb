package com.adsbynimbus.openrtb.targeting.distribution;

import androidx.annotation.NonNull;

/**
 * Implementation of {@link Publisher.Builder} with Androidx annotations for validation
 */
public class AndroidPublisherBuilder implements Publisher.Builder {

    public final Publisher publisher;

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