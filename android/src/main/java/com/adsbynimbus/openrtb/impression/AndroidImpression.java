package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.List;

import static com.adsbynimbus.openrtb.BidRequest.EXTENSION;
import static com.adsbynimbus.openrtb.BidRequest.ID;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link Impression} for convenient building and serialization
 */
public class AndroidImpression extends ArrayMap<String, Object> implements Impression, Impression.Builder {

    @Retention(SOURCE)
    @StringDef({ID, BANNER, VIDEO, INTERSTITIAL, BID_FLOOR, SECURE})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({POSITION_UNKNOWN, ABOVE_THE_FOLD, BELOW_THE_FOLD, HEADER, FOOTER, SIDEBAR, FULL_SCREEN})
    public @interface Position { }

    public final transient ArrayMap<String, Object> ext;

    /**
     * Constructor
     *
     * @param publisherAdUnitId publisher ad unit identifier
     */
    public AndroidImpression(@NonNull String publisherAdUnitId) {
        this.ext = new ArrayMap<>(3);
        ext.put(Extension.POSITION, publisherAdUnitId);
        put(EXTENSION, ext);
        put(SECURE, 1);
    }

    /**
     * {@inheritDoc}
     *
     * @param id {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder id(String id) {
        put(ID, id);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param banner {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder banner(@NonNull Banner banner) {
        put(BANNER, banner);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param video {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder video(@NonNull Video video) {
        put(VIDEO, video);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param bidFloor {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder bidFloor(@FloatRange(from = 0) float bidFloor) {
        put(BID_FLOOR, bidFloor);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param instl {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder interstitial(boolean instl) {
        put(INTERSTITIAL, instl ? 1 : 0);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param secure {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder secure(boolean secure) {
        put(SECURE, secure);
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param facebookAppId {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder facebookAppId(@NonNull String facebookAppId) {
        ext.put(Extension.FACEBOOK_APP_ID, facebookAppId);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param apsParams {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder apsParams(@NonNull List apsParams) {
        ext.put(Extension.APS, apsParams);
        return this;
    }
}
