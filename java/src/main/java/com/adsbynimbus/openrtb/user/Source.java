package com.adsbynimbus.openrtb.user;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

public interface Source {

    // Extensions
    String OM_PARTNER_NAME = "omidpn";
    String OM_SDK_VERSION = "omidpv";

    interface Builder extends NimbusRTB.Builder {

        default Source build() {
            final Map values = getValues();
            return new Source() {

                public final Object ext = values.containsKey(OM_PARTNER_NAME) ||
                        values.containsKey(OM_SDK_VERSION) ? new Object() {
                    public final String omidpn = (String) values.get(OM_PARTNER_NAME);
                    public final String omidpv = (String) values.get(OM_SDK_VERSION);
                } : null;
            };
        }
    }
}
