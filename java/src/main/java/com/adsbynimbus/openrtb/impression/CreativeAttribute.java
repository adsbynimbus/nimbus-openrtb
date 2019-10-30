package com.adsbynimbus.openrtb.impression;

/**
 * Standard list of creative attributes that can describe an ad being served or serve as restrictions of thereof.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=45">OpenRTB Section 5.3</a>
 */
public interface CreativeAttribute {

    /**
     * Audio Ad (Auto-Play)
     */
    int AUDIO_AD_AUTO_PLAY = 1;

    /**
     * Audio Ad (User Initiated)
     */
    int AUDIO_AD_USER_INITIATED = 2;

    /**
     * Expandable (Automatic)
     */
    int EXPANDABLE_AUTOMATIC = 3;

    /**
     * Expandable (User Initiated - Click)
     */
    int EXPANDABLE_USER_CLICK = 4;

    /**
     * Expandable (User Initiated - Rollover)
     */
    int EXPANDABLE_USER_ROLLOVER = 5;

    /**
     * In-Banner Video Ad (Auto-Play)
     */
    int BANNER_VIDEO_AUTO_PLAY = 6;

    /**
     * In-Banner Video Ad (User Initiated)
     */
    int BANNER_VIDEO_USER_INITIATED = 7;

    /**
     * Pop (e.g., Over, Under, or Upon Exit)
     */
    int HAS_POPUP = 8;

    /**
     * Provocative or Suggestive Imagery
     */
    int PROVOCATIVE_OR_SUGGESTIVE = 9;

    /**
     * Shaky, Flashing, Flickering, Extreme Animation, Smileys
     */
    int EXTREME_ANIMATION = 10;

    /**
     * Surveys
     */
    int SURVEYS = 11;

    /**
     * Text Only
     */
    int TEXT_ONLY = 12;

    /**
     * User Interactive (e.g., Embedded Games)
     */
    int USER_INTERACTIVE_AND_GAMES = 13;

    /**
     * Windows Dialog or Alert Style
     */
    int DIALOG_OR_ALERT_STYLE = 14;

    /**
     * Has Audio On/Off Button
     */
    int HAS_VOLUME_TOGGLE = 15;

    /**
     * Ad Provides Skip Button (e.g. VPAID-rendered skip button on pre-roll video)
     */
    int HAS_SKIP_BUTTON = 16;

    /**
     * Adobe Flash
     */
    int ADOBE_FLASH = 17;
}
