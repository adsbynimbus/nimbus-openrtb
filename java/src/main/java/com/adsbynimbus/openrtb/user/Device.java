package com.adsbynimbus.openrtb.user;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

public interface Device {

    String USER_AGENT = "ua";
    String GEO = "geo"; //GEO object
    String IP_ADDRESS = "ip";
    String DEVICE_TYPE = "devicetype";
    String MAKE = "make";
    String MODEL = "model";
    String OS = "os";
    String OS_VERSION = "osv";
    String CONNECTION_TYPE = "connectiontype"; //Integer
    String ADVERTISING_ID = "ifa";

    interface Builder extends NimbusRTB.Builder {

        default Device build() {
            final Map values = getValues();
            return new Device() {
                public final String ua = (String) values.get(USER_AGENT);
                public final Geo geo = (Geo) values.get(GEO);
                public final String ip = (String) values.get(IP_ADDRESS);
                public final Integer devicetype = (Integer) values.get(DEVICE_TYPE);
                public final String make = (String) values.get(MAKE);
                public final String model = (String) values.get(MODEL);
                public final String os = (String) values.get(OS);
                public final String osv = (String) values.get(OS_VERSION);
                public final Integer connectiontype = (Integer) values.get(CONNECTION_TYPE);
                public final String ifa = (String) values.get(ADVERTISING_ID);
            };
        }
    }
}