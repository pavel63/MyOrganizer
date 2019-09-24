package com.pavelwinter.myorganizer.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.pavelwinter.myorganizer.presentation.fragments.ProjectsFragment
import com.pavelwinter.myorganizer.presentation.fragments.QuotaFragment
import com.pavelwinter.myorganizer.presentation.fragments.TaskListFragment
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.pavelwinter.myorganizer.R.layout.activity_main)

        bottomNavigationInit()
    }



    private fun bottomNavigationInit() {
        bnve?.enableAnimation(false)
        bnve?.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        bnve?.setTextSize(10.0f)
        bnve?.setIconSize(24f, 24f)

        goToFragment(TaskListFragment())
        bnve ?.currentItem = 0

        bnve?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                com.pavelwinter.myorganizer.R.id.bottom_navigation_list_m -> {
                    if (getVisibleFragment() !is TaskListFragment) {
                        item.isChecked = true
                        goToFragment(TaskListFragment())
                    }
                }

                com.pavelwinter.myorganizer.R.id.bottom_navigation_projects_m -> {
                    if (getVisibleFragment() !is ProjectsFragment) {
                        item.isChecked = true
                        goToFragment(ProjectsFragment())
                    }
                }

                com.pavelwinter.myorganizer.R.id.bottom_navigation_quotas_m -> {
                    if (getVisibleFragment() !is QuotaFragment) {
                        item.isChecked = true
                        goToFragment(QuotaFragment())
                    }
                }
            }
            true
        }
    }




    private fun goToFragment(fragmentTo: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(com.pavelwinter.myorganizer.R.id.nav_host_fragment, fragmentTo)
            .commit()
    }



    private fun getVisibleFragment(): Fragment? {
        try {
            val fragmentManager = supportFragmentManager
            val fragments = fragmentManager?.fragments
            if (!fragments.isNullOrEmpty()) {
                for (fragment in fragments) {
                    if (fragment != null && fragment.isVisible)
                        Timber.d("===CURRENT FRAGMENT ${fragment.javaClass}")
                    Timber.d("===CURRENT FRAGMENT simple name${fragment?.javaClass?.simpleName}")
                    Timber.d("===FRAGM TAG ${fragment.tag}")
                    return fragment
                }
            }
            return null
        } catch (throwable: Throwable) {
            return null
        }
    }

}
