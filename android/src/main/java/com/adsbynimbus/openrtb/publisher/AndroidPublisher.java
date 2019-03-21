package com.adsbynimbus.openrtb.publisher;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidPublisher extends ArrayMap<String, Object> implements Publisher {

    @Retention(SOURCE)
    @StringDef({NAME, DOMAIN, CONTENT_CATEGORIES, FACEBOOK_APP_ID})
    public @interface Values {}

    public static class Builder implements Publisher.Builder {

        protected final AndroidPublisher values = new AndroidPublisher();

        @Override
        public AndroidPublisher build() {
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
