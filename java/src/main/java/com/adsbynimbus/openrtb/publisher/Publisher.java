package com.adsbynimbus.openrtb.publisher;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

public interface Publisher {

    String NAME = "name";
    String DOMAIN = "domain";
    String CONTENT_CATEGORIES = "cat"; // String[]

    interface Builder extends NimbusRTB.Builder {

        default Publisher build() {
            final Map values = getValues();
            return new Publisher() {
                public final String name = (String) values.get(NAME);
                public final String domain = (String) values.get(DOMAIN);
                public final String[] cat = (String[]) values.get(CONTENT_CATEGORIES);
            };
        }
    }
}