package com.adsbynimbus.openrtb.publisher;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidApp extends ArrayMap<String, Object> implements App {

    @Retention(SOURCE)
    @StringDef({NAME, DOMAIN, CONTENT_CATEGORIES, BUNDLE, STORE_URL, PAID, PUBLISHER})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({FREE_APP, PAID_APP})
    public @interface AppCost { }

    public static class Builder implements App.Builder {

        protected final AndroidApp values = new AndroidApp();

        @Override
        public AndroidApp build() {
            if (!values.containsKey(PUBLISHER)) {
                final AndroidPublisher publisher = new AndroidPublisher();
                publisher.put(NAME, values.get(NAME));
                publisher.put(DOMAIN, values.get(DOMAIN));
                publisher.put(CONTENT_CATEGORIES, values.get(CONTENT_CATEGORIES));
                values.put(PUBLISHER, publisher);
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
         * Set required info
         *
         * @param appName     - {@link String} Application name
         * @param packageName - {@link String} Package name
         * @param appDomain   - {@link String} Publisher domain name [i.e. https://www.timehop.com]
         * @param storeUrl    - {@link String} Store Url
         * @return {@link Builder}
         */
        public Builder withRequiredAppInfo(@NonNull String appName, @NonNull String packageName,
                                           @NonNull String appDomain, @NonNull String storeUrl) {
            values.put(NAME, appName);
            values.put(BUNDLE, packageName);
            values.put(DOMAIN, appDomain);
            values.put(STORE_URL, storeUrl);
            return this;
        }

        /**
         * Set categories
         *
         * @param categories - {@link String[]}
         * @return {@link Builder}
         */
        public Builder withCategories(String... categories) {
            values.put(CONTENT_CATEGORIES, categories);
            return this;
        }

        /**
         * Set if the app is paid or not
         *
         * @param appCost - {@link AppCost}
         * @return {@link Builder}
         */
        public Builder withAppCost(@AppCost int appCost) {
            values.put(PAID, appCost);
            return this;
        }

        /**
         * Set the {@link Publisher}
         *
         * @param publisher - {@link AndroidPublisher}
         * @return {@link Builder}
         */
        public Builder withPublisher(@NonNull AndroidPublisher publisher) {
            values.put(PUBLISHER, publisher);
            return this;
        }
    }
}
