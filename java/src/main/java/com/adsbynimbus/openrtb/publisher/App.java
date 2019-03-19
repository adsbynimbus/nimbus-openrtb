package com.adsbynimbus.openrtb.publisher;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

public interface App extends Publisher {

    String BUNDLE = "bundle";
    String STORE_URL = "storeurl";
    String PAID = "paid"; //Integer
    String PUBLISHER = "publisher";

    interface Builder extends NimbusRTB.Builder {

        Map<String, Object> getValues();

        default App build() {
            final Map values = getValues();
            return new App() {
                public final String name = (String) values.get(NAME);
                public final String bundle = (String) values.get(BUNDLE);
                public final String domain = (String) values.get(DOMAIN);
                public final String storeurl = (String) values.get(STORE_URL);
                public final String[] cat = (String[]) values.get(CONTENT_CATEGORIES);
                public final Integer paid = (Integer) values.get(PAID);
                public final String publisher = (String) values.get(PUBLISHER);
            };
        }
    }
}
