package com.adsbynimbus.openrtb.impression;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import java.util.EnumSet;

/**
 * Implementation of {@link Video.Builder} with Androidx annotations for validation
 *
 * @see Video
 */
public final class AndroidVideoBuilder implements Video.Builder {

    /**
     * The {@link Video} object this builder wraps
     */
    @NonNull
    public final Video video;

    /**
     * Constructs a {@link AndroidVideoBuilder} that will edit the fields of the {@link Video} object in place
     *
     * @param video a non null video object
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
    public AndroidVideoBuilder position(Position position) {
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
    public AndroidVideoBuilder protocols(@NonNull EnumSet<Video.Protocol> protocols) {
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
    public AndroidVideoBuilder playbackMethods(Video.PlaybackMethod playbackMethod) {
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
    public AndroidVideoBuilder placement(Video.Placement placement) {
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
    public AndroidVideoBuilder linearity(Video.Linearity linearity) {
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
    public AndroidVideoBuilder deliveryMethod(EnumSet<Video.DeliveryMethod> deliveryMethods) {
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
    public AndroidVideoBuilder apis(EnumSet<Api> apis) {
        video.api = apis;
        return this;
    }
}
