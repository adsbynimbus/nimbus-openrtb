package com.adsbynimbus.openrtb.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

/**
 *  This object represents a native asset object, which is the main container
 *  for each asset requested or supported by Exchange on behalf of the rendering client.
 *
 *  [OpenRTB Native Ads 1.2](https://www.iab.com/wp-content/uploads/2018/03/OpenRTB-Native-Ads-Specification-Final-1.2.pdf)
 */
@Serializable
public class Asset (
    @JvmField @SerialName("id") public var id: Int,
    @JvmField @SerialName("required") public var required: Byte,
    @JvmField @SerialName("ext") public var ext: Map<String, String>? = null,
    @JvmField @SerialName("title") public var title: TitleObject? = null,
    @JvmField @SerialName("img") public var img: ImageObject? = null,
    @JvmField @SerialName("video") public var video: VideoObject? = null,
    @JvmField @SerialName("data") public var data: DataObject? = null,
){
    @Serializable
    public class TitleObject(
        @JvmField @SerialName("len") public var length: Int
    )
    @Serializable
    public class ImageObject(
         @JvmField @SerialName("type") public var type: Byte,
         @JvmField @SerialName("w") public var w: Int? = null,
         @JvmField @SerialName("h") public var h: Int? = null,
         @JvmField @SerialName("hmin") public var hmin: Int? = null,
         @JvmField @SerialName("wmin") public var wmin: Int? = null,
    )
    @Serializable
    public class VideoObject(
        @JvmField @SerialName("mimes") public var mimes: Array<String>? = null,
        @JvmField @SerialName("minduration") public var minduration: Int = 0,
        @JvmField @SerialName("maxduration") public var maxduration: Int = 60,
        @JvmField @SerialName("protocols") public var protocols: ByteArray? = null,
    )
    @Serializable
    public class DataObject(
        @JvmField @SerialName("type") public var type: Byte,
        @JvmField @SerialName("len") public var len: Int,
    )
}
