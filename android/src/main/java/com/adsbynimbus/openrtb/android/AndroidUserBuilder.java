package com.adsbynimbus.openrtb.android;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;

import com.adsbynimbus.openrtb.request.Data;
import com.adsbynimbus.openrtb.request.User;

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
    private final User user;

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
    @Override @NonNull
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
    @Override @NonNull
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
    @Override @NonNull
    public AndroidUserBuilder yearOfBirth(@Nullable @IntRange(from = 0) Integer yob) {
        user.yob = yob;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param gender {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidUserBuilder gender(@Nullable @Gender String gender) {
        user.gender = gender;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param keywords {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidUserBuilder keywords(@Nullable String keywords) {
        user.keywords = keywords;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param customData {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidUserBuilder customData(@Nullable String customData) {
        user.custom_data = customData;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param data {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidUserBuilder data(@Nullable Data... data) {
        user.data = data;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param consentString {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidUserBuilder gdprConsentString(@Nullable String consentString) {
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
    @Override @NonNull
    public AndroidUserBuilder gdprDidConsent(boolean didConsent) {
        if (user.ext == null) {
            user.ext = new User.Extension();
        }
        user.ext.did_consent = didConsent ? 1 : 0;
        return this;
    }
}