package com.adsbynimbus.openrtb.user;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

public interface Regs {

    String COPPA = "coppa"; // int

    //Extensions
    String GDPR_CONSENT = "gdpr"; // int

    interface Builder extends NimbusRTB.Builder {

        default Regs build() {
            final Map values = getValues();
            return new Regs() {

                public final int coppa = (int) values.get(COPPA);
                public final Object ext = values.containsKey(GDPR_CONSENT) ? new Object() {
                    public final int gdpr = (int) values.get(GDPR_CONSENT);
                } : null;
            };
        }
    }
}
