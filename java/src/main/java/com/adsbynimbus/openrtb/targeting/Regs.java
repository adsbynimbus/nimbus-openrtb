package com.adsbynimbus.openrtb.targeting;

/**
 * This object contains any legal, governmental, or industry regulations that apply to the request. The
 * coppa flag signals whether or not the request falls under the United States Federal Trade Commission’s
 * regulations for the United States Children’s Online Privacy Protection Act ("COPPA").
 */
public interface Regs {

    String COPPA = "coppa"; // int: 0 = no, 1 = yes

    interface Extension {
        String GDPR = "gdpr"; // int: 0 = no, 1 = yes
    }

    /**
     * Builder for constructing a {@link Regs} object
     */
    interface Builder {

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

    /**
     * Definition of {@link Regs} with all public mutable fields
     */
    class MutableRegs implements Regs {
        public int coppa;
        public Extension ext;
    }

    /**
     * Definition of {@link Regs.Extension} with all public mutable fields
     */
    class MutableExtension implements Regs.Extension {
        public int gdpr;
    }
}
