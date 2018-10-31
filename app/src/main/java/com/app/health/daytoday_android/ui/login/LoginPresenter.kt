package com.app.health.daytoday_android.ui.login

import android.content.Context
import android.util.Log
import com.app.health.daytoday_android.framework.PreferenceManager
import com.app.health.daytoday_android.framework.UserGenerator
import com.app.health.daytoday_android.ui.BaseActivityContract
import com.app.health.daytoday_android.ui.BasePresenter
import health.daytoday.com.app.data.repositories.GetUserRepositoryContract
import health.daytoday.com.app.domain.Github
import health.daytoday.com.app.domain.User
import health.daytoday.com.app.usecases.GetUserFromDb
import health.daytoday.com.app.usecases.GetUserRepositories
import health.daytoday.com.app.usecases.LoginPresenterContract
import health.daytoday.com.app.usecases.LoginUser
import org.json.JSONObject

class LoginPresenter(
        private val view : View,
        private val userGenerator: UserGenerator
    ) : BasePresenter() , LoginPresenterContract , GetUserRepositoryContract {


    override fun manageGithubResult(result: Github) {
        val values: String = "Hola mundo";
        PreferenceManager.saveUserData(values, view.getContextFromActivity())
        println("holamundo")
        val retunrData: String? = PreferenceManager.getUserData(view.getContextFromActivity())
        Log.i("","")
    }

    override fun manageError(message: String?) {
        println("Holamundo2")
    }


    override fun loginUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    interface View : BaseActivityContract {

        fun showErrorMessage(message:String)

        fun successLogin(user: User)

        fun getContextFromActivity() : Context

    }



    fun getUser(){

        val getUserFromDbUseCase = GetUserFromDb(userGenerator)
        view.successLogin(getUserFromDbUseCase.invoke())

    }

    fun loginUser(username : String, password : String){
        val loginUserUseCase = LoginUser (this, username,password)
        loginUserUseCase.invoke()
    }

    fun findUserRepositories(username : String){

        
        val getUserRepositories = GetUserRepositories(username,view.getSchedule(),this)
        getUserRepositories.invoke()

    }

}
