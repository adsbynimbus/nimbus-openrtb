package com.adsbynimbus.openrtb.impression;

import java.util.List;

/**
 * This object describes an ad placement or impression being auctioned. A single bid request can include
 * multiple Imp objects, a use case for which might be an exchange that supports selling all ad positions on
 * a given page. Each Imp object has a required ID so that bids can reference them individually.
 * The presence of Banner (Section 3.2.6), Video (Section 3.2.7), and/or Native (Section 3.2.9) objects
 * subordinate to the Imp object indicates the type of impression being offered. The publisher can choose
 * one such type which is the typical case or mix them at their discretion. However, any given bid for the
 * impression must conform to one of the offered types.
 */
public class Impression {

    public static final String BANNER = "banner"; // Banner
    public static final String VIDEO = "video"; // Video
    public static final String INTERSTITIAL = "instl"; //int (default 0; 0 = not interstitial, 1 = interstitial or full screen)
    public static final String SECURE = "secure"; //int (default: 1, 0 = not secure, 1 = require https)

    public String id;
    public Banner banner;
    public Video video;
    public Integer instl; // Server default 0
    public Float bidfloor; // Server default 1.0
    public Integer secure; // Server default 1
    public Extension ext;

    /**
     * Impression 'ext' object used by Nimbus
     */
    public static class Extension {
        public static final String POSITION = "position";
        public static final String FACEBOOK_APP_ID = "facebook_app_id";
        public static final String APS = "aps";

        public String position;
        public String facebook_app_id;
        public List aps;
    }


    /**
     * Builder for constructing a {@link Impression} object
     */
    public interface Builder  {

        /**
         * Set the id of the impression
         *
         * @param id an optional identifier
         * @return this builder instance
         */
        Builder id(String id);

        /**
         * Include a banner in the auction for this impression
         *
         * @param banner a configured banner object
         * @return this builder instance
         */
        Builder banner(Banner banner);

        /**
         * Include a video in the auction for this impression
         *
         * @param video a configured video object
         * @return this builder instance
         */
        Builder video(Video video);

        /**
         * Set the bid floor. [Default: 1.00]
         *
         * @param bidFloor
         * @return this builder instance
         */
        Builder bidFloor(float bidFloor);

        /**
         * Set to true if this placement is an interstitial
         *
         * @param instl true if this placement is an interstitial
         * @return this builder instance
         */
        Builder interstitial(boolean instl);

        /**
         * Set to true if this impression must be served over HTTPS, false to allow HTTP and HTTPS. Default is true
         *
         * @param secure true if this impression must be served over HTTPS, false to allow HTTP and HTTPS
         * @return this builder instance
         */
        Builder secure(boolean secure);

        /**
         * Set the Facebook App id of this impression
         *
         * @param facebookAppId
         * @return this builder instance
         */
        Builder facebookAppId(String facebookAppId);

        /**
         * Set the APS params for this impression
         *
         * @param apsParams
         * @return this builder instance
         */
        Builder apsParams(List apsParams);
    }
}
