package com.adsbynimbus.openrtb.publisher;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidApp extends ArrayMap<String, Object> implements App {

    @Retention(SOURCE)
    @StringDef({NAME, DOMAIN, CONTENT_CATEGORIES, BUNDLE, STORE_URL, PAID, PUBLISHER})
    public @interface Values {}

    public static class Builder implements App.Builder {

        protected final AndroidApp values = new AndroidApp();

        @Override
        public AndroidApp build() {
            return values;
        }

        @Override
        public Map getValues() {
            return values;
        }

        public Builder setValue(@Values String property, Object value) {
            values.put(property, value);
            return this;
        }
    }
}
