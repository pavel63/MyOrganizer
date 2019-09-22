package com.pavelwinter.myorganizer.data.db.datamanagment

import com.pavelwinter.myorganizer.data.db.db_entities.TaskE
import com.pavelwinter.myorganizer.data.db.db_entities.TaskEDao
import com.pavelwinter.myorganizer.presentation.utils.App

class TasksDataManager: IDbDataManager<TaskE> {

     var taskEDao : TaskEDao ?= null

    init {
        taskEDao = App().daoSession.taskEDao
    }

    override fun addObject(taskE: TaskE) {
        taskEDao ?.insertOrReplace(taskE)

    }


    override fun deleteObject(id: Int) {
        val taskIdsQueryBuilder = taskEDao ?.queryBuilder()
            ?.where(TaskEDao.Properties._id.eq(id))
        taskIdsQueryBuilder ?.build()
        val taskIdsList = taskIdsQueryBuilder ?.list()
        if(!taskIdsList .isNullOrEmpty()){
            taskEDao ?.delete(taskIdsList[0])
        }
    }
}