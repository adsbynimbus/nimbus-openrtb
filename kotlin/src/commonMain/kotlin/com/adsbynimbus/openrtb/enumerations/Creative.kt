package com.adsbynimbus.openrtb.enumerations

/**
 * API frameworks supported by the publisher for a creative.
 *
 * [OpenRTB Section 5.6](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
 */
public object Api {
    /** Supports VPAID 1 (Unused) **/
    public const val VPAID_1: Int = 1

    /** Supports VPAID 2 (Unused) **/
    public const val VPAID_2: Int = 2

    /** Supports MRAID 1 **/
    public const val MRAID_1: Int = 3

    /** Supports ORMMA */
    public const val ORMMA: Int = 4

    /** Supports MRAID 2 **/
    public const val MRAID_2: Int = 5

    /** Supports MRAID 3 **/
    public const val MRAID_3: Int = 6

    /** Supports OM SDK **/
    public const val OMID: Int = 7
}

/**
 * Standard list of creative attributes.
 *
 * Can describe an ad being served or serve as restrictions of thereof.
 *
 * [OpenRTB Section 5.3](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=50)
 */
public object CreativeAttribute {
    /** Audio Ad (Auto-Play) */
    public const val AUDIO_AD_AUTO_PLAY: Int = 1

    /** Audio Ad (User Initiated) */
    public const val AUDIO_AD_USER_INITIATED: Int = 2

    /** Expandable (Automatic) */
    public const val EXPANDABLE_AUTOMATIC: Int = 3

    /** Expandable (User Initiated - Click) */
    public const val EXPANDABLE_USER_CLICK: Int = 4

    /** Expandable (User Initiated - Rollover) */
    public const val EXPANDABLE_USER_ROLLOVER: Int = 5

    /** In-Banner Video Ad (Auto-Play) */
    public const val BANNER_VIDEO_AUTO_PLAY: Int = 6

    /** In-Banner Video Ad (User Initiated) */
    public const val BANNER_VIDEO_USER_INITIATED: Int = 7

    /** Pop (e.g., Over, Under, or Upon Exit) */
    public const val HAS_POPUP: Int = 8

    /** Provocative or Suggestive Imagery */
    public const val PROVOCATIVE_OR_SUGGESTIVE: Int = 9

    /** Shaky, Flashing, Flickering, Extreme Animation, Smileys */
    public const val EXTREME_ANIMATION: Int = 10

    /** Surveys */
    public const val SURVEYS: Int = 11

    /** Text Only */
    public const val TEXT_ONLY: Int = 12

    /** User Interactive (e.g., Embedded Games) */
    public const val USER_INTERACTIVE_AND_GAMES: Int = 13

    /** Windows Dialog or Alert Style */
    public const val DIALOG_OR_ALERT_STYLE: Int = 14

    /** Has Audio On/Off Button */
    public const val HAS_VOLUME_TOGGLE: Int = 15

    /** Ad Provides Skip Button (e.g. VPAID-rendered skip button on pre-roll video) */
    public const val HAS_SKIP_BUTTON: Int = 16

    /** Adobe Flash */
    public const val ADOBE_FLASH: Int = 17
}

/**
 * Describes the position of the ad as a relative measure of visibility or prominence.
 *
 * This OpenRTB table has values derived from the Inventory Quality Guidelines (IQG).
 * Values 4 - 7 apply to apps.
 *
 * [OpenRTB Section 5.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
 */
public object Position {
    public const val UNKNOWN: Int = 0

    @Deprecated("Use Position.UNKNOWN instead.")
    public const val POSITION_UNKNOWN: Int = UNKNOWN
    public const val ABOVE_THE_FOLD: Int = 1
    public const val BELOW_THE_FOLD: Int = 3
    public const val HEADER: Int = 4
    public const val FOOTER: Int = 5
    public const val SIDEBAR: Int = 6
    public const val FULLSCREEN: Int = 7

    @Deprecated("Use Position.FULLSCREEN instead.")
    public const val FULL_SCREEN: Int = FULLSCREEN
}

/**
 * Protocols
 *
 * [OpenRTB Section 5.8](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
 */
public object Protocol {
    /** Vast 2.0 */
    public const val VAST_2: Int = 2

    /** Vast 3.0 */
    public const val VAST_3: Int = 3

    /** Vast 2.0 Wrapper */
    public const val VAST_2_WRAPPER: Int = 5

    /** Vast 3.0 Wrapper */
    public const val VAST_3_WRAPPER: Int = 6
}

/**
 * Video Placement Type
 *
 * [OpenRTB Section 5.9](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
 */
public object PlacementType {
    /**
     * Played before, during or after the streaming video content that the consumer has requested
     * (e.g., Pre-roll, Mid-roll, Post-roll).
     */
    public const val IN_STREAM: Int = 1

    /**
     * Exists within a web banner that leverages the banner space to deliver a video experience as
     * opposed to another static or rich media format. The format relies on the existence of display
     * ad inventory on the page for its delivery
     */
    public const val IN_BANNER: Int = 2

    /**
     * Loads and plays dynamically between paragraphs of editorial content; existing as a standalone
     * branded message
     */
    public const val IN_ARTICLE: Int = 3

    /** Found in content, social, or product feeds. */
    public const val IN_FEED: Int = 4

    /**
     * Covers the entire or a portion of screen area, but is always on screen while displayed (i.e.
     * cannot be scrolled out of view). Note that a full-screen interstitial (e.g., in mobile) can be
     * distinguished from a floating/slider unit by the [Impression.instl] field.
     */
    public const val INTERSTITIAL_SLIDER_FLOATING: Int = 5
}

/**
 * Media Playback Method
 *
 * [OpenRTB Section 5.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=53)
 */
public object PlaybackMethod {
    /** Playback initiates on Page Load with Sound On */
    public const val PAGE_LOAD_SOUND_ON: Int = 1

    /** Playback initiates on Page Load with Sound Off by Default */
    public const val PAGE_LOAD_SOUND_OFF: Int = 2

    /** Playback initiates on Click with Sound On */
    public const val CLICK_SOUND_ON: Int = 3

    /** Playback initiates on Mouse-Over with Sound On */
    public const val MOUSE_OVER_SOUND_ON: Int = 4

    /** Playback initiates on Entering Viewport with Sound On */
    public const val ENTER_VIEWPORT_SOUND_ON: Int = 5

    /** Playback initiates on Entering Viewport with Sound Off by default */
    public const val ENTER_VIEWPORT_SOUND_OFF: Int = 6
}

/**
 * Linearity
 *
 * [OpenRTB Section 5.7](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
 */
public object Linearity {
    /** Linear / In-Stream Video */
    public const val LINEAR: Int = 1

    /** Non-Linear / Overlay Video*/
    public const val NON_LINEAR: Int = 2
}

/**
 * Content Delivery
 *
 * [OpenRTB Section 5.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=53)
 */
public object Delivery {
    /** Streaming Media */
    public const val STREAMING: Int = 1

    /** Progressive Media */
    public const val PROGRESSIVE: Int = 2

    /** Downloaded Media */
    public const val DOWNLOAD: Int = 3
}

/**
 * Companion Ad Type
 *
 * [OpenRTB Section 5.14](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=54)
 */
public object CompanionType {
    /** URI to a static resource such as an image */
    public const val STATIC: Int = 1

    /** HTML to display the companion element */
    public const val HTML: Int = 2

    /** URI source for an IFrame to display the companion element */
    public const val IFRAME: Int = 3
}
