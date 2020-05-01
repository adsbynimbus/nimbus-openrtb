package com.adsbynimbus.openrtb.request;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This object provides information pertaining to the device through which the user is interacting. Device
 * information includes its hardware, platform, location, and carrier data. The device can refer to a mobile
 * handset, a desktop computer, set top box, or other digital device.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=28">OpenRTB Section 3.2.18</a>
 */
public class Device {

    /**
     * Options for the type of device connectivity
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56">OpenRTB Section 5.22</a>
     */
    public interface ConnectionType {

        /**
         * Unknown
         */
        int UNKNOWN = 0;

        /**
         * Unknown
         */
        int ETHERNET = 1;

        /**
         * Wifi
         */
        int WIFI = 2;

        /**
         * Cellular Network – Unknown Generation
         */
        int CELLULAR_UNKNOWN = 3;

        /**
         * Cellular Network – 2G
         */
        int CELLULAR_2G = 4;

        /**
         * Cellular Network – 3G
         */
        int CELLULAR_3G = 5;

        /**
         * Cellular Network – 4G
         */
        int CELLULAR_4G = 6;
    }

    /**
     * Type of device from which the impression originated.
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=56">OpenRTB Section 5.21</a>
     */
    public interface DeviceType {

        /**
         * Mobile/Tablet - Interchangeable with PHONE and Tablet
         */
        int MOBILE_TABLET = 1;

        /**
         * Personal Computer
         */
        int PERSONAL_COMPUTER = 2;

        /**
         * Connected TV
         */
        int CONNECTED_TV = 3;

        /**
         * Phone - Interchangeable with MOBILE_TABLET
         */
        int PHONE = 4;

        /**
         * Tablet - Interchangeable with MOBILE_TABLET
         */
        int TABLET = 5;

        /**
         * Connected Device
         */
        int CONNECTED_DEVICE = 6;

        /**
         * Set Top Box
         */
        int SET_TOP_BOX = 7;
    }

    /**
     * Browser user agent string.
     */
    public String ua;

    /**
     * Location of the device assumed to be the user’s current location defined by a Geo object.
     */
    @Nullable
    public Geo geo;

    /**
     * Standard "Do Not Track" flag as set in the header by the browser, where 0 = tracking is unrestricted,
     * 1 = do not track
     */
    @Nullable
    public Integer dnt;

    /**
     * "Limit Ad Tracking" signal commercially endorsed (e.g., iOS, Android), where 0 = tracking is unrestricted,
     * 1 = tracking must be limited per commercial guidelines.
     */
    @Nullable
    public Integer lmt;

    /**
     * IPv4 address closest to device. Will be set automatically by Nimbus
     */
    @Nullable
    public String ip;

    /**
     * The general type of device.
     */
    public Integer devicetype;

    /**
     * Device make (e.g., "Google").
     */
    @Nullable
    public String make;

    /**
     * Device model (e.g., "Pixel").
     */
    @Nullable
    public String model;

    /**
     * Device operating system (e.g., "Android")
     */
    public String os;

    /**
     * Device operating system version (e.g., "10", "9", "8.1", "8").
     */
    public String osv;

    /**
     * Physical height of the screen in pixels.
     */
    public Integer h;

    /**
     * Physical width of the screen in pixels.
     */
    public Integer w;

    /**
     * Browser language using ISO-639-1-alpha-2
     */
    @Nullable
    public String language;

    /**
     * Carrier or ISP (e.g., "Verizon") using exchange curated string names which should be published
     * to bidders a priori.
     */
    @Nullable
    public String carrier;

    /**
     * Network connection type.
     */
    @Nullable
    public Integer connectiontype;

    /**
     * ID sanctioned for advertiser use in the clear (i.e., not hashed).
     */
    public String ifa;

    /**
     * Builder for constructing a Device object
     *
     * @see Device
     */
    public interface Builder {

        /**
         * Sets the limit ad tracking and do not track flags.
         *
         * @param lat true if limited ad tracking is enabled for this device
         * @return this builder instance
         * @see #lmt
         * @see #dnt
         */
        @NotNull
        Builder limitedAdTracking(boolean lat);

        /**
         * Sets the physical device size of the screen.
         *
         * @param width  physical width of the screen in pixels
         * @param height physical height of the screen in pixels
         * @return this builder instance
         * @see #h
         * @see #w
         */
        @NotNull
        Builder size(int width, int height);

        /**
         * Sets the user agent of this device.
         *
         * @param userAgent the user agent provided by the device WebView
         * @return this builder instance
         * @see #ua
         */
        @NotNull
        Builder userAgent(@NotNull String userAgent);

        /**
         * Sets the location information of this device.
         *
         * @param geo the location information of this device
         * @return this builder instance
         * @see #geo
         * @see Geo
         */
        @NotNull
        Builder geo(@Nullable Geo geo);

        /**
         * Sets the IP address of the device. This can be omitted as Nimbus will infer it from the inbound request.
         *
         * @param ipAddress the ipv4 address closest to the device
         * @return this builder instance
         * @see #ip
         */
        @NotNull
        Builder ipAddress(@Nullable String ipAddress);

        /**
         * Sets the type of device.
         *
         * @param deviceType the type of device this is
         * @return this builder instance
         * @see #devicetype
         * @see DeviceType
         */
        @NotNull
        Builder deviceType(@Nullable Integer deviceType);

        /**
         * Sets the device language.
         *
         * @param language the device language using ISO-639-1-alpha-2
         * @return this builder instance
         * @see #language
         */
        @NotNull
        Builder language(@Nullable String language);

        /**
         * Sets the device carrier.
         *
         * @param carrier the carrier of the device (e.g. "Verizon")
         * @return this builder instance
         * @see #carrier
         */
        @NotNull
        Builder carrier(@Nullable String carrier);

        /**
         * Set the current connection type of this device.
         *
         * @param connectionType the latest resolvable connection type
         * @return this builder instance
         * @see #connectiontype
         * @see ConnectionType
         */
        @NotNull
        Builder connectionType(@Nullable Integer connectionType);

        /**
         * Sets the advertising id provided by the device's operating system.
         *
         * @param ifa the advertising id as returned by the device's operating system
         * @return this builder instance
         * @see #ifa
         */
        @NotNull
        Builder advertisingId(@NotNull String ifa);

        /**
         * Sets manufacturer name of this device (e.g. "Google").
         *
         * @param make the manufacturer name
         * @return this builder instance
         * @see #make
         */
        @NotNull
        Builder manufacturer(@Nullable String make);

        /**
         * Sets model name of this device (e.g. "Pixel").
         *
         * @param model the name of this device model
         * @return this builder instance
         * @see #model
         */
        @NotNull
        Builder model(@Nullable String model);

        /**
         * Sets the operating system name of this device.
         *
         * @param os the operating system name (e.g. "Android")
         * @return this builder instance
         * @see #os
         */
        @NotNull
        Builder osName(@Nullable String os);

        /**
         * Sets the operating system version of this device.
         *
         * @param osVersion the operating system version (e.g "10", "9", "8.1")
         * @return this builder instance
         * @see #osv
         */
        @NotNull
        Builder osVersion(@Nullable String osVersion);
    }
}