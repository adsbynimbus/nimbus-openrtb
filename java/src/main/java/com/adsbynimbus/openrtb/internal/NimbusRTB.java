package com.adsbynimbus.openrtb.internal;

import java.util.Map;

public interface NimbusRTB {

    String EXTENSION = "ext";

    interface Builder {
        String OMIT_FORMAT = "Omitting %s %s %d";

        Map<String, Object> getValues();
    }
}
