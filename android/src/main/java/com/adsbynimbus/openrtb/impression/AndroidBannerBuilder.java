package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import java.lang.annotation.Retention;

/**
 * Implementation of {@link Banner.Builder} with Androidx annotations for validation
 *
 * @see Banner
 */
public final class AndroidBannerBuilder implements Banner.Builder {

    /**
     * The {@link Banner} object this builder wraps
     */
    @NonNull
    public final Banner banner;

    /**
     * Constructs a {@link AndroidBannerBuilder} that will edit the fields of the {@link Banner} object in place
     *
     * @param banner a non null banner object
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
    @Override
    public AndroidBannerBuilder format(@NonNull Format... format) {
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public AndroidBannerBuilder blockedAttributes(@CreativeAttributeInt int... battr) {
        banner.battr = battr;
        return this;
    }
}