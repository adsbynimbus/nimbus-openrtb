package com.adsbynimbus.openrtb.impression;

import android.util.Log;
import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;

import com.adsbynimbus.openrtb.impression.AndroidImpression.Position;

import java.lang.annotation.Retention;
import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.FORMAT;
import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Android implementation of a Nimbus OpenRTB {@link Banner} impression
 */
public class AndroidBanner extends ArrayMap<String, Object> implements Banner {

    @Retention(SOURCE)
    @StringDef({BID_FLOOR, FORMAT, WIDTH, HEIGHT, POSITION, MIME_TYPES, SUPPORTED_APIS})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({VPAID_2, MRAID_1, MRAID_2, MRAID_3})
    public @interface SupportedApis { }

    /**
     * Builder for {@link AndroidBanner}
     */
    public static class Builder implements Banner.Builder {

        protected final AndroidBanner values;

        public Builder() {
            values = new AndroidBanner();
            if (INCLUDE_DEFAULTS.get()) {
                values.put(POSITION, FULL_SCREEN);
                values.put(BID_FLOOR, 2f);
            }
        }

        @Override
        public AndroidBanner build() {
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
         * @param value - {@link Object}
         *
         * @return {@link Builder}
         */
        public Builder setValue(@Values String property, Object value) {
            values.put(property, value);
            return this;
        }

        /**
         * Set the requested formats of the ad. The item at index 0 is used for the W and H parameter of the request;
         * the first 5 items in the array (indices 0 - 4) are prioritized by demand partners.
         *
         * @param formats    - An array of supported {@link AndroidFormat}
         * @return {@link Builder}
         */
        public Builder withFormats(@NonNull AndroidFormat... formats) {
            if (formats.length > 0) {
                values.put(FORMAT, formats);
                values.put(WIDTH, formats[0].w);
                values.put(HEIGHT, formats[0].h);
            }
            return this;
        }

        /**
         * Set the position of the Ad Unit.
         *
         * @param position - position
         * @return {@link Builder}
         */
        public Builder withPosition(@Position int position) {
            values.put(POSITION, position);
            return this;
        }

        /**
         * Set the requested mimeTypes. Server default is "text/html"
         *
         * @param mimeTypes - {@link String[]}
         * @return {@link Builder}
         */
        public Builder withMimes(String... mimeTypes) {
            values.put(MIME_TYPES, mimeTypes);
            return this;
        }

        /**
         * Set the bid floor. [Default 2.0]
         *
         * @param bidFloor - bid floor
         * @return {@link Builder}
         */
        public Builder withBidFloor(@FloatRange(from = 0) float bidFloor) {
            if (INCLUDE_DEFAULTS.get()) {
                values.put(BID_FLOOR, bidFloor);
                return this;
            }

            if (bidFloor >= 0) {
                if ((int) bidFloor != 2) {
                    values.put(BID_FLOOR, bidFloor);
                } else {
                    // Omit bidFloor == 2 (default)
                    Log.d(AndroidBanner.Builder.class.getName(), String.format(OMIT_FORMAT, BID_FLOOR, '=', 2));
                }
            } else {
                //Omit bidFloor < 0 (invalid)
                Log.d(AndroidBanner.Builder.class.getName(), String.format(OMIT_FORMAT, BID_FLOOR, '<', 0));
            }
            return this;
        }

        /**
         * Set the supported creative types
         *
         * @param apis - {@link SupportedApis} [VPAID_2, MRAID_1, MRAID_2, MRAID_3]
         * @return {@link Builder}
         */
        public Builder withSupportedApis(@SupportedApis int...apis) {
            values.put(SUPPORTED_APIS, apis);
            return this;
        }
    }
}