package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;

import static com.adsbynimbus.openrtb.BidRequest.EXTENSION;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link Regs} for convenient building and serialization
 */
public class AndroidRegs extends ArrayMap<String, Object> implements Regs, Regs.Builder {

    @Retention(SOURCE)
    @StringDef({COPPA, EXTENSION, Extension.GDPR_CONSENT})
    public @interface Values { }

    protected final ArrayMap<String, Object> ext = new ArrayMap<>(1);

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        if (Extension.GDPR_CONSENT.equals(key)) {
            put(EXTENSION, ext);
            return ext.put(key, value);
        }
        return super.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @param isCOPPA {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder setCOPPA(boolean isCOPPA) {
        put(COPPA, isCOPPA ? 1 : 0);
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
        ext.put(Extension.GDPR_CONSENT, didConsent ? 1 : 0);
        put(EXTENSION, ext);
        return this;
    }
}
