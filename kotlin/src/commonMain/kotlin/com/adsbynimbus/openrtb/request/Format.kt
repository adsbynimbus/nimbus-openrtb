package com.adsbynimbus.openrtb.request

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
class Format(
    @JvmField val w: Int,
    @JvmField val h: Int,
) {
    companion object {
        @JvmField val InterstitialPortrait = Format(320, 480)
        @JvmField val InterstitialLandscape = Format(480, 320)
        @JvmField val MobileBanner = Format(320, 50)
        @JvmField val MediumRectangle = Format(300, 250)
        @JvmField val HalfScreen = Format(300, 600)
        @JvmField val Leaderboard = Format(728, 90)
    }
}
