package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object contains information known or derived about the human user of the device (i.e., the
 * audience for advertising).
 *
 * The user id is an exchange artifact and may be subject to rotation or other privacy policies.
 * However, this user ID must be stable long enough to serve reasonably as the basis for frequency
 * capping and retargeting.
 *
 * [OpenRTB Section 3.2.20](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=30)
 *
 * @property age Age of the user
 * @property buyeruid Buyer-specific ID for the user as mapped by the exchange for the buyer.
 *                    Set to Facebook bidder token if integrating Facebook demand.
 * @property yob Year of birth as a 4-digit integer
 * @property gender The gender of this user. If omitted it is assumed to be unknown.
 *                  "male" = male
 *                  "female" = female.
 * @property keywords Comma separated list of keywords, interests, or intent.
 * @property custom_data Optional feature to pass bidder data that was set in the exchange’s cookie.
 *                       The string must be in base85 cookie safe characters and be in any format.
 *                       Proper JSON encoding must be used to include "escaped" quotation marks.
 * @property data Additional user data. Each data object represents a different data source.
 * @property ext User extension object unique to Nimbus
 * @see [OpenRTB Section 3.2.21](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=31)
 */
@Serializable
public class User(
    @JvmField @SerialName("age") public var age: Int = 0,
    @JvmField @SerialName("buyeruid") public var buyeruid: String? = null,
    @JvmField @SerialName("yob") public var yob: Int = 0,
    @JvmField @SerialName("gender") public var gender: String? = null,
    @JvmField @SerialName("keywords") public var keywords: String? = null,
    @JvmField @SerialName("custom_data") public var custom_data: String? = null,
    @JvmField @SerialName("data") public var data: Array<Data>? = null,
    @JvmField @SerialName("ext") public var ext: Extension? = null,
) {

    /**
     * User extension object used by Nimbus
     *
     * @property consent Publisher provided GDPR consent string
     * @property did_consent 1 if the user has consented to data tracking, 0 if the user has opted
     *                       out of data tracking.
     * @property unity_buyeruid String token provided by the Unity Ads SDK to include Unity demand
     *                          in the auction. Token is initialized when UnityAds is initialized
     *                          and the token and campaign is refreshed after the ad playback has
     *                          started.
     */
    @Serializable
    public class Extension(
        @JvmField @SerialName("consent") public var consent: String? = null,
        @JvmField @SerialName("did_consent") public var did_consent: Byte? = null,
        @JvmField @SerialName("unity_buyeruid") public var unity_buyeruid: String? = null,
    )
}
