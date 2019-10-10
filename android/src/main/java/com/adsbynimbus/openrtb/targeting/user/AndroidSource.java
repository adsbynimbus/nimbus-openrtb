package com.adsbynimbus.openrtb.targeting.user;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;

import static com.adsbynimbus.openrtb.BidRequest.EXTENSION;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link com.adsbynimbus.openrtb.targeting.user.Source} for convenient building and serialization
 */
public class AndroidSource extends ArrayMap<String, Object> implements com.adsbynimbus.openrtb.targeting.user.Source, Source.Builder {

    @Retention(SOURCE)
    @StringDef({EXTENSION, Extension.OM_PARTNER_NAME, Extension.OM_SDK_VERSION})
    public @interface Values { }

    public final ArrayMap<String, Object> ext = new ArrayMap<>(2);

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        if (Extension.OM_PARTNER_NAME.equals(key) || Extension.OM_SDK_VERSION.equals(key)) {
            return ext.put(key, value);
        }
        return super.put(key, value);
    }

    public AndroidSource build() {
        if (!ext.isEmpty()) {
            put(EXTENSION, ext);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param partnerName {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidSource.Builder withOMSdkEnabled(@NonNull String partnerName, @NonNull String sdkVersion) {
        ext.put(Extension.OM_PARTNER_NAME, partnerName);
        ext.put(Extension.OM_SDK_VERSION, sdkVersion);
        return this;
    }
}