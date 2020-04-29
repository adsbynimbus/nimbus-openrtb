package com.adsbynimbus.openrtb.targeting.distribution;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This object should be included if the ad supported content is a non-browser application (typically in
 * mobile) as opposed to a website. A bid request must not contain both an App and a Site object. At a
 * minimum, it is useful to provide an App ID or bundle, but this is not strictly required.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=25">OpenRTB Section 3.2.14</a>
 */
public class App {

    /**
     * Free App
     */
    public static final int FREE = 0;

    /**
     * Paid App
     */
    public static final int PAID = 1;

    /**
     * App name (may be aliased at the publisher’s request).
     */
    public String name;

    /**
     * A platform-specific application identifier intended to be unique to the app and independent of the exchange. On
     * Android, this should be a bundle or package name (e.g., com.foo.mygame). On iOS, it is typically a numeric ID.
     */
    public String bundle;

    /**
     * Domain of the app (e.g., "adsbynimbus.com").
     */
    public String domain;

    /**
     * App store URL for an installed app; for IQG 2.1 compliance
     */
    public String storeurl;

    /**
     * Array of IAB content categories of the app.
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39">OpenRTB Section 5.1</a>
     */
    @Nullable
    public String[] cat;

    /**
     * Array of IAB content categories that describe the current section of the app.
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39">OpenRTB Section 5.1</a>
     */
    @Nullable
    public String[] sectioncat;

    /**
     * Array of IAB content categories that describe the current page or view of the app.
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39">OpenRTB Section 5.1</a>
     */
    @Nullable
    public String[] pagecat;

    /**
     * Application version.
     */
    public String ver;

    /**
     * Indicates if the app has a privacy policy, where 0 = no, 1 = yes
     */
    @Nullable
    public Integer privacypolicy;

    /**
     * Indicates if the app is free or paid.
     * <ul>
     *     <li>0: free</li>
     *     <li>1: paid</li>
     * </ul>
     */
    @Nullable
    public Integer paid;

    /**
     * Details about the publisher of the app.
     */
    public Publisher publisher;

    /**
     * Builder for constructing an app object
     *
     * @see App
     */
    public interface Builder {

        /**
         * Sets the name of this app.
         *
         * @param name the name of the app
         * @return this builder instance
         * @see #name
         */
        @NotNull
        Builder name(@NotNull String name);

        /**
         * Sets the bundle id of this app.
         *
         * @param bundle the bundle id
         * @return this builder instance
         * @see #bundle
         */
        @NotNull
        Builder bundle(@NotNull String bundle);

        /**
         * Sets the domain name of this app.
         *
         * @param domain the domain associated with this app
         * @return this builder instance
         * @see #domain
         */
        @NotNull
        Builder domain(@NotNull String domain);

        /**
         * Sets this app store url.
         *
         * @param storeUrl the store url of this app
         * @return this builder instance
         * @see #storeurl
         */
        @NotNull
        Builder storeUrl(@NotNull String storeUrl);

        /**
         * Sets the IAB content categories that describe this app.
         *
         * @param cat list of IAB content categories
         * @return this builder instance
         * @see #cat
         * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39">OpenRTB Section 5.1</a>
         */
        @NotNull
        Builder categories(@Nullable String... cat);

        /**
         * Sets the IAB content categories that describe the current page of this app.
         *
         * @param pageCategories list of IAB content categories
         * @return this builder instance
         * @see #pagecat
         * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=34">OpenRTB Section 5.1</a>
         */
        @NotNull
        Builder pageCategories(@Nullable String... pageCategories);

        /**
         * Sets the IAB content categories that describe the current section of this app.
         *
         * @param sectionCategories list of IAB content categories
         * @return this builder instance
         * @see #sectioncat
         * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=34">OpenRTB Section 5.1</a>
         */
        @NotNull
        Builder sectionCategories(@Nullable String... sectionCategories);

        /**
         * Sets the version of this app.
         *
         * @param version the app version friendly name
         * @return this builder instance
         * @see #ver
         */
        @NotNull
        Builder version(@NotNull String version);

        /**
         * Sets to true if this app has a privacy policy associated with it.
         *
         * @param privacyPolicy the privacy policy where 0: no policy; 1: policy
         * @return this builder instance
         * @see #privacypolicy
         */
        @NotNull
        Builder privacyPolicy(boolean privacyPolicy);

        /**
         * Sets to true if this app is a paid app.
         *
         * @param paid true if this app is a paid app, false otherwise
         * @return this builder instance
         * @see #paid
         */
        @NotNull
        Builder paid(boolean paid);

        /**
         * Sets the Publisher of this app.
         *
         * @param publisher the configured publisher object
         * @return this builder instance
         * @see #publisher
         * @see Publisher
         */
        @NotNull
        Builder publisher(@NotNull Publisher publisher);
    }
}
