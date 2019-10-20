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
    @StringDef({COPPA, EXTENSION, Extension.GDPR})
    public @interface Values { }

    protected final ArrayMap<String, Object> ext = new ArrayMap<>(1);

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        if (Extension.GDPR.equals(key)) {
            put(EXTENSION, ext);
            return ext.put(key, value);
        }
        return super.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @param coppa {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder coppa(boolean coppa) {
        put(COPPA, coppa ? 1 : 0);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param gdpr {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder gdpr(boolean gdpr) {
        ext.put(Extension.GDPR, gdpr ? 1 : 0);
        put(EXTENSION, ext);
        return this;
    }
}
