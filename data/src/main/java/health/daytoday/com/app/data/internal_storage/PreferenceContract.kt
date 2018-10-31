package health.daytoday.com.app.data.internal_storage

import health.daytoday.com.app.domain.Github

interface PreferenceContract {

    fun saveUserInSharedPref(user : Github)
    fun getUserFromSharedPreference(): String?
}