package com.pavelwinter.myorganizer.data.db.datamanagment

import com.pavelwinter.myorganizer.data.db.db_entities.ProjectE
import com.pavelwinter.myorganizer.data.db.db_entities.ProjectEDao
import com.pavelwinter.myorganizer.data.db.db_entities.TaskEDao
import com.pavelwinter.myorganizer.presentation.utils.App


class ProjectsDataManager: IDbDataManager<ProjectE> {

        private var projectsDao : ProjectEDao?= null

        init {
            projectsDao = App.session ?.projectEDao
        }



        override fun addObject(projectEDao: ProjectE) {
            projectsDao ?.insertOrReplace(projectEDao)

        }




        fun getProjectsList():List<ProjectE>?{
            val projectsQueryBuilder = projectsDao
                ?.queryBuilder()
            projectsQueryBuilder ?.build()
            return projectsQueryBuilder ?.list() ?.toList()
        }




        override fun updateObject(id :Long, projectE: ProjectE) {
            val projectsQueryBuilder = projectsDao ?.queryBuilder()
                ?.where(ProjectEDao.Properties._id.eq(id))
            projectsQueryBuilder ?.build()
            val projectsList = projectsQueryBuilder ?.list()

            if (!projectsList .isNullOrEmpty()) {
                val projectsIds = projectsList[0]
                projectsIds ._id = id
                projectsDao ?.update(projectE)
            }
        }




        override fun deleteObject(id: Int) {
            val projectsIdsQueryBuilder = projectsDao ?.queryBuilder()
                ?.where(ProjectEDao.Properties._id.eq(id))
            projectsIdsQueryBuilder ?.build()
            val projectIdsList = projectsIdsQueryBuilder ?.list()
            if(!projectIdsList .isNullOrEmpty()){
                projectsDao ?.delete(projectIdsList[0])
            }
        }
    }
