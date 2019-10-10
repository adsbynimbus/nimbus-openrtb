package com.adsbynimbus.client;

import java.util.Collections;
import java.util.Map;

/**
 * Interface for defining a client for making OpenRTB requests to Nimbus
 */
public interface OpenRTBClient {

    String HEADER_OPEN_RTB = "x-openrtb-version";
    String OPEN_RTB_VERSION = "2.5";

    /**
     * Returns a map of required headers needed to make a request
     *
     * @return headers
     */
    default Map<String, String> requiredHeaders() {
        return Collections.singletonMap(HEADER_OPEN_RTB, OPEN_RTB_VERSION);
    }
}
