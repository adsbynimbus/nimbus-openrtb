package com.adsbynimbus.openrtb.targeting.user;

/**
 * This object provides information pertaining to the device through which the user is interacting. Device
 * information includes its hardware, platform, location, and carrier data. The device can refer to a mobile
 * handset, a desktop computer, set top box, or other digital device.
 */
public class Device {

    public static final String USER_AGENT = "ua";
    public static final String GEO = "geo"; // geo object
    public static final String DO_NOT_TRACK = "dnt";
    public static final String LIMIT_AD_TRACKING = "lmt";
    public static final String IP_ADDRESS = "ip";
    public static final String DEVICE_TYPE = "devicetype";
    public static final String MAKE = "make";
    public static final String MODEL = "model";
    public static final String OS = "os";
    public static final String OS_VERSION = "osv";
    public static final String LANGUAGE = "language";
    public static final String CARRIER = "carrier";
    public static final String CONNECTION_TYPE = "connectiontype"; //Integer
    public static final String ADVERTISING_ID = "ifa";

    public enum ConnectionType {
        UNKNOWN(0),
        ETHERNET(1),
        WIFI(2),
        CELLULAR_UNKNOWN(3),
        CELLULAR_2G(4),
        CELLULAR_3G(5),
        CELLULAR_4G(6);

        public final int value;

        ConnectionType(int value) {
            this.value = value;
        }
    }

    public String ua;
    public Geo geo;
    public int dnt;
    public int lmt;
    public String ip;
    public Integer devicetype;
    public String make;
    public String model;
    public String os;
    public String osv;
    public int h;
    public int w;
    public String language;
    public String carrier;
    public ConnectionType connectiontype;
    public String ifa;

    /**
     * Builder for constructing a {@link Device} object
     */
    public interface Builder {

        /**
         * Sets the limit ad tracking and do not track flags
         *
         * @param lat true if limited ad tracking is enabled for this device
         * @return this builder instance
         */
        Builder limitedAdTracking(boolean lat);

        /**
         * Set the physical device size of the screen
         *
         * @param width physical width of the screen in pixels
         * @param height physical height of the screen in pixels
         * @return this builder instance
         */
        Builder size(int width, int height);

        /**
         * Sets the user agent of this device
         *
         * @param userAgent
         * @return this builder instance
         */
        Builder userAgent(String userAgent);

        /**
         * With {@link Geo} information
         *
         * @param geo
         * @return this builder instance
         */
        Builder geo(Geo geo);

        /**
         * Set the IP address of the device. This can be omitted as Nimbus will infer it from the request context.
         *
         * @param ipAddress
         * @return this builder instance
         */
        Builder ipAddress(String ipAddress);

        /**
         * Sets the device language
         *
         * @param language
         * @return this builder instance
         */
        Builder language(String language);

        /**
         * Sets the device carrier
         *
         * @param carrier
         * @return this builder instance
         */
        Builder carrier(String carrier);

        /**
         * Set the connection type type
         *
         * @param connectionType
         * @return this builder instance
         */
        Builder connectionType(ConnectionType connectionType);

        /**
         * Set the advertising id
         *
         * @param ifa the advertising id as returned by the device's operating system
         * @return this builder instance
         */
        Builder advertisingId(String ifa);

        /**
         * Set manufacturer name of this device
         *
         * @param make
         * @return this builder instance
         */
        Builder manufacturer(String make);

        /**
         * Set model name of this device
         *
         * @param model
         * @return this builder instance
         */
        Builder model(String model);

        /**
         * Set the operating system name of this device
         *
         * @param os
         * @return this builder instance
         */
        Builder osName(String os);

        /**
         * Set the operating system version of this device
         *
         * @param osVersion
         * @return this builder instance
         */
        Builder osVersion(String osVersion);
    }
}