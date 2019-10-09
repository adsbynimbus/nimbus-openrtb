package com.adsbynimbus.openrtb.publisher;

/**
 * This object should be included if the ad supported content is a non-browser application (typically in
 * mobile) as opposed to a website. A bid request must not contain both an App and a Site object. At a
 * minimum, it is useful to provide an App ID or bundle, but this is not strictly required.
 */
public interface App {

    int FREE_APP = 0;
    int PAID_APP = 1;

    String BUNDLE = "bundle";
    String STORE_URL = "storeurl";
    String PAID = "paid"; //Integer
    String PUBLISHER = "publisher";
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
         * Set categories
         *
         * @param categories
         * @return this builder instance
         */
        Builder withCategories(String... categories);

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
        public String ver;
        public Integer paid;
        public String publisher;
    }
}
