package com.adsbynimbus.openrtb.internal;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public interface NimbusRTB {

    String EXTENSION = "ext";

    interface Builder {
        AtomicBoolean INCLUDE_DEFAULTS = new AtomicBoolean(true);

        String OMIT_FORMAT = "Omitting %s %s %d";

        Map<String, Object> getValues();
    }
}
