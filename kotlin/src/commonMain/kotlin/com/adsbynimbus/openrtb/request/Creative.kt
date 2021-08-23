package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Creative {
    @SerialName("static") Static,
    @SerialName("video") Video,
    @SerialName("native") Native;

    /**
     * API frameworks supported by the publisher for a creative
     *
     * [OpenRTB Section 5.6](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
     */
    @JvmInline @Serializable
    value class Api(val value: Int) {
        companion object {
            const val Vpaid1 = 1
            const val Vpaid2 = 2
            const val Mraid1 = 3
            const val Ormma = 4
            const val Mraid2 = 5
            const val Mraid3 = 6
            const val Omid = 7
        }
    }

    /**
     * Standard list of creative attributes that can describe an ad being served or serve as
     * restrictions of thereof.
     *
     * [OpenRTB Section 5.3](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=50)
     */
    @JvmInline @Serializable
    value class Attribute(val value: Int) {
        companion object {
            const val AudioAdAutoPlay = 1
            const val AudioAdUserInitiated = 2
            const val ExpandableAutomatic = 3
            const val ExpandableUserClick = 4
            const val ExpandableUserRollover = 5
            const val BannerVideoAutoPlay = 6
            const val BannerVideoUserInitiated = 7
            const val HasPopup = 8
            const val ProvocativeOrSuggestive = 9
            const val ExtremeAnimation = 10
            const val Surveys = 11
            const val TextOnly = 12
            const val UserInteractiveAndGames = 13
            const val DialogOrAlertStyle = 14
            const val HasVolumeToggle = 15
            const val HasSkipButton = 16
            const val AdobeFlash = 17
        }
    }

    /**
     * Describes the position of the ad as a relative measure of visibility or prominence. This OpenRTB
     * table has values derived from the Inventory Quality Guidelines (IQG). Values 4 - 7 apply to apps.
     *
     * [OpenRTB Section 5.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
     */
    @JvmInline @Serializable
    value class Position(val value: Int) {
        companion object {
            const val Unknown = 0
            const val AboveTheFold = 1
            const val BelowTheFold = 3
            const val Header = 4
            const val Footer = 5
            const val Sidebar = 6
            const val Fullscreen = 7
        }
    }
}
