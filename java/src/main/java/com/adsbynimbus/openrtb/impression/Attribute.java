package com.adsbynimbus.openrtb.impression;

/**
 * Defines attributes of a creative
 */
public enum Attribute {
    AUDIO_AD_AUTO_PLAY(1),
    AUDIO_AD_USER_INITIATED(2),
    EXPANDABLE_AUTOMATIC(3),
    EXPANDABLE_USER_CLICK(4),
    EXPANDABLE_USER_ROLLOVER(5),
    BANNER_VIDEO_AUTO_PLAY(6),
    BANNER_VIDEO_USER_INITIATED(7),
    HAS_POPUP(8),
    PROVOCATIVE_OR_SUGGESTIVE(9),
    EXTREME_ANIMATION(10),
    SURVEYS(11),
    TEXT_ONLY(12),
    USER_INTERACTIVE_AND_GAMES(13),
    DIALOG_OR_ALERT_STYLE(14),
    HAS_VOLUME_TOGGLE(15),
    HAS_SKIP_BUTTON(16),
    ADOBE_FLASH(17);

    public final int value;

    Attribute(int value) {
        this.value = value;
    }
}
