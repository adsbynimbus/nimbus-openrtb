package com.adsbynimbus.openrtb.targeting;

/**
 * This object describes the nature and behavior of the entity that is the source of the bid request
 * upstream from the exchange. The primary purpose of this object is to define post-auction or upstream
 * decisioning when the exchange itself does not control the final decision. A common example of this is
 * header bidding, but it can also apply to upstream server entities such as another RTB exchange, a
 * mediation platform, or an ad server combines direct campaigns with 3rd party demand in decisioning
 */
public class Source {

    public Extension ext;

    // Extensions
    public static class Extension {

        public String omidpn;
        public String omidpv;
    }

    /**
     * Builder for constructing a {@link Source} object
     */
    public interface Builder {

        /**
         * Set the OM SDK information for a measurement enabled app
         *
         * @param partnerName should match the partner name field from OM
         * @param sdkVersion OM SDK version
         * @return this builder instance
         */
        Builder omSdk(String partnerName, String sdkVersion);
    }
}
