package com.adsbynimbus.openrtb.user;

import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidRegs extends ArrayMap<String, Object> implements Regs {

    @Retention(SOURCE)
    @StringDef({COPPA, GDPR_CONSENT})
    public @interface Values {}

    public static class Builder implements Regs.Builder {

        protected final AndroidRegs values = new AndroidRegs();

        @Override
        public Regs build() {
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
