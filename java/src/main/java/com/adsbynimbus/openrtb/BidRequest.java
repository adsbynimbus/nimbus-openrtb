package com.adsbynimbus.openrtb;

import com.adsbynimbus.openrtb.impression.Format;
import com.adsbynimbus.openrtb.impression.Impression;
import com.adsbynimbus.openrtb.publisher.App;
import com.adsbynimbus.openrtb.user.Device;
import com.adsbynimbus.openrtb.user.Regs;
import com.adsbynimbus.openrtb.user.Source;
import com.adsbynimbus.openrtb.user.User;

/**
 * The top-level bid request object contains a globally unique bid request or auction ID. This id attribute is
 * required as is at least one impression object (Section 3.2.4). Other attributes in this top-level object
 * establish rules and restrictions that apply to all impressions being offered.
 * There are also several subordinate objects that provide detailed data to potential buyers. Among these
 * are the Site and App objects, which describe the type of published media in which the impression(s)
 * appear. These objects are highly recommended, but only one applies to a given bid request depending
 * on whether the media is browser-based web content or a non-browser application, respectively.
 */
public interface BidRequest {

    String IMP = "imp"; // Impression[] (only size 1 valid)
    String APP = "app"; // App
    String DEVICE = "device"; // Device
    String USER = "user"; // User
    String TEST = "test"; // int (default 0; 0 = Live, 1 = Test)
    String TIMEOUT = "tmax"; // int
    String REGS = "regs";
    String SOURCE = "source";
    String BADV = "badv";

    String EXTENSION = "ext";

    /**
     * BidRequest 'ext' object used by Nimbus
     */
    interface Extension {
        String API_KEY = "api_key";
        String SESSION_ID = "session_id";
    }

    /**
     * Builder for constructing a {@link BidRequest} object
     */
    interface Builder {

    }

    /**
     * Definition of {@link BidRequest} with all public mutable fields
     */
    class MutableBidRequest implements BidRequest {
        public Impression[] imp;
        public App app;
        public Device device;
        public Format format;
        public User user;
        public Integer test;
        public Integer tmax;
        public Regs regs;
        public Source source;
        public String[] badv;
        public Extension ext;
    }

    /**
     * Definition of {@link BidRequest.Extension} with all public mutable fields
     */
    class MutableExtension implements Extension {
        public String api_key;
        public String session_id;
    }
}
