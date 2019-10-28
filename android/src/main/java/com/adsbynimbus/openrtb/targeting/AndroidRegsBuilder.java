package com.adsbynimbus.openrtb.targeting;

/**
 * Implementation of {@link Regs.Builder} with Androidx annotations for validation
 */
public final class AndroidRegsBuilder implements Regs.Builder {

    public final Regs regs;

    public AndroidRegsBuilder(Regs regs) {
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
