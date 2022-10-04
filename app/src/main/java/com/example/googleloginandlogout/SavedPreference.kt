package com.example.googleloginandlogout

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.util.prefs.Preferences

object SavedPreference {
    const val EMAIL = "email"
    const val USERNAME = "username"

    private fun getSharedPreference(ctx: Context?): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }

    private fun editor(context: Context, username: String, username1: String) {
        getSharedPreference(context)?.edit()?.putString(username, username1)?.apply()
    }

    fun getEmail(context: Context) = getSharedPreference(
        context
    )?.getString(EMAIL, "")

    fun setEmail(context: Context, email: String) {
        editor(
            context,
            EMAIL,
            email
        )
    }

    fun setUsername(context: Context, username: String) {
        editor(
            context,
            USERNAME,
            username
        )
    }

    fun getUsername(context: Context) = getSharedPreference(
        context
    )?.getString(USERNAME, "")

}