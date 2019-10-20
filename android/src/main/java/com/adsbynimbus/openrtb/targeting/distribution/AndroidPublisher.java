package com.adsbynimbus.openrtb.targeting.distribution;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;

import static com.adsbynimbus.openrtb.targeting.distribution.App.CONTENT_CATEGORIES;
import static com.adsbynimbus.openrtb.targeting.distribution.App.DOMAIN;
import static com.adsbynimbus.openrtb.targeting.distribution.App.NAME;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link Publisher} for convenient building and serialization
 */
public class AndroidPublisher extends ArrayMap<String, Object> implements Publisher, Publisher.Builder {

    @Retention(SOURCE)
    @StringDef({NAME, DOMAIN, CONTENT_CATEGORIES})
    public @interface Values { }

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        return super.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @param categories {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder categories(String... categories) {
        put(CONTENT_CATEGORIES, categories);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param name {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder name(@NonNull String name) {
        put(NAME, name);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param domain {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder domain(@NonNull String domain) {
        put(DOMAIN, domain);
        return this;
    }
}