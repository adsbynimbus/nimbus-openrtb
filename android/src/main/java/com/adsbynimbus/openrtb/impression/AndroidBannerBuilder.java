package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

import java.util.EnumSet;

/**
 * Implementation of {@link Banner.Builder} with Androidx annotations for validation
 */
public class AndroidBannerBuilder implements Banner.Builder {

    @NonNull
    public final Banner banner;

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
    public AndroidBannerBuilder position(Position position) {
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
    public AndroidBannerBuilder apis(EnumSet<Api> apis) {
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
    public AndroidBannerBuilder blockedAttributes(EnumSet<Attribute> battr) {
        banner.battr = battr;
        return this;
    }
}