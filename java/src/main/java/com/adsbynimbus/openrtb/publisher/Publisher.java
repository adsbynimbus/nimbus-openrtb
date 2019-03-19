package com.adsbynimbus.openrtb.publisher;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

public interface Publisher extends BasePublisher {

    // Extensions
    String FACEBOOK_APP_ID = "facebook_app_id";

    interface Builder extends NimbusRTB.Builder {

        default Publisher build() {
            final Map values = getValues();
            return new Publisher() {
                public final String name = (String) values.get(NAME);
                public final String domain = (String) values.get(DOMAIN);
                public final String[] cat = (String[]) values.get(CONTENT_CATEGORIES);
                public final Object ext = values.containsKey(FACEBOOK_APP_ID) ? new Object() {
                    public final String facebook_app_id = (String) values.get(FACEBOOK_APP_ID);
                } : null;
            };
        }
    }
}