package com.pavelwinter.myorganizer.presentation.view_models

import androidx.lifecycle.ViewModel
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType

 open class ParentViewModel : ViewModel() {

    fun sortListByPriority (listParent : List<ParentType>) = listParent .sortedBy { it.priority }


    fun sortListByPercentDone (listParent : List<ParentType>) = listParent .sortedByDescending { it.percentDone }

}