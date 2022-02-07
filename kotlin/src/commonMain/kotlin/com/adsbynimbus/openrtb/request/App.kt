package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object should be included if the ad supported content is a non-browser application
 * (typically in mobile) as opposed to a website. A bid request must not contain both an App and a
 * Site object. At a minimum, it is useful to provide an App ID or bundle, but this is not strictly
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
 * @property ver Application version.
 * @property keywords A list of keywords describing the app.
 * @property cat Array of IAB content categories of the app.
 * @property sectioncat Array of IAB content categories that describe the current section of the
 *                      app.
 * @property pagecat Array of IAB content categories that describe the current page or view of the
 *                   app.
 * @property privacypolicy Indicates if the app has a privacy policy. (0 = No, 1 = Yes)
 * @property paid Indicates if the app is free or paid. (0 = Free, 1 = Paid)
 * @property publisher Details about the publisher of the app.
 */
@Serializable
public class App(
    @JvmField @SerialName("name") public var name: String? = null,
    @JvmField @SerialName("bundle") public var bundle: String? = null,
    @JvmField @SerialName("domain") public var domain: String? = null,
    @JvmField @SerialName("storeurl") public var storeurl: String? = null,
    @JvmField @SerialName("ver") public var ver: String? = null,
    @JvmField @SerialName("keywords") public var keywords: String? = null,
    @JvmField @SerialName("cat") public var cat: Array<String>? = null,
    @JvmField @SerialName("sectioncat") public var sectioncat: Array<String>? = null,
    @JvmField @SerialName("pagecat") public var pagecat: Array<String>? = null,
    @JvmField @SerialName("privacypolicy") public var privacypolicy: Byte? = null,
    @JvmField @SerialName("paid") public var paid: Byte? = null,
    @JvmField @SerialName("publisher") public var publisher: Publisher? = null,
)
