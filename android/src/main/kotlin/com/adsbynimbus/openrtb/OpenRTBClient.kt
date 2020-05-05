package com.adsbynimbus.openrtb

import java.util.*

/**
 * Interface for defining a client for making OpenRTB requests to Nimbus
 */
interface OpenRTBClient {
    /**
     * Returns a map of required headers needed to make a request
     *
     * @return headers to be added to the outbound request
     */
    fun requiredHeaders(): Map<String, String>? {
        return Collections.singletonMap(HEADER_OPEN_RTB, OPEN_RTB_VERSION)
    }

    companion object {
        /**
         * Required header if making a request to Nimbus defining the OpenRTB version
         */
        const val HEADER_OPEN_RTB = "x-openrtb-version"

        /**
         * The current supported OpenRTB version for use with [.HEADER_OPEN_RTB]
         */
        const val OPEN_RTB_VERSION = "2.5"
    }
}