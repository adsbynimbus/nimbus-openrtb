package com.adsbynimbus.openrtb.impression;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;
import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidVideo extends ArrayMap<String, Object> implements Video {

    @Retention(SOURCE)
    @StringDef({BID_FLOOR, MIME_TYPES, MIN_DURATION, MAX_DURATION, PROTOCOLS, WIDTH, HEIGHT, START_DELAY, SKIP,
        SKIP_MIN, SKIP_AFTER, MIN_BITRATE, MAX_BITRATE, POSITION, SUPPORTED_APIS})
    public @interface Values {}

    public static class Builder implements Video.Builder {

        protected final AndroidVideo values = new AndroidVideo();

        @Override
        public AndroidVideo build() {
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
