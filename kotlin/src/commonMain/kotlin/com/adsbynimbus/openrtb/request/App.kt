package com.adsbynimbus.openrtb.request

import kotlin.jvm.JvmField

/**
 * This object should be included if the ad supported content is a non-browser application
 * (typically inmobile) as opposed to a website. A bid request must not contain both an App and a
 * Site object. At aminimum, it is useful to provide an App ID or bundle, but this is not strictly
 * required.
 *
 * [OpenRTB Section 3.2.14](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=25)
 *
 * @property name App name (may be aliased at the publisher’s request).
 * @property bundle A platform-specific application identifier intended to be unique to the app and
 *                  independent of the exchange. On Android, this should be a bundle or package name
 *                  (e.g., com.foo.mygame). On iOS, it is typically a numeric ID.
 * @property domain Domain of the app (e.g., "adsbynimbus.com").
 * @property storeurl App store URL for an installed app; for IQG 2.1 compliance.
 * @property cat Array of IAB content categories of the app.
 *              [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39)
 * @property sectioncat Array of IAB content categories that describe the current section of the
 *                      app.
 *              [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39)
 * @property pagecat Array of IAB content categories that describe the current page or view of the
 *                   app.
 *              [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39)
 * @property ver Application version.
 * @property privacypolicy Indicates if the app has a privacy policy. (0 = No, 1 = Yes)
 * @property paid Indicates if the app is free or paid. (0 = Free, 1 = Paid)
 * @property publisher Details about the publisher of the app.
 */
class App(
    @JvmField var name: String? = null,
    @JvmField var bundle: String? = null,
    @JvmField var domain: String? = null,
    @JvmField var storeurl: String? = null,
    @JvmField var cat: Array<String>? = null,
    @JvmField var sectioncat: Array<String>? = null,
    @JvmField var pagecat: Array<String>? = null,
    @JvmField var ver: String? = null,
    @JvmField var privacypolicy: Int? = null,
    @JvmField var paid: Int? = null,
    @JvmField var publisher: Publisher? = null,
) {
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
         * @see [App.name]
         */
        fun name(name: String?): Builder

        /**
         * Sets the bundle id of this app.
         *
         * @param bundle the bundle id
         * @return this builder instance
         * @see [App.bundle]
         */
        fun bundle(bundle: String?): Builder

        /**
         * Sets the domain name of this app.
         *
         * @param domain the domain associated with this app
         * @return this builder instance
         * @see [App.domain]
         */
        fun domain(domain: String?): Builder

        /**
         * Sets this app store url.
         *
         * @param storeUrl the store url of this app
         * @return this builder instance
         * @see [App.storeurl]
         */
        fun storeUrl(storeUrl: String?): Builder

        /**
         * Sets the IAB content categories that describe this app.
         *
         * @param cat list of IAB content categories
         * @return this builder instance
         * @see [App.cat]
         * [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=39)
         */
        fun categories(vararg cat: String?): Builder

        /**
         * Sets the IAB content categories that describe the current page of this app.
         *
         * @param pageCategories list of IAB content categories
         * @return this builder instance
         * @see [App.pagecat]
         * [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=34)
         */
        fun pageCategories(vararg pageCategories: String?): Builder

        /**
         * Sets the IAB content categories that describe the current section of this app.
         *
         * @param sectionCategories list of IAB content categories
         * @return this builder instance
         * @see [App.sectioncat]
         * [OpenRTB Section 5.1](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=34)
         */
        fun sectionCategories(vararg sectionCategories: String?): Builder

        /**
         * Sets the version of this app.
         *
         * @param version the app version friendly name
         * @return this builder instance
         * @see [App.ver]
         */
        fun version(version: String?): Builder

        /**
         * Sets to true if this app has a privacy policy associated with it.
         *
         * @param privacyPolicy the privacy policy where 0: no policy; 1: policy
         * @return this builder instance
         * @see [App.privacypolicy]
         */
        fun privacyPolicy(privacyPolicy: Boolean): Builder

        /**
         * Sets to true if this app is a paid app.
         *
         * @param paid true if this app is a paid app, false otherwise
         * @return this builder instance
         * @see [App.paid]
         */
        fun paid(paid: Boolean): Builder

        /**
         * Sets the Publisher of this app.
         *
         * @param publisher the configured publisher object
         * @return this builder instance
         * @see [Publisher]
         */
        fun publisher(publisher: Publisher?): Builder
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