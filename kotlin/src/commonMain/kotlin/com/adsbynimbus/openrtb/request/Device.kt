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
    @JvmField var ua: String? = null,
    @JvmField var geo: Geo? = null,
    @JvmField var dnt: Int? = null,
    @JvmField var lmt: Int? = null,
    @JvmField var ip: String? = null,
    @JvmField var devicetype: Int? = null,
    @JvmField var make: String? = null,
    @JvmField var model: String? = null,
    @JvmField var hwv: String? = null,
    @JvmField var os: String = "android",
    @JvmField var osv: String? = null,
    @JvmField var h: Int? = null,
    @JvmField var w: Int? = null,
    @JvmField var language: String? = null,
    @JvmField var carrier: String? = null,
    @JvmField var connectiontype: Int? = null,
    @JvmField var ifa: String? = null,
) {
    /**
     * Options for the type of device connectivity
     *
     * [OpenRTB Section 5.22](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56)
     */
    interface ConnectionType {
        companion object {
            /**
             * Unknown
             */
            const val UNKNOWN = 0

            /**
             * Unknown
             */
            const val ETHERNET = 1

            /**
             * Wifi
             */
            const val WIFI = 2

            /**
             * Cellular Network – Unknown Generation
             */
            const val CELLULAR_UNKNOWN = 3

            /**
             * Cellular Network – 2G
             */
            const val CELLULAR_2G = 4

            /**
             * Cellular Network – 3G
             */
            const val CELLULAR_3G = 5

            /**
             * Cellular Network – 4G
             */
            const val CELLULAR_4G = 6
        }
    }

    /**
     * Type of device from which the impression originated.
     *
     * [OpenRTB Section 5.21](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56)
     */
    interface DeviceType {
        companion object {
            /**
             * Mobile/Tablet - Interchangeable with PHONE and Tablet
             */
            const val MOBILE_TABLET = 1

            /**
             * Personal Computer
             */
            const val PERSONAL_COMPUTER = 2

            /**
             * Connected TV
             */
            const val CONNECTED_TV = 3

            /**
             * Phone - Interchangeable with MOBILE_TABLET
             */
            const val PHONE = 4

            /**
             * Tablet - Interchangeable with MOBILE_TABLET
             */
            const val TABLET = 5

            /**
             * Connected Device
             */
            const val CONNECTED_DEVICE = 6

            /**
             * Set Top Box
             */
            const val SET_TOP_BOX = 7
        }
    }
}