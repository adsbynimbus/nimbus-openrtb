package com.adsbynimbus.openrtb.impression;


import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Android implementation of a Nimbus OpenRTB size
 */
public class AndroidFormat implements Format {

    static final SparseArray<AndroidFormat> FORMATS = new SparseArray<>(10);

    @Retention(SOURCE)
    @IntDef({FULLSCREEN_PORT, FULLSCREEN_LAND, BANNER_300_50, BANNER_320_50, LETTERBOX, HALF_SCREEN, LEADERBOARD})
    public @interface FormatName { }

    public final int w;
    public final int h;

    /**
     * Constructor
     *
     * @param width  - width
     * @param height - height
     */
    public AndroidFormat(int width, int height) {
        this.w = width;
        this.h = height;
    }

    /**
     * Return the width. Marked with deprecated to discourage use over field access.
     *
     * @return "w" value
     */
    @Override
    @Deprecated
    public int getWidth() {
        return w;
    }

    /**
     * Return the height. Marked with deprecated to discourage use over field access.
     *
     * @return "h" value
     */
    @Override
    @Deprecated
    public int getHeight() {
        return h;
    }

    /**
     * Returns and {@link AndroidFormat} for the given {@link FormatName}
     *
     * @param size - {@link FormatName}
     * @return {@link AndroidFormat}
     */
    public static AndroidFormat forSize(@FormatName int size) {
        AndroidFormat format = FORMATS.get(size);
        if (format == null) {
            switch (size) {
                case FULLSCREEN_PORT:
                    format = new AndroidFormat(320,480);
                    break;
                case FULLSCREEN_LAND:
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
                    Log.d(AndroidFormat.class.getName(),
                            "Invalid format specified, this may result in no Ad being shown.");
            }
            FORMATS.put(size, format);
        }
        return format;
    }
}
