package com.adsbynimbus.openrtb.user;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

public interface User {

    String AGE = "age"; // Integer
    String BUYER_UID = "buyeruid";
    String YEAR_OF_BIRTH = "yob"; // Integer
    String GENDER = "gender";

    // Gender Consts
    String MALE = "Male";
    String FEMALE = "Female";

    // Nimbus Extensions
    String CONSENT = "consent";
    String DID_CONSENT = "did_consent"; // int

    interface Builder extends NimbusRTB.Builder {

        default User build() {
            final Map values = getValues();
            return new User() {
                public final Integer age = (Integer) values.get(AGE);
                public final String buyeruid = (String) values.get(BUYER_UID);
                public final Integer yob = (Integer) values.get(YEAR_OF_BIRTH);
                public final String gender = (String) values.get(GENDER);
                public final Object ext =
                        values.containsKey(CONSENT) || values.containsKey(DID_CONSENT) ? new Object() {
                            public final String consent = (String) values.get(CONSENT);
                            public final int did_consent =
                                    (int) (values.containsKey(DID_CONSENT) ? values.get(DID_CONSENT) : 0);
                        } : null;
            };
        }
    }
}
