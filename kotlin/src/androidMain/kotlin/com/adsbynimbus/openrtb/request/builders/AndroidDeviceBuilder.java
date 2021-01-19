package com.adsbynimbus.openrtb.request.builders;

import android.os.Build;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adsbynimbus.openrtb.request.Device;
import com.adsbynimbus.openrtb.request.Device.ConnectionType;
import com.adsbynimbus.openrtb.request.Device.DeviceType;
import com.adsbynimbus.openrtb.request.Geo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Device builder implementation with Androidx annotations for validation
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
    
    @NonNull
    private final Device device;

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
     * Returns a builder for the geo object. A new Geo object will be created if none exists.
     *
     * @return a builder wrapping the geo object
     */
    @NonNull
    public AndroidGeoBuilder geo() {
        if (device.geo == null) {
            device.geo = new Geo();
        }
        return new AndroidGeoBuilder(device.geo);
    }
    
    @Override @NonNull
    public AndroidDeviceBuilder userAgent(@Nullable String userAgent) {
        device.ua = userAgent;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder geo(@Nullable Geo geo) {
        device.geo = geo;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder ipAddress(@Nullable String ipAddress) {
        device.ip = ipAddress;
        return this;
    }

    @Override @NonNull
    public Device.Builder deviceType(@DeviceTypeInt Integer deviceType) {
        device.devicetype = deviceType;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder connectionType(@ConnectionTypeInt Integer connectionType) {
        device.connectiontype = connectionType;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder limitedAdTracking(boolean lat) {
        final int val = lat ? 1 : 0;
        device.lmt = val;
        device.dnt = val;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder size(int width, int height) {
        device.w = width;
        device.h = height;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder language(String language) {
        device.language = language;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder carrier(String carrier) {
        device.carrier = carrier;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder advertisingId(@Nullable String ifa) {
        device.ifa = ifa;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder manufacturer(String make) {
        device.make = make;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder model(String model) {
        device.model = model;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder osName(String os) {
        device.os = os;
        return this;
    }

    @Override @NonNull
    public AndroidDeviceBuilder osVersion(String osVersion) {
        device.osv = osVersion;
        return this;
    }
}
