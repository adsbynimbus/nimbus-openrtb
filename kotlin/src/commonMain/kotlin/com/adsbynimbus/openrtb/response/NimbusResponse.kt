package com.adsbynimbus.openrtb.response

import kotlin.jvm.JvmField

/**
 * A winning bid response from Nimbus
 *
 * @property type The type of creative returned. This maps to one of "static", "video", or "native"
 * @property auction_id This unique auction id. Represented as a GUID.
 * @property bid_in_cents This winning auction's bid in cents.
 * @property bid_raw This winning auction's precise winning bid.
 * @property content_type The content type of this creative. "text/html" for static or a mime type
 *                        for video ads
 * @property height The height of the creative if available. Will not be set for Video or Native ads
 * @property width The width of the creative if available. Will not be set for Video or Native ads
 * @property is_interstitial Set to 1 if the original request was for an interstitial ad
 * @property markup The markup returned by Nimbus. Will be in the format of html for static or xml
 *                  VAST for video
 * @property network The network that won this auction
 * @property trackers Contains additional urls for measurement
 * @property placement_id The winning placement id if the winning bid maps to a line item
 * @property is_mraid Set to 1 if Nimbus has determined the creative returned requests MRAID in the
 *                    creative markup
 */
class NimbusResponse(
    @JvmField val type: String,
    @JvmField val auction_id: String,
    @JvmField val bid_in_cents: Int = 0,
    @JvmField val bid_raw: Float = 0f,
    @JvmField val content_type: String? = null,
    @JvmField val height: Int = 0,
    @JvmField val width: Int = 0,
    @JvmField val is_interstitial: Int = 0,
    @JvmField val markup: String,
    @JvmField val network: String = "",
    @JvmField val trackers: Trackers = Trackers(),
    @JvmField val placement_id: String,
    @JvmField val is_mraid: Int = 0,
)

/**
 * Additional tracking urls
 *
 * @property impression_trackers Urls to fire a request to when an impression is registered
 * @property click_trackers Urls to fire a request to when a click is registered
 */
open class Trackers(
    @JvmField val impression_trackers: Array<String> = emptyArray(),
    @JvmField val click_trackers: Array<String> = emptyArray(),
)