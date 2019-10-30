package com.adsbynimbus.openrtb.targeting.distribution;

/**
 * This object should be included if the ad supported content is a non-browser application (typically in
 * mobile) as opposed to a website. A bid request must not contain both an App and a Site object. At a
 * minimum, it is useful to provide an App ID or bundle, but this is not strictly required.
 */
public class App {

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
     * Domain of the app (e.g., “adsbynimbus.com”).
     */
    public String domain;

    /**
     * App store URL for an installed app; for IQG 2.1 compliance
     */
    public String storeurl;

    /**
     * Array of IAB content categories of the app. Refer to List 5.1
     */
    public String[] cat;

    /**
     * Array of IAB content categories that describe the current section of the app. Refer to List 5.1.
     */
    public String[] sectioncat;

    /**
     * Array of IAB content categories that describe the current page or view of the app. Refer to List 5.1.
     */
    public String[] pagecat;

    /**
     * Application version.
     */
    public String ver;

    /**
     * Indicates if the app has a privacy policy, where 0 = no, 1 = yes
     */
    public Integer privacypolicy;

    /**
     * 0 = app is free, 1 = the app is a paid version
     */
    public Integer paid;

    /**
     * Details about the {@link Publisher} of the app.
     */
    public Publisher publisher;

    /**
     * Builder for constructing an {@link App} object
     */
    public interface Builder {

        /**
         * Set the name of this app
         *
         * @param name name of the app
         * @return this builder instance
         * @see #name
         */
        Builder name(String name);

        /**
         * Set the bundle id of this app.
         *
         * @param bundle the bundle id
         * @return this builder instance
         * @see #bundle
         */
        Builder bundle(String bundle);

        /**
         * Set the domain name of this app
         *
         * @param domain the domain associated with this app
         * @return this builder instance
         * @see #domain
         */
        Builder domain(String domain);

        /**
         * Set this app store url
         *
         * @param storeUrl the store url of this app
         * @return this builder instance
         * @see #storeurl
         */
        Builder storeUrl(String storeUrl);

        /**
         * Set the IAB content categories that describe this app.
         *
         * @param cat list of IAB content categories
         * @return this builder instance
         * @see #cat
         */
        Builder categories(String... cat);

        /**
         * Set the IAB content categories that describe the current page of this app
         *
         * @param pageCategories list of IAB content categories
         * @return this builder instance
         */
        Builder pageCategories(String... pageCategories);

        /**
         * Set the IAB content categories that describe the current section of this app
         *
         * @param sectionCategories list of IAB content categories
         * @return this builder instance
         * @see #sectioncat
         */
        Builder sectionCategories(String... sectionCategories);

        /**
         * Set the version of this app
         *
         * @param version the app version friendly name
         * @return this builder instance
         * @see #ver
         */
        Builder version(String version);

        /**
         * Set to true if this app has a privacy policy associated with it
         *
         * @param privacyPolicy 0: no policy; 1: policy
         * @return this builder instance
         * @see #privacypolicy
         */
        Builder privacyPolicy(boolean privacyPolicy);

        /**
         * Set to true if this app is a paid app
         *
         * @param paid true if this app is a paid app, false otherwise
         * @return this builder instance
         * @see #paid
         */
        Builder paid(boolean paid);

        /**
         * Set the Publisher of this app
         *
         * @param publisher the configured publisher object
         * @return this builder instance
         * @see #publisher
         * @see Publisher
         */
        Builder publisher(Publisher publisher);
    }
}
