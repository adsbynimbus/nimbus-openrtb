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
    @JvmField val name: String? = null,
    @JvmField val bundle: String? = null,
    @JvmField val domain: String? = null,
    @JvmField val storeurl: String? = null,
    @JvmField val cat: Array<String>? = null,
    @JvmField val sectioncat: Array<String>? = null,
    @JvmField val pagecat: Array<String>? = null,
    @JvmField val ver: String? = null,
    @JvmField val privacypolicy: Int? = null,
    @JvmField val paid: Int? = null,
    @JvmField val publisher: Publisher? = null,
)