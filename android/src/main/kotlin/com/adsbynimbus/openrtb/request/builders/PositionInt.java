package com.adsbynimbus.openrtb.request.builders;

import androidx.annotation.IntDef;

import com.adsbynimbus.openrtb.request.Position;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({Position.POSITION_UNKNOWN, Position.ABOVE_THE_FOLD, Position.BELOW_THE_FOLD, Position.HEADER, Position.FOOTER,
        Position.SIDEBAR, Position.FULL_SCREEN})
public @interface PositionInt { }
