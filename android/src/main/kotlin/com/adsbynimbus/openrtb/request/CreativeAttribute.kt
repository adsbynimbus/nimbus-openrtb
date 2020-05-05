package com.adsbynimbus.openrtb.request

/**
 * Standard list of creative attributes that can describe an ad being served or serve as restrictions of thereof.
 *
 * [OpenRTB Section 5.3](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=50)
 */
interface CreativeAttribute {
    companion object {
        /**
         * Audio Ad (Auto-Play)
         */
        const val AUDIO_AD_AUTO_PLAY = 1

        /**
         * Audio Ad (User Initiated)
         */
        const val AUDIO_AD_USER_INITIATED = 2

        /**
         * Expandable (Automatic)
         */
        const val EXPANDABLE_AUTOMATIC = 3

        /**
         * Expandable (User Initiated - Click)
         */
        const val EXPANDABLE_USER_CLICK = 4

        /**
         * Expandable (User Initiated - Rollover)
         */
        const val EXPANDABLE_USER_ROLLOVER = 5

        /**
         * In-Banner Video Ad (Auto-Play)
         */
        const val BANNER_VIDEO_AUTO_PLAY = 6

        /**
         * In-Banner Video Ad (User Initiated)
         */
        const val BANNER_VIDEO_USER_INITIATED = 7

        /**
         * Pop (e.g., Over, Under, or Upon Exit)
         */
        const val HAS_POPUP = 8

        /**
         * Provocative or Suggestive Imagery
         */
        const val PROVOCATIVE_OR_SUGGESTIVE = 9

        /**
         * Shaky, Flashing, Flickering, Extreme Animation, Smileys
         */
        const val EXTREME_ANIMATION = 10

        /**
         * Surveys
         */
        const val SURVEYS = 11

        /**
         * Text Only
         */
        const val TEXT_ONLY = 12

        /**
         * User Interactive (e.g., Embedded Games)
         */
        const val USER_INTERACTIVE_AND_GAMES = 13

        /**
         * Windows Dialog or Alert Style
         */
        const val DIALOG_OR_ALERT_STYLE = 14

        /**
         * Has Audio On/Off Button
         */
        const val HAS_VOLUME_TOGGLE = 15

        /**
         * Ad Provides Skip Button (e.g. VPAID-rendered skip button on pre-roll video)
         */
        const val HAS_SKIP_BUTTON = 16

        /**
         * Adobe Flash
         */
        const val ADOBE_FLASH = 17
    }
}