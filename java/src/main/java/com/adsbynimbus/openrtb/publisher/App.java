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
