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
    public Builder name(String name) {
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
    public Builder bundle(String bundle) {
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
    public Builder domain(String domain) {
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
    public Builder storeUrl(String storeUrl) {
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
    public Builder categories(String... categories) {
        put(CONTENT_CATEGORIES, categories);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param paid {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder paid(boolean paid) {
        put(PAID, paid ? PAID_APP : FREE_APP);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param publisher {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder publisher(@NonNull Publisher publisher) {
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
    public Builder pageCategories(String... pageCategories) {
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
    public Builder sectionCategories(String... sectionCategories) {
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
    public Builder privacyPolicy(boolean privacyPolicy) {
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
    public Builder version(String version) {
        put(VERSION, version);
        return this;
    }
}
