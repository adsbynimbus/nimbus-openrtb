package com.adsbynimbus.openrtb.android;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.impression.Banner;
import com.adsbynimbus.openrtb.impression.Impression;
import com.adsbynimbus.openrtb.impression.Video;

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
    @Override @NonNull
    public AndroidImpressionBuilder id(@Nullable String id) {
        impression.id = id;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param banner {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidImpressionBuilder banner(@Nullable Banner banner) {
        impression.banner = banner;
        return this;
    }

    /**
     * Returns a builder for the banner object. A new {@link Banner} object will be created if none exists.
     *
     * @return a builder wrapping the banner object
     * @see Banner
     */
    @NonNull
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
    @Override @NonNull
    public AndroidImpressionBuilder video(@Nullable Video video) {
        impression.video = video;
        return this;
    }

    /**
     * Returns a builder for the video object. A new {@link Video} object will be created if none exists.
     *
     * @return a builder wrapping the video object
     * @see Video
     */
    @NonNull
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
    @Override @NonNull
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
    @Override @NonNull
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
    @Override @NonNull
    public AndroidImpressionBuilder secure(boolean secure) {
        impression.secure = secure ? 1 : 0;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param facebookAppId {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override @NonNull
    public AndroidImpressionBuilder facebookAppId(@Nullable String facebookAppId) {
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
    @Override @NonNull
    public AndroidImpressionBuilder apsParams(@Nullable List<?> apsParams) {
        if (impression.ext == null) {
            impression.ext = new Impression.Extension();
        }
        impression.ext.aps = apsParams;
        return this;
    }
}
