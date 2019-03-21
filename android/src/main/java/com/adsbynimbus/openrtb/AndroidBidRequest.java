package com.adsbynimbus.openrtb;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.FORMAT;
import static java.lang.annotation.RetentionPolicy.SOURCE;


public class AndroidBidRequest extends ArrayMap<String, Object> implements BidRequest {

    @Retention(SOURCE)
    @StringDef({APP, DEVICE, FORMAT, USER, TEST, TIMEOUT, REGS, API_KEY, SESSION_ID})
    public @interface Values {}

    public static class Builder implements BidRequest.Builder {

        protected final AndroidBidRequest values = new AndroidBidRequest();

        @Override
        public BidRequest build() {
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
