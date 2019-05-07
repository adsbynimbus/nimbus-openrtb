package com.adsbynimbus.openrtb;

import com.adsbynimbus.openrtb.impression.Format;
import com.adsbynimbus.openrtb.impression.Impression;
import com.adsbynimbus.openrtb.internal.NimbusRTB;
import com.adsbynimbus.openrtb.publisher.App;
import com.adsbynimbus.openrtb.user.Device;
import com.adsbynimbus.openrtb.user.Regs;
import com.adsbynimbus.openrtb.user.User;

import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.FORMAT;

public interface BidRequest {

    String IMP = "imp"; // Impression[] (only size 1 valid)
    String APP = "app"; // App
    String DEVICE = "device"; // Device
    String USER = "user"; // User
    String TEST = "test"; // int (default 0; 0 = Live, 1 = Test)
    String TIMEOUT = "tmax"; // int
    String REGS = "regs";
    String BADV = "badv";

    //Extensions
    String API_KEY = "api_key";
    String SESSION_ID = "session_id";

    interface Builder extends NimbusRTB.Builder {

        default BidRequest build() {
            final Map values = getValues();
            return new BidRequest() {
                public final Impression[] imp = (Impression[]) values.get(IMP);
                public final App app = (App) values.get(APP);
                public final Device device = (Device) values.get(DEVICE);
                public final Format format = (Format) values.get(FORMAT);
                public final User user = (User) values.get(USER);
                public final Integer test = (Integer) values.get(TEST); // Server default 0
                public final Integer tmax = (Integer) values.get(TIMEOUT); // Server default 500
                public final Regs regs = (Regs) values.get(REGS);
                public final String[] badv = (String[]) values.get(BADV);
                public final Object ext = values.containsKey(API_KEY) || values.containsKey(SESSION_ID) ?
                        new Object() {
                            public final String api_key = (String) values.get(API_KEY);
                            public final String session_id = (String) values.get(SESSION_ID);
                        } : null;
            };
        }
    }
}
