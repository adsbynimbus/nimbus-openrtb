package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import java.lang.annotation.Retention;
import java.util.List;

import static com.adsbynimbus.openrtb.BidRequest.EXTENSION;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link Impression} for convenient building and serialization
 */
public class AndroidImpression extends ArrayMap<String, Object> implements Impression, Impression.Builder {

    @Retention(SOURCE)
    @StringDef({BANNER, VIDEO, DISPLAY_MANAGER, DISPLAY_MANAGER_SERVER, INTERSTITIAL, BID_FLOOR, REQUIRE_HTTPS})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({POSITION_UNKNOWN, ABOVE_THE_FOLD, BELOW_THE_FOLD, HEADER, FOOTER, SIDEBAR, FULL_SCREEN})
    public @interface Position { }


    /* The following fields are used internally and should not be accessed */
    public transient boolean video;
    public transient boolean interstitial;
    public transient AndroidFormat[] displayFormats;

    public final ArrayMap<String, Object> ext;

    /**
     * Constructor
     *
     * @param publisherAdUnitId publisher ad unit identifier
     */
    public AndroidImpression(@NonNull String publisherAdUnitId) {
        this.video = false;
        this.interstitial = false;
        this.displayFormats = null;
        this.ext = new ArrayMap<>(3);
        put(REQUIRE_HTTPS, 1);
        ext.put(Extension.POSITION, publisherAdUnitId);
        put(EXTENSION, ext);
    }


    /**
     * {@inheritDoc}
     *
     * @param banner {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder includeBanner(@NonNull Banner banner) {
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
    public Builder includeVideo(@NonNull Video video) {
        this.video = true;
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
    public Builder withBidFloor(@FloatRange(from = 0) float bidFloor) {
        put(BID_FLOOR, bidFloor);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public Builder asInterstitial() {
        this.interstitial = true;
        put(INTERSTITIAL, 1);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public Builder allowHttp() {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param facebookAppId {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withFacebookAppId(@NonNull String facebookAppId) {
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
    public Builder withApsParams(@NonNull List apsParams) {
        ext.put(Extension.APS, apsParams);
        return this;
    }
}
