package com.adsbynimbus.openrtb.request

/**
 * This object provides information pertaining to the device through which the user is interacting. Device
 * information includes its hardware, platform, location, and carrier data. The device can refer to a mobile
 * handset, a desktop computer, set top box, or other digital device.
 *
 * @see [OpenRTB Section 3.2.18](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=28)
 */
class Device {
    /**
     * Options for the type of device connectivity
     *
     * @see [OpenRTB Section 5.22](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=56)
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
     * @see [OpenRTB Section 5.21](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=56)
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

    /**
     * Browser user agent string.
     */
    @JvmField
    var ua: String? = null

    /**
     * Location of the device assumed to be the user’s current location defined by a Geo object.
     */
    @JvmField
    var geo: Geo? = null

    /**
     * Standard "Do Not Track" flag as set in the header by the browser, where 0 = tracking is unrestricted,
     * 1 = do not track
     */
    @JvmField
    var dnt: Int? = null

    /**
     * "Limit Ad Tracking" signal commercially endorsed (e.g., iOS, Android), where 0 = tracking is unrestricted,
     * 1 = tracking must be limited per commercial guidelines.
     */
    @JvmField
    var lmt: Int? = null

    /**
     * IPv4 address closest to device. Will be set automatically by Nimbus
     */
    @JvmField
    var ip: String? = null

    /**
     * The general type of device.
     */
    @JvmField
    var devicetype: Int? = null

    /**
     * Device make (e.g., "Google").
     */
    @JvmField
    var make: String? = null

    /**
     * Device model (e.g., "Pixel").
     */
    @JvmField
    var model: String? = null

    /**
     * Device operating system (e.g., "Android")
     */
    @JvmField
    var os: String? = null

    /**
     * Device operating system version (e.g., "10", "9", "8.1", "8").
     */
    @JvmField
    var osv: String? = null

    /**
     * Physical height of the screen in pixels.
     */
    @JvmField
    var h: Int? = null

    /**
     * Physical width of the screen in pixels.
     */
    @JvmField
    var w: Int? = null

    /**
     * Browser language using ISO-639-1-alpha-2
     */
    @JvmField
    var language: String? = null

    /**
     * Carrier or ISP (e.g., "Verizon") using exchange curated string names which should be published
     * to bidders a priori.
     */
    @JvmField
    var carrier: String? = null

    /**
     * Network connection type.
     */
    @JvmField
    var connectiontype: Int? = null

    /**
     * ID sanctioned for advertiser use in the clear (i.e., not hashed).
     */
    @JvmField
    var ifa: String? = null

    /**
     * Builder for constructing a Device object
     *
     * @see Device
     */
    interface Builder {
        /**
         * Sets the limit ad tracking and do not track flags.
         *
         * @param lat true if limited ad tracking is enabled for this device
         * @return this builder instance
         * @see .lmt
         *
         * @see .dnt
         */
        fun limitedAdTracking(lat: Boolean): Builder

        /**
         * Sets the physical device size of the screen.
         *
         * @param width  physical width of the screen in pixels
         * @param height physical height of the screen in pixels
         * @return this builder instance
         * @see .h
         *
         * @see .w
         */
        fun size(width: Int, height: Int): Builder

        /**
         * Sets the user agent of this device.
         *
         * @param userAgent the user agent provided by the device WebView
         * @return this builder instance
         * @see .ua
         */
        fun userAgent(userAgent: String?): Builder

        /**
         * Sets the location information of this device.
         *
         * @param geo the location information of this device
         * @return this builder instance
         * @see .geo
         *
         * @see Geo
         */
        fun geo(geo: Geo?): Builder

        /**
         * Sets the IP address of the device. This can be omitted as Nimbus will infer it from the inbound request.
         *
         * @param ipAddress the ipv4 address closest to the device
         * @return this builder instance
         * @see .ip
         */
        fun ipAddress(ipAddress: String?): Builder

        /**
         * Sets the type of device.
         *
         * @param deviceType the type of device this is
         * @return this builder instance
         * @see .devicetype
         *
         * @see DeviceType
         */
        fun deviceType(deviceType: Int?): Builder

        /**
         * Sets the device language.
         *
         * @param language the device language using ISO-639-1-alpha-2
         * @return this builder instance
         * @see .language
         */
        fun language(language: String?): Builder

        /**
         * Sets the device carrier.
         *
         * @param carrier the carrier of the device (e.g. "Verizon")
         * @return this builder instance
         * @see .carrier
         */
        fun carrier(carrier: String?): Builder

        /**
         * Set the current connection type of this device.
         *
         * @param connectionType the latest resolvable connection type
         * @return this builder instance
         * @see .connectiontype
         *
         * @see ConnectionType
         */
        fun connectionType(connectionType: Int?): Builder

        /**
         * Sets the advertising id provided by the device's operating system.
         *
         * @param ifa the advertising id as returned by the device's operating system
         * @return this builder instance
         * @see .ifa
         */
        fun advertisingId(ifa: String?): Builder

        /**
         * Sets manufacturer name of this device (e.g. "Google").
         *
         * @param make the manufacturer name
         * @return this builder instance
         * @see .make
         */
        fun manufacturer(make: String?): Builder

        /**
         * Sets model name of this device (e.g. "Pixel").
         *
         * @param model the name of this device model
         * @return this builder instance
         * @see .model
         */
        fun model(model: String?): Builder

        /**
         * Sets the operating system name of this device.
         *
         * @param os the operating system name (e.g. "Android")
         * @return this builder instance
         * @see .os
         */
        fun osName(os: String?): Builder

        /**
         * Sets the operating system version of this device.
         *
         * @param osVersion the operating system version (e.g "10", "9", "8.1")
         * @return this builder instance
         * @see .osv
         */
        fun osVersion(osVersion: String?): Builder
    }
}