package com.adsbynimbus.openrtb.enumerations

/**
 * Media Playback Method
 *
 * [OpenRTB Section 5.10](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=53)
 */
public object PlaybackMethods {
    /** Playback initiates on Page Load with Sound On */
    public const val PAGE_LOAD_SOUND_ON: Byte = 1

    /** Playback initiates on Page Load with Sound Off by Default */
    public const val PAGE_LOAD_SOUND_OFF: Byte = 2

    /** Playback initiates on Click with Sound On */
    public const val CLICK_SOUND_ON: Byte = 3

    /** Playback initiates on Mouse-Over with Sound On */
    public const val MOUSE_OVER_SOUND_ON: Byte = 4

    /** Playback initiates on Entering Viewport with Sound On */
    public const val ENTER_VIEWPORT_SOUND_ON: Byte = 5

    /** Playback initiates on Entering Viewport with Sound Off by default */
    public const val ENTER_VIEWPORT_SOUND_OFF: Byte = 6
}
