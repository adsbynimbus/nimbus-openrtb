package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.IntDef;

import com.adsbynimbus.openrtb.request.CreativeAttribute;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({CreativeAttribute.AUDIO_AD_AUTO_PLAY, CreativeAttribute.AUDIO_AD_USER_INITIATED,
        CreativeAttribute.EXPANDABLE_AUTOMATIC, CreativeAttribute.EXPANDABLE_USER_CLICK,
        CreativeAttribute.EXPANDABLE_USER_ROLLOVER, CreativeAttribute.BANNER_VIDEO_AUTO_PLAY,
        CreativeAttribute.BANNER_VIDEO_USER_INITIATED, CreativeAttribute.HAS_POPUP,
        CreativeAttribute.PROVOCATIVE_OR_SUGGESTIVE, CreativeAttribute.EXTREME_ANIMATION,
        CreativeAttribute.SURVEYS, CreativeAttribute.TEXT_ONLY, CreativeAttribute.USER_INTERACTIVE_AND_GAMES,
        CreativeAttribute.DIALOG_OR_ALERT_STYLE, CreativeAttribute.HAS_VOLUME_TOGGLE,
        CreativeAttribute.HAS_SKIP_BUTTON, CreativeAttribute.ADOBE_FLASH})
public @interface CreativeAttributeInt { }
