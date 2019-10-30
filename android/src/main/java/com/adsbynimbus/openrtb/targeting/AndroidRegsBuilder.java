package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.NonNull;

/**
 * Implementation of {@link Regs.Builder} with Androidx annotations for validation
 *
 * @see Regs
 */
public final class AndroidRegsBuilder implements Regs.Builder {

    /**
     * This {@link Regs} object this builder wraps
     */
    @NonNull
    public final Regs regs;

    /**
     * Constructs a {@link AndroidRegsBuilder} that will edit the fields of the {@link Regs} object in place
     *
     * @param regs a non null regs object
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
