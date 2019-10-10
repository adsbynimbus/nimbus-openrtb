package com.adsbynimbus.openrtb.targeting.user;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;

import static com.adsbynimbus.openrtb.BidRequest.EXTENSION;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link User} for convenient building and serialization
 */
public class AndroidUser extends ArrayMap<String, Object> implements User, User.Builder {

    @Retention(SOURCE)
    @StringDef({AGE, YEAR_OF_BIRTH, BUYER_UID, GENDER, EXTENSION, Extension.CONSENT, Extension.DID_CONSENT})
    public @interface Values { }

    @Retention(SOURCE)
    @StringDef({MALE, FEMALE})
    public @interface Gender { }

    public final ArrayMap<String, Object> ext = new ArrayMap<>(2);

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        if (Extension.CONSENT.equals(key) || Extension.DID_CONSENT.equals(key)) {
            put(EXTENSION, ext);
            return ext.put(key, value);
        }
        return super.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @param age {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withAge(@IntRange(from = 0) int age) {
        put(AGE, age);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param buyerUid {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withBuyerUid(@NonNull String buyerUid) {
        put(BUYER_UID, buyerUid);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param yob {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withYearOfBirth(@IntRange(from = 0) int yob) {
        put(YEAR_OF_BIRTH, yob);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param gender {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withGender(@Gender String gender) {
        put(GENDER, gender);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param consentString {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withIABConsentString(@NonNull String consentString) {
        ext.put(Extension.CONSENT, consentString);
        put(EXTENSION, ext);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param didConsent {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withGDPRConsent(boolean didConsent) {
        ext.put(Extension.DID_CONSENT, didConsent ? 1 : 0);
        put(EXTENSION, ext);
        return this;
    }
}