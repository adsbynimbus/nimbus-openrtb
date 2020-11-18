package com.adsbynimbus.openrtb.request

import kotlin.jvm.JvmField

/**
 * This object describes the nature and behavior of the entity that is the source of the bid request
 * upstream from the exchange.
 *
 * The primary purpose of this object is to define post-auction or upstream decisioning when the exchange itself does
 * not control the final decision. A common example of this is header bidding, but it can also apply to upstream server
 * entities such as another RTB exchange, a mediation platform, or an ad server combines direct campaigns with 3rd
 * party demand in decisioning
 *
 * [OpenRTB Section 3.2.2](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=16)
 */
open class Source {
    /**
     * Placeholder for exchange-specific extensions to OpenRTB.
     */
    @JvmField
    var ext: Extension? = null

    /**
     * Source extension object unique to Nimbus
     *
     * @see [Source]
     */
    open class Extension {
        /**
         * Partner name that identifies the OM SDK integration
         */
        @JvmField
        var omidpn: String? = null

        /**
         * Current version of the OM SDK integration
         */
        @JvmField
        var omidpv: String? = null
    }

    /**
     * Builder for constructing a Source object
     *
     * @see [Source]
     */
    interface Builder {
        /**
         * Sets the OM SDK information for a measurement enabled app.
         *
         * @param partnerName should match the partner name field from OM
         * @param sdkVersion OM SDK version
         * @return this builder instance
         * @see [Extension.omidpn]
         * @see [Extension.omidpv]
         */
        fun omSdk(partnerName: String?, sdkVersion: String?): Builder
    }
}