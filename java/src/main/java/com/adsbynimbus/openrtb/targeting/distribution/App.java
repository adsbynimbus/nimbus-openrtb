package com.adsbynimbus.openrtb.targeting.distribution;

import com.adsbynimbus.openrtb.targeting.Data;

/**
 * This object should be included if the ad supported content is a non-browser application (typically in
 * mobile) as opposed to a website. A bid request must not contain both an App and a Site object. At a
 * minimum, it is useful to provide an App ID or bundle, but this is not strictly required.
 */
public class App {

    public static final int FREE_APP = 0;
    public static final int PAID_APP = 1;

    public static final String NAME = Data.NAME;
    public static final String DOMAIN = "domain";
    public static final String CONTENT_CATEGORIES = "cat"; // String[]
    public static final String BUNDLE = "bundle";
    public static final String STORE_URL = "storeurl";
    public static final String PAGE_CATEGORIES = "pagecat";
    public static final String PAID = "paid"; //Integer
    public static final String PRIVACY_POLICY = "privacypolicy";
    public static final String PUBLISHER = "publisher";
    public static final String SECTION_CATEGORIES = "sectioncat";
    public static final String VERSION = "ver";

    public String name;
    public String bundle;
    public String domain;
    public String storeurl;
    public String[] cat;
    public String[] sectioncat;
    public String[] pagecat;
    public String ver;
    public Integer privacypolicy;
    public Integer paid;
    public Publisher publisher;

    /**
     * Builder for constructing a {@link App} object
     */
    public interface Builder {

        /**
         * Set the name of this app
         *
         * @param name
         * @return this builder instance
         */
        Builder name(String name);

        /**
         * Set the bundle id of this app.
         *
         * @param bundle the bundle id
         * @return this builder instance
         */
        Builder bundle(String bundle);

        /**
         * Set the domain name of this app
         *
         * @param domain
         * @return this builder instance
         */
        Builder domain(String domain);

        /**
         * Set this app store url
         *
         * @param storeUrl
         * @return this builder instance
         */
        Builder storeUrl(String storeUrl);

        /**
         * Set content categories
         *
         * @param cat
         * @return this builder instance
         */
        Builder categories(String... cat);

        /**
         * Set the page categories of this app
         *
         * @param pageCategories
         * @return this builder instance
         */
        Builder pageCategories(String... pageCategories);

        /**
         * Set section categories of this app
         *
         * @param sectionCategories
         * @return this builder instance
         */
        Builder sectionCategories(String... sectionCategories);

        /**
         * Set the version of this app
         *
         * @param version
         * @return this builder instance
         */
        Builder version(String version);

        /**
         * Set to true if this app has a privacy policy associated with it
         *
         * @param privacyPolicy 0: no policy; 1: policy
         * @return this builder instance
         */
        Builder privacyPolicy(boolean privacyPolicy);

        /**
         * Set to true if this app is a paid app
         *
         * @param paid true if this app is a paid app, false otherwise
         * @return this builder instance
         */
        Builder paid(boolean paid);

        /**
         * Set the Publisher of this app
         *
         * @param publisher
         * @return this builder instance
         */
        Builder publisher(Publisher publisher);
    }
}
