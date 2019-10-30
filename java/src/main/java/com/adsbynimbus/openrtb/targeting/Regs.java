package com.adsbynimbus.openrtb.targeting;

/**
 * This object contains any legal, governmental, or industry regulations that apply to the request. The
 * coppa flag signals whether or not the request falls under the United States Federal Trade Commission’s
 * regulations for the United States Children’s Online Privacy Protection Act ("COPPA").
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=12">OpenRTB Section 3.2.3</a>
 */
public class Regs {

    /**
     * Flag indicating if this request is subject to the COPPA regulations established by the USA FTC,
     * where 0 = no, 1 = yes. Refer to Section 7.5 for more information. [Default: 0]
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=71">OpenRTB Section 7.5</a>
     */
    public int coppa;
    public Extension ext;

    /**
     * Placeholder for exchange-specific extensions to OpenRTB. Reference {@link Extension} for values
     */
    public static class Extension {

        /**
         * Flag indication if this request is subject to GDPR regulations. This flag will be set automatically by
         * Nimbus based on the received IP address. [Default: 0]
         */
        public int gdpr;
    }

    /**
     * Builder for constructing a {@link Regs} object
     */
    public interface Builder {

        /**
         * Set to true if COPPA applies to this request
         *
         * @param coppa true if COPPA applies to this request. Default is false
         * @return this builder instance
         * @see #coppa
         * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=71">OpenRTB Section 7.5</a>
         */
        Builder coppa(boolean coppa);

        /**
         * Set to true if GDPR applies to this request
         *
         * @param gdpr true if GDPR applies to this request. Default is false
         * @return this builder instance
         * @see Extension#gdpr
         */
        Builder gdpr(boolean gdpr);
    }
}
