package com.adsbynimbus.openrtb;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.impression.Format;
import com.adsbynimbus.openrtb.impression.Impression;
import com.adsbynimbus.openrtb.targeting.distribution.App;
import com.adsbynimbus.openrtb.targeting.user.Device;
import com.adsbynimbus.openrtb.targeting.Regs;
import com.adsbynimbus.openrtb.targeting.Source;
import com.adsbynimbus.openrtb.targeting.user.User;

/**
 *  Implementation of {@link BidRequest.Builder} with Androidx annotations for validation
 */
public final class AndroidBidRequestBuilder implements BidRequest.Builder {

    @NonNull
    public final BidRequest request;

    public AndroidBidRequestBuilder(@NonNull BidRequest request) {
        this.request = request;
    }

    /**
     * {@inheritDoc}
     *
     * @param impression {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder impression(@NonNull Impression impression) {
        request.imp = new Impression[]{impression};
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param app {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder app(@NonNull App app) {
        request.app = app;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param device {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder device(@NonNull Device device) {
        request.device = device;
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
    public AndroidBidRequestBuilder deviceSize(int width, int height) {
        request.format = new Format(width, height);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param user {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder user(@NonNull User user) {
        request.user = user;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param enabled {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder test(boolean enabled) {
        if (enabled) {
            request.test = 1;
        }
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param timeout {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder timeout(@IntRange(from = 1) int timeout) {
        request.tmax = timeout;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param regs {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder regs(@NonNull Regs regs) {
        request.regs = regs;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param source {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder source(@NonNull Source source) {
        request.source = source;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param domains {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder blockedDomains(@NonNull String... domains) {
        request.badv = domains;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param apiKey {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder apiKey(@NonNull String apiKey) {
        if (request.ext == null) {
            request.ext = new BidRequest.Extension();
        }
        request.ext.api_key = apiKey;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param sessionId {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidBidRequestBuilder sessionId(@NonNull String sessionId) {
        if (request.ext == null) {
            request.ext = new BidRequest.Extension();
        }
        request.ext.session_id = sessionId;
        return this;
    }
}
