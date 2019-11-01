package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.impression.Video.DeliveryMethod;
import com.adsbynimbus.openrtb.impression.Video.Linearity;
import com.adsbynimbus.openrtb.impression.Video.Placement;
import com.adsbynimbus.openrtb.impression.Video.PlaybackMethod;
import com.adsbynimbus.openrtb.impression.Video.Protocol;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Video builder implementation with Androidx annotations for validation
 *
 * @see Video
 */
public final class AndroidVideoBuilder implements Video.Builder {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Protocol.VAST_2, Protocol.VAST_3, Protocol.VAST_2_WRAPPER, Protocol.VAST_3_WRAPPER})
    public @interface ProtocolInt { }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Placement.IN_STREAM, Placement.IN_BANNER, Placement.IN_ARTICLE, Placement.IN_FEED,
            Placement.INTERSTITIAL_SLIDER_FLOATING})
    public @interface PlacementInt { }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({PlaybackMethod.PAGE_LOAD_SOUND_ON, PlaybackMethod.PAGE_LOAD_SOUND_OFF, PlaybackMethod.CLICK_SOUND_ON,
            PlaybackMethod.MOUSE_OVER_SOUND_ON, PlaybackMethod.ENTER_VIEWPORT_SOUND_ON,
            PlaybackMethod.ENTER_VIEWPORT_SOUND_OFF})
    public @interface PlaybackMethodInt { }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Linearity.LINEAR, Linearity.NON_LINEAR})
    public @interface LinearityInt { }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({DeliveryMethod.STREAMING, DeliveryMethod.PROGRESSIVE, DeliveryMethod.DOWNLOAD})
    public @interface DeliveryMethodInt { }

    /**
     * The video object this builder wraps.
     */
    @NonNull
    public final Video video;

    /**
     * Constructs a builder that will edit the fields of the video object in place.
     *
     * @param video a video object
     */
    public AndroidVideoBuilder(@NonNull Video video) {
        this.video = video;
    }

    /**
     * {@inheritDoc}
     *
     * @param position {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidVideoBuilder position(@PositionInt Integer position) {
        video.pos = position;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param mimeTypes {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidVideoBuilder mimes(@NonNull String... mimeTypes) {
        video.mimes = mimeTypes;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param bidFloor {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidVideoBuilder bidFloor(@FloatRange(from = 0) float bidFloor) {
        video.bidfloor = bidFloor;
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
    public AndroidVideoBuilder duration(@IntRange(from = 0) int minDuration, @IntRange(from = 1) int maxDuration) {
        video.minduration = minDuration;
        video.maxduration = maxDuration;
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
    public AndroidVideoBuilder bitrate(@IntRange(from = 0) int minBitrate, int maxBitrate) {
        video.minbitrate = minBitrate;
        video.maxbitrate = maxBitrate;
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
    public AndroidVideoBuilder playerSize(@IntRange(from = 0) int width, @IntRange(from = 0) int height) {
        video.w = width;
        video.h = height;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param protocols {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidVideoBuilder protocols(@NonNull @ProtocolInt int... protocols) {
        video.protocols = protocols;
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
    public AndroidVideoBuilder skipEnabled(@IntRange(from = 0) int skipMin, @IntRange(from = 0) int skipAfter) {
        video.skip = 1;
        video.skipmin = skipMin;
        video.skipafter = skipAfter;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param startDelay {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidVideoBuilder startDelay(@IntRange(from = 0) int startDelay) {
        video.startdelay = startDelay;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param playbackMethod {@inheritDoc}
     * @return {@inheritDoc}
     */
    public AndroidVideoBuilder playbackMethod(@PlaybackMethodInt Integer playbackMethod) {
        video.playbackmethod = playbackMethod;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param placement {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidVideoBuilder placement(@PlacementInt Integer placement) {
        video.placement = placement;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param linearity {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidVideoBuilder linearity(@LinearityInt Integer linearity) {
        video.linearity = linearity;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param deliveryMethods {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidVideoBuilder deliveryMethod(@DeliveryMethodInt int... deliveryMethods) {
        video.delivery = deliveryMethods;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param apis {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidVideoBuilder apis(@ApiInt int... apis) {
        video.api = apis;
        return this;
    }
}
