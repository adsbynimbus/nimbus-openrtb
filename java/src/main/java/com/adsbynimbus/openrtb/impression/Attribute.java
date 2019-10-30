package com.adsbynimbus.openrtb.impression;

/**
 * Standard list of creative attributes that can describe an ad being served or serve as restrictions of thereof.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=45">OpenRTB Section 5.3</a>
 */
public enum Attribute {

    /**
     * 1: Audio Ad (Auto-Play)
     */
    AUDIO_AD_AUTO_PLAY(1),

    /**
     * 2: Audio Ad (User Initiated)
     */
    AUDIO_AD_USER_INITIATED(2),

    /**
     * 3: Expandable (Automatic)
     */
    EXPANDABLE_AUTOMATIC(3),

    /**
     * 4: Expandable (User Initiated - Click)
     */
    EXPANDABLE_USER_CLICK(4),

    /**
     * 5: Expandable (User Initiated - Rollover)
     */
    EXPANDABLE_USER_ROLLOVER(5),

    /**
     * 6: In-Banner Video Ad (Auto-Play)
     */
    BANNER_VIDEO_AUTO_PLAY(6),

    /**
     * 7: In-Banner Video Ad (User Initiated)
     */
    BANNER_VIDEO_USER_INITIATED(7),

    /**
     * 8: Pop (e.g., Over, Under, or Upon Exit)
     */
    HAS_POPUP(8),

    /**
     * 9: Provocative or Suggestive Imagery
     */
    PROVOCATIVE_OR_SUGGESTIVE(9),

    /**
     * 10: Shaky, Flashing, Flickering, Extreme Animation, Smileys
     */
    EXTREME_ANIMATION(10),

    /**
     * 11: Surveys
     */
    SURVEYS(11),

    /**
     * 12: Text Only
     */
    TEXT_ONLY(12),

    /**
     * 13: User Interactive (e.g., Embedded Games)
     */
    USER_INTERACTIVE_AND_GAMES(13),

    /**
     * 14: Windows Dialog or Alert Style
     */
    DIALOG_OR_ALERT_STYLE(14),

    /**
     * 15: Has Audio On/Off Button
     */
    HAS_VOLUME_TOGGLE(15),

    /**
     * 16: Ad Provides Skip Button (e.g. VPAID-rendered skip button on pre-roll video)
     */
    HAS_SKIP_BUTTON(16),

    /**
     * 17: Adobe Flash
     */
    ADOBE_FLASH(17);

    public final int value;

    Attribute(int value) {
        this.value = value;
    }
}
