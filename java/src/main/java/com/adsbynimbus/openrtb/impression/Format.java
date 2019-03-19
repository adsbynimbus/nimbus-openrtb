package com.adsbynimbus.openrtb.impression;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

public interface Format {

    //Share format parameter
    String FORMAT = "format";

    String WIDTH = "w";
    String HEIGHT = "h";

    interface Builder extends NimbusRTB.Builder {

        default Format build() {
            final Map values = getValues();
            return new Format() {
                public final int w = (int) values.get(WIDTH);
                public final int h = (int) values.get(HEIGHT);
            };
        }
    }
}
