package com.adsbynimbus.openrtb.user;

/**
 * This object describes the nature and behavior of the entity that is the source of the bid request
 * upstream from the exchange. The primary purpose of this object is to define post-auction or upstream
 * decisioning when the exchange itself does not control the final decision. A common example of this is
 * header bidding, but it can also apply to upstream server entities such as another RTB exchange, a
 * mediation platform, or an ad server combines direct campaigns with 3rd party demand in decisioning
 */
public interface Source {

    // Extensions
    interface Extension {
        String OM_PARTNER_NAME = "omidpn";
        String OM_SDK_VERSION = "omidpv";
    }

    /**
     * Builder for constructing a {@link Source} object
     */
    interface Builder {

    }

    /**
     * Definition of {@link Source} with all public mutable fields
     */
    class MutableSource implements Source {
        public Extension ext;
    }

    /**
     * Definition of {@link Source.Extension} with all public mutable fields
     */
    class MutableExtension implements Extension {
        public String omidpn;
        public String omidpv;
    }
}
