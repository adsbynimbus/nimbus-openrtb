package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

import java.util.List;

/**
 * Implementation of {@link Impression.Builder} with Androidx annotations for validation
 */
public class AndroidImpressionBuilder implements Impression.Builder {

    @NonNull
    public final Impression impression;

    /**
     * Constructor
     *
     * @param impression
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
