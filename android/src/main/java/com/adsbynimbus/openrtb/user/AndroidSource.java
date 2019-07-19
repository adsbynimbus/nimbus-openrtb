package com.adsbynimbus.openrtb.user;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidSource extends ArrayMap<String, Object> implements Source {

    @Retention(SOURCE)
    @StringDef({OM_PARTNER_NAME, OM_SDK_VERSION})
    public @interface Values { }

    public static class Builder implements Source.Builder {

        protected final AndroidSource values = new AndroidSource();
        protected ArrayMap<String, Object> ext;

        @Override
        public AndroidSource build() {
            return values;
        }

        @Override
        public Map<String, Object> getValues() {
            return values;
        }

        /**
         * Manually set a value on the builder object
         *
         * @param property - {@link AndroidRegs.Values}
         * @param value    - {@link Object}
         * @return {@link AndroidRegs.Builder}
         */
        public AndroidSource.Builder setValue(@AndroidRegs.Values String property, Object value) {
            values.put(property, value);
            return this;
        }

        /**
         * Set the OM SDK information for a measurement enabled app
         *
         * @param partnerName - String: should match the partner name field from OM
         * @return {@link AndroidSource.Builder}
         */
        public AndroidSource.Builder withOMSdkEnabled(@NonNull String partnerName,
                @NonNull String sdkVersion) {
            if (ext == null) {
                ext = new ArrayMap<>(2);
            }
            ext.put(OM_PARTNER_NAME, partnerName);
            ext.put(OM_SDK_VERSION, sdkVersion);
            return this;
        }
    }
}