package com.pavelwinter.myorganizer.presentation.utils

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.facebook.stetho.Stetho
import com.pavelwinter.myorganizer.BuildConfig
import com.pavelwinter.myorganizer.data.db.db_entities.DaoMaster
import com.pavelwinter.myorganizer.data.db.db_entities.DaoSession
import timber.log.Timber


class App :Application() {

    lateinit var daoSession : DaoSession

    // for vector drawable compativity pre-lollipiop version
    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }


    override fun onCreate() {
        super.onCreate()

        initGreendaoDb()

        Stetho.initializeWithDefaults(this)

        //Setup logs by Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }



    private fun initGreendaoDb(){
        val helper = DaoMaster.DevOpenHelper(this, "mydatabase.db")
        val db = helper.writableDb
       // daoSession = DaoMaster(db).newSession()
        AppCompanion.session = DaoMaster(db).newSession()
    }



    companion object AppCompanion{
        var session : DaoSession ?=null
    }

}