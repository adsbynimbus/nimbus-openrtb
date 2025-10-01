package com.adsbynimbus.openrtb.enumerations
public object AdUnitType {
    /** Unknown ad unit type. */
    public const val UNKNOWN: Byte = 0

    /**
     * Inline represents banner ads typically sized at or below 300x250.
     * Common dimensions include 300x250, 300x50, 320x50, 320x100, and 728x90.
     * It May also include video ads when the placementType is set to "inline".
     */
    public const val INLINE: Byte = 1

    /** Interstitial represents full-screen, blocking ads, typically sized at 320x480. */
    public const val INTERSTITIAL: Byte = 2

    /**
     * Rewarded represents ads that grant a reward to users upon completion.
     * While often video-based, the format is not limited to video.
     * For video ads, users are typically required to watch to completion; behavior for other formats is still to be defined.
     */
    public const val REWARDED: Byte = 3

    /**
     * Native represents native ads, where the ad UI is constructed client-side by the publisher.
     * These ads are typically non-blocking and styled to match the app’s content.
     * Currently used as a placeholder, as official support may vary.
     */
    public const val NATIVE: Byte = 4

    /**
     * Dynamic represents Nimbus’s proprietary dynamic ad unit.
     * It simultaneously requests RTB Banner, RTB Video, and occasionally RTB Native creatives.
     * This unit is typically displayed inline, which distinguishes it from interstitial units.
     */
    public const val DYNAMIC: Byte = 5
}
