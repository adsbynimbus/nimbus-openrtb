package com.adsbynimbus.openrtb.request

import kotlin.jvm.JvmField

/**
 * This object represents an allowed size (i.e., height and width combination)
 *
 * [OpenRTB Section 3.2.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=23)
 *
 * @property w width in device independent pixels (DIPS).
 * @property h height in device independent pixels (DIPS).
 */
sealed class Format(
    @JvmField val w: Int,
    @JvmField val h: Int,
)

object InterstitialPortrait : Format(320, 480)
object InterstitialLandscape : Format(480, 320)
object MobileBanner : Format(320, 50)
object MediumRectangle : Format(300, 250)
object HalfScreen : Format(300, 600)
object Leaderboard : Format(728, 90)

class Custom(w: Int, h: Int) : Format(w, h)
