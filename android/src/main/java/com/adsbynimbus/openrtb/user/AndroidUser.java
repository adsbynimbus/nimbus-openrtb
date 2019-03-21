package com.adsbynimbus.openrtb.user;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidUser extends ArrayMap<String, Object> implements User {

    @Retention(SOURCE)
    @StringDef({AGE, YEAR_OF_BIRTH, BUYER_ID, GENDER, CONSENT, DID_CONSENT})
    public @interface Values {}

    public static class Builder implements User.Builder {

        protected final AndroidUser values = new AndroidUser();

        @Override
        public AndroidUser build() {
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
