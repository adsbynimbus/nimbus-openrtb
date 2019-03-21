package com.adsbynimbus.openrtb.impression;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidFormat extends ArrayMap<String, Object> implements Format {

    @Retention(SOURCE)
    @StringDef({WIDTH, HEIGHT})
    public @interface Values {}

    public static class Builder implements Format.Builder {

        protected final AndroidFormat values = new AndroidFormat();

        @Override
        public AndroidFormat build() {
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
