package com.adsbynimbus.openrtb.targeting.user;

/**
 * This object contains information known or derived about the human user of the device (i.e., the
 * audience for advertising). The user id is an exchange artifact and may be subject to rotation or other
 * privacy policies. However, this user ID must be stable long enough to serve reasonably as the basis for
 * frequency capping and retargeting.
 */
public interface User {

    String AGE = "age"; // Integer
    String BUYER_UID = "buyeruid";
    String YEAR_OF_BIRTH = "yob"; // Integer
    String GENDER = "gender";

    // Gender Consts
    String MALE = "Male";
    String FEMALE = "Female";

    /**
     * User 'ext' object used by Nimbus
     */
    interface Extension {
        String CONSENT = "consent";
        String DID_CONSENT = "did_consent"; // int
    }

    /**
     * Builder for constructing a {@link User} object
     */
    interface Builder {

        /**
         * Set the age of the user
         *
         * @param age
         * @return this builder instance
         */
        Builder withAge(int age);

        /**
         * Set the buyer id. If using Facebook this is the bidder token
         *
         * @param buyerUid
         * @return this builder instance
         */
        Builder withBuyerUid(String buyerUid);

        /**
         * Set the age of the user
         *
         * @param yob year of birth
         * @return this builder instance
         */
        Builder withYearOfBirth(int yob);

        /**
         * Sets the gender of the user
         *
         * @param gender [M, F, or O]
         * @return this builder instance
         */
        Builder withGender(String gender);

        /**
         * Adds the IAB consent string to the request
         *
         * @param consentString
         * @return this builder instance
         */
        Builder withIABConsentString(String consentString);

        /**
         * Adds the IAB consent string to the request
         *
         * @param didConsent boolean: true if gave consent [Default: false]
         * @return this builder instance
         */
        Builder withGDPRConsent(boolean didConsent);
    }

    /**
     * Definition of {@link User} with all public mutable fields
     */
    class MutableUser implements User {
        public Integer age;
        public String buyeruid;
        public Integer yob;
        public String gender;
        public Extension ext;
    }

    /**
     * Definition of {@link User.Extension} with all public mutable fields
     */
    class MutableExtension implements Extension {
        public String consent;
        public int did_consent;
    }
}
