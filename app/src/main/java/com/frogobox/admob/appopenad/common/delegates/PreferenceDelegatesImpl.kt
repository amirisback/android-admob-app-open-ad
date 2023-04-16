package com.frogobox.admob.appopenad.common.delegates

import android.content.Context
import android.content.SharedPreferences
import com.frogobox.admob.appopenad.util.Constant.PREF_NAME
import com.frogobox.admob.appopenad.util.singleGetSharedPreferences


/**
 * Created by faisalamir on 01/07/22
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.
 * All rights reserved
 *
 */

class PreferenceDelegatesImpl(context: Context) : PreferenceDelegates {

    companion object {
        val TAG: String = PreferenceDelegatesImpl::class.java.simpleName
    }

    private val sharedPreferences: SharedPreferences = context.singleGetSharedPreferences(PREF_NAME)
    private val prefEditor: SharedPreferences.Editor = sharedPreferences.edit()

    override fun savePrefFloat(key: String, value: Float) {
        prefEditor.putFloat(key, value).apply()
    }

    override fun savePrefInt(key: String, value: Int) {
        prefEditor.putInt(key, value).apply()
    }

    override fun savePrefString(key: String, value: String) {
        prefEditor.putString(key, value).apply()
    }

    override fun savePrefBoolean(key: String, value: Boolean) {
        prefEditor.putBoolean(key, value).apply()
    }

    override fun savePrefLong(key: String, value: Long) {
        prefEditor.putLong(key, value).apply()
    }

    override fun deletePref(key: String) {
        prefEditor.remove(key).apply()
    }

    override fun nukePref() {
        prefEditor.clear().apply()
    }

    override fun loadPrefFloat(key: String): Float {
        return sharedPreferences.getFloat(key, 0f)
    }

    override fun loadPrefFloat(key: String, defaultValue: Float): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    override fun loadPrefString(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }

    override fun loadPrefString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    override fun loadPrefInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    override fun loadPrefInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    override fun loadPrefLong(key: String): Long {
        return sharedPreferences.getLong(key, 0)
    }

    override fun loadPrefLong(key: String, defaultValue: Long): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    override fun loadPrefBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    override fun loadPrefBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    // Please Add Your Code Under This Line --------------------------------------------------------

}