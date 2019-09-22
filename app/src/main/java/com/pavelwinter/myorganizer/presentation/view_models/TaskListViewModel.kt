package com.pavelwinter.myorganizer.presentation.view_models

import androidx.lifecycle.MutableLiveData
import com.pavelwinter.myorganizer.data.MainRepository
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType

class TaskListViewModel : ParentViewModel() {

    val tasksList : MutableLiveData<List<ParentType>> by lazy {
        MutableLiveData<List<ParentType>>()
    }



    fun loadData(){
       tasksList.value = sortListByPriority(MainRepository.getMockRepository().generateParentList())
    }

}
