package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.Regs;

/**
 * Regs builder object with Androidx annotations for validation
 */
public final class AndroidRegsBuilder implements Regs.Builder {

    @NonNull
    private final Regs regs;

    /**
     * Constructs a builder that will edit the fields of the regs object in place
     *
     * @param regs a regs object
     */
    public AndroidRegsBuilder(@NonNull Regs regs) {
        this.regs = regs;
    }

    @Override @NonNull
    public AndroidRegsBuilder coppa(boolean coppa) {
        regs.coppa = coppa ? 1 : 0;
        return this;
    }

    @Override @NonNull
    public AndroidRegsBuilder gdpr(boolean gdpr) {
        if (regs.ext == null) {
            regs.ext = new Regs.Extension();
        }
        regs.ext.gdpr = gdpr ? 1 : 0;
        return this;
    }

    @Override @NonNull
    public Regs.Builder ccpa(@Nullable String usPrivacyString) {
        if (regs.ext == null) {
            regs.ext = new Regs.Extension();
        }
        regs.ext.us_privacy = usPrivacyString;
        return this;
    }
}
