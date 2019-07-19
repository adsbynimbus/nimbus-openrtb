package com.adsbynimbus.openrtb;

import android.util.Log;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import com.adsbynimbus.openrtb.impression.AndroidFormat;
import com.adsbynimbus.openrtb.impression.AndroidImpression;
import com.adsbynimbus.openrtb.impression.Impression;
import com.adsbynimbus.openrtb.publisher.AndroidApp;
import com.adsbynimbus.openrtb.publisher.App;
import com.adsbynimbus.openrtb.user.AndroidDevice;
import com.adsbynimbus.openrtb.user.AndroidRegs;
import com.adsbynimbus.openrtb.user.AndroidSource;
import com.adsbynimbus.openrtb.user.AndroidUser;
import com.adsbynimbus.openrtb.user.Device;
import com.adsbynimbus.openrtb.user.Regs;
import com.adsbynimbus.openrtb.user.User;

import java.lang.annotation.Retention;
import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.FORMAT;
import static com.adsbynimbus.openrtb.internal.NimbusRTB.EXTENSION;

public class AndroidBidRequest extends ArrayMap<String, Object> implements BidRequest {

    @Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @StringDef({APP, DEVICE, FORMAT, USER, TEST, TIMEOUT, REGS, BADV, API_KEY, SESSION_ID})
    public @interface Values { }

    public static class Builder implements BidRequest.Builder {

        protected final AndroidBidRequest values = new AndroidBidRequest();
        protected final ArrayMap<String, Object> ext = new ArrayMap<>(2);

        @Override
        public AndroidBidRequest build() {
            values.put(EXTENSION, ext);
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
         * Set the {@link Impression} object
         *
         * @param impression - {@link AndroidImpression}
         * @return {@link Builder}
         */
        public Builder forImpression(@NonNull AndroidImpression impression) {
            values.put(IMP, new AndroidImpression[]{impression});
            return this;
        }

        /**
         * Set the {@link App} object
         *
         * @param app - {@link AndroidApp}
         * @return {@link Builder}
         */
        public Builder forApp(@NonNull AndroidApp app) {
            values.put(APP, app);
            return this;
        }

        /**
         * Set the {@link Device} object
         *
         * @param device - {@link AndroidDevice}
         * @return {@link Builder}
         */
        public Builder forDevice(@NonNull AndroidDevice device) {
            values.put(DEVICE, device);
            return this;
        }

        /**
         * Set the device size as "format" object. This is a Nimbus modification
         *
         * @param width  - int width
         * @param height - int height
         * @return {@link Builder}
         */
        public Builder forDeviceSize(int width, int height) {
            values.put(FORMAT, new AndroidFormat(width, height));
            return this;
        }

        /**
         * Set the {@link User} object
         *
         * @param user - {@link AndroidUser}
         * @return {@link Builder}
         */
        public Builder withUser(@NonNull AndroidUser user) {
            values.put(USER, user);
            return this;
        }

        /**
         * Mark this request as a test
         *
         * @return {@link Builder}
         */
        public Builder withTestFlag() {
            values.put(TEST, 1);
            return this;
        }

        /**
         * Set the timeout of the request.
         *
         * @param timeout - int [Default: 500]
         * @return {@link Builder}
         */
        public Builder withTimeout(@IntRange(from = 1) int timeout) {
            if (INCLUDE_DEFAULTS.get()) {
                values.put(TIMEOUT, timeout);
                return this;
            }

            if (timeout < 1) {
                // Omit timeout < 1 (invalid)
                Log.d(AndroidBidRequest.Builder.class.getName(), String.format(OMIT_FORMAT, TIMEOUT, '<', 1));
            } else if (timeout == 500) {
                // Omit timeout = 500 (default)
                Log.d(AndroidBidRequest.Builder.class.getName(), String.format(OMIT_FORMAT, TIMEOUT, '=', 500));
            } else {
                values.put(TIMEOUT, timeout);
            }
            return this;
        }

        /**
         * Sets the {@link Regs} object
         *
         * @param regs - {@link AndroidRegs}
         * @return {@link Builder}
         */
        public Builder withRegs(@NonNull AndroidRegs regs) {
            values.put(REGS, regs);
            return this;
        }

        /**
         * Sets the {@link AndroidSource} object
         *
         * @param source - {@link AndroidSource}
         * @return {@link Builder}
         */
        public Builder withSource(@NonNull AndroidSource source) {
            values.put(SOURCE, source);
            return this;
        }

        /**
         * Sets a list of blocked advertisers by domains
         *
         * @param domains - {@link String}...
         * @return {@link Builder}
         */
        public Builder withBlockedDomains(@NonNull String... domains) {
            values.put(BADV, domains);
            return this;
        }

        /**
         * Sets the Nimbus API key
         *
         * @param apiKey - {@link String}
         * @return {@link Builder}
         */
        public Builder withApiKey(@NonNull String apiKey) {
            ext.put(API_KEY, apiKey);
            return this;
        }

        /**
         * Sets the Nimbus session id
         *
         * @param sessionId - {@link String}
         * @return {@link Builder}
         */
        public Builder withSessionId(@NonNull String sessionId) {
            ext.put(SESSION_ID, sessionId);
            return this;
        }
    }
}
