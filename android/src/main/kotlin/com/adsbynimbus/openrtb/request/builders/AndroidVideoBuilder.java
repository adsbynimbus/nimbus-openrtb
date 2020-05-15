package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.Video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.adsbynimbus.openrtb.request.Video.DeliveryMethod;
import static com.adsbynimbus.openrtb.request.Video.Linearity;
import static com.adsbynimbus.openrtb.request.Video.Protocol;
import static com.adsbynimbus.openrtb.request.Video.Placement;
import static com.adsbynimbus.openrtb.request.Video.PlaybackMethod;

/**
 * Video builder implementation with Androidx annotations for validation
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

    @NonNull
    private final Video video;

    /**
     * Constructs a builder that will edit the fields of the video object in place.
     *
     * @param video a video object
     */
    public AndroidVideoBuilder(@NonNull Video video) {
        this.video = video;
    }

    @Override @NonNull
    public AndroidVideoBuilder position(@PositionInt Integer position) {
        video.pos = position;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder mimes(@Nullable String... mimeTypes) {
        video.mimes = mimeTypes;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder bidFloor(@FloatRange(from = 0) float bidFloor) {
        video.bidfloor = bidFloor;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder duration(@IntRange(from = 0) int minDuration, @IntRange(from = 1) int maxDuration) {
        video.minduration = minDuration;
        video.maxduration = maxDuration;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder bitrate(@IntRange(from = 0) int minBitrate, int maxBitrate) {
        video.minbitrate = minBitrate;
        video.maxbitrate = maxBitrate;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder playerSize(@IntRange(from = 0) int width, @IntRange(from = 0) int height) {
        video.w = width;
        video.h = height;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder protocols(@NonNull @ProtocolInt int... protocols) {
        video.protocols = protocols;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder skipEnabled(@IntRange(from = 0) int skipMin, @IntRange(from = 0) int skipAfter) {
        video.skip = 1;
        video.skipmin = skipMin;
        video.skipafter = skipAfter;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder startDelay(@IntRange(from = 0) int startDelay) {
        video.startdelay = startDelay;
        return this;
    }

    @NonNull
    public AndroidVideoBuilder playbackMethod(@PlaybackMethodInt @Nullable int... playbackMethod) {
        video.playbackmethod = playbackMethod;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder placement(@PlacementInt Integer placement) {
        video.placement = placement;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder linearity(@LinearityInt Integer linearity) {
        video.linearity = linearity;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder deliveryMethod(@DeliveryMethodInt @Nullable int... deliveryMethods) {
        video.delivery = deliveryMethods;
        return this;
    }

    @Override @NonNull
    public AndroidVideoBuilder apis(@ApiInt @Nullable int... apis) {
        video.api = apis;
        return this;
    }
}
