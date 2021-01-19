package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.App;
import com.adsbynimbus.openrtb.request.BidRequest;
import com.adsbynimbus.openrtb.request.Device;
import com.adsbynimbus.openrtb.request.Format;
import com.adsbynimbus.openrtb.request.Impression;
import com.adsbynimbus.openrtb.request.Regs;
import com.adsbynimbus.openrtb.request.Source;
import com.adsbynimbus.openrtb.request.User;

/**
 * BidRequest builder implementation with Androidx annotations for validation
 */
public final class AndroidBidRequestBuilder implements BidRequest.Builder {
    
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
    
    @Override @NonNull
    public AndroidBidRequestBuilder impression(@Nullable Impression impression) {
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

    @Override @NonNull
    public AndroidBidRequestBuilder app(@Nullable App app) {
        request.app = app;
        return this;
    }

    /**
     * Returns a builder for the app object. A new App object will be created if none exists.
     *
     * @return a builder wrapping the app object
     */
    @NonNull
    public AndroidAppBuilder app() {
        if (request.app == null) {
            request.app = new App();
        }
        return new AndroidAppBuilder(request.app);
    }

    /**
     * Returns a builder for the app object. A new App object will be created if none exists.
     *
     * @return a builder wrapping the app object
     */
    @NonNull
    public AndroidDeviceBuilder device() {
        if (request.device == null) {
            request.device = new Device();
        }
        return new AndroidDeviceBuilder(request.device);
    }

    /**
     * Returns a builder for the regs object. A new Regs object will be created if none exists.
     *
     * @return a builder wrapping the regs object
     */
    @NonNull
    public AndroidRegsBuilder regs() {
        if (request.regs == null) {
            request.regs = new Regs();
        }
        return new AndroidRegsBuilder(request.regs);
    }

    /**
     * Returns a builder for the source object. A new Source object will be created if none exists.
     *
     * @return a builder wrapping the source object
     */
    @NonNull
    public AndroidSourceBuilder source() {
        if (request.source == null) {
            request.source = new Source();
        }
        return new AndroidSourceBuilder(request.source);
    }

    /**
     * Returns a builder for the user object. A new User object will be created if none exists.
     *
     * @return a builder wrapping the user object
     */
    @NonNull
    public AndroidUserBuilder user() {
        if (request.user == null) {
            request.user = new User();
        }
        return new AndroidUserBuilder(request.user);
    }

    @Override @NonNull
    public AndroidBidRequestBuilder device(@Nullable Device device) {
        request.device = device;
        return this;
    }

    @Override @NonNull
    public AndroidBidRequestBuilder deviceSize(int width, int height) {
        request.format = new Format(width, height);
        return this;
    }

    @Override @NonNull
    public AndroidBidRequestBuilder user(@Nullable User user) {
        request.user = user;
        return this;
    }

    @Override @NonNull
    public AndroidBidRequestBuilder test(boolean enabled) {
        if (enabled) {
            request.test = 1;
        }
        return this;
    }

    @Override @NonNull
    public AndroidBidRequestBuilder timeout(@IntRange(from = 1) int timeout) {
        request.tmax = timeout;
        return this;
    }

    @Override @NonNull
    public AndroidBidRequestBuilder regs(@Nullable Regs regs) {
        request.regs = regs;
        return this;
    }

    @Override @NonNull
    public AndroidBidRequestBuilder source(@Nullable Source source) {
        request.source = source;
        return this;
    }

    @Override @NonNull
    public AndroidBidRequestBuilder blockedDomains(@Nullable String... domains) {
        request.badv = domains;
        return this;
    }

    @Override @NonNull
    public AndroidBidRequestBuilder sessionId(@Nullable String sessionId) {
        if (request.ext == null) {
            request.ext = new BidRequest.Extension();
        }
        request.ext.session_id = sessionId;
        return this;
    }
}
