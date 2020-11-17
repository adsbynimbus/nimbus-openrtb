package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.Banner;
import com.adsbynimbus.openrtb.request.Impression;
import com.adsbynimbus.openrtb.request.Video;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Impression builder implementation with Androidx annotations for validation
 */
public final class AndroidImpressionBuilder implements Impression.Builder {

    @NonNull
    private final Impression impression;

    /**
     * Constructs a builder that will edit the fields of the impression object in place.
     *
     * @param impression an impression object
     */
    public AndroidImpressionBuilder(@NonNull Impression impression) {
        this.impression = impression;
    }

    /**
     * Returns a builder for the banner object. A new Banner object will be created if none exists.
     *
     * @return a builder wrapping the banner object
     */
    @NonNull
    public AndroidBannerBuilder banner() {
        if (impression.banner == null) {
            impression.banner = new Banner();
        }
        return new AndroidBannerBuilder(impression.banner);
    }

    /**
     * Returns a builder for the video object. A new Video object will be created if none exists.
     *
     * @return a builder wrapping the video object
     */
    @NonNull
    public AndroidVideoBuilder video() {
        if (impression.video == null) {
            impression.video = new Video();
        }
        return new AndroidVideoBuilder(impression.video);
    }


    @Override @NonNull
    public AndroidImpressionBuilder id(String id) {
        impression.id = id;
        return this;
    }

    @Override @NonNull
    public AndroidImpressionBuilder banner(@Nullable Banner banner) {
        impression.banner = banner;
        return this;
    }

    @Override @NonNull
    public AndroidImpressionBuilder video(@Nullable Video video) {
        impression.video = video;
        return this;
    }

    @Override @NonNull
    public AndroidImpressionBuilder bidFloor(@FloatRange(from = 0) float bidFloor) {
        impression.bidfloor = bidFloor;
        return this;
    }

    @Override @NonNull
    public AndroidImpressionBuilder interstitial(boolean instl) {
        impression.instl = instl ? 1 : 0;
        return this;
    }

    @Override @NonNull
    public AndroidImpressionBuilder secure(boolean secure) {
        impression.secure = secure ? 1 : 0;
        return this;
    }

    @Override @NonNull
    public AndroidImpressionBuilder facebookAppId(@Nullable String facebookAppId) {
        if (impression.ext == null) {
            impression.ext = new Impression.Extension();
        }
        impression.ext.facebook_app_id = facebookAppId;
        return this;
    }

    @NotNull @Override
    public Impression.Builder facebookTestAdType(@Nullable String facebookTestAdType) {
        if (impression.ext == null) {
            impression.ext = new Impression.Extension();
        }
        impression.ext.facebook_test_ad_type = facebookTestAdType;
        return this;
    }

    @Override @NonNull
    public AndroidImpressionBuilder apsParams(@Nullable List<?> apsParams) {
        if (impression.ext == null) {
            impression.ext = new Impression.Extension();
        }
        impression.ext.aps = apsParams;
        return this;
    }
}
