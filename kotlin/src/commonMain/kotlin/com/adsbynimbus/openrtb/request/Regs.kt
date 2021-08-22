package com.adsbynimbus.openrtb.request

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object contains any legal, governmental, or industry regulations that apply to the request.
 *
 * The coppa flag signals whether or not the request falls under the United States Federal Trade
 * Commission’s regulations for the United States Children’s Online Privacy Protection Act
 * ("COPPA").
 *
 * [OpenRTB Section 3.2.3](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=17)
 *
 * @property coppa Flag indicating if this request is subject to the COPPA regulations established
 *                 by the USA FTC.
 *                 0 = no
 *                 1 = yes
 * @property ext Regs extension object unique to Nimbus
 * @see [OpenRTB Section 7.5](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=76)
 */
@Serializable
class Regs(
    @JvmField val coppa: Int = 0,
    @JvmField val ext: Extension = Extension(),
) {
    /**
     * Placeholder for exchange-specific extensions to OpenRTB.
     *
     * @property gdpr Flag indication if this request is subject to GDPR regulations. This flag will
     *                be set automatically by Nimbus based on the received IP address.
     * @property us_privacy A publisher generated string representing compliance with CCPA.
     *                      The CCPA privacy string is a 4 character string in the following format:
     *
     *                      Integer - Privacy string version.
     *                      (Y, N, -) - Publisher has provided explicit user notice.
     *                      (Y, N, -) - User opted out of sale
     *                      (Y, N, -) - Publisher operating under the Limited Service Provider
     *                                  Agreement
     *
     *                      If the user does not fall within a US Privacy jurisdiction, hyphens
     *                      should be used in the last three positions, generating this privacy
     *                      string: "1---"
     * @see [US Privacy String Format](https://github.com/InteractiveAdvertisingBureau/USPrivacy/blob/master/CCPA/Version%201.0/US%20Privacy%20String.md.us-privacy-string-format)
     */
    @Serializable
    open class Extension(
        @JvmField val gdpr: Int = 0,
        @JvmField val us_privacy: String = ""
    )
}