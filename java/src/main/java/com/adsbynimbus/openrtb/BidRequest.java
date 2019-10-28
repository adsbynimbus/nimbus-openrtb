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
public class BidRequest {

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

    /**
     * BidRequest 'ext' object used by Nimbus
     */
    public static class Extension {

        public String api_key;
        public String session_id;
    }

    /**
     * Builder for constructing a {@link BidRequest} object
     */
    public interface Builder {

        /**
         * Add an impression to this request
         *
         * @param impression
         * @return this builder instance
         */
        Builder impression(Impression impression);

        /**
         * Set the app details for this request
         *
         * @param app
         * @return this builder instance
         */
        Builder app(App app);

        /**
         * Set the {@link Device} details of this request
         *
         * @param device
         * @return this builder instance
         */
        Builder device(Device device);

        /**
         * Set the device size of this request in absolute pixels
         *
         * @param width width of the device in pixels
         * @param height height of the device in pixels
         * @return this builder instance
         */
        Builder deviceSize(int width, int height);

        /**
         * Set the {@link User} details of this request
         *
         * @param user
         * @return this builder instance
         */
        Builder user(User user);

        /**
         * Mark this request as a test
         *
         * @param enabled true if test mode is enabled, default is false
         * @return {@link Builder}
         */
        Builder test(boolean enabled);

        /**
         * Set the timeout of the request.
         *
         * @param timeout int [Default: 500]
         * @return this builder instance
         */
        Builder timeout(int timeout);

        /**
         * Sets the {@link Regs} object
         *
         * @param regs
         * @return this builder instance
         */
        Builder regs(Regs regs);

        /**
         * Sets the {@link Source} object
         *
         * @param source
         * @return this builder instance
         */
        Builder source(Source source);

        /**
         * Sets a list of blocked advertisers by domains
         *
         * @param domains
         * @return this builder instance
         */
         Builder blockedDomains(String... domains);

        /**
         * Sets the Nimbus API key
         *
         * @param apiKey
         * @return this builder instance
         */
        Builder apiKey(String apiKey);

        /**
         * Sets the Nimbus session id
         *
         * @param sessionId
         * @return this builder instance
         */
        Builder sessionId(String sessionId);
    }
}
