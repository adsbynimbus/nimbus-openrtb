package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import com.adsbynimbus.openrtb.impression.AndroidImpression.Position;

import java.lang.annotation.Retention;

import static com.adsbynimbus.openrtb.impression.Format.BANNER_300_50;
import static com.adsbynimbus.openrtb.impression.Format.BANNER_320_50;
import static com.adsbynimbus.openrtb.impression.Format.FORMAT;
import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.LEADERBOARD;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link Banner} for convenient building and serialization
 */
public class AndroidBanner extends ArrayMap<String, Object> implements Banner, Banner.Builder {

    @Retention(SOURCE)
    @StringDef({BID_FLOOR, BLOCKED_ATTRIBUTES, FORMAT, WIDTH, HEIGHT, POSITION, MIME_TYPES, API})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({VPAID_2, MRAID_1, MRAID_2, MRAID_3, OMID})
    public @interface SupportedApis { }

    @Retention(SOURCE)
    @IntDef({BANNER_300_50, BANNER_320_50, LEADERBOARD})
    public @interface BannerSize { }

    @Retention(SOURCE)
    @IntDef({AUDIO_AD_AUTO_PLAY, AUDIO_AD_USER_INITIATED, EXPANDABLE_AUTOMATIC, EXPANDABLE_USER_CLICK,
        EXPANDABLE_USER_ROLLOVER, BANNER_VIDEO_AUTO_PLAY, BANNER_VIDEO_USER_INITIATED, HAS_POPUP,
        PROVOCATIVE_OR_SUGGESTIVE, EXTREME_ANIMATION, SURVEYS, TEXT_ONLY, USER_INTERACTIVE_AND_GAMES,
        DIALOG_OR_ALERT_STYLE, HAS_VOLUME_TOGGLE, HAS_SKIP_BUTTON, ADOBE_FLASH})
    public @interface CreativeAttributes { }

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        return super.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @param formats {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withFormats(@NonNull Format... formats) {
        put(FORMAT, formats);
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
    public Builder withDeviceIndependentSize(int width, int height) {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param position {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withPosition(@Position int position) {
        put(POSITION, position);
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
     * @param apis {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withSupportedApis(@SupportedApis int... apis) {
        put(API, apis);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param attributes {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withBlockedAttributes(@CreativeAttributes int... attributes) {
        put(BLOCKED_ATTRIBUTES, attributes);
        return this;
    }
}