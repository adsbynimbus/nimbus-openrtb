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
    String GEO = "geo"; //GEO object
    String IP_ADDRESS = "ip";
    String DEVICE_TYPE = "devicetype";
    String MAKE = "make";
    String MODEL = "model";
    String OS = "os";
    String OS_VERSION = "osv";
    String CONNECTION_TYPE = "connectiontype"; //Integer
    String ADVERTISING_ID = "ifa";

    /**
     * Builder for constructing a {@link Device} object
     */
    interface Builder {

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
         * Set the connection type type
         *
         * @param connectionType
         * @return {@link Builder}
         */
        Builder withConnectionType(int connectionType);

        /**
         * Set the advertising id
         *
         * @param advertisingId
         * @return this builder instance
         */
        Builder withAdvertisingId(String advertisingId);
    }

    /**
     * Definition of {@link Device} with all public mutable fields
     */
    class MutableDevice implements Device {
        public String ua;
        public Geo geo;
        public String ip;
        public Integer devicetype;
        public String make;
        public String model;
        public String os;
        public String osv;
        public Integer connectiontype;
        public String ifa;
    }
}