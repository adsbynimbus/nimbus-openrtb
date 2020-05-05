package com.adsbynimbus.openrtb.request

/**
 * This object should be included if the ad supported content is a non-browser application (typically in
 * mobile) as opposed to a website. A bid request must not contain both an App and a Site object. At a
 * minimum, it is useful to provide an App ID or bundle, but this is not strictly required.
 *
 * @see [OpenRTB Section 3.2.14](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=25)
 */
class App {
    /**
     * App name (may be aliased at the publisher’s request).
     */
    @JvmField
    var name: String? = null

    /**
     * A platform-specific application identifier intended to be unique to the app and independent of the exchange. On
     * Android, this should be a bundle or package name (e.g., com.foo.mygame). On iOS, it is typically a numeric ID.
     */
    @JvmField
    var bundle: String? = null

    /**
     * Domain of the app (e.g., "adsbynimbus.com").
     */
    @JvmField
    var domain: String? = null

    /**
     * App store URL for an installed app; for IQG 2.1 compliance
     */
    @JvmField
    var storeurl: String? = null

    /**
     * Array of IAB content categories of the app.
     *
     * @see [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=39)
     */
    @JvmField
    var cat: Array<String>? = null

    /**
     * Array of IAB content categories that describe the current section of the app.
     *
     * @see [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=39)
     */
    @JvmField
    var sectioncat: Array<String>? = null

    /**
     * Array of IAB content categories that describe the current page or view of the app.
     *
     * @see [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=39)
     */
    @JvmField
    var pagecat: Array<String>? = null

    /**
     * Application version.
     */
    @JvmField
    var ver: String? = null

    /**
     * Indicates if the app has a privacy policy, where 0 = no, 1 = yes
     */
    @JvmField
    var privacypolicy: Int? = null

    /**
     * Indicates if the app is free or paid.
     *
     *  * 0: free
     *  * 1: paid
     *
     */
    @JvmField
    var paid: Int? = null

    /**
     * Details about the publisher of the app.
     */
    @JvmField
    var publisher: Publisher? = null

    /**
     * Builder for constructing an app object
     *
     * @see App
     */
    interface Builder {
        /**
         * Sets the name of this app.
         *
         * @param name the name of the app
         * @return this builder instance
         * @see .name
         */
        fun name(name: String?): Builder?

        /**
         * Sets the bundle id of this app.
         *
         * @param bundle the bundle id
         * @return this builder instance
         * @see .bundle
         */
        fun bundle(bundle: String?): Builder?

        /**
         * Sets the domain name of this app.
         *
         * @param domain the domain associated with this app
         * @return this builder instance
         * @see .domain
         */
        fun domain(domain: String?): Builder?

        /**
         * Sets this app store url.
         *
         * @param storeUrl the store url of this app
         * @return this builder instance
         * @see .storeurl
         */
        fun storeUrl(storeUrl: String?): Builder?

        /**
         * Sets the IAB content categories that describe this app.
         *
         * @param cat list of IAB content categories
         * @return this builder instance
         * @see .cat
         *
         * @see [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=39)
         */
        fun categories(vararg cat: String?): Builder?

        /**
         * Sets the IAB content categories that describe the current page of this app.
         *
         * @param pageCategories list of IAB content categories
         * @return this builder instance
         * @see .pagecat
         *
         * @see [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=34)
         */
        fun pageCategories(vararg pageCategories: String?): Builder?

        /**
         * Sets the IAB content categories that describe the current section of this app.
         *
         * @param sectionCategories list of IAB content categories
         * @return this builder instance
         * @see .sectioncat
         *
         * @see [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=34)
         */
        fun sectionCategories(vararg sectionCategories: String?): Builder?

        /**
         * Sets the version of this app.
         *
         * @param version the app version friendly name
         * @return this builder instance
         * @see .ver
         */
        fun version(version: String?): Builder?

        /**
         * Sets to true if this app has a privacy policy associated with it.
         *
         * @param privacyPolicy the privacy policy where 0: no policy; 1: policy
         * @return this builder instance
         * @see .privacypolicy
         */
        fun privacyPolicy(privacyPolicy: Boolean): Builder?

        /**
         * Sets to true if this app is a paid app.
         *
         * @param paid true if this app is a paid app, false otherwise
         * @return this builder instance
         * @see .paid
         */
        fun paid(paid: Boolean): Builder?

        /**
         * Sets the Publisher of this app.
         *
         * @param publisher the configured publisher object
         * @return this builder instance
         * @see .publisher
         *
         * @see Publisher
         */
        fun publisher(publisher: Publisher?): Builder?
    }

    companion object {
        /**
         * Free App
         */
        const val FREE = 0

        /**
         * Paid App
         */
        const val PAID = 1
    }
}