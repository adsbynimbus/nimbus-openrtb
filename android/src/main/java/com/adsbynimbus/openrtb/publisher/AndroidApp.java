package com.adsbynimbus.openrtb.publisher;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;

import static com.adsbynimbus.openrtb.publisher.Publisher.CONTENT_CATEGORIES;
import static com.adsbynimbus.openrtb.publisher.Publisher.DOMAIN;
import static com.adsbynimbus.openrtb.publisher.Publisher.NAME;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link App} for convenient building and serialization
 */
public class AndroidApp extends ArrayMap<String, Object> implements App, App.Builder {

    @Retention(SOURCE)
    @StringDef({NAME, DOMAIN, CONTENT_CATEGORIES, BUNDLE, STORE_URL, PAID, PUBLISHER, VERSION})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({FREE_APP, PAID_APP})
    public @interface AppCost { }

    public AndroidApp build() {
        if (!containsKey(PUBLISHER)) {
            final AndroidPublisher publisher = new AndroidPublisher();
            publisher.put(NAME, get(NAME));
            publisher.put(DOMAIN, get(DOMAIN));
            publisher.put(CONTENT_CATEGORIES, get(CONTENT_CATEGORIES));
            put(PUBLISHER, publisher);
        }
        return this;
    }

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        return super.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @param name {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withName(String name) {
        put(NAME, name);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param bundle {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withBundle(String bundle) {
        put(BUNDLE, bundle);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param domain {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withDomain(String domain) {
        put(DOMAIN, domain);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param storeUrl {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withStoreUrl(String storeUrl) {
        put(STORE_URL, storeUrl);
        return this;
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
     * @param appCost {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withAppCost(@AppCost int appCost) {
        put(PAID, appCost);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param publisher {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withPublisher(@NonNull Publisher publisher) {
        put(PUBLISHER, publisher);
        return this;
    }
}
