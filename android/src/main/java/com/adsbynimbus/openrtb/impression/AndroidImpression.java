package com.adsbynimbus.openrtb.impression;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static com.adsbynimbus.openrtb.impression.BaseCreative.BID_FLOOR;
import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidImpression extends ArrayMap<String, Object> implements Impression {

    @Retention(SOURCE)
    @StringDef({BANNER, VIDEO, DISPLAY_MANAGER, DISPLAY_MANAGER_SERVER, INTERSTITIAL, BID_FLOOR, REQUIRE_HTTPS})
    public @interface Values {}

    public static class Builder implements Impression.Builder {

        protected final AndroidImpression values = new AndroidImpression();

        @Override
        public AndroidImpression build() {
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
