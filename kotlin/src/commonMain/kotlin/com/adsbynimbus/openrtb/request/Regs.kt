package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
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
 * @property ext Placeholder for exchange-specific extensions to OpenRTB.
 * @see [OpenRTB Section 7.5](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=76)
 */
@Serializable
public class Regs(
    @JvmField @SerialName("coppa") public var coppa: Byte = 0,
    @JvmField @SerialName("ext") public var ext: Extension? = null,
)

/**
 * Flag indication if this request is subject to GDPR regulations.
 *
 * This flag will be set automatically by Nimbus based on the received IP address.
 */
public var Regs.gdpr: Byte?
    get() = ext?.get("gdpr")?.jsonPrimitive?.intOrNull?.toByte()
    set(value) {
        ext = buildJsonObject {
            ext?.forEach { put(it.key, it.value) }
            put("gdpr", value)
        }
    }

/**
 * A publisher generated string representing compliance with CCPA.
 *
 * The CCPA privacy string is a 4 character string in the following format:
 *
 * Integer   - Privacy string version.
 * (Y, N, -) - Publisher has provided explicit user notice.
 * (Y, N, -) - User opted out of sale
 * (Y, N, -) - Publisher operating under the Limited Service Provider Agreement
 *
 * If the user does not fall within a US Privacy jurisdiction, hyphens should be used in the last
 * three positions, generating this privacy string: "1---"
 *
 * @see [US Privacy String Format](https://github.com/InteractiveAdvertisingBureau/USPrivacy/blob/master/CCPA/Version%201.0/US%20Privacy%20String.md.us-privacy-string-format)
 */
public var Regs.us_privacy: String?
    get() = ext?.get("us_privacy")?.jsonPrimitive?.contentOrNull
    set(value) {
        ext = buildJsonObject {
            ext?.forEach { put(it.key, it.value) }
            put("us_privacy", value)
        }
    }
