package com.adsbynimbus.openrtb.android;

import androidx.annotation.IntDef;

import com.adsbynimbus.openrtb.request.Api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({Api.VPAID_1, Api.VPAID_2, Api.MRAID_1, Api.ORMMA, Api.MRAID_2, Api.MRAID_3})
public @interface ApiInt { }
