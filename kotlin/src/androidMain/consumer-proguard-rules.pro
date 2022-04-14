-keepattributes RuntimeVisibleAnnotations,AnnotationDefault
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}
-keepclassmembers @kotlinx.serialization.Serializable class com.adsbynimbus.openrtb.** {
    *** Companion;
    *** INSTANCE;
    kotlinx.serialization.KSerializer serializer(...);
}

-if @kotlinx.serialization.Serializable class com.adsbynimbus.openrtb.**
-keepclassmembers class com.adsbynimbus.openrtb.<1>$Companion {
    kotlinx.serialization.KSerializer serializer(...);
}
