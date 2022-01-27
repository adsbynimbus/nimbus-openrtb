package com.adsbynimbus.openrtb.request

import com.adsbynimbus.openrtb.enumerations.Position

/**
 * Describes the position of the ad as a relative measure of visibility or prominence.
 *
 * This OpenRTB table has values derived from the Inventory Quality Guidelines (IQG).
 * Values 4 - 7 apply to apps.
 *
 * [OpenRTB Section 5.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=51)
 */
@Deprecated("Use com.adsbynimbus.openrtb.creative.Position instead")
public val Position: Position = Position
