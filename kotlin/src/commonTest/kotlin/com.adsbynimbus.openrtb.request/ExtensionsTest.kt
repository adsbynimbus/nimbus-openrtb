package com.adsbynimbus.openrtb.request

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExtensionsTest : StringSpec({

    val user = User()

    "When adding values to an Extension, previous values are preserved" {
        user.unity_buyeruid shouldBe null
        user.unity_buyeruid = "test_buyer_id"
        user.consent = "consent_string"
        user.unity_buyeruid shouldBe "test_buyer_id"
        user.consent shouldBe "consent_string"
    }
})
