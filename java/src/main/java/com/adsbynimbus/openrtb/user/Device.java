package com.adsbynimbus.openrtb.user;

/**
 * This object provides information pertaining to the device through which the user is interacting. Device
 * information includes its hardware, platform, location, and carrier data. The device can refer to a mobile
 * handset, a desktop computer, set top box, or other digital device.
 */
public interface Device {

    int UNKNOWN = 0;
    int ETHERNET = 1;
    int WIFI = 2;
    int CELLULAR_UNKNOWN = 3;
    int CELLULAR_2G = 4;
    int CELLULAR_3G = 5;
    int CELLULAR_4G = 6;

    String USER_AGENT = "ua";
    String GEO = "geo"; // geo object
    String DO_NOT_TRACK = "dnt";
    String LIMIT_AD_TRACKING = "lmt";
    String IP_ADDRESS = "ip";
    String DEVICE_TYPE = "devicetype";
    String MAKE = "make";
    String MODEL = "model";
    String OS = "os";
    String OS_VERSION = "osv";
    String LANGUAGE = "language";
    String CARRIER = "carrier";
    String CONNECTION_TYPE = "connectiontype"; //Integer
    String ADVERTISING_ID = "ifa";

    /**
     * Builder for constructing a {@link Device} object
     */
    interface Builder {

        /**
         * Sets the limit ad tracking and do not track flags
         *
         * @return this builder instance
         */
        Builder withLimitedAdTracking();

        /**
         * Set the physical device size of the screen
         *
         * @param width physical width of the screen in pixels
         * @param height physical height of the screen in pixels
         * @return this builder instance
         */
        Builder withPhysicalDeviceSize(int width, int height);

        /**
         * Sets the user agent
         *
         * @param userAgent
         * @return this builder instance
         */
        Builder withUserAgent(String userAgent);

        /**
         * With {@link Geo} information
         *
         * @param geo
         * @return this builder instance
         */
        Builder withGeo(Geo geo);

        /**
         * Set the IP address of the device. This can be omitted as Nimbus will infer it from the request context.
         *
         * @param ipAddress
         * @return this builder instance
         */
        Builder withIpAddress(String ipAddress);

        /**
         * Sets the device language
         *
         * @param language
         * @return this builder instance
         */
        Builder withLanguage(String language);

        /**
         * Sets the device carrier
         *
         * @param carrier
         * @return this builder instance
         */
        Builder withCarrier(String carrier);

        /**
         * Set the connection type type
         *
         * @param connectionType
         * @return this builder instance
         */
        Builder withConnectionType(int connectionType);

        /**
         * Set the advertising id
         *
         * @param advertisingId
         * @return this builder instance
         */
        Builder withAdvertisingId(String advertisingId);

        /**
         * Set the device manufacturer name
         *
         * @param make
         * @return this builder instance
         */
        Builder withManufacturer(String make);

        /**
         * Set the device model name
         *
         * @param model
         * @return this builder instance
         */
        Builder withModelName(String model);

        /**
         * Set the operating system name
         *
         * @param os
         * @return this builder instance
         */
        Builder withOsName(String os);

        /**
         * Set the operating system version
         *
         * @param osVersion
         * @return this builder instance
         */
        Builder withOsVersion(String osVersion);
    }

    /**
     * Definition of {@link Device} with all public mutable fields
     */
    class MutableDevice implements Device {
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
        public Integer connectiontype;
        public String ifa;
    }
}