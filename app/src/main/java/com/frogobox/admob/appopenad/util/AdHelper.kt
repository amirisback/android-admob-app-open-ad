package com.frogobox.admob.appopenad.util

import android.content.Context
import com.frogobox.admob.appopenad.common.delegates.PreferenceDelegatesImpl

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


object AdHelper {

    fun getAdOpenAppUnitId(context: Context?): String {
        return if (context != null) {
            PreferenceDelegatesImpl(context).loadPrefString(Constant.PREF_AD_UNIT_ID, Constant.AD_UNIT_ID)
        } else {
            Constant.AD_UNIT_ID
        }
    }

}