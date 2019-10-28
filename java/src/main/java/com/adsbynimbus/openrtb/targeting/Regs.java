package com.adsbynimbus.openrtb.targeting;

/**
 * This object contains any legal, governmental, or industry regulations that apply to the request. The
 * coppa flag signals whether or not the request falls under the United States Federal Trade Commission’s
 * regulations for the United States Children’s Online Privacy Protection Act ("COPPA").
 */
public class Regs {

    public int coppa;
    public Extension ext;

    public static class Extension {

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
         */
        Builder coppa(boolean coppa);

        /**
         * Set to true if GDPR applies to this request
         *
         * @param gdpr true if GDPR applies to this request. Default is false
         * @return this builder instance
         */
        Builder gdpr(boolean gdpr);
    }
}
