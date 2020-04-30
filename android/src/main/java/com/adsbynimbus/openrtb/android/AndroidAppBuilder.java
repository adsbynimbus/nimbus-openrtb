package com.adsbynimbus.openrtb.android;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.targeting.distribution.App;
import com.adsbynimbus.openrtb.targeting.distribution.Publisher;

/**
 * App builder implementation with Androidx annotations for validation
 *
 * @see App
 */
public final class AndroidAppBuilder implements App.Builder {

    /**
     * The app object this builder wraps
     */
    @NonNull
    private final App app;

    /**
     * Constructs a builder that will edit the fields of the app object in place.
     *
     * @param app an app object
     */
    public AndroidAppBuilder(@NonNull App app) {
        this.app = app;
    }

    /**
     * {@inheritDoc}
     *
     * @param name {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder name(@NonNull String name) {
        app.name = name;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param bundle {@inheritDoc}
     * @return {@inheritDoc}
     * @see Context#getPackageName()
     */
    @Override @NonNull
    public AndroidAppBuilder bundle(@NonNull String bundle) {
        app.bundle = bundle;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param domain {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder domain(@NonNull String domain) {
        app.domain = domain;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param storeUrl {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder storeUrl(@NonNull String storeUrl) {
        app.storeurl = storeUrl;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param categories {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder categories(@Nullable String... categories) {
        app.cat = categories;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param paid {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder paid(boolean paid) {
        app.paid = paid ? 1 : 0;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param publisher {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder publisher(@NonNull Publisher publisher) {
        app.publisher = publisher;
        return this;
    }

    /**
     * Returns a builder for the publisher object. A new {@link Publisher} object will be created if none exists.
     *
     * @return a builder wrapping the publisher object
     */ @NonNull
    public AndroidPublisherBuilder publisher() {
        if (app.publisher == null) {
            app.publisher = new Publisher();
        }
        return new AndroidPublisherBuilder(app.publisher);
    }

    /**
     * {@inheritDoc}
     *
     * @param pageCategories {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder pageCategories(@Nullable String... pageCategories) {
        app.pagecat = pageCategories;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param sectionCategories {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder sectionCategories(@Nullable String... sectionCategories) {
        app.sectioncat = sectionCategories;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param privacyPolicy {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder privacyPolicy(boolean privacyPolicy) {
        app.privacypolicy = privacyPolicy ? 1 : 0;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param version {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidAppBuilder version(@Nullable String version) {
        app.ver = version;
        return this;
    }
}
