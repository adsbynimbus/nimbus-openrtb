package com.adsbynimbus.openrtb.impression;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.FORMAT;
import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;

public interface Banner extends BaseCreative {

    interface Builder extends NimbusRTB.Builder {

        default Banner build() {
            final Map values = getValues();
            return new Banner() {
                public final Float bidfloor = (Float) values.get(BID_FLOOR); // Server default is 2.0
                public final Format[] format = (Format[]) values.get(FORMAT);
                public final Integer w = (Integer) values.get(WIDTH);
                public final Integer h = (Integer) values.get(HEIGHT);
                public final Integer pos = (Integer) values.get(POSITION);
                public final String[] mimes = (String[]) values.get(MIME_TYPES);
                public final int[] api = (int[]) values.get(SUPPORTED_APIS);
            };
        }
    }
}
