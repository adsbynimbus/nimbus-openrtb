package com.adsbynimbus.openrtb.targeting.user;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import com.adsbynimbus.openrtb.targeting.user.Device.ConnectionType;
import com.adsbynimbus.openrtb.targeting.user.Device.DeviceType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Device builder implementation with Androidx annotations for validation
 *
 * @see Device
 */
public final class AndroidDeviceBuilder implements Device.Builder {

    /**
     * Android OS name constant
     */
    public static final String ANDROID = "android";

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ConnectionType.UNKNOWN, ConnectionType.ETHERNET, ConnectionType.WIFI, ConnectionType.CELLULAR_UNKNOWN,
            ConnectionType.CELLULAR_2G, ConnectionType.CELLULAR_3G, ConnectionType.CELLULAR_4G})
    public @interface ConnectionTypeInt { }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({DeviceType.MOBILE_TABLET, DeviceType.PERSONAL_COMPUTER, DeviceType.CONNECTED_TV, DeviceType.PHONE,
            DeviceType.TABLET, DeviceType.CONNECTED_DEVICE, DeviceType.SET_TOP_BOX})
    public @interface DeviceTypeInt { }

    /**
     * The devide object this builder wraps
     */
    @NonNull
    public final Device device;

    /**
     * Constructs a builder that will edit the fields of the device object in place.
     *
     * @param device a device object
     */
    public AndroidDeviceBuilder(@NonNull Device device) {
        this.device = device;
        device.make = Build.MANUFACTURER;
        device.model = Build.MODEL;
        device.os = ANDROID;
        device.osv = Build.VERSION.RELEASE;
    }

    /**
     * {@inheritDoc}
     *
     * @param userAgent {@inheritDoc}
     * @return {@inheritDoc}
     * @see WebSettings#getDefaultUserAgent(Context)
     */
    @Override
    public AndroidDeviceBuilder userAgent(@NonNull String userAgent) {
        device.ua = userAgent;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param geo {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDeviceBuilder geo(@NonNull Geo geo) {
        device.geo = geo;
        return this;
    }

    /**
     * Returns a builder for the geo object. A new {@link Geo} object will be created if none exists.
     *
     * @return a builder wrapping the geo object
     */
    public AndroidGeoBuilder geo() {
        if (device.geo == null) {
            device.geo = new Geo();
        }
        return new AndroidGeoBuilder(device.geo);
    }

    /**
     * {@inheritDoc}
     *
     * @param ipAddress {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDeviceBuilder ipAddress(@NonNull String ipAddress) {
        device.ip = ipAddress;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param deviceType {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Device.Builder deviceType(@DeviceTypeInt Integer deviceType) {
        device.devicetype = deviceType;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param connectionType {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDeviceBuilder connectionType(@ConnectionTypeInt Integer connectionType) {
        device.connectiontype = connectionType;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param lat {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDeviceBuilder limitedAdTracking(boolean lat) {
        final int val = lat ? 1 : 0;
        device.lmt = val;
        device.dnt = val;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param width  {@inheritDoc}
     * @param height {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDeviceBuilder size(int width, int height) {
        device.w = width;
        device.h = height;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param language {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDeviceBuilder language(String language) {
        device.language = language;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param carrier {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDeviceBuilder carrier(String carrier) {
        device.carrier = carrier;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param ifa {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public AndroidDeviceBuilder advertisingId(@NonNull String ifa) {
        device.ifa = ifa;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param make {@inheritDoc}
     * @return {@inheritDoc}
     * @see Build#MANUFACTURER
     */
    @Override
    public AndroidDeviceBuilder manufacturer(String make) {
        device.make = make;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param model {@inheritDoc}
     * @return {@inheritDoc}
     * @see Build#MODEL
     */
    @Override
    public AndroidDeviceBuilder model(String model) {
        device.model = model;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param os {@inheritDoc} - Set to {@value #ANDROID}
     * @return {@inheritDoc}
     * @see #ANDROID
     */
    @Override
    public AndroidDeviceBuilder osName(String os) {
        device.os = os;
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param osVersion {@inheritDoc}
     * @return {@inheritDoc}
     * @see Build.VERSION#RELEASE
     */
    @Override
    public AndroidDeviceBuilder osVersion(String osVersion) {
        device.osv = osVersion;
        return this;
    }
}
