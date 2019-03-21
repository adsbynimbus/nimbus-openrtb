package com.adsbynimbus.openrtb.user;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidGeo extends ArrayMap<String, Object> implements Geo {

    @Retention(SOURCE)
    @StringDef({LATITUDE, LONGITUDE, TYPE, ACCURACY, COUNTRY, CITY})
    public @interface Values {}

    public static class Builder implements Geo.Builder {

        protected final AndroidGeo values = new AndroidGeo();

        @Override
        public AndroidGeo build() {
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
