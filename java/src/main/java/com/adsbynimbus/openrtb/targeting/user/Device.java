package com.adsbynimbus.openrtb.targeting.user;

/**
 * This object provides information pertaining to the device through which the user is interacting. Device
 * information includes its hardware, platform, location, and carrier data. The device can refer to a mobile
 * handset, a desktop computer, set top box, or other digital device.
 */
public class Device {

    public interface ConnectionType {
        int UNKNOWN = 0;
        int ETHERNET = 1;
        int WIFI = 2;
        int CELLULAR_UNKNOWN = 3;
        int CELLULAR_2G = 4;
        int CELLULAR_3G = 5;
        int CELLULAR_4G = 6;
    }

    public interface DeviceType {
        int MOBILE_TABLET = 1;
        int PERSONAL_COMPUTER = 2;
        int CONNECTED_TV = 3;
        int PHONE = 4;
        int TABLET = 5;
        int CONNECTED_DEVICE = 6;
        int SET_TOP_BOX = 7;
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
    public Integer connectiontype;
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
         * @param width  physical width of the screen in pixels
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
         * Set the type of device for this object.
         *
         * @param deviceType
         * @return this builder instance
         */
        Builder deviceType(Integer deviceType);

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
        Builder connectionType(Integer connectionType);

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