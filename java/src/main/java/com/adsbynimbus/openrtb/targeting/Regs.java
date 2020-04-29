package com.adsbynimbus.openrtb.targeting;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This object contains any legal, governmental, or industry regulations that apply to the request. The
 * coppa flag signals whether or not the request falls under the United States Federal Trade Commission’s
 * regulations for the United States Children’s Online Privacy Protection Act ("COPPA").
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=17">OpenRTB Section 3.2.3</a>
 */
public class Regs {

    /**
     * Flag indicating if this request is subject to the COPPA regulations established by the USA FTC,
     * where 0 = no, 1 = yes.
     * <p><br>
     * If this value is omitted Nimbus defaults to 0
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=76">OpenRTB Section 7.5</a>
     */
    @Nullable
    public Integer coppa;

    /**
     * Regs extension object unique to Nimbus
     */
    @Nullable
    public Extension ext;

    /**
     * Placeholder for exchange-specific extensions to OpenRTB
     */
    public static class Extension {

        /**
         * Flag indication if this request is subject to GDPR regulations. This flag will be set automatically by
         * Nimbus based on the received IP address.
         * <p><br>
         * If this value is omitted Nimbus defaults to 0
         */
        @Nullable
        public Integer gdpr;

        /**
         * A publisher generated string representing compliance with CCPA.
         *
         * <p>The CCPA privacy string is a 4 character string in the following format:
         * <ul>
         *     <li>Integer - Privacy string version.</li>
         *     <li>[Y, N, -] - Publisher has provided explicit user notice.</li>
         *     <li>[Y, N, -] - User opted out of sale</li>
         *     <li>[Y, N, -] - Publisher operating under the Limited Service Provider Agreement</li>
         * </ul>
         * <p>If the user does not fall within a US Privacy jurisdiction, hyphens should be used in
         * the last three positions, generating this privacy string: "1---"
         *
         * @see <a href="https://github.com/InteractiveAdvertisingBureau/USPrivacy/blob/master/CCPA/Version%201.0/US%20Privacy%20String.md#us-privacy-string-format">US Privacy String Format</a>
         */
        @Nullable
        public String us_privacy;
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
        @NotNull
        Builder coppa(boolean coppa);

        /**
         * Set to true if GDPR applies to this request
         *
         * @param gdpr true if GDPR applies to this request. Default is false
         * @return this builder instance
         * @see Extension#gdpr
         */
        @NotNull
        Builder gdpr(boolean gdpr);

        /**
         * A publisher generated string representing compliance with CCPA.
         *
         * @param usPrivacyString the four character CCPA privacy string
         * @return this builder instance
         * @see Extension#us_privacy
         */
        @NotNull
        Builder ccpa(@NotNull String usPrivacyString);
    }
}
