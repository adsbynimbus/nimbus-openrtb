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
    @JvmField var type: String = "",
    @JvmField var auction_id: String = "",
    @JvmField var bid_in_cents: Int = 0,
    @JvmField var bid_raw: Float = 0f,
    @JvmField var content_type: String? = null,
    @JvmField var height: Int = 0,
    @JvmField var width: Int = 0,
    @JvmField var is_interstitial: Int = 0,
    @JvmField var markup: String? = null,
    @JvmField var network: String = "",
    @JvmField var trackers: Trackers? = null,
    @JvmField var placement_id: String? = null,
    @JvmField var is_mraid: Int = 0,
)

/**
 * Additional tracking urls
 *
 * @property impression_trackers Urls to fire a request to when an impression is registered
 * @property click_trackers Urls to fire a request to when a click is registered
 */
open class Trackers(
    @JvmField var impression_trackers: Array<String>? = null,
    @JvmField var click_trackers: Array<String>? = null,
)