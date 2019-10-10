package com.adsbynimbus.openrtb.targeting.distribution;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link App} for convenient building and serialization
 */
public class AndroidApp extends ArrayMap<String, Object> implements App, App.Builder {

    @Retention(SOURCE)
    @StringDef({NAME, DOMAIN, CONTENT_CATEGORIES, BUNDLE, STORE_URL, PAGE_CATEGORIES, PAID, PRIVACY_POLICY, PUBLISHER,
        SECTION_CATEGORIES, VERSION})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({FREE_APP, PAID_APP})
    public @interface AppCost { }

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
    public Builder withContentCategories(String... categories) {
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

    /**
     * {@inheritDoc}
     *
     * @param pageCategories {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withPageCategories(String... pageCategories) {
        put(PAGE_CATEGORIES, pageCategories);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param sectionCategories {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withSectionCategories(String... sectionCategories) {
        put(SECTION_CATEGORIES, sectionCategories);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param privacyPolicy {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withPrivacyPolicy(int privacyPolicy) {
        put(PRIVACY_POLICY, privacyPolicy);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param version {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withVersion(String version) {
        put(VERSION, version);
        return this;
    }
}
