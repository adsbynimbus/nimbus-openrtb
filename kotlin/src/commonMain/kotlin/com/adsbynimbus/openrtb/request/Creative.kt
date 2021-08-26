@file:Suppress("RedundantVisibilityModifier", "INLINE_CLASS_DEPRECATED")

package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Creative {
    @SerialName("static") Static,
    @SerialName("video") Video,
    @SerialName("native") Native;

    /**
     * API frameworks supported by the publisher for a creative
     *
     * [OpenRTB Section 5.6](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
     */
    public inline class Api(public val value: Int) {
        public companion object {
            public const val Vpaid1: Int = 1
            public const val Vpaid2: Int = 2
            public const val Mraid1: Int = 3
            public const val Ormma: Int = 4
            public const val Mraid2: Int = 5
            public const val Mraid3: Int = 6
            public const val Omid: Int = 7
        }
    }

    /**
     * Standard list of creative attributes that can describe an ad being served or serve as
     * restrictions of thereof.
     *
     * [OpenRTB Section 5.3](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=50)
     */
    public inline class Attribute(public val value: Int) {
        public companion object {
            public const val AudioAdAutoPlay: Int = 1
            public const val AudioAdUserInitiated: Int = 2
            public const val ExpandableAutomatic: Int = 3
            public const val ExpandableUserClick: Int = 4
            public const val ExpandableUserRollover: Int = 5
            public const val BannerVideoAutoPlay: Int = 6
            public const val BannerVideoUserInitiated: Int = 7
            public const val HasPopup: Int = 8
            public const val ProvocativeOrSuggestive: Int = 9
            public const val ExtremeAnimation: Int = 10
            public const val Surveys: Int = 11
            public const val TextOnly: Int = 12
            public const val UserInteractiveAndGames: Int = 13
            public const val DialogOrAlertStyle: Int = 14
            public const val HasVolumeToggle: Int = 15
            public const val HasSkipButton: Int = 16
            public const val AdobeFlash: Int = 17
        }
    }

    /**
     * Describes the position of the ad as a relative measure of visibility or prominence. This OpenRTB
     * table has values derived from the Inventory Quality Guidelines (IQG). Values 4 - 7 apply to apps.
     *
     * [OpenRTB Section 5.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
     */
    public inline class Position(public val value: Int) {
        public companion object {
            public const val Unknown: Int = 0
            public const val AboveTheFold: Int = 1
            public const val BelowTheFold: Int = 3
            public const val Header: Int = 4
            public const val Footer: Int = 5
            public const val Sidebar: Int = 6
            public const val Fullscreen: Int = 7
        }
    }
}
