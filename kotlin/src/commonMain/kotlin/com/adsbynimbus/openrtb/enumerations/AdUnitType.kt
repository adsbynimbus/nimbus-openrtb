package com.adsbynimbus.openrtb.enumerations

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = AdUnitTypeSerializer::class)
public enum class AdUnitType(public val value: Int) {
    /** Unknown ad unit type. */
    Unknown(0),

    /**
     * Inline represents banner ads typically sized at or below 300x250.
     * Common dimensions include 300x250, 300x50, 320x50, 320x100, and 728x90.
     * It May also include video ads when the placementType is set to "inline".
     */
    Inline(1),

    /** Interstitial represents full-screen, blocking ads, typically sized at 320x480. */
    Interstitial(2),

    /**
     * Rewarded represents ads that grant a reward to users upon completion.
     * While often video-based, the format is not limited to video.
     * For video ads, users are typically required to watch to completion; behavior for other formats is still to be defined.
     */
    Rewarded(3),

    /**
     * Native represents native ads, where the ad UI is constructed client-side by the publisher.
     * These ads are typically non-blocking and styled to match the app’s content.
     * Currently used as a placeholder, as official support may vary.
     */
    Native(4),

    /**
     * Dynamic represents Nimbus’s proprietary dynamic ad unit.
     * It simultaneously requests RTB Banner, RTB Video, and occasionally RTB Native creatives.
     * This unit is typically displayed inline, which distinguishes it from interstitial units.
     */
    Dynamic(5);

    internal companion object {
        fun fromValue(value: Int): AdUnitType = when (value) {
            1 -> Inline
            2 -> Interstitial
            3 -> Rewarded
            4 -> Native
            5 -> Dynamic
            else -> Unknown
        }
    }
}

internal class AdUnitTypeSerializer() : KSerializer<AdUnitType> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("AdUnitType", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: AdUnitType, ) = encoder.encodeInt(value.value)
    override fun deserialize(decoder: Decoder): AdUnitType = AdUnitType.fromValue(decoder.decodeInt())
}
