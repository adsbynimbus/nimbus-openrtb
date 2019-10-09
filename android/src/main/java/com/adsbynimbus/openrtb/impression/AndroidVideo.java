package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import com.adsbynimbus.openrtb.impression.AndroidImpression.Position;

import java.lang.annotation.Retention;

import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link Video} for convenient building and serialization
 */
public class AndroidVideo extends ArrayMap<String, Object> implements Video, Video.Builder {

    @Retention(SOURCE)
    @StringDef({BID_FLOOR, MIME_TYPES, MIN_DURATION, MAX_DURATION, PROTOCOLS, WIDTH, HEIGHT,
        START_DELAY, SKIP, SKIP_MIN, SKIP_AFTER, MIN_BITRATE, MAX_BITRATE, POSITION, PLAYBACK_METHOD})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({VAST_2, VAST_2_WRAPPER, VAST_3, VAST_3_WRAPPER})
    public @interface Protocols { }

    @Retention(SOURCE)
    @IntDef({PAGE_LOAD_SOUND_ON, PAGE_LOAD_SOUND_OFF, CLICK_SOUND_ON, MOUSE_OVER_SOUND_ON,
        ENTER_VIEWPORT_SOUND_OFF, ENTER_VIEWPORT_SOUND_ON})
    public @interface PlaybackMethod { }

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        return super.put(key, value);
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
     * @param mimeTypes {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withMimes(@NonNull String... mimeTypes) {
        put(MIME_TYPES, mimeTypes);
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
     * @param minDuration {@inheritDoc}
     * @param maxDuration {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withDurationConstraint(@IntRange(from = 0) int minDuration, @IntRange(from = 1) int maxDuration) {
        put(MIN_DURATION, minDuration);
        put(MAX_DURATION, maxDuration);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param minBitrate {@inheritDoc}
     * @param maxBitrate {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withBitrateConstraint(@IntRange(from = 0) int minBitrate, int maxBitrate) {
        put(MIN_BITRATE, minBitrate);
        put(MAX_BITRATE, maxBitrate);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param width  {@inheritDoc}
     * @param height {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withDeviceSize(@IntRange(from = 0) int width, @IntRange(from = 0) int height) {
        put(WIDTH, width);
        put(HEIGHT, height);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param protocols {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withProtocols(@NonNull @Protocols int... protocols) {
        put(PROTOCOLS, protocols);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param skipMin   {@inheritDoc}
     * @param skipAfter {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withSkipEnabled(@IntRange(from = 0) int skipMin, @IntRange(from = 0) int skipAfter) {
        put(SKIP, 1);
        put(SKIP_MIN, skipMin);
        put(SKIP_AFTER, skipAfter);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param startDelay {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withStartDelay(@IntRange(from = 0) int startDelay) {
        put(START_DELAY, startDelay);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param playbackMethods {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Builder withPlaybackMethods(@PlaybackMethod int... playbackMethods) {
        put(PLAYBACK_METHOD, playbackMethods);
        return this;
    }
}
