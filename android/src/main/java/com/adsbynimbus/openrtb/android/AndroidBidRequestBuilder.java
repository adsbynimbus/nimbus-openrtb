package com.adsbynimbus.openrtb.android;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.BidRequest;
import com.adsbynimbus.openrtb.impression.Format;
import com.adsbynimbus.openrtb.impression.Impression;
import com.adsbynimbus.openrtb.targeting.distribution.App;
import com.adsbynimbus.openrtb.targeting.user.Device;
import com.adsbynimbus.openrtb.targeting.Regs;
import com.adsbynimbus.openrtb.targeting.Source;
import com.adsbynimbus.openrtb.targeting.user.User;

/**
 * BidRequest builder implementation with Androidx annotations for validation
 *
 * @see BidRequest
 */
public final class AndroidBidRequestBuilder implements BidRequest.Builder {

    /**
     * The bid request object this builder wraps
     */
    @NonNull
    private final BidRequest request;

    /**
     * Constructs a builder that will edit the fields of the bid request object in place.
     *
     * @param request a bid request object
     */
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
     * Returns a builder for the imp object. A new Impression object will be created if none exists.
     *
     * @return a builder wrapping the imp object
     */
    public AndroidImpressionBuilder impression() {
        if (request.imp == null || request.imp.length < 1 || request.imp[0] == null) {
            request.imp = new Impression[]{new Impression()};
        }
        return new AndroidImpressionBuilder(request.imp[0]);
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
     * Returns a builder for the app object. A new App object will be created if none exists.
     *
     * @return a builder wrapping the app object
     */
    public AndroidAppBuilder app() {
        if (request.app == null) {
            request.app = new App();
        }
        return new AndroidAppBuilder(request.app);
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
     * Returns a builder for the app object. A new App object will be created if none exists.
     *
     * @return a builder wrapping the app object
     */
    public AndroidDeviceBuilder device() {
        if (request.device == null) {
            request.device = new Device();
        }
        return new AndroidDeviceBuilder(request.device);
    }

    /**
     * {@inheritDoc}
     *
     * @param width  {@inheritDoc}
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
     * Returns a builder for the user object. A new User object will be created if none exists.
     *
     * @return a builder wrapping the user object
     */
    public AndroidUserBuilder user() {
        if (request.user == null) {
            request.user = new User();
        }
        return new AndroidUserBuilder(request.user);
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
     * Returns a builder for the regs object. A new Regs object will be created if none exists.
     *
     * @return a builder wrapping the regs object
     */
    public AndroidRegsBuilder regs() {
        if (request.regs == null) {
            request.regs = new Regs();
        }
        return new AndroidRegsBuilder(request.regs);
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
     * Returns a builder for the source object. A new Source object will be created if none exists.
     *
     * @return a builder wrapping the source object
     */
    public AndroidSourceBuilder source() {
        if (request.source == null) {
            request.source = new Source();
        }
        return new AndroidSourceBuilder(request.source);
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
