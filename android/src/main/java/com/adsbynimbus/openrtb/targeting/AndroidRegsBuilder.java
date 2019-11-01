package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.NonNull;

/**
 * Regs builder object with Androidx annotations for validation
 *
 * @see Regs
 */
public final class AndroidRegsBuilder implements Regs.Builder {

    /**
     * This regs object this builder wraps
     */
    @NonNull
    public final Regs regs;

    /**
     * Constructs a builder that will edit the fields of the regs object in place
     *
     * @param regs a regs object
     */
    public AndroidRegsBuilder(@NonNull Regs regs) {
        this.regs = regs;
    }

    /**
     * {@inheritDoc}
     *
     * @param coppa {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidRegsBuilder coppa(boolean coppa) {
        regs.coppa = coppa ? 1 : 0;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param gdpr {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidRegsBuilder gdpr(boolean gdpr) {
        if (regs.ext == null) {
            regs.ext = new Regs.Extension();
        }
        regs.ext.gdpr = gdpr ? 1 : 0;
        return this;
    }
}
