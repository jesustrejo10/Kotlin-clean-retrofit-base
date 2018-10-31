package com.app.health.daytoday_android.ui.login

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.health.daytoday_android.R
import com.app.health.daytoday_android.framework.UserGenerator
import com.app.health.daytoday_android.ui.BaseActivity
import health.daytoday.com.app.domain.User
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_login2.*

/**
 * All Activities are cataloged like a "View", so it need to implement a contract to pass it
 * instance to the presenter. so the presenter can invoke the methods that it have access.
 */
class LoginActivity : BaseActivity() , LoginPresenter.View, View.OnClickListener {
    override fun getContextFromActivity(): Context {
        return applicationContext
    }


    override fun onClick(p0: View?) {

        when(p0?.id){
            R.id.button -> {
                presenter.getUser()
            }
        }

    }

    var presenter : LoginPresenter

    /**
     * This method will be triggered before the constructor.
     * Here we are going to Instance the Presenter and other stuffs.
     */
    init{
        val userGenerator = UserGenerator()
        presenter = LoginPresenter(this, userGenerator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        button.setOnClickListener(this)
        val email = "ofarinez+1@gmail.com"
        val password = "tera1234"

        //presenter.loginUser(email,password)
        presenter.findUserRepositories("jesustrejo10")


    }

    override fun showErrorMessage(message: String) {
    }

    override fun successLogin(user: User) {
        println(user.name)
        println(user.id)
    }


}
