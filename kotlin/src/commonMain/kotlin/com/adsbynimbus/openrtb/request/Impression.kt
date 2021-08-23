package com.adsbynimbus.openrtb.request

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object describes an ad placement or impression being auctioned.
 *
 * A single [BidRequest] can include multiple Impression objects, a use case for which might be an
 * exchange that supports selling all ad positions on a given page. Each [Impression] object has a
 * required ID so that bids can reference them individually. The presence of [Banner], [Video], or
 * [Native], subordinate to the Imp object indicates the type of impression being offered. The
 * publisher can choose one such type which is the typical case or mix them at their discretion.
 * However, any given bid for the impression must conform to one of the offered types.
 *
 * [OpenRTB Section 3.2.4](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=12)
 *
 * @property id A unique identifier for this impression within the context of the bid request
 *              (typically, starts with 1and increments).
 *
 *              This field is optional as only 1 impression object is currently supported by Nimbus.
 * @property banner A banner object; required if this impression is offered as a banner ad
 *                  opportunity or is used in the Nimbus hybrid auction.
 * @property video A video object; required if this impression is offered as a video ad opportunity
 *                 or is used in Nimbus hybrid auction.
 * @property native A native object;  required if this impression is offered as a native ad
 *                  opportunity or is used in a Nimbus hybrid auction.
 * @property instl  An integer flag marking this impression object as an interstitial.
 *                  1 = the ad is interstitial or full screen,
 *                  0 = not interstitial.
 * @property bidfloor Minimum bid for this impression expressed in CPM.
 * @property secure Flag to indicate if the impression requires secure HTTPS URL creative assets and
 *                  markup.
 *                  0 = non-secure
 *                  1 = secure
 * @property ext Placeholder for exchange-specific extensions to OpenRTB
 */
@Serializable
class Impression(
    @JvmField val id: String? = null,
    @JvmField val banner: Banner? = null,
    @JvmField val video: Video? = null,
    @JvmField val native: Native? = null,
    @JvmField val instl: Int,
    @JvmField val bidfloor: Float = 1f,
    @JvmField val secure: Int = 1,
    @JvmField val ext: Extension,
) {

    /**
     * Impression extension unique to Nimbus
     *
     * @property position Required string identifying the name of the placement that will be
     *                    displayed on the Nimbus dashboard.
     * @property aps The list of key value pairs provided by a DTBRequest from the APS library.
     * @property facebook_app_id The identifier for this app provided by Facebook. Required if
     *                           including Facebook demand in this request.
     * @property facebook_test_ad_type An optional ad type to force a test response for validating
     *                                 integrations.
     * @see [Facebook Testing](https://developers.facebook.com/docs/audience-network/overview/in-house-mediation/server-to-server/testing)
     */
    @Serializable
    open class Extension(
        @JvmField val position: String,
        @JvmField val aps: List<Aps> = emptyList(),
        @JvmField val facebook_app_id: String? = null,
        @JvmField val facebook_test_ad_type: String? = null,
    )

    @Serializable
    class Aps(
        @JvmField val amzn_b: Array<String>,
        @JvmField val amzn_vid: Array<String>,
        @JvmField val amzn_h: Array<String>,
        @JvmField val amznp: Array<String>,
        @JvmField val amznrdr: Array<String>,
        @JvmField val amznslots: Array<String>,
        @JvmField val dc: Array<String>,
    )
}