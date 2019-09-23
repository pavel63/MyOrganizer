package com.pavelwinter.myorganizer.data.db.datamanagment

import com.pavelwinter.myorganizer.data.db.db_entities.QuotaE
import com.pavelwinter.myorganizer.data.db.db_entities.QuotaEDao
import com.pavelwinter.myorganizer.presentation.utils.App

class QuotasDataManager: IDbDataManager<QuotaE> {

        private var quotaDao : QuotaEDao?= null

        init {
            quotaDao = App.session ?.quotaEDao
        }



        override fun addObject(quotaE: QuotaE) {
            quotaDao ?.insertOrReplace(quotaE)

        }




        fun getQuotasList():List<QuotaE>?{
            val quotaQueryBuilder = quotaDao
                ?.queryBuilder()
            quotaQueryBuilder ?.build()
            return quotaQueryBuilder ?.list() ?.toList()
        }




        override fun updateObject(id :Long, quotaE: QuotaE) {
            val quotaQueryBuilder = quotaDao ?.queryBuilder()
                ?.where(QuotaEDao.Properties._id.eq(id))
            quotaQueryBuilder ?.build()
            val quotaList = quotaQueryBuilder ?.list()

            if (!quotaList .isNullOrEmpty()) {
                val quotaIds = quotaList[0]
                quotaIds ._id = id
                quotaDao ?.update(quotaE)
            }
        }




        override fun deleteObject(id: Int) {
            val quotasIdsQueryBuilder = quotaDao ?.queryBuilder()
                ?.where(QuotaEDao.Properties._id.eq(id))
            quotasIdsQueryBuilder ?.build()
            val quotaIdsList = quotasIdsQueryBuilder ?.list()
            if(!quotaIdsList .isNullOrEmpty()){
                quotaDao ?.delete(quotaIdsList[0])
            }
        }
    }
