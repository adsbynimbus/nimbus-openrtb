package com.adsbynimbus.openrtb.targeting.user;

import com.adsbynimbus.openrtb.targeting.Data;

/**
 * This object contains information known or derived about the human user of the device (i.e., the
 * audience for advertising). The user id is an exchange artifact and may be subject to rotation or other
 * privacy policies. However, this user ID must be stable long enough to serve reasonably as the basis for
 * frequency capping and retargeting.
 *
 * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=25">OpenRTB Section 3.2.20</a>
 */
public class User {

    /**
     * Gender of this User
     */
    public enum Gender {

        /**
         * Male
         */
        MALE("Male"),

        /**
         * Female
         */
        FEMALE("Female"),

        /**
         * Other
         */
        OTHER("O");

        public final String value;

        Gender(String value) {
            this.value = value;
        }
    }

    /**
     * Optional age of the user
     */
    public Integer age;

    /**
     * Buyer-specific ID for the user as mapped by the exchange for the buyer. Set to Facebook bidder token if
     * integrating Facebook demand
     */
    public String buyeruid;

    /**
     * Year of birth as a 4-digit integer
     */
    public Integer yob;

    /**
     * Gender, where “Male” = male, “Female” = female, “O” = known to be other (i.e., omitted is unknown).
     */
    public Gender gender;
    public String keywords;
    public String custom_data;
    public Data[] data;
    public Extension ext;

    /**
     * User 'ext' object used by Nimbus
     */
    public static class Extension {

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
         * @param gender Male or Female
         * @return this builder instance
         */
        Builder gender(Gender gender);

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
