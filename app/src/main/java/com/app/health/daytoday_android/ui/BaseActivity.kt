package com.app.health.daytoday_android.ui

import android.support.v7.app.AppCompatActivity
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

abstract class BaseActivity : AppCompatActivity() ,BaseActivityContract {


    override fun getSchedule(): Scheduler {
        return  AndroidSchedulers.mainThread()
    }



}

interface BaseActivityContract{

    fun getSchedule():Scheduler
}
