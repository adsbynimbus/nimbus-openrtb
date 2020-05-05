package com.adsbynimbus.openrtb.request

/**
 * This object contains information known or derived about the human user of the device (i.e., the
 * audience for advertising). The user id is an exchange artifact and may be subject to rotation or other
 * privacy policies. However, this user ID must be stable long enough to serve reasonably as the basis for
 * frequency capping and retargeting.
 *
 * @see [OpenRTB Section 3.2.20](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=30)
 */
class User {
    /**
     * Age of the user
     */
    @JvmField
    var age: Int? = null

    /**
     * Buyer-specific ID for the user as mapped by the exchange for the buyer. Set to Facebook bidder token if
     * integrating Facebook demand
     */
    @JvmField
    var buyeruid: String? = null

    /**
     * Year of birth as a 4-digit integer
     */
    @JvmField
    var yob: Int? = null

    /**
     * User gender where "male" = male, "female" = female. If omitted it is assumed to be unknown.
     */
    @JvmField
    var gender: String? = null

    /**
     * Comma separated list of keywords, interests, or intent.
     */
    @JvmField
    var keywords: String? = null

    /**
     * Optional feature to pass bidder data that was set in the exchange’s cookie. The string must be in base85 cookie
     * safe characters and be in any format. Proper JSON encoding must be used to include "escaped" quotation marks.
     */
    @JvmField
    var custom_data: String? = null

    /**
     * Additional user data. Each data object represents a different data source.
     *
     * @see [OpenRTB Section 3.2.21](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf.page=31)
     */
    @JvmField
    var data: Array<Data>? = null

    /**
     * User extension object unique to Nimbus
     */
    @JvmField
    var ext: Extension? = null

    /**
     * User extension object used by Nimbus
     *
     * @see User
     */
    class Extension {
        /**
         * Publisher provided GDPR consent string
         */
        @JvmField
        var consent: String? = null

        /**
         * Set to 1 if the user has consented to data tracking, 0 if the user has opted out of data tracking
         */
        @JvmField
        var did_consent = 0
    }

    /**
     * Builder for constructing a User object
     *
     * @see User
     */
    interface Builder {
        /**
         * Sets the age of the user.
         *
         * @param age the age of the user in years
         * @return this builder instance
         * @see .age
         */
        fun age(age: Int): Builder

        /**
         * Sets the buyer id. If using Facebook this is the bidder token.
         *
         * @param buyerUid set to the Facebook bidder token if using Facebook
         * @return this builder instance
         * @see .buyeruid
         */
        fun buyerUid(buyerUid: String?): Builder

        /**
         * Sets the age of this user.
         *
         * @param yob year of birth as a 4 digit int
         * @return this builder instance
         * @see .yob
         */
        fun yearOfBirth(yob: Int): Builder

        /**
         * Sets the gender of this user.
         *
         * @param gender one of "Male" or "Female"
         * @return this builder instance
         * @see .gender
         */
        fun gender(gender: String?): Builder

        /**
         * Sets the keywords associated with this user.
         *
         * @param keywords a comma delimited String of keywords
         * @return this builder instance
         * @see .keywords
         */
        fun keywords(keywords: String?): Builder

        /**
         * Sets a String of custom data to be sent to Nimbus for this user.
         *
         * @param customData a String representing some custom data
         * @return this builder instance
         * @see .custom_data
         */
        fun customData(customData: String?): Builder

        /**
         * Sets an array of Data objects to be sent with this user.
         *
         * @param data any number of Data objects describing this user
         * @return this builder instance
         * @see .data
         *
         * @see Data
         */
        fun data(vararg data: Data?): Builder

        /**
         * Adds a publisher provided GDPR consent String to this User to be sent with a request.
         *
         * @param consent publisher provided GDPR consent String
         * @return this builder instance
         * @see Extension.consent
         */
        fun gdprConsentString(consent: String?): Builder

        /**
         * Sets to true if the user has consented to the publisher's data policy.
         *
         * @param didConsent true if gave consent [Default: false]
         * @return this builder instance
         * @see Extension.did_consent
         */
        fun gdprDidConsent(didConsent: Boolean): Builder
    }

    companion object {
        /**
         * Male User
         */
        const val MALE = "male"

        /**
         * Female
         */
        const val FEMAlE = "female"
    }
}