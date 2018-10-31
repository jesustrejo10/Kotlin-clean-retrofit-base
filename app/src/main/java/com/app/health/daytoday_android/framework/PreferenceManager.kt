package com.app.health.daytoday_android.framework

import android.content.Context
import android.content.SharedPreferences
import android.util.Base64
import com.app.health.daytoday_android.R
import health.daytoday.com.app.data.internal_storage.PreferenceContract
import health.daytoday.com.app.domain.Github
import org.json.JSONObject

class PreferenceManager(
        private val context : Context
) : PreferenceContract {
    override fun getUserFromSharedPreference(): String? {
       return getUserData(context)
    }


    override fun saveUserInSharedPref(user: Github) {
          saveUserData(user.toString(),context)
    }

    companion object {

        fun encrypt(input: String): String {
            // This is base64 encoding, which is not an encryption
            return Base64.encodeToString(input.toByteArray(), Base64.DEFAULT)
        }

        fun decrypt(input: String): String {
            return String(Base64.decode(input, Base64.DEFAULT))
        }
        fun saveUserData(obj: String, ctx: Context){
            if (obj==null)
                return
            val fileName=ctx.resources.getString(R.string.key_sharedp)
            val key=ctx.resources.getString(R.string.key_sharedp)
            val sharedPreferencesUtil =ctx.getSharedPreferences(fileName, Context.MODE_PRIVATE)
            val editor = sharedPreferencesUtil.edit();
            editor.putString(encrypt(key), encrypt(obj));
            editor.apply();
        }



        fun cleanUserData( ctx: Context): Boolean {
            val fileName=ctx.resources.getString(R.string.key_sharedp)
            val sharedPreferencesUtil =ctx.getSharedPreferences(fileName, Context.MODE_PRIVATE)
            return  sharedPreferencesUtil.edit().clear().commit()
        }

        fun getUserData(ctx: Context): String? {
            var returnData: String;
            val fileName=ctx.resources.getString(R.string.key_sharedp)
            val key=ctx.resources.getString(R.string.key_sharedp)
            val sharedPreferencesUtil =ctx.getSharedPreferences(fileName, Context.MODE_PRIVATE)
            var userData: String = sharedPreferencesUtil.getString(encrypt(key), encrypt("default"))
            if (userData.isNullOrEmpty()){
                return null
            }else{

                returnData = decrypt(userData);
            }

            return returnData
        }
    }


}

