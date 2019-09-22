package com.pavelwinter.myorganizer.data

import com.pavelwinter.myorganizer.data.db.db_entities.DaoSession
import com.pavelwinter.myorganizer.data.mocks.DataTypesGenerator
import com.pavelwinter.myorganizer.presentation.utils.App

object MainRepository : IMainRepository{
    override fun getSharedPrefsRepository() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDb () : DaoSession{
        return App().daoSession
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun getMockRepository() = DataTypesGenerator
}