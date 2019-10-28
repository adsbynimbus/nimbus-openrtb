package com.adsbynimbus.openrtb.impression;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({Position.POSITION_UNKNOWN, Position.ABOVE_THE_FOLD, Position.BELOW_THE_FOLD, Position.HEADER, Position.FOOTER,
        Position.SIDEBAR, Position.FULL_SCREEN})
public @interface PositionInt { }
