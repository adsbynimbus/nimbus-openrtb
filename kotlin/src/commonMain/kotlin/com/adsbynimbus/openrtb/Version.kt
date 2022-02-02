@file:JvmName("OpenRTB")
@file:JvmMultifileClass

package com.adsbynimbus.openrtb

import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/** Required header for all requests to Nimbus defining the OpenRTB version */
public const val OPENRTB_HEADER: String = "x-openrtb-version"

/** The current supported OpenRTB version by this request object */
public const val OPENRTB_VERSION: String = "2.5"
