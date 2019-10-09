package com.adsbynimbus.openrtb.user;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;

import java.lang.annotation.Retention;

import static androidx.core.content.PermissionChecker.PERMISSION_GRANTED;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * {@link ArrayMap} implementation of {@link Device} for convenient building and serialization
 */
public class AndroidDevice extends ArrayMap<String, Object> implements Device, Device.Builder {

    public static final String ANDROID = "android";

    @Retention(SOURCE)
    @StringDef({USER_AGENT, GEO, IP_ADDRESS, DEVICE_TYPE, MAKE, MODEL, OS, OS_VERSION, CONNECTION_TYPE, ADVERTISING_ID})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({UNKNOWN, ETHERNET, WIFI, CELLULAR_UNKNOWN, CELLULAR_2G, CELLULAR_3G, CELLULAR_4G})
    public @interface Connection { }

    public AndroidDevice() {
        super();
        put(MAKE, Build.MANUFACTURER);
        put(MODEL, Build.MODEL);
        put(OS, ANDROID);
        put(OS_VERSION, Build.VERSION.RELEASE);
    }

    @Nullable @Override
    public Object put(@Values String key, Object value) {
        return super.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @param userAgent {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withUserAgent(@NonNull String userAgent) {
        put(USER_AGENT, userAgent);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param geo {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withGeo(@NonNull Geo geo) {
        put(GEO, geo);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param ipAddress {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Builder withIpAddress(@NonNull String ipAddress) {
        put(IP_ADDRESS, ipAddress);
        return this;
    }

    /**
     * Set the {@link Connection} type
     *
     * @param connectionType - {@link Connection}
     * @return {@link Builder}
     */
    @Override
    public Builder withConnectionType(@Connection int connectionType) {
        put(CONNECTION_TYPE, connectionType);
        return this;
    }

    /**
     * Set the {@link Connection} type from the current {@link Context}
     *
     * @param context - {@link Context}
     * @return {@link Builder}
     */
    public Builder withConnectionFromContext(Context context) {
        @Connection int connectionType = UNKNOWN;
        if (ContextCompat.checkSelfPermission(context,
            Manifest.permission.ACCESS_NETWORK_STATE) == PERMISSION_GRANTED) {
            final ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
            if (activeNetwork != null) {
                switch (activeNetwork.getType()) {
                    case ConnectivityManager.TYPE_MOBILE:
                    case ConnectivityManager.TYPE_MOBILE_MMS:
                    case ConnectivityManager.TYPE_MOBILE_SUPL:
                    case ConnectivityManager.TYPE_MOBILE_DUN:
                        final TelephonyManager mTelephonyManager =
                            (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                        switch (mTelephonyManager.getNetworkType()) {
                            case TelephonyManager.NETWORK_TYPE_GPRS:
                            case TelephonyManager.NETWORK_TYPE_EDGE:
                            case TelephonyManager.NETWORK_TYPE_CDMA:
                            case TelephonyManager.NETWORK_TYPE_1xRTT:
                            case TelephonyManager.NETWORK_TYPE_IDEN:
                                connectionType = CELLULAR_2G;
                                break;
                            case TelephonyManager.NETWORK_TYPE_UMTS:
                            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                            case TelephonyManager.NETWORK_TYPE_HSDPA:
                            case TelephonyManager.NETWORK_TYPE_HSUPA:
                            case TelephonyManager.NETWORK_TYPE_HSPA:
                            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                            case TelephonyManager.NETWORK_TYPE_EHRPD:
                            case TelephonyManager.NETWORK_TYPE_HSPAP:
                                connectionType = CELLULAR_3G;
                                break;
                            case TelephonyManager.NETWORK_TYPE_LTE:
                                connectionType = CELLULAR_4G;
                                break;
                            default:
                                connectionType = CELLULAR_UNKNOWN;
                        }
                        break;
                    case ConnectivityManager.TYPE_WIMAX:
                        connectionType = CELLULAR_4G;
                        break;
                    case ConnectivityManager.TYPE_ETHERNET:
                        connectionType = ETHERNET;
                        break;
                    case ConnectivityManager.TYPE_WIFI:
                        connectionType = WIFI;
                        break;
                    case ConnectivityManager.TYPE_BLUETOOTH:
                    case ConnectivityManager.TYPE_DUMMY:
                    case ConnectivityManager.TYPE_VPN:
                    default:
                }
            }
        }
        put(CONNECTION_TYPE, connectionType);
        return this;
    }

    /**
     * Set the advertising id
     *
     * @param advertisingId - {@link String}
     * @return {@link Builder}
     */
    @Override
    public Builder withAdvertisingId(@NonNull String advertisingId) {
        put(ADVERTISING_ID, advertisingId);
        return this;
    }
}
