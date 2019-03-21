package com.adsbynimbus.openrtb.user;

import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.Map;

import static com.adsbynimbus.openrtb.internal.NimbusRTB.EXTENSION;
import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidUser extends ArrayMap<String, Object> implements User {

    @Retention(SOURCE)
    @StringDef({AGE, YEAR_OF_BIRTH, BUYER_ID, GENDER, CONSENT, DID_CONSENT})
    public @interface Values { }

    @Retention(SOURCE)
    @StringDef({MALE, FEMALE, OTHER})
    public @interface Gender { }

    public static class Builder implements User.Builder {

        protected final AndroidUser values = new AndroidUser();
        protected ArrayMap<String, Object> ext;

        @Override
        public AndroidUser build() {
            if (ext != null) {
                values.put(EXTENSION, ext);
            }
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
         * Set the age of the user
         *
         * @param age - age
         * @return {@link Builder}
         */
        public Builder withAge(@IntRange(from = 0) int age) {
            values.put(AGE, age);
            return this;
        }

        /**
         * Set the buyer id. If using Facebook this is the bidder token
         *
         * @param buyerId - {@link String}
         * @return {@link Builder}
         */
        public Builder withBuyerId(@NonNull String buyerId) {
            values.put(BUYER_ID, buyerId);
            return this;
        }

        /**
         * Set the age of the user
         *
         * @param yob - year of birth
         * @return {@link Builder}
         */
        public Builder withYearOfBirth(@IntRange(from = 0) int yob) {
            values.put(YEAR_OF_BIRTH, yob);
            return this;
        }

        /**
         * Sets the gender of the user
         *
         * @param gender - {@link Gender} [M, F, or O]
         * @return {@link Builder}
         */
        public Builder withGender(@Gender String gender) {
            values.put(GENDER, gender);
            return this;
        }

        /**
         * Adds the IAB consent string to the request
         *
         * @param consentString - {@link String}
         * @return {@link Builder}
         */
        public Builder withIABConsentString(@NonNull String consentString) {
            if (ext == null) {
                ext = new ArrayMap<>(2);
            }
            ext.put(CONSENT, consentString);
            return this;
        }

        /**
         * Adds the IAB consent string to the request
         *
         * @param didConsent - boolean: true if gave consent [Default: false]
         * @return {@link Builder}
         */
        public Builder withGDPRConsent(boolean didConsent) {
            if (didConsent) {
                if (ext == null) {
                    ext = new ArrayMap<>(2);
                }
                ext.put(DID_CONSENT, 1);
            } else {
                // Omit did_consent = 0 (Default)
                Log.d(AndroidUser.Builder.class.getName(), String.format(OMIT_FORMAT, DID_CONSENT, '=', 0));
            }
            return this;
        }
    }
}