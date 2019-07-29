package com.adsbynimbus.openrtb.user;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;

import java.lang.annotation.Retention;
import java.util.Map;

import static androidx.core.content.PermissionChecker.PERMISSION_GRANTED;
import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AndroidDevice extends ArrayMap<String, Object> implements Device {

    static final String ANDROID = "android";

    @Retention(SOURCE)
    @StringDef({USER_AGENT, GEO, IP_ADDRESS, DEVICE_TYPE, MAKE, MODEL, OS, OS_VERSION, CONNECTION_TYPE, ADVERTISING_ID})
    public @interface Values { }

    @Retention(SOURCE)
    @IntDef({UNKNOWN, ETHERNET, WIFI, CELLULAR_UNKNOWN, CELLULAR_2G, CELLULAR_3G, CELLULAR_4G})
    public @interface Connection { }

    public static class Builder implements Device.Builder {

        protected final AndroidDevice values;

        public Builder() {
            values = new AndroidDevice();
            values.put(MAKE, Build.MANUFACTURER);
            values.put(MODEL, Build.MODEL);
            values.put(OS, ANDROID);
            values.put(OS_VERSION, Build.VERSION.RELEASE);
        }

        @Override
        public AndroidDevice build() {
            return values;
        }

        @Override
        public Map<String, Object> getValues() {
            return values;
        }

        /**
         * Manually set a value on the builder object
         *
         * @param property - {@link Values}
         * @param value    - {@link Object}
         * @return {@link Builder}
         */
        public Builder setValue(@Values String property, Object value) {
            values.put(property, value);
            return this;
        }

        /**
         * Sets the user agent
         *
         * @param userAgent - {@link String}
         * @return {@link Builder}
         */
        public Builder withUserAgent(@NonNull String userAgent) {
            values.put(USER_AGENT, userAgent);
            return this;
        }

        /**
         * With {@link Geo} information
         *
         * @param geo - {@link AndroidGeo}
         * @return {@link Builder}
         */
        public Builder withGeo(@NonNull AndroidGeo geo) {
            values.put(GEO, geo);
            return this;
        }

        /**
         * Set the IP address of the device. This can be omitted as Nimbus will infer it from the request context.
         *
         * @param ipAddress - {@link String}
         * @return {@link Builder}
         */
        public Builder withIpAddress(@NonNull String ipAddress) {
            values.put(IP_ADDRESS, ipAddress);
            return this;
        }

        /**
         * Set the {@link Connection} type
         *
         * @param connectionType - {@link Connection}
         * @return {@link Builder}
         */
        public Builder withConnectionType(@Connection int connectionType) {
            values.put(CONNECTION_TYPE, connectionType);
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
            values.put(CONNECTION_TYPE, connectionType);
            return this;
        }

        /**
         * Set the advertising id
         *
         * @param advertisingId - {@link String}
         * @return {@link Builder}
         */
        public Builder withAdvertisingId(@NonNull String advertisingId) {
            values.put(ADVERTISING_ID, advertisingId);
            return this;
        }
    }
}
