@file:Suppress("RedundantVisibilityModifier", "INLINE_CLASS_DEPRECATED")

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
    @JvmField @SerialName("age") public val age: Int? = null,
    @JvmField @SerialName("buyeruid") public val buyeruid: String? = null,
    @JvmField @SerialName("yob") public val yob: Int? = null,
    @JvmField @SerialName("gender") public val gender: String? = null,
    @JvmField @SerialName("keywords") public val keywords: String? = null,
    @JvmField @SerialName("custom_data") public val custom_data: String? = null,
    @JvmField @SerialName("data") public val data: Array<Data> = emptyArray(),
    @JvmField @SerialName("ext") public val ext: Extension? = null,
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
    public open class Extension(
        @JvmField @SerialName("consent") public val consent: String = "",
        @JvmField @SerialName("did_consent") public val did_consent: Int = 0,
        @JvmField @SerialName("unity_buyeruid") public val unity_buyeruid: String? = null,
    )

    public inline class Gender(public val gender: Char) {
        public companion object {
            public const val Male: Char = 'M'
            public const val Female: Char = 'F'
            public const val Other: Char = 'O'
        }
    }
}
