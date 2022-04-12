package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object represents an allowed size (i.e., height and width combination)
 *
 * [OpenRTB Section 3.2.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=23)
 *
 * @property w width in device independent pixels (DIPS).
 * @property h height in device independent pixels (DIPS).
 */
@Serializable
public class Format(
    @JvmField @SerialName("w") public val w: Int,
    @JvmField @SerialName("h") public val h: Int,
) {
    public companion object {
        /** 320 by 480 portrait interstitial */
        @JvmField public val INTERSTITIAL_PORT: Format = Format(320, 480)
        /** 480 by 320 landscape interstitial */
        @JvmField public val INTERSTITIAL_LAND: Format = Format(480, 320)
        /** 320 by 50 mobile banner */
        @JvmField public val BANNER_320_50: Format = Format(320, 50)
        /** 300 by 250 medium rectangle */
        @JvmField public val BANNER_300_250: Format = Format(300, 250)
        /** An alias for a 300 by 250 medium rectangle  */
        @JvmField public val LETTERBOX: Format = BANNER_300_250
        /** 300 by 600 half page */
        @JvmField public val HALF_SCREEN: Format = Format(300, 600)
        /** 728 by 90 mobile banner */
        @JvmField public val LEADERBOARD: Format = Format(728, 90)
        /** 300 by 250 medium rectangle  */
        public inline val MREC: Format get() = BANNER_300_250
    }
}
