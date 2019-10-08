package com.adsbynimbus.openrtb.impression;

import java.util.Map;

/**
 * This object describes an ad placement or impression being auctioned. A single bid request can include
 * multiple Imp objects, a use case for which might be an exchange that supports selling all ad positions on
 * a given page. Each Imp object has a required ID so that bids can reference them individually.
 * The presence of Banner (Section 3.2.6), Video (Section 3.2.7), and/or Native (Section 3.2.9) objects
 * subordinate to the Imp object indicates the type of impression being offered. The publisher can choose
 * one such type which is the typical case or mix them at their discretion. However, any given bid for the
 * impression must conform to one of the offered types.
 */
public interface Impression extends Creative {

    String BANNER = "banner"; // Banner
    String VIDEO = "video"; // Video
    String DISPLAY_MANAGER = "displaymanager";
    String DISPLAY_MANAGER_SERVER = "displaymanagerserver";
    String INTERSTITIAL = "instl"; //int (default 0; 0 = not interstitial, 1 = interstitial or full screen)
    String REQUIRE_HTTPS = "secure"; //int (default: 1, 0 = not secure, 1 = require https)

    /**
     * Impression 'ext' object used by Nimbus
     */
    interface Extension {
        String POSITION = "position";
        String FACEBOOK_APP_ID = "facebook_app_id";
        String APS = "aps";
    }


    /**
     * Builder for constructing a {@link Impression} object
     */
    interface Builder  {

    }

    /**
     * Definition of {@link Impression} with all public mutable fields
     */
    class MutableImpression implements Impression {
        public Banner banner;
        public Video video;
        public String displaymanager;
        public String displaymanagerserver;
        public Integer instl; // Server default 0
        public Float bidfloor; // Server default 1.0
        public Integer secure; // Server default 1
        public Extension ext;
    }

    /**
     * Definition of {@link Impression.Extension} with all public mutable fields
     */
    class MutableExtension implements Extension {
        public String position;
        public String facebook_app_id;
        public Map aps;
    }
}
