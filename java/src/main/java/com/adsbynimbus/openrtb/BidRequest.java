package com.adsbynimbus.openrtb;

import com.adsbynimbus.openrtb.impression.Format;
import com.adsbynimbus.openrtb.impression.Impression;
import com.adsbynimbus.openrtb.targeting.distribution.App;
import com.adsbynimbus.openrtb.targeting.user.Device;
import com.adsbynimbus.openrtb.targeting.Regs;
import com.adsbynimbus.openrtb.targeting.Source;
import com.adsbynimbus.openrtb.targeting.user.User;

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

    String ID = "id";
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

        /**
         * Set the {@link Impression} object
         *
         * @param impressions
         * @return this builder instance
         */
        Builder forImpressions(Impression... impressions);

        /**
         * Set the {@link App} object
         *
         * @param app
         * @return this builder instance
         */
        Builder forApp(App app);

        /**
         * Set the {@link Device} object
         *
         * @param device
         * @return this builder instance
         */
        Builder forDevice(Device device);

        /**
         * Set the device size
         *
         * @param width int width
         * @param height int height
         * @return this builder instance
         */
        Builder forDeviceSize(int width, int height);

        /**
         * Set the {@link User} object
         *
         * @param user
         * @return this builder instance
         */
        Builder withUser(User user);

        /**
         * Mark this request as a test
         *
         * @return {@link Builder}
         */
        Builder withTestFlag();

        /**
         * Set the timeout of the request.
         *
         * @param timeout int [Default: 500]
         * @return this builder instance
         */
        Builder withTimeout(int timeout);

        /**
         * Sets the {@link Regs} object
         *
         * @param regs
         * @return this builder instance
         */
        Builder withRegs(Regs regs);

        /**
         * Sets the {@link Source} object
         *
         * @param source
         * @return this builder instance
         */
        Builder withSource(Source source);

        /**
         * Sets a list of blocked advertisers by domains
         *
         * @param domains
         * @return this builder instance
         */
         Builder withBlockedDomains(String... domains);

        /**
         * Sets the Nimbus API key
         *
         * @param apiKey
         * @return this builder instance
         */
        Builder withApiKey(String apiKey);

        /**
         * Sets the Nimbus session id
         *
         * @param sessionId
         * @return this builder instance
         */
        Builder withSessionId(String sessionId);
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
