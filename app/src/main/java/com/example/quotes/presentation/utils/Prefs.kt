package com.example.quotes.presentation.utils

import android.content.SharedPreferences

class Prefs(private val preferences: SharedPreferences) {

    fun saveStateBoard() {
        preferences.edit().putBoolean("isShow", true).apply()
    }

    fun isBoardShow(): Boolean {
        return preferences.getBoolean("isShow", false)
    }

    fun saveUserName(name: String) {
        preferences.edit().putString("name", name).apply()
    }

    fun getUserName(): String? {
        return preferences.getString("name", "User")
    }

    fun saveUserSettings(list: MutableSet<String>) {
        preferences.edit().putStringSet("settings", list).apply()
    }

    fun getUserSettings(): MutableSet<String>? {
        return preferences.getStringSet("settings", null)
    }

    fun clearData() {
        preferences.edit().clear().apply()
    }
}