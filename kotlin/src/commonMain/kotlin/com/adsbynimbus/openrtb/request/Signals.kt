package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 * Custom signals for this request
 * @property session Session related signals as used by Nimbus
 */
@Serializable
public class Signals(
    @JvmField @SerialName("session") public val session: MutableMap<String, String> = mutableMapOf(),
) {
    public inline var depth: Int
        get() = session["depth"]?.toIntOrNull() ?: 0
        set(value) { session["depth"] = value.coerceAtLeast(0).toString() }

    public inline var duration: Int
        get() = session["duration"]?.toIntOrNull() ?: 0
        set(value) { session["duration"] = value.coerceAtLeast(0).toString() }
}
