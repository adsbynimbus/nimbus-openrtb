package com.adsbynimbus.openrtb.targeting.user;

import com.adsbynimbus.openrtb.targeting.Data;

/**
 * This object contains information known or derived about the human user of the device (i.e., the
 * audience for advertising). The user id is an exchange artifact and may be subject to rotation or other
 * privacy policies. However, this user ID must be stable long enough to serve reasonably as the basis for
 * frequency capping and retargeting.
 */
public class User {

    public static final String AGE = "age"; // Integer
    public static final String BUYER_UID = "buyeruid";
    public static final String YEAR_OF_BIRTH = "yob"; // Integer
    public static final String GENDER = "gender";
    public static final String KEYWORDS = "keywords";
    public static final String CUSTOM_DATA = "custom_data";
    public static final String DATA = "data";

    // Gender Consts
    public static final String MALE = "Male";
    public static final String FEMALE = "Female";

    public Integer age;
    public String buyeruid;
    public Integer yob;
    public String gender;
    public String keywords;
    public String custom_data;
    public Data[] data;
    public Extension ext;

    /**
     * User 'ext' object used by Nimbus
     */
    public static class Extension {
        public static final String CONSENT = "consent";
        public static final String DID_CONSENT = "did_consent"; // int

        public String consent;
        public int did_consent;
    }

    /**
     * Builder for constructing a {@link User} object
     */
    public interface Builder {

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
         * @param keywords a comma delimited String of keywords
         * @return this builder instance
         */
        Builder keywords(String keywords);

        /**
         * Set a String of custom data to be sent to Nimbus for this user
         *
         * @param customData a String representing some custom data
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
         * Adds a publisher provided GDPR consent String to this User to be sent with a request
         *
         * @param consent publisher provided GDPR consent String
         * @return this builder instance
         */
        Builder gdprConsentString(String consent);

        /**
         * Set to true if the user has consented to the publisher's data policy
         *
         * @param didConsent true if gave consent [Default: false]
         * @return this builder instance
         */
        Builder gdprDidConsent(boolean didConsent);
    }
}
