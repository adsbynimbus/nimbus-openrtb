package com.adsbynimbus.openrtb.impression;

import static com.adsbynimbus.openrtb.impression.Format.FORMAT;
import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;

/**
 * This object represents the most general type of impression. Although the term “banner” may have very
 * specific meaning in other contexts, here it can be many things including a simple static image, an
 * expandable ad unit, or even in-banner video (refer to the Video object in Section 3.2.7 for the more
 * generalized and full featured video ad units). An array of Banner objects can also appear within the
 * Video to describe optional companion ads defined in the VAST specification.
 * The presence of a Banner as a subordinate of the Imp object indicates that this impression is offered as
 * a banner type impression. At the publisher’s discretion, that same impression may also be offered as
 * video, audio, and/or native by also including as Imp subordinates objects of those types. However, any
 * given bid for the impression must conform to one of the offered types.
 */
public interface Banner extends Creative {

    /* Supported APIS [See OpenRTB 2.5 Section 5.6] */
    int VPAID_2 = 2;
    int MRAID_1 = 3;
    int MRAID_2 = 5;
    int MRAID_3 = 6;

    /**
     * Builder for constructing a {@link Banner} object
     */
    interface Builder {

    }

    /**
     * Definition of {@link Banner} with all public mutable fields
     */
    class MutableBanner implements Banner {
        public Float bidfloor; // Server default is 2.0
        public Format[] format;
        public Integer w;
        public Integer h;
        public Integer pos;
        public String[] mimes;
        public int[] api;
    }
}
