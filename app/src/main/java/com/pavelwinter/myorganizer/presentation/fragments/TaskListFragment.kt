package com.pavelwinter.myorganizer.presentation.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import com.pavelwinter.myorganizer.data.mocks.DataTypesGenerator
import com.pavelwinter.myorganizer.presentation.adapters.TasksAdapter
import com.pavelwinter.myorganizer.presentation.fragments.Forms.AddTaskFragment
import com.pavelwinter.myorganizer.presentation.view_models.TaskListViewModel
import kotlinx.android.synthetic.main.task_list_fragment.*

class TaskListFragment : BaseFragment() {

    private lateinit var taskViewModel: TaskListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        task_list_fragment_fab ?.setOnClickListener {
            goToAnotherFragment(AddTaskFragment(),null)
        }

        initViewModel()
        taskViewModel.loadData()
    }




    private fun initViewModel(){
        taskViewModel = ViewModelProviders.of(this).get(TaskListViewModel::class.java)

        val taskListObserver = Observer<List<ParentType>> { tasks ->
            if(tasks.isNotEmpty()) setupAdapter(tasks) else taskViewModel .loadData()
        }

        taskViewModel .tasksList .observe(this, taskListObserver)

    }




   private fun setupAdapter(itemsList : List<ParentType>){
        with(task_list_fragment_rv){
            adapter = TasksAdapter(itemsList)
            layoutManager = LinearLayoutManager(this@TaskListFragment.activity)
        }
    }

}
