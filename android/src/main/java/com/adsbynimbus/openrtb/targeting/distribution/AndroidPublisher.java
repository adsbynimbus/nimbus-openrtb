package com.adsbynimbus.openrtb.targeting.distribution;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link com.adsbynimbus.openrtb.targeting.distribution.Publisher} for convenient building and serialization
 */
public class AndroidPublisher extends ArrayMap<String, Object> implements com.adsbynimbus.openrtb.targeting.distribution.Publisher, Publisher.Builder {

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
    public Builder withCategories(String... categories) {
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
    public Builder withName(@NonNull String name) {
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
    public Builder withDomain(@NonNull String domain) {
        put(DOMAIN, domain);
        return this;
    }
}