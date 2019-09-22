package com.pavelwinter.myorganizer.presentation.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import com.pavelwinter.myorganizer.data.mocks.DataTypesGenerator
import com.pavelwinter.myorganizer.presentation.adapters.ProjectsAdapter
import com.pavelwinter.myorganizer.presentation.fragments.Forms.AddProjectFragment
import com.pavelwinter.myorganizer.presentation.view_models.ProjectsViewModel
import kotlinx.android.synthetic.main.projects_fragment.*

class ProjectsFragment : BaseFragment() {

    private lateinit var viewModel: ProjectsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.projects_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        projects_fragment_fab ?.setOnClickListener {
            goToAnotherFragment(AddProjectFragment(),null)
        }

        viewModel = ViewModelProviders.of(this).get(ProjectsViewModel::class.java)
        setupAdapter(DataTypesGenerator.generateParentList())
    }


    private fun setupAdapter(projectsFragment: List<ParentType>) {
        with(projects_fragment_rv) {
            adapter = ProjectsAdapter(projectsFragment)
            layoutManager = LinearLayoutManager(this@ProjectsFragment.activity)
        }
    }

}
