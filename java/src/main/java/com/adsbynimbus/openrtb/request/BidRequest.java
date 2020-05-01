package com.adsbynimbus.openrtb.request;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * The top-level bid request object contains a globally unique bid request or auction ID. This id attribute is
 * required as is at least one impression object (Section 3.2.4). Other attributes in this top-level object
 * establish rules and restrictions that apply to all impressions being offered.
 * There are also several subordinate objects that provide detailed data to potential buyers. Among these
 * are the Site and App objects, which describe the type of published media in which the impression(s)
 * appear. These objects are highly recommended, but only one applies to a given bid request depending
 * on whether the media is browser-based web content or a non-browser application, respectively.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=15">OpenRTB Section 3.2.1</a>
 */
public class BidRequest {

    /**
     * Required header if making a request to Nimbus defining the OpenRTB version
     */
    public static final String HEADER_OPEN_RTB = "x-openrtb-version";

    /**
     * The current supported OpenRTB version for use with {@link #HEADER_OPEN_RTB}
     */
    public static final String OPEN_RTB_VERSION = "2.5";

    /**
     * Array of impression objects representing the impressions offered. Only 1 impression object is supported.
     */
    public Impression[] imp;

    /**
     * Details about the publisher’s app (i.e., non-browser applications).
     */
    public App app;

    /**
     * Details about the user’s device to which the impression will be delivered.
     */
    public Device device;

    /**
     * This is not part of the spec, adding this here for convenience allows height and width to be passed without the
     * video/banner object to backwards support the GET
     */
    public Format format;

    /**
     * Details about the human user of the device; the advertising audience.
     */
    @Nullable
    public User user;

    /**
     * Indicator of test mode in which auctions are not billable, where 0 = live mode, 1 = test mode
     */
    @Nullable
    public Integer test;

    /**
     * Maximum time in milliseconds the exchange allows for bids to be received including Internet latency to avoid
     * timeout. This value supersedes any a priori guidance from the exchange.
     * <p><br>
     * If this value is omitted Nimbus will default to 500
     */
    @Nullable
    public Integer tmax;

    /**
     * A Regs object that specifies any industry, legal, or governmental regulations in force for this request.
     */
    @Nullable
    public Regs regs;

    /**
     * A Source object that provides data about the inventory source and which entity makes the final decision.
     */
    @Nullable
    public Source source;

    /**
     * Block list of advertisers by their domains (e.g., "ford.com").
     */
    @Nullable
    public String[] badv;

    /**
     * Placeholder for exchange-specific extensions to OpenRTB.
     */
    public Extension ext;

    /**
     * BidRequest extension object unique to Nimbus
     */
    public static class Extension {

        /**
         * The publisher specific api key used to communicate with Nimbus
         */
        public String api_key;

        /**
         * Any unique string value to identify the session. Defaults to {@link UUID#randomUUID()} when using the
         * Nimbus SDK
         */
        public String session_id;
    }

    /**
     * Builder for constructing a BidRequest object
     *
     * @see BidRequest
     */
    public interface Builder {

        /**
         * Sets the impression for this request.
         *
         * @param impression an impression object to set or replace the value currently on this request. Will create the
         *                   impression array if it does not exist and replace the current value in imp[0] if one does.
         * @return this builder instance
         */
        @NotNull
        Builder impression(@NotNull Impression impression);

        /**
         * Sets the app details for this request.
         *
         * @param app an app object to set or replace the value currently on this request.
         * @return this builder instance
         */
        @NotNull
        Builder app(@NotNull App app);

        /**
         * Sets the device details of this request.
         *
         * @param device a device object to set or replace the value currently on this request.
         * @return this builder instance
         */
        @NotNull
        Builder device(@NotNull Device device);

        /**
         * Sets the device size of this request in absolute pixels.
         *
         * @param width  width of the device in pixels
         * @param height height of the device in pixels
         * @return this builder instance
         */
        @NotNull
        Builder deviceSize(int width, int height);

        /**
         * Set the user details of this request.
         *
         * @param user a user object to set or replace the value currently on this request
         * @return this builder instance
         */
        @NotNull
        Builder user(@NotNull User user);

        /**
         * Marks this request as a test.
         *
         * @param enabled true if test mode is enabled, default is false
         * @return {@link Builder}
         */
        @NotNull
        Builder test(boolean enabled);

        /**
         * Sets the timeout of this request in ms.
         * <p><br>
         * If this value is omitted Nimbus will default to 500
         *
         * @param timeout set or replace the timeout value on this request.
         * @return this builder instance
         */
        @NotNull
        Builder timeout(int timeout);

        /**
         * Sets the regs object of this request.
         *
         * @param regs a regs object to set or replace the value currently on this request
         * @return this builder instance
         */
        @NotNull
        Builder regs(@NotNull Regs regs);

        /**
         * Sets the source object of this request.
         *
         * @param source a source object to set or replace the value currently on this request
         * @return this builder instance
         */
        @NotNull
        Builder source(@NotNull Source source);

        /**
         * Sets a list of blocked advertisers by domains.
         *
         * @param domains a list of domain names to block
         * @return this builder instance
         */
        @NotNull
        Builder blockedDomains(@NotNull String... domains);

        /**
         * Sets the Nimbus API key.
         *
         * @param apiKey the publisher specific api key provided by Nimbus
         * @return this builder instance
         */
        @NotNull
        Builder apiKey(@NotNull String apiKey);

        /**
         * Sets the Nimbus session id.
         *
         * @param sessionId any unique identifier for this session. Recommend using {@link UUID#randomUUID()}
         * @return this builder instance
         */
        @NotNull
        Builder sessionId(@NotNull String sessionId);
    }
}