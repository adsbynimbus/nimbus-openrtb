package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * This object describes the nature and behavior of the entity that is the source of the bid request
 * upstream from the exchange.
 *
 * The primary purpose of this object is to define post-auction or upstream decisioning when the
 * exchange itself does not control the final decision. A common example of this is header bidding,
 * but it can also apply to upstream server entities such as another RTB exchange, a mediation
 * platform, or an ad server combines direct campaigns with 3rd party demand in decisioning.
 *
 * [OpenRTB Section 3.2.2](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=16)
 *
 * @property ext Placeholder for exchange-specific extensions to OpenRTB.
 */
@Serializable
public class Source(
    @SerialName("ext") public val ext: MutableMap<String, String> = mutableMapOf()
) {

    /** Partner name that identifies the OM SDK integration */
    public inline var omidpn: String
        get() = ext["omidpn"] ?: ""
        set(value) { ext["omidpn"] = value }

    /** Current version of the OM SDK integration */
    public inline var omidpv: String
        get() = ext["omidpv"] ?: ""
        set(value) { ext["omidpv"] = value }
}
