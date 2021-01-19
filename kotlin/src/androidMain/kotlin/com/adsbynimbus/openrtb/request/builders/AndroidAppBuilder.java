package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.App;
import com.adsbynimbus.openrtb.request.Publisher;

/**
 * App builder implementation with Androidx annotations for validation
 */
public final class AndroidAppBuilder implements App.Builder {

    @NonNull
    private final App app;

    public AndroidAppBuilder(@NonNull App app) {
        this.app = app;
    }

    /**
     * Returns a builder for the publisher object. A new Publisher object will be created if none exists.
     *
     * @return a builder wrapping the publisher object
     */
    @NonNull
    public AndroidPublisherBuilder publisher() {
        if (app.publisher == null) {
            app.publisher = new Publisher();
        }
        return new AndroidPublisherBuilder(app.publisher);
    }

    @Override @NonNull
    public AndroidAppBuilder name(String name) {
        app.name = name;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder bundle(String bundle) {
        app.bundle = bundle;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder domain(String domain) {
        app.domain = domain;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder storeUrl(String storeUrl) {
        app.storeurl = storeUrl;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder categories(String... categories) {
        app.cat = categories;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder paid(boolean paid) {
        app.paid = paid ? 1 : 0;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder publisher(@Nullable Publisher publisher) {
        app.publisher = publisher;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder pageCategories(String... pageCategories) {
        app.pagecat = pageCategories;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder sectionCategories(String... sectionCategories) {
        app.sectioncat = sectionCategories;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder privacyPolicy(boolean privacyPolicy) {
        app.privacypolicy = privacyPolicy ? 1 : 0;
        return this;
    }

    @Override @NonNull
    public AndroidAppBuilder version(String version) {
        app.ver = version;
        return this;
    }
}
