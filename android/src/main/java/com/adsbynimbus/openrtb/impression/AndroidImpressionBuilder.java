package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

import java.util.List;

/**
 * Impression builder implementation with Androidx annotations for validation
 *
 * @see Impression
 */
public final class AndroidImpressionBuilder implements Impression.Builder {

    /**
     * The impression object this builder wraps.
     */
    @NonNull
    public final Impression impression;

    /**
     * Constructs a builder that will edit the fields of the impression object in place.
     *
     * @param impression an impression object
     */
    public AndroidImpressionBuilder(@NonNull Impression impression) {
        this.impression = impression;
    }

    /**
     * {@inheritDoc}
     *
     * @param id {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidImpressionBuilder id(String id) {
        impression.id = id;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param banner {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidImpressionBuilder banner(@NonNull Banner banner) {
        impression.banner = banner;
        return this;
    }

    /**
     * Returns a builder for the banner object. A new {@link Banner} object will be created if none exists.
     *
     * @return a builder wrapping the banner object
     * @see Banner
     */
    public AndroidBannerBuilder banner() {
        if (impression.banner == null) {
            impression.banner = new Banner();
        }
        return new AndroidBannerBuilder(impression.banner);
    }

    /**
     * {@inheritDoc}
     *
     * @param video {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidImpressionBuilder video(@NonNull Video video) {
        impression.video = video;
        return this;
    }

    /**
     * Returns a builder for the video object. A new {@link Video} object will be created if none exists.
     *
     * @return a builder wrapping the video object
     * @see Video
     */
    public AndroidVideoBuilder video() {
        if (impression.video == null) {
            impression.video = new Video();
        }
        return new AndroidVideoBuilder(impression.video);
    }

    /**
     * {@inheritDoc}
     *
     * @param bidFloor {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidImpressionBuilder bidFloor(@FloatRange(from = 0) float bidFloor) {
        impression.bidfloor = bidFloor;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param instl {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidImpressionBuilder interstitial(boolean instl) {
        impression.instl = instl ? 1 : 0;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param secure {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidImpressionBuilder secure(boolean secure) {
        impression.secure = secure ? 1 : 0;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param facebookAppId {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidImpressionBuilder facebookAppId(@NonNull String facebookAppId) {
        if (impression.ext == null) {
            impression.ext = new Impression.Extension();
        }
        impression.ext.facebook_app_id = facebookAppId;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param apsParams {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidImpressionBuilder apsParams(@NonNull List apsParams) {
        if (impression.ext == null) {
            impression.ext = new Impression.Extension();
        }
        impression.ext.aps = apsParams;
        return this;
    }
}
