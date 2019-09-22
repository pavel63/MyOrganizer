package com.pavelwinter.myorganizer.presentation.view_models

import androidx.lifecycle.MutableLiveData
import com.pavelwinter.myorganizer.data.MainRepository
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType

class QuotaViewModel : ParentViewModel() {

    val quotaList : MutableLiveData<List<ParentType>> by lazy {
        MutableLiveData<List<ParentType>>()
    }


    fun loadData(){
       quotaList .value = sortListByPercentDone(MainRepository.getMockRepository() .generateParentList())
    }
}
