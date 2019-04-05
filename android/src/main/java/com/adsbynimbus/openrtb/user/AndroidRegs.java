package com.adsbynimbus.openrtb.user;

import android.util.Log;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidRegs extends ArrayMap<String, Object> implements Regs {

    @Retention(SOURCE)
    @StringDef({COPPA, GDPR_CONSENT})
    public @interface Values { }

    public static class Builder implements Regs.Builder {

        protected final AndroidRegs values = new AndroidRegs();
        protected ArrayMap<String, Object> ext;

        @Override
        public AndroidRegs build() {
            return values;
        }

        @Override
        public Map<String, Object> getValues() {
            return values;
        }

        /**
         * Manually set a value on the builder object
         *
         * @param property - {@link Values}
         * @param value    - {@link Object}
         * @return {@link Builder}
         */
        public Builder setValue(@Values String property, Object value) {
            values.put(property, value);
            return this;
        }

        /**
         * Set the COPPA to true
         *
         * @return {@link Builder}
         */
        public Builder forCOPPA() {
            values.put(COPPA, 1);
            return this;
        }

        /**
         * Set the GDPR consent flag
         *
         * @param didConsent - boolean: true if did consent
         * @return {@link Builder}
         */
        public Builder withGDPRConsent(boolean didConsent) {
            if (didConsent) {
                if (ext == null) {
                    ext = new ArrayMap<>(1);
                }
                ext.put(GDPR_CONSENT, 1);
            } else {
                // Omit gdpr_consent = 0 (default)
                Log.d(AndroidRegs.Builder.class.getName(), String.format(OMIT_FORMAT, GDPR_CONSENT, '=', 0));
            }
            return this;
        }
    }
}
