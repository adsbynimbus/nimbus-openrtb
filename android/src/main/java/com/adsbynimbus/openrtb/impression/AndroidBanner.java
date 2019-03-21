package com.adsbynimbus.openrtb.impression;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.FORMAT;
import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;
import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidBanner extends ArrayMap<String, Object> implements Banner {

    @Retention(SOURCE)
    @StringDef({BID_FLOOR, FORMAT, WIDTH, HEIGHT, POSITION, MIME_TYPES, SUPPORTED_APIS})
    public @interface Values {}

    public static class Builder implements Banner.Builder {

        protected final AndroidBanner values = new AndroidBanner();

        @Override
        public AndroidBanner build() {
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
