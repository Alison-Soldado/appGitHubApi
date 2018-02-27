package com.example.alison.appgithubapi.util

import android.content.Context

class PreferencesUtil(context: Context) {

    companion object {
        const val USER_INFORMATION = "USER_INFORMATION"
    }

    val prefs = context.getSharedPreferences(USER_INFORMATION, 0)

    fun setSP(key: String, value: Any) {
        val editablePrefs = prefs.edit()
        when(value) {
            is String -> editablePrefs.putString(key, value)
            is Int -> editablePrefs.putInt(key, value)
            is Boolean -> editablePrefs.putBoolean(key, value)
            else -> throw IllegalArgumentException("This type cannot be saved")
        }.also {
            editablePrefs.apply()
        }
    }

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T> getSP(key: String): T {
        return when(T::class) {
            String::class, CharSequence::class -> prefs.getString(key, "")
            Boolean::class, Boolean::class -> prefs.getBoolean(key, false)
            else -> throw RuntimeException("This type cannot be saved")
        } as T
    }

    fun clearSP() {
        val prefsClear = prefs.edit()
        prefsClear.clear()
        prefsClear.apply()
    }
}