package com.adsbynimbus.openrtb.enumerations

import com.adsbynimbus.openrtb.request.Impression

/**
 * Video Placement Type
 *
 * [OpenRTB Section 5.9](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=52)
 */
public object PlacementType {
    /**
     * Played before, during, or after the streaming video content that the consumer has
     * requested (e.g., Pre-roll, Mid-roll, Post-roll).
     */
    public const val IN_STREAM: Byte = 1

    /**
     * Exists within a web banner that leverages the banner space to deliver a video experience
     * as opposed to another static or rich media format. The format relies on the existence of
     * display ad inventory on the page for its delivery.
     */
    public const val IN_BANNER: Byte = 2

    /**
     * Loads and plays dynamically between paragraphs of editorial content; existing as a
     * standalone branded message.
     */
    public const val IN_ARTICLE: Byte = 3

    /** Found in content, social, or product feeds. */
    public const val IN_FEED: Byte = 4

    /**
     * Covers the entire or a portion of screen area, but is always on screen while displayed
     * (i.e. cannot be scrolled out of view).
     *
     * Note that a full-screen interstitial (e.g., in mobile) can be distinguished from a
     * floating/slider unit by the [Impression.instl] field.
     */
    public const val INTERSTITIAL_SLIDER_FLOATING: Byte = 5
}
