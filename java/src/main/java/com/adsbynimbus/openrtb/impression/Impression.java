package com.adsbynimbus.openrtb.impression;

import java.util.List;

/**
 * This object describes an ad placement or impression being auctioned. A single bid request can include
 * multiple Imp objects, a use case for which might be an exchange that supports selling all ad positions on
 * a given page. Each Imp object has a required ID so that bids can reference them individually.
 * The presence of {@link Banner} (Section 3.2.6), {@link Video} (Section 3.2.7), and/or Native (Section 3.2.9) objects
 * subordinate to the Imp object indicates the type of impression being offered. The publisher can choose
 * one such type which is the typical case or mix them at their discretion. However, any given bid for the
 * impression must conform to one of the offered types.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=12">OpenRTB Section 3.2.4</a>
 */
public class Impression {

    /**
     * A unique identifier for this impression within the context of the bid request
     * (typically, starts with 1 and increments). This field is optional as only 1 imp object is currently supported.
     */
    public String id;

    /**
     * A {@link Banner} object (Section 3.2.6); required if this impression is offered as a banner ad opportunity or
     * is used in the Nimbus hybrid auction.
     */
    public Banner banner;

    /**
     * A {@link Video} object (Section 3.2.7); required if this impression is offered as a video ad opportunity or is
     * used in Nimbus hybrid auction.
     */
    public Video video;

    /**
     * 1 = the ad is interstitial or full screen, 0 = not interstitial. Default is 0
     */
    public Integer instl;

    /**
     * Minimum bid for this impression expressed in CPM. Default is 1.0
     */
    public Float bidfloor;

    /**
     * Flag to indicate if the impression requires secure HTTPS URL creative assets and markup, where 0 = non-secure,
     * 1 = secure. If this field is omitted all request will default to HTTPS
     */
    public Integer secure;

    /**
     * Placeholder for exchange-specific extensions to OpenRTB. Reference {@link Extension} for values
     */
    public Extension ext;

    /**
     * {@link Impression} extension unique to Nimbus
     */
    public static class Extension {

        /**
         * Required string identifying the name of the placement that will be displayed on the Nimbus dashboard.
         */
        public String position;

        /**
         * The identifier for this app provided by Facebook. Required if including Facebook demand in this request.
         */
        public String facebook_app_id;

        /**
         * The list of key value pairs provided by a DTBRequest from the APS library.
         */
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
         * @see #id
         */
        Builder id(String id);

        /**
         * Include a banner in the auction for this impression
         *
         * @param banner a configured banner object
         * @return this builder instance
         * @see #banner
         */
        Builder banner(Banner banner);

        /**
         * Include a video in the auction for this impression
         *
         * @param video a configured video object
         * @return this builder instance
         * @see #video
         */
        Builder video(Video video);

        /**
         * Set the bid floor of this impression [Default: 1.00]
         *
         * @param bidFloor bid floor represented in CPM. [Default: 1.0]
         * @return this builder instance
         * @see #bidfloor
         */
        Builder bidFloor(float bidFloor);

        /**
         * Set to true if this placement is an interstitial
         *
         * @param instl true if this placement is an interstitial
         * @return this builder instance
         * @see #instl
         */
        Builder interstitial(boolean instl);

        /**
         * Set to true if this impression must be served over HTTPS, false to allow HTTP and HTTPS. This call is
         * optional and Nimbus will default to only serving over HTTPS
         *
         * @param secure true if this impression must be served over HTTPS, false to allow HTTP and HTTPS.
         *               [Default: true]
         * @return this builder instance
         * @see #secure
         */
        Builder secure(boolean secure);

        /**
         * Set the Facebook App id of this impression
         *
         * @param facebookAppId unique app identifier provided by Facebook
         * @return this builder instance
         */
        Builder facebookAppId(String facebookAppId);

        /**
         * Set the APS params for this impression
         *
         * @param apsParams a list of key value pair maps from the APS sdk
         * @return this builder instance
         */
        Builder apsParams(List apsParams);
    }
}
