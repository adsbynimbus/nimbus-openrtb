package com.adsbynimbus.openrtb.publisher;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static com.adsbynimbus.openrtb.internal.NimbusRTB.EXTENSION;
import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidPublisher extends ArrayMap<String, Object> implements Publisher {

    @Retention(SOURCE)
    @StringDef({NAME, DOMAIN, CONTENT_CATEGORIES, FACEBOOK_APP_ID})
    public @interface Values { }

    public static class Builder implements Publisher.Builder {

        protected final AndroidPublisher values = new AndroidPublisher();
        protected ArrayMap<String, Object> ext;

        @Override
        public AndroidPublisher build() {
            if (ext != null) {
                values.put(EXTENSION, ext);
            }
            return values;
        }

        @Override
        public Map<String, Object> getValues() {
            return values;
        }

        /**
         * Manually set a value on the builder object
         *
         * @param property - {@link Values}
         * @param value    - {@link Object}
         * @return {@link Builder}
         */
        public Builder setValue(@Values String property, Object value) {
            values.put(property, value);
            return this;
        }

        /**
         * Set categories
         *
         * @param categories - {@link String[]}
         * @return {@link AndroidApp.Builder}
         */
        public Builder withCategories(String... categories) {
            values.put(CONTENT_CATEGORIES, categories);
            return this;
        }

        /**
         * Set the publisher name
         *
         * @param name - {@link String}
         * @return {@link Builder}
         */
        public Builder withName(@NonNull String name) {
            values.put(NAME, name);
            return this;
        }

        /**
         * Set the publisher domain
         *
         * @param domain - {@link String}
         * @return {@link Builder}
         */
        public Builder withDomain(@NonNull String domain) {
            values.put(DOMAIN, domain);
            return this;
        }

        /**
         * Set the publisher domain
         *
         * @param facebookAppId - {@link String}
         * @return {@link Builder}
         */
        public Builder withFacebookAppId(@NonNull String facebookAppId) {
            if (ext == null) {
                ext = new ArrayMap<>(1);
            }
            ext.put(FACEBOOK_APP_ID, facebookAppId);
            return this;
        }

        /**
         * Set the publisher domain
         *
         * @param googleId - {@link String}
         * @return {@link Builder}
         */
        public Builder withGoogleId(@NonNull String googleId) {
            if (ext == null) {
                ext = new ArrayMap<>(1);
            }
            ext.put(GOOGLE_ID, googleId);
            return this;
        }

        /**
         * Set the publisher domain
         *
         * @param apsParams - {@link String}
         * @return {@link Builder}
         */
        public Builder withApsParams(@NonNull Map<String, Object> apsParams) {
            if (ext == null) {
                ext = new ArrayMap<>(1);
            }
            ext.put(APS, apsParams);
            return this;
        }
    }
}