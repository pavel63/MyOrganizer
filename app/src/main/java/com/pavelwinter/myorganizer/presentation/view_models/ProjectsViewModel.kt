package com.pavelwinter.myorganizer.presentation.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavelwinter.myorganizer.data.MainRepository
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType

class ProjectsViewModel : ViewModel() {

    val projectsList : MutableLiveData<List<ParentType>> by lazy {
        MutableLiveData<List<ParentType>>()
    }



    fun loadData(){
      projectsList .value = MainRepository.getMockRepository().generateParentList()
    }

}
