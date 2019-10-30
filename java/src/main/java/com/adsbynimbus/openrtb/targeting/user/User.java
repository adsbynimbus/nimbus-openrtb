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
     * {@link Gender}, where "Male" = male, "Female" = female, "O" = known to be other (i.e., omitted is unknown).
     */
    public Gender gender;

    /**
     * Comma separated list of keywords, interests, or intent.
     */
    public String keywords;

    /**
     * Optional feature to pass bidder data that was set in the exchange’s cookie. The string must be in base85 cookie
     * safe characters and be in any format. Proper JSON encoding must be used to include "escaped" quotation marks.
     */
    public String custom_data;

    /**
     * Additional user data. Each {@link Data} object represents a different data source.
     *
     * @see <a href="https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf#page=26">OpenRTB Section 3.2.21</a>
     */
    public Data[] data;

    /**
     * {@link User} extension object unique to Nimbus
     */
    public Extension ext;

    /**
     * {@link User} extentsion object used by Nimbus
     */
    public static class Extension {

        /**
         * Publisher provided GDPR consent string
         */
        public String consent;

        /**
         * Set to 1 if the user has consented to data tracking, 0 if the user has opted out of data tracking
         */
        public int did_consent;
    }

    /**
     * Builder for constructing a {@link User} object
     */
    public interface Builder {

        /**
         * Set the age of the user
         *
         * @param age the age of the user in years
         * @return this builder instance
         * @see #age
         */
        Builder age(int age);

        /**
         * Set the buyer id. If using Facebook this is the bidder token
         *
         * @param buyerUid set to the Facebook bidder token if using Facebook
         * @return this builder instance
         * @see #buyeruid
         */
        Builder buyerUid(String buyerUid);

        /**
         * Set the age of this user
         *
         * @param yob year of birth as a 4 digit int
         * @return this builder instance
         * @see #yob
         */
        Builder yearOfBirth(int yob);

        /**
         * Sets the gender of this user
         *
         * @param gender one of {@link Gender#MALE} or {@link Gender#FEMALE}
         * @return this builder instance
         * @see #gender
         */
        Builder gender(Gender gender);

        /**
         * Sets the keywords associated with this user
         *
         * @param keywords a comma delimited String of keywords
         * @return this builder instance
         * @see #keywords
         */
        Builder keywords(String keywords);

        /**
         * Set a String of custom data to be sent to Nimbus for this user
         *
         * @param customData a String representing some custom data
         * @return this builder instance
         * @see #custom_data
         */
        Builder customData(String customData);

        /**
         * Sets an array of Data objects to be sent with this user
         *
         * @param data any number of Data objects describing this user
         * @return this builder instance
         * @see #data
         * @see Data
         */
        Builder data(Data... data);

        /**
         * Adds a publisher provided GDPR consent String to this User to be sent with a request
         *
         * @param consent publisher provided GDPR consent String
         * @return this builder instance
         * @see Extension#consent
         */
        Builder gdprConsentString(String consent);

        /**
         * Set to true if the user has consented to the publisher's data policy
         *
         * @param didConsent true if gave consent [Default: false]
         * @return this builder instance
         * @see Extension#did_consent
         */
        Builder gdprDidConsent(boolean didConsent);
    }
}
