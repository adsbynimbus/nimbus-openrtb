package com.adsbynimbus.openrtb.targeting.distribution;

import com.adsbynimbus.openrtb.targeting.Data;

/**
 * This object should be included if the ad supported content is a non-browser application (typically in
 * mobile) as opposed to a website. A bid request must not contain both an App and a Site object. At a
 * minimum, it is useful to provide an App ID or bundle, but this is not strictly required.
 */
public interface App {

    int FREE_APP = 0;
    int PAID_APP = 1;

    String NAME = Data.NAME;
    String DOMAIN = "domain";
    String CONTENT_CATEGORIES = "cat"; // String[]
    String BUNDLE = "bundle";
    String STORE_URL = "storeurl";
    String PAGE_CATEGORIES = "pagecat";
    String PAID = "paid"; //Integer
    String PRIVACY_POLICY = "privacypolicy";
    String PUBLISHER = "publisher";
    String SECTION_CATEGORIES = "sectioncat";
    String VERSION = "ver";

    /**
     * Builder for constructing a {@link App} object
     */
    interface Builder {

        /**
         * Set the name of the app
         *
         * @param name
         * @return this builder instance
         */
        Builder withName(String name);

        /**
         * Set the bundle id
         *
         * @param bundle
         * @return this builder instance
         */
        Builder withBundle(String bundle);

        /**
         * Set the domain name of the app
         *
         * @param domain
         * @return this builder instance
         */
        Builder withDomain(String domain);

        /**
         * Set the app store url
         *
         * @param storeUrl
         * @return this builder instance
         */
        Builder withStoreUrl(String storeUrl);

        /**
         * Set content categories
         *
         * @param categories
         * @return this builder instance
         */
        Builder withContentCategories(String... categories);

        /**
         * Set if the app is paid or not
         *
         * @param appCost
         * @return this builder instance
         */
        Builder withAppCost(int appCost);

        /**
         * Set the {@link Publisher}
         *
         * @param publisher
         * @return this builder instance
         */
        Builder withPublisher(Publisher publisher);

        /**
         * Set page categories
         *
         * @param pageCategories
         * @return this builder instance
         */
        Builder withPageCategories(String... pageCategories);

        /**
         * Set section categories
         *
         * @param sectionCategories
         * @return this builder instance
         */
        Builder withSectionCategories(String... sectionCategories);

        /**
         * Include privacy policy information
         *
         * @param privacyPolicy 0: no policy; 1: policy
         * @return this builder instance
         */
        Builder withPrivacyPolicy(int privacyPolicy);

        /**
         * Include the app version
         *
         * @param version
         * @return this builder instance
         */
        Builder withVersion(String version);
    }

    /**
     * Definition of {@link App} with all public mutable fields
     */
    class MutableApp implements App {
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
        public String publisher;
    }
}
