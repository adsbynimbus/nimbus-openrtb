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
    @IntDef({0})
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
                case 0:
                    format = new AndroidFormat(320, 480);
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
