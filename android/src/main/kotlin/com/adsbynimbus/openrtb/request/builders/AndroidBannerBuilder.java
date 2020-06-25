package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.Banner;
import com.adsbynimbus.openrtb.request.Format;

import org.jetbrains.annotations.NotNull;

/**
 * Banner builder implementation with Androidx annotations for validation
 */
public final class AndroidBannerBuilder implements Banner.Builder {

    @NonNull
    private final Banner banner;

    /**
     * Constructs an builder that will edit the fields of the banner object in place.
     *
     * @param banner a banner object
     */
    public AndroidBannerBuilder(@NonNull Banner banner) {
        this.banner = banner;
    }
    
    @Override @NonNull
    public AndroidBannerBuilder format(@Nullable Format... format) {
        banner.format = format;
        return this;
    }
    
    @Override @NonNull
    public AndroidBannerBuilder size(int width, int height) {
        banner.w = width;
        banner.h = height;
        return this;
    }

    @Override @NonNull
    public AndroidBannerBuilder position(@PositionInt int position) {
        banner.pos = position;
        return this;
    }

    @Override @NonNull
    public AndroidBannerBuilder bidFloor(@FloatRange(from = 0) float bidFloor) {
        banner.bidfloor = bidFloor;
        return this;
    }

    @Override @NonNull
    public AndroidBannerBuilder apis(@ApiInt @NonNull int... apis) {
        banner.api = apis;
        return this;
    }

    @Override @NonNull
    public AndroidBannerBuilder blockedAttributes(@CreativeAttributeInt @NonNull int... battr) {
        banner.battr = battr;
        return this;
    }

    @Override @NotNull
    public Banner.Builder vcm(int vcm) {
        banner.vcm = vcm;
        return this;
    }
}