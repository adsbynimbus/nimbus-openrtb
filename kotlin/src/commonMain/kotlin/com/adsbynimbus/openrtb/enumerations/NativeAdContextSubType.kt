package com.adsbynimbus.openrtb.enumerations

public object NativeAdContextSubType {
    public val GENERALORMIXED: Byte = 10 // General or mixed content
    public val ARTICLE: Byte = 11 // Primarily article content (which of course could include images, etc as part of the article)
    public val VIDEO: Byte = 12// Primarily video content
    public val AUDIO: Byte = 13 // Primarily audio content
    public val IMAGE: Byte = 14 // Primarily image content
    public val USERGENERATED: Byte = 15 // User-generated content - forums, comments, etc
    public val SOCIAL: Byte = 20 // General social content such as a general social network
    public val EMAIL: Byte = 21 // Primarily email content
    public val CHAT: Byte = 22 // Primarily chat/IM content
    public val SALES: Byte = 30 //  Content focused on selling products, whether digital or physical
    public val APPSTORE: Byte = 31 // Application store/marketplace
    public val PRODUCTREVIEWS: Byte = 32 // Product reviews site primarily (which may sell product secondarily)
}
