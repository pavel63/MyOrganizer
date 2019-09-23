package com.pavelwinter.myorganizer.data.di

import com.pavelwinter.myorganizer.data.db.datamanagment.TasksDataManager
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun provideTaskDataManager():TasksDataManager{
    return TasksDataManager()
    }

}