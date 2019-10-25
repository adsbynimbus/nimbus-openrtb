package com.adsbynimbus.openrtb.impression;

import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.IntDef;

import com.adsbynimbus.openrtb.R;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Android implementation of {@link Format}
 */
public class AndroidFormat extends Format {

    @Retention(SOURCE)
    @IntDef({INTERSTITIAL_PORT, INTERSTITIAL_LAND, BANNER_300_50, BANNER_320_50, LETTERBOX, HALF_SCREEN, LEADERBOARD})
    public @interface FormatName { }

    /**
     * Constructor
     *
     * @param width  - width
     * @param height - height
     */
    public AndroidFormat(int width, int height) {
        super(width, height);
    }

    /**
     * Returns and {@link AndroidFormat[]} for the given {@link FormatName} arguments
     *
     * @param sizes - {@link FormatName}
     * @return {@link AndroidFormat}
     */
    public static Format[] forSizes(@FormatName int... sizes) {
        final Format[] formats = new Format[sizes.length];
        for (int i = 0; i < formats.length; ++i) {
            Format format;
                switch (sizes[i]) {
                    case INTERSTITIAL_PORT:
                        format = new AndroidFormat(320, 480);
                        break;
                    case INTERSTITIAL_LAND:
                        format = new AndroidFormat(480, 320);
                        break;
                    case BANNER_300_50:
                        format = new AndroidFormat(300, 50);
                        break;
                    case BANNER_320_50:
                        format = new AndroidFormat(320, 50);
                        break;
                    case LETTERBOX:
                        format = new AndroidFormat(300, 250);
                        break;
                    case HALF_SCREEN:
                        format = new AndroidFormat(300, 600);
                        break;
                    case LEADERBOARD:
                        format = new AndroidFormat(728, 90);
                        break;
                    default:
                        format = null;
                }
            formats[i] = format;
        }
        return formats;
    }

    /**
     * Helper methods to load default interstitial sizes from a resource file
     *
     * @param context - {@link Context}
     * @return {@link AndroidFormat[]}
     */
    public static AndroidFormat[] loadDefaultInterstitialSizes(Context context) {
        final int[] sizeArray = context.getResources().getIntArray(R.array.interstitial_size_defaults);
        final AndroidFormat[] interstitialFormats = new AndroidFormat[sizeArray.length / 2];
        for (int i = 0; i < interstitialFormats.length; ++i) {
            interstitialFormats[i] = new AndroidFormat(sizeArray[i * 2], sizeArray[i * 2 + 1]);
        }
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            final AndroidFormat portrait = interstitialFormats[0];
            interstitialFormats[0] = interstitialFormats[1];
            interstitialFormats[1] = portrait;
        }
        return interstitialFormats;
    }
}