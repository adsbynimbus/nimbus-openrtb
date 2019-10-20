package com.adsbynimbus.openrtb.targeting.user;

import com.adsbynimbus.openrtb.targeting.Data;

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
    String KEYWORDS = "keywords";
    String CUSTOM_DATA = "custom_data";
    String DATA = "data";


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
        Builder age(int age);

        /**
         * Set the buyer id. If using Facebook this is the bidder token
         *
         * @param buyerUid
         * @return this builder instance
         */
        Builder buyerUid(String buyerUid);

        /**
         * Set the age of this user
         *
         * @param yob year of birth
         * @return this builder instance
         */
        Builder yearOfBirth(int yob);

        /**
         * Sets the gender of this user
         *
         * @param gender [M, F, or O]
         * @return this builder instance
         */
        Builder gender(String gender);

        /**
         * Sets the keywords associated with this user
         *
         * @param keywords a comma delimited string of keywords
         * @return this builder instance
         */
        Builder keywords(String keywords);

        /**
         * Set a string of custom data to be sent to Nimbus for this user
         *
         * @param customData a string representing some custom data
         * @return this builder instance
         */
        Builder customData(String customData);

        /**
         * Sets an array of Data objects to be sent with this user
         *
         * @param data any number of Data objects
         * @return this builder instance
         */
        Builder data(Data... data);

        /**
         * Adds a publisher provided GDPR consent string to this User to be sent with a request
         *
         * @param consentString publisher provided GDPR consent string
         * @return this builder instance
         */
        Builder gdprConsentString(String consentString);

        /**
         * Set to true if the user has consented to the publisher's data policy
         *
         * @param didConsent true if gave consent [Default: false]
         * @return this builder instance
         */
        Builder gdprDidConsent(boolean didConsent);
    }

    /**
     * Definition of {@link User} with all public mutable fields
     */
    class MutableUser implements User {
        public Integer age;
        public String buyeruid;
        public Integer yob;
        public String gender;
        public String keywords;
        public String custom_data;
        public Data[] data;
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
