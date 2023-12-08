package com.adsbynimbus.openrtb.enumerations

public object NativeAdContext {
    public const val CONTENT: Byte = 1 // Content-centric context such as newsfeed, article, image gallery, video gallery, or similar.
    public const val SOCIAL: Byte = 2 // Social-centric context such as social network feed, email, chat, or similar.
    public const val PRODUCT: Byte = 3 // Product context such as product listings, details, recommendations, reviews, or similar.
}
