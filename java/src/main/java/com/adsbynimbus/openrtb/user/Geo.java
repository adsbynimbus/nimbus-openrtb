package com.adsbynimbus.openrtb.user;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

public interface Geo {

    String LATITUDE = "lat"; // Float
    String LONGITUDE = "lon"; // Float (optional)
    String TYPE = "type"; // Integer
    String ACCURACY =  "accuracy"; // Integer
    String COUNTRY = "country";
    String CITY = "city";

    interface Builder extends NimbusRTB.Builder {

        default Geo build() {
            final Map values = getValues();
            return new Geo() {
                public final Float lat = (Float) values.get(LATITUDE);
                public final Float lon = (Float) values.get(LONGITUDE);
                public final Integer type = (Integer) values.get(TYPE);
                public final Integer accuracy = (Integer) values.get(ACCURACY);
                public final String country = (String) values.get(COUNTRY);
                public final String city = (String) values.get(CITY);
            };
        }
    }
}
