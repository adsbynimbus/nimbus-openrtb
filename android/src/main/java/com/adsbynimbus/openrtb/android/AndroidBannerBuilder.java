package com.adsbynimbus.openrtb.android;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.Banner;
import com.adsbynimbus.openrtb.request.Format;

/**
 * Banner builder implementation with Androidx annotations for validation
 *
 * @see Banner
 */
public final class AndroidBannerBuilder implements Banner.Builder {

    /**
     * The banner object this builder wraps.
     */
    @NonNull
    public final Banner banner;

    /**
     * Constructs an builder that will edit the fields of the banner object in place.
     *
     * @param banner a banner object
     */
    public AndroidBannerBuilder(@NonNull Banner banner) {
        this.banner = banner;
    }

    /**
     * {@inheritDoc}
     *
     * @param format {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidBannerBuilder format(@Nullable Format... format) {
        banner.format = format;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param width {@inheritDoc}
     * @param height {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidBannerBuilder size(int width, int height) {
        banner.w = width;
        banner.h = height;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param position {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidBannerBuilder position(@PositionInt int position) {
        banner.pos = position;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param bidFloor {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidBannerBuilder bidFloor(@FloatRange(from = 0) float bidFloor) {
        banner.bidfloor = bidFloor;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param apis {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidBannerBuilder apis(@ApiInt int... apis) {
        banner.api = apis;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param battr {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidBannerBuilder blockedAttributes(@CreativeAttributeInt int... battr) {
        banner.battr = battr;
        return this;
    }
}