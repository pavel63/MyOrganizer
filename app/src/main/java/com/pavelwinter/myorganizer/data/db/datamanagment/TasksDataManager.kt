package com.pavelwinter.myorganizer.data.db.datamanagment

import com.pavelwinter.myorganizer.data.db.db_entities.TaskE
import com.pavelwinter.myorganizer.data.db.db_entities.TaskEDao
import com.pavelwinter.myorganizer.presentation.utils.App
import java.util.ArrayList

class TasksDataManager: IDbDataManager<TaskE> {

    private var taskEDao : TaskEDao ?= null

    init {
        taskEDao = App.session ?.taskEDao
    }



    override fun addObject(taskE: TaskE) {
        taskEDao ?.insertOrReplace(taskE)

    }




    fun getTaskList():List<TaskE>?{
            val taskQueryBuilder = taskEDao
                ?.queryBuilder()
            taskQueryBuilder ?.build()
            return taskQueryBuilder ?.list() ?.toList()
    }




    override fun updateObject(id :Long, taskeE: TaskE) {
            val taskQueryBuilder = taskEDao ?.queryBuilder()
                ?.where(TaskEDao.Properties._id.eq(id))
            taskQueryBuilder ?.build()
            val taskList = taskQueryBuilder ?.list()

            if (!taskList .isNullOrEmpty()) {
                val taskIds = taskList[0]
                taskIds ._id = id
                taskEDao ?.update(taskeE)
            }
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