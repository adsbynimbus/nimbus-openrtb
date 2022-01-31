package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object provides information pertaining to the device through which the user is interacting.
 *
 * Device information includes its hardware, platform, location, and carrier data. The device can
 * refer to a mobile handset, a desktop computer, set top box, or other digital device.
 *
 * [OpenRTB Section 3.2.18](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=28)
 *
 * @property ua Browser user agent string.
 * @property geo Location of the device assumed to be the user’s current location defined by a Geo
 *               object.
 * @property dnt Standard "Do Not Track" flag as set in the header by the browser.
 *               (0 = tracking is unrestricted; 1 = do not track)
 * @property lmt "Limit Ad Tracking" signal commercially endorsed (e.g., iOS, Android).
 *                   0 = tracking is unrestricted
 *                   1 = tracking must be limited per commercial guidelines
 * @property ip IPv4 address closest to device. Will be set automatically by Nimbus.
 * @property devicetype The general type of device.
 * @property make Device make (e.g., "Google").
 * @property model Device model (e.g., "Pixel").
 * @property hwv Device hardware version
 * @property os Device operating system (e.g., "Android")
 * @property osv Device operating system version (e.g., "10", "9", "8.1", "8").
 * @property h Physical height of the screen in pixels.
 * @property w Physical width of the screen in pixels.
 * @property language Browser language using ISO-639-1-alpha-2
 * @property carrier Carrier or ISP (e.g., "Verizon") using exchange curated string names which
 *                   should be published to bidders a priori.
 * @property connectiontype Network connection type.
 * @property ifa ID sanctioned for advertiser use in the clear (i.e., not hashed).
 */
@Serializable
public data class Device(
    @JvmField @SerialName("ua") public val ua: String,
    @JvmField @SerialName("ifa") public val ifa: String,
    @JvmField @SerialName("make") public val make: String,
    @JvmField @SerialName("model") public val model: String,
    @JvmField @SerialName("hwv") public val hwv: String,
    @JvmField @SerialName("os") public val os: String,
    @JvmField @SerialName("osv") public val osv: String,
    @JvmField @SerialName("h") public val h: Int,
    @JvmField @SerialName("w") public val w: Int,
    @JvmField @SerialName("language") public val language: String? = null,
    @JvmField @SerialName("devicetype") public val devicetype: Byte = 0,
    @JvmField @SerialName("connectiontype") public val connectiontype: Byte = 0,
    @JvmField @SerialName("dnt") public val dnt: Byte = 0,
    @JvmField @SerialName("lmt") public val lmt: Byte = 0,
    @JvmField @SerialName("geo") public val geo: Geo? = null,
    @JvmField @SerialName("ip") public val ip: String? = null,
    @JvmField @SerialName("carrier") public val carrier: String? = null,
)
