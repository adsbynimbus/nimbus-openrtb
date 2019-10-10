package com.adsbynimbus.openrtb.targeting;

import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;

import static com.adsbynimbus.openrtb.targeting.Data.ID;
import static com.adsbynimbus.openrtb.targeting.Data.NAME;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@inheritDoc}
 */
public class AndroidSegment extends ArrayMap<String, Object> implements Segment, Segment.Builder {

    @Retention(SOURCE)
    @StringDef({ID, NAME, VALUE})
    public @interface Values { }

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        return super.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @param id {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withId(String id) {
        put(ID, id);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param name {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withName(String name) {
        put(NAME, name);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param value {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withValue(String value) {
        put(VALUE, value);
        return this;
    }
}
