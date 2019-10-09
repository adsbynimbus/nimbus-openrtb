package com.adsbynimbus.openrtb;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import com.adsbynimbus.openrtb.impression.AndroidFormat;
import com.adsbynimbus.openrtb.impression.Impression;
import com.adsbynimbus.openrtb.publisher.App;
import com.adsbynimbus.openrtb.user.Device;
import com.adsbynimbus.openrtb.user.Regs;
import com.adsbynimbus.openrtb.user.Source;
import com.adsbynimbus.openrtb.user.User;

import java.lang.annotation.Retention;

import static com.adsbynimbus.openrtb.impression.Format.FORMAT;

/**
 * {@link ArrayMap} implementation of {@link BidRequest} for convenient building and serialization
 */
public class AndroidBidRequest extends ArrayMap<String, Object> implements BidRequest, BidRequest.Builder {

    @Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @StringDef({APP, DEVICE, FORMAT, IMP, USER, SOURCE, TEST, TIMEOUT, REGS, BADV, EXTENSION,
        Extension.API_KEY, Extension.SESSION_ID})
    public @interface Values { }

    public final ArrayMap<String, Object> ext = new ArrayMap<>(2);

    public AndroidBidRequest build() {
        if (!ext.isEmpty()) {
            put(EXTENSION, ext);
        }
        return this;
    }

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        if (Extension.API_KEY.equals(key) || Extension.SESSION_ID.equals(key)) {
            return ext.put(key, value);
        }
        return super.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @param impressions {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder forImpressions(@NonNull Impression... impressions) {
        put(IMP, impressions);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param app {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder forApp(@NonNull App app) {
        put(APP, app);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param device {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder forDevice(@NonNull Device device) {
        put(DEVICE, device);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param width {@inheritDoc}
     * @param height {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder forDeviceSize(int width, int height) {
        put(FORMAT, new AndroidFormat(width, height));
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param user {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withUser(@NonNull User user) {
        put(USER, user);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public Builder withTestFlag() {
        put(TEST, 1);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param timeout {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withTimeout(@IntRange(from = 1) int timeout) {
        put(TIMEOUT, timeout);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param regs {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withRegs(@NonNull Regs regs) {
        put(REGS, regs);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param source {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withSource(@NonNull Source source) {
        put(SOURCE, source);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param domains {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withBlockedDomains(@NonNull String... domains) {
        put(BADV, domains);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param apiKey {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withApiKey(@NonNull String apiKey) {
        ext.put(Extension.API_KEY, apiKey);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param sessionId {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withSessionId(@NonNull String sessionId) {
        ext.put(Extension.SESSION_ID, sessionId);
        return this;
    }
}
