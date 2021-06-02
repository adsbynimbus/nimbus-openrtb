package com.adsbynimbus.openrtb.request.builders;

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
 */
public final class AndroidUserBuilder implements User.Builder {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({User.MALE, User.FEMAlE})
    public @interface Gender { }

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

    @Override @NonNull
    public AndroidUserBuilder age(@IntRange(from = 0) int age) {
        user.age = age;
        return this;
    }

    @Override @NonNull
    public AndroidUserBuilder buyerUid(@Nullable String buyerUid) {
        user.buyeruid = buyerUid;
        return this;
    }

    @Override @NonNull
    public AndroidUserBuilder yearOfBirth(@IntRange(from = 0) int yob) {
        user.yob = yob;
        return this;
    }

    @Override @NonNull
    public AndroidUserBuilder gender(@Gender String gender) {
        user.gender = gender;
        return this;
    }

    @Override @NonNull
    public AndroidUserBuilder keywords(String keywords) {
        user.keywords = keywords;
        return this;
    }

    @Override @NonNull
    public AndroidUserBuilder customData(String customData) {
        user.custom_data = customData;
        return this;
    }

    @Override @NonNull
    public AndroidUserBuilder data(Data... data) {
        user.data = data;
        return this;
    }

    @Override @NonNull
    public AndroidUserBuilder gdprConsentString(@Nullable String consentString) {
        if (user.ext == null) {
            user.ext = new User.Extension();
        }
        user.ext.consent = consentString;
        return this;
    }

    @Override @NonNull
    public AndroidUserBuilder gdprDidConsent(boolean didConsent) {
        if (user.ext == null) {
            user.ext = new User.Extension();
        }
        user.ext.did_consent = didConsent ? 1 : 0;
        return this;
    }

    @Override @NonNull
    public AndroidUserBuilder unityBuyerId(@Nullable String token) {
        if (user.ext == null) {
            user.ext = new User.Extension();
        }
        user.ext.unity_buyeruid = token;
        return this;
    }
}