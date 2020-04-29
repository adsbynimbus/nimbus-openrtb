package com.adsbynimbus.openrtb.impression;

import com.adsbynimbus.openrtb.BidRequest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This object describes an ad placement or impression being auctioned. A single {@link BidRequest} can include
 * multiple {@link Impression} objects, a use case for which might be an exchange that supports selling all ad positions
 * on a given page. Each {@link Impression} object has a required ID so that bids can reference them individually.
 * The presence of {@link Banner} (Section 3.2.6), {@link Video} (Section 3.2.7), subordinate to the Imp object
 * indicates the type of impression being offered. The publisher can choose one such type which is the typical case or
 * mix them at their discretion. However, any given bid for the impression must conform to one of the offered types.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=12">OpenRTB Section 3.2.4</a>
 */
public class Impression {

    /**
     * A unique identifier for this impression within the context of the bid request (typically, starts with 1
     * and increments). This field is optional as only 1 impression object is currently supported by Nimbus.
     */
    @Nullable
    public String id;

    /**
     * A banner object; required if this impression is offered as a banner ad opportunity or is used in the Nimbus
     * hybrid auction.
     */
    @Nullable
    public Banner banner;

    /**
     * A video object; required if this impression is offered as a video ad opportunity or is used in Nimbus
     * hybrid auction.
     */
    @Nullable
    public Video video;

    /**
     * 1 = the ad is interstitial or full screen, 0 = not interstitial.
     * <p><br>
     * If this value is omitted Nimbus will default to 0
     */
    @Nullable
    public Integer instl;

    /**
     * Minimum bid for this impression expressed in CPM.
     * <p><br>
     * If this value is omitted Nimbus defaults to 1.0
     */
    @Nullable
    public Float bidfloor;

    /**
     * Flag to indicate if the impression requires secure HTTPS URL creative assets and markup, where 0 = non-secure,
     * 1 = secure.
     * <p><br>
     * If this value is omitted Nimbus defaults to 1
     */
    @Nullable
    public Integer secure;

    /**
     * Placeholder for exchange-specific extensions to OpenRTB
     *
     * @see Extension
     */
    public Extension ext;

    /**
     * Impression extension unique to Nimbus
     *
     * @see Impression
     */
    public static class Extension {

        /**
         * Required string identifying the name of the placement that will be displayed on the Nimbus dashboard.
         */
        public String position;

        /**
         * The identifier for this app provided by Facebook. Required if including Facebook demand in this request.
         */
        @Nullable
        public String facebook_app_id;

        /**
         * The list of key value pairs provided by a DTBRequest from the APS library.
         */
        @Nullable
        public List<?> aps;
    }


    /**
     * Builder for constructing an Impression object
     *
     * @see Impression
     */
    public interface Builder  {

        /**
         * Sets the id of the impression
         *
         * @param id an optional identifier
         * @return this builder instance
         * @see #id
         */
        @NotNull
        Builder id(@Nullable String id);

        /**
         * Includes a banner in the auction for this impression
         *
         * @param banner a configured banner object
         * @return this builder instance
         * @see #banner
         */
        @NotNull
        Builder banner(@Nullable Banner banner);

        /**
         * Includes a video in the auction for this impression
         *
         * @param video a configured video object
         * @return this builder instance
         * @see #video
         */
        @NotNull
        Builder video(@Nullable Video video);

        /**
         * Sets the bid floor of this impression.
         * <p><br>
         * If this value is omitted Nimbus will default to 1.0
         *
         * @param bidFloor bid floor represented in CPM
         * @return this builder instance
         * @see #bidfloor
         */
        @NotNull
        Builder bidFloor(float bidFloor);

        /**
         * Sets to true if this placement is an interstitial
         *
         * @param instl true if this placement is an interstitial
         * @return this builder instance
         * @see #instl
         */
        @NotNull
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
        @NotNull
        Builder secure(boolean secure);

        /**
         * Sets the Facebook App id of this impression
         *
         * @param facebookAppId unique app identifier provided by Facebook
         * @return this builder instance
         */
        @NotNull
        Builder facebookAppId(@Nullable String facebookAppId);

        /**
         * Sets the APS params for this impression
         *
         * @param apsParams a list of key value pair maps from the APS sdk
         * @return this builder instance
         */
        @NotNull
        Builder apsParams(@Nullable List<?> apsParams);
    }
}
