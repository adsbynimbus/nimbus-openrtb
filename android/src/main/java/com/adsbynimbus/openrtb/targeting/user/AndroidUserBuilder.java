package com.adsbynimbus.openrtb.targeting.user;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;

import com.adsbynimbus.openrtb.targeting.Data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * User builder with Androidx annotations for validation
 *
 * @see User
 */
public final class AndroidUserBuilder implements User.Builder {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({User.MALE, User.FEMAlE})
    public @interface Gender { }

    /**
     * The user object this builder wraps
     */
    @NonNull
    public final User user;

    /**
     * Constructs a builder that will edit the fields of the user object in place.
     *
     * @param user a user object
     */
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
    public AndroidUserBuilder gender(@Gender String gender) {
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