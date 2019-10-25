package com.adsbynimbus.openrtb.targeting.user;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.targeting.Data;

/**
 * Implementation of {@link User.Builder} with Androidx annotations for validation
 */
public class AndroidUserBuilder implements User.Builder {

    @NonNull
    public final User user;

    public AndroidUserBuilder(@NonNull User user) {
        this.user = user;
    }

    /**
     * {@inheritDoc}
     *
     * @param age {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidUserBuilder age(@IntRange(from = 0) int age) {
        user.age = age;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param buyerUid {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidUserBuilder buyerUid(@NonNull String buyerUid) {
        user.buyeruid = buyerUid;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param yob {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidUserBuilder yearOfBirth(@IntRange(from = 0) int yob) {
        user.yob = yob;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param gender {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidUserBuilder gender(String gender) {
        user.gender = gender;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param keywords {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidUserBuilder keywords(String keywords) {
        user.keywords = keywords;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param customData {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidUserBuilder customData(String customData) {
        user.custom_data = customData;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param data {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidUserBuilder data(Data... data) {
        user.data = data;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param consentString {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidUserBuilder gdprConsentString(@NonNull String consentString) {
        if (user.ext == null) {
            user.ext = new User.Extension();
        }
        user.ext.consent = consentString;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param didConsent {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidUserBuilder gdprDidConsent(boolean didConsent) {
        if (user.ext == null) {
            user.ext = new User.Extension();
        }
        user.ext.did_consent = didConsent ? 1 : 0;
        return this;
    }
}