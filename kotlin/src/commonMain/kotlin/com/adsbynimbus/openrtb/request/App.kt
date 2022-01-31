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
    @JvmField @SerialName("name") public val name: String = "",
    @JvmField @SerialName("bundle") public val bundle: String = "",
    @JvmField @SerialName("domain") public val domain: String = "",
    @JvmField @SerialName("storeurl") public val storeurl: String = "",
    @JvmField @SerialName("ver") public val ver: String = "",
    @JvmField @SerialName("keywords") public val keywords: String = "",
    @JvmField @SerialName("cat") public val cat: Array<String> = emptyArray(),
    @JvmField @SerialName("sectioncat") public val sectioncat: Array<String> = emptyArray(),
    @JvmField @SerialName("pagecat") public val pagecat: Array<String> = emptyArray(),
    @JvmField @SerialName("privacypolicy") public val privacypolicy: Byte = 0,
    @JvmField @SerialName("paid") public val paid: Byte = 0,
    @JvmField @SerialName("publisher") public val publisher: Publisher = Publisher(name, domain, cat),
)
