package com.adsbynimbus.openrtb.enumerations

/**
 * Standard list of creative attributes.
 *
 * Can describe an ad being served or serve as restrictions of thereof.
 *
 * [OpenRTB Section 5.3](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=50)
 */
public object CreativeAttributes {

    /** Audio Ad (Auto-Play) */
    public const val AUDIO_AD_AUTO_PLAY: Byte = 1

    /** Audio Ad (User Initiated) */
    public const val AUDIO_AD_USER_INITIATED: Byte = 2

    /** Expandable (Automatic) */
    public const val EXPANDABLE_AUTOMATIC: Byte = 3

    /** Expandable (User Initiated - Click) */
    public const val EXPANDABLE_USER_CLICK: Byte = 4

    /** Expandable (User Initiated - Rollover) */
    public const val EXPANDABLE_USER_ROLLOVER: Byte = 5

    /** In-Banner Video Ad (Auto-Play) */
    public const val BANNER_VIDEO_AUTO_PLAY: Byte = 6

    /** In-Banner Video Ad (User Initiated) */
    public const val BANNER_VIDEO_USER_INITIATED: Byte = 7

    /** Pop (e.g., Over, Under, or Upon Exit) */
    public const val HAS_POPUP: Byte = 8

    /** Provocative or Suggestive Imagery */
    public const val PROVOCATIVE_OR_SUGGESTIVE: Byte = 9

    /** Shaky, Flashing, Flickering, Extreme Animation, Smileys */
    public const val EXTREME_ANIMATION: Byte = 10

    /** Surveys */
    public const val SURVEYS: Byte = 11

    /** Text Only */
    public const val TEXT_ONLY: Byte = 12

    /** User Byteeractive (e.g., Embedded Games) */
    public const val USER_INTERACTIVE_AND_GAMES: Byte = 13

    /** Windows Dialog or Alert Style */
    public const val DIALOG_OR_ALERT_STYLE: Byte = 14

    /** Has Audio On/Off Button */
    public const val HAS_VOLUME_TOGGLE: Byte = 15

    /** Ad Provides Skip Button (e.g. VPAID-rendered skip button on pre-roll video) */
    public const val HAS_SKIP_BUTTON: Byte = 16

    /** Adobe Flash */
    public const val ADOBE_FLASH: Byte = 17
}
