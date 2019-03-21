package com.adsbynimbus.openrtb.impression;

import android.util.Log;
import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import javax.xml.transform.Source;
import java.lang.annotation.Retention;
import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Android implementation of a Nimbus OpenRTB {@link Video} impression
 */
public class AndroidVideo extends ArrayMap<String, Object> implements Video {

    @Retention(SOURCE)
    @StringDef({BID_FLOOR, MIME_TYPES, MIN_DURATION, MAX_DURATION, PROTOCOLS, WIDTH, HEIGHT, START_DELAY, SKIP,
            SKIP_MIN, SKIP_AFTER, MIN_BITRATE, MAX_BITRATE, POSITION})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({VAST_2, VAST_2_WRAPPER, VAST_3, VAST_3_WRAPPER})
    public @interface Protocols { }

    @Retention(SOURCE)
    @IntDef({PAGE_LOAD_SOUND_ON, PAGE_LOAD_SOUND_OFF, CLICK_SOUND_ON, MOUSE_OVER_SOUND_ON,
            ENTER_VIEWPORT_SOUND_OFF, ENTER_VIEWPORT_SOUND_ON})
    public @interface PlaybackMethod { }

    /**
     * Builder for {@link AndroidVideo}
     */
    public static class Builder implements Video.Builder {

        protected final AndroidVideo values = new AndroidVideo();

        @Override
        public AndroidVideo build() {
            return values;
        }

        @Override
        public Map<String, Object> getValues() {
            return values;
        }

        /**
         * Manually set a value on the builder object
         *
         * @param property - {@link Values}
         * @param value    - {@link Object}
         * @return {@link Builder}
         */
        public Builder setValue(@Values String property, Object value) {
            values.put(property, value);
            return this;
        }

        /**
         * Set the position of the Ad Unit
         *
         * @param position - position
         * @return {@link AndroidBanner.Builder}
         */
        public Builder withPosition(int position) {
            values.put(POSITION, position);
            return this;
        }

        /**
         * Set the requested mimeTypes. [Default: "video/mp4"]
         *
         * @param mimeTypes - {@link String[]}
         * @return {@link AndroidBanner.Builder}
         */
        public Builder withMimes(@NonNull String... mimeTypes) {
            values.put(MIME_TYPES, mimeTypes);
            return this;
        }

        /**
         * Set the bid floor. [Default: 2.0]
         *
         * @param bidFloor - bid floor
         * @return {@link AndroidBanner.Builder}
         */
        public Builder withBidFloor(@FloatRange(from = 0) float bidFloor) {
            if (bidFloor >= 0) {
                if (bidFloor != 2.0f) {
                    values.put(BID_FLOOR, bidFloor);
                } else {
                    // Omit bidFloor == 2 (default)
                    Log.d(AndroidVideo.Builder.class.getName(), String.format(OMIT_FORMAT, BID_FLOOR, '=', 2));
                }
            } else {
                //Omit bidFloor < 0 (invalid)
                Log.d(AndroidVideo.Builder.class.getName(), String.format(OMIT_FORMAT, BID_FLOOR, '<', 0));
            }
            return this;
        }

        /**
         * Set a duration constraint for a {@link Video} impression
         *
         * @param minDuration - int [Default: 0]
         * @param maxDuration - int [Default: 60]
         * @return {@link Builder}
         */
        public Builder withDurationConstraint(@IntRange(from = 0) int minDuration,
                                              @IntRange(from = 1) int maxDuration) {
            if (minDuration > 0) {
                values.put(MIN_DURATION, minDuration);
            } else {
                // Omit minDuration < 0 (invalid) : Omit minDuration == 0 (default)
                Log.d(AndroidVideo.Builder.class.getName(), String.format(OMIT_FORMAT, MIN_DURATION, '<' + '=', 0));
            }
            if (maxDuration > 0) {
                if (maxDuration != 60) {
                    values.put(MAX_DURATION, maxDuration);
                } else {
                    // Omit maxDuration == 60 (default)
                    Log.d(AndroidVideo.Builder.class.getName(), String.format(OMIT_FORMAT, MAX_DURATION, '=', 60));
                }
            } else {
                // Omit maxDuration < 1 (invalid)
                Log.d(AndroidVideo.Builder.class.getName(), String.format(OMIT_FORMAT, MAX_DURATION, '<', 1));
            }
            return this;
        }

        /**
         * Set a bitrate constraint for a {@link Video} impression
         *
         * @param minBitrate - int [Default: 0]
         * @param maxBitrate - int [Default: 20000]
         * @return {@link Builder}
         */
        public Builder withBitrateConstraint(@IntRange(from = 0) int minBitrate, int maxBitrate) {
            if (minBitrate > 0) {
                values.put(MIN_BITRATE, minBitrate);
            } else {
                // Omit minBitrate < 0 (invalid) : Omit minBitrate == 0 (default)
                Log.d(AndroidVideo.Builder.class.getName(), String.format(OMIT_FORMAT, MIN_BITRATE, '<' + '=', 0));
            }
            if (maxBitrate > 0) {
                if (maxBitrate != 20000) {
                    values.put(MAX_BITRATE, maxBitrate);
                } else {
                    // Omit maxBitrate == 20000 (default)
                    Log.d(AndroidVideo.Builder.class.getName(), String.format(OMIT_FORMAT, MAX_BITRATE, '=', 20000));
                }
            } else {
                // Omit minBitrate < 1 (invalid)
                Log.d(AndroidVideo.Builder.class.getName(), String.format(OMIT_FORMAT, MAX_BITRATE, '<', 1));
            }
            return this;
        }

        /**
         * Set the device width and height
         *
         * @param width  - device width in absolute pixel
         * @param height - device height in absolute pixel
         * @return {@link Builder}
         */
        public Builder withDeviceSize(@IntRange(from = 0) int width, @IntRange(from = 0) int height) {
            values.put(WIDTH, width);
            values.put(HEIGHT, height);
            return this;
        }

        /**
         * Set the supported protocols
         *
         * @param protocols - {@link Protocols} [VAST_2, VAST_2_WRAPPER, VAST_3, VAST_3_WRAPPER]
         * @return {@link Builder}
         */
        public Builder withProtocols(@NonNull @Protocols int... protocols) {
            values.put(PROTOCOLS, protocols);
            return this;
        }

        /**
         * Set if the video asset is skippable. Not calling this function assumes it is not skippable
         *
         * @param skipMin   - minimum duration in seconds of video length before skip is enabled
         * @param skipAfter - minimum duration video must be watched to skip
         * @return {@link Builder}
         */
        public Builder withSkipEnabled(@IntRange(from = 0) int skipMin, @IntRange(from = 0) int skipAfter) {
            values.put(SKIP, 1);
            if (skipMin > 0) {
                values.put(SKIP_MIN, skipMin);
            } else {
                // Omit skipMin < 0 (invalid) : Omit skipMin == 0 (default)
                Log.d(AndroidVideo.class.getName(), String.format(OMIT_FORMAT, SKIP_MIN, '<' + '=', 0));
            }
            if (skipAfter > 0) {
                values.put(SKIP_AFTER, skipAfter);
            } else {
                // Omit skipAfter < 0 (invalid) : Omit skipAfter == 0 (default)
                Log.d(AndroidVideo.class.getName(), String.format(OMIT_FORMAT, SKIP_AFTER, '<' + '=', 0));
            }
            return this;
        }

        /**
         * Set video start delay
         *
         * @param startDelay - int [Default: 0]
         * @return {@link Builder}
         */
        public Builder withStartDelay(@IntRange(from = 0) int startDelay) {
            if (startDelay > 0) {
                values.put(START_DELAY, startDelay);
            } else {
                // Omit startDelay < 0 (invalid) : Omit startDelay == 0 (default)
                Log.d(AndroidVideo.class.getName(), String.format(OMIT_FORMAT, START_DELAY, '<' + '=', 0));
            }
            return this;
        }

        /**
         * Set the playback method.
         *
         * @param playbackMethod - {@link PlaybackMethod} [PAGE_LOAD_SOUND_ON, PAGE_LOAD_SOUND_OFF, CLICK_SOUND_ON,
         *                       MOUSE_OVER_SOUND_ON, ENTER_VIEWPORT_SOUND_OFF, ENTER_VIEWPORT_SOUND_ON]
         * @return {@link Builder}
         */
        public Builder withPlaybackMethod(@PlaybackMethod int playbackMethod) {
            if (playbackMethod < 1 || playbackMethod > 6 || playbackMethod == 2) {
                // Omit playbackMethod < 0 || > 6 (invalid) : Omit playbackMethod == 2 (default)
                Log.d(AndroidVideo.class.getName(), String.format(OMIT_FORMAT, PLAYBACK_METHOD, '!' + '=', 13456));
            } else {
                values.put(PLAYBACK_METHOD, playbackMethod);
            }
            return this;
        }
    }
}
