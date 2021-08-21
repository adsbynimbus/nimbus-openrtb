package com.adsbynimbus.openrtb.request

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
class Device(
    @JvmField val ua: String? = null,
    @JvmField val geo: Geo? = null,
    @JvmField val dnt: Int? = null,
    @JvmField val lmt: Int? = null,
    @JvmField val ip: String? = null,
    @JvmField val devicetype: Int? = null,
    @JvmField val make: String? = null,
    @JvmField val model: String? = null,
    @JvmField val hwv: String? = null,
    @JvmField val os: String = "android",
    @JvmField val osv: String? = null,
    @JvmField val h: Int? = null,
    @JvmField val w: Int? = null,
    @JvmField val language: String? = null,
    @JvmField val carrier: String? = null,
    @JvmField val connectiontype: Int? = null,
    @JvmField val ifa: String? = null,
)

/*
 * Options for the type of device connectivity
 *
 * [OpenRTB Section 5.22](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56)
 */
const val Ethernet = 1
const val Wifi = 2
const val CellularUnknown = 3
const val Cellular2G = 4
const val Cellular3G = 5
const val Cellular4G = 6

/*
 * Type of device from which the impression originated.
 *
 * [OpenRTB Section 5.21](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56)
 */
/** Interchangeable with Phone and Tablet */
const val MobileTablet = 1
const val PersonalComputer = 2
const val ConnectedTv = 3
/** Interchangeable with MobileTablet */
const val Phone = 4
/** Interchangeable with MobileTablet */
const val Tablet = 5
const val ConnectedDevice = 6
const val SetTopBox = 7
