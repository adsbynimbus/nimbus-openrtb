package com.adsbynimbus.openrtb.publisher;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

import static com.adsbynimbus.openrtb.publisher.Publisher.CONTENT_CATEGORIES;
import static com.adsbynimbus.openrtb.publisher.Publisher.DOMAIN;
import static com.adsbynimbus.openrtb.publisher.Publisher.NAME;

public interface App {

    int FREE_APP = 0;
    int PAID_APP = 1;

    String BUNDLE = "bundle";
    String STORE_URL = "storeurl";
    String PAID = "paid"; //Integer
    String PUBLISHER = "publisher";
    String VERSION = "ver";

    interface Builder extends NimbusRTB.Builder {

        default App build() {
            final Map values = getValues();
            return new App() {
                public final String name = (String) values.get(NAME);
                public final String bundle = (String) values.get(BUNDLE);
                public final String domain = (String) values.get(DOMAIN);
                public final String storeurl = (String) values.get(STORE_URL);
                public final String[] cat = (String[]) values.get(CONTENT_CATEGORIES);
                public final String ver = (String) values.get(VERSION);
                public final Integer paid = (Integer) values.get(PAID);
                public final String publisher = (String) values.get(PUBLISHER);
            };
        }
    }
}
