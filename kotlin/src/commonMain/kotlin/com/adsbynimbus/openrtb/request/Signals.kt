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
    @JvmField @SerialName("session") public var session: Session = Session(),
)

/**
 * Session related signals as used by Nimbus
 * @property depth Depth of the request
 * @property duration represents the duration in seconds since this session has started
 */
@Serializable
public class Session(
    @JvmField @SerialName("depth") public var depth: Int = 0,
    @JvmField @SerialName("duration") public var duration: Long = 0,
)
