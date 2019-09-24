package com.pavelwinter.myorganizer.presentation.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import com.pavelwinter.myorganizer.presentation.view_models.QuotaViewModel
import com.pavelwinter.myorganizer.presentation.adapters.QuotaAdapter
import com.pavelwinter.myorganizer.presentation.fragments.forms.AddQuotaFragment
import kotlinx.android.synthetic.main.quota_fragment.*

class QuotaFragment : BaseFragment() {

    private lateinit var mQuotaViewModel : QuotaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quota_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        quota_fragment_fab ?.setOnClickListener {
            goToAnotherFragment(AddQuotaFragment(), null)
        }

        initViewModel()
        mQuotaViewModel .loadData()
    }




    private fun initViewModel() {
        mQuotaViewModel = ViewModelProviders.of(this).get(QuotaViewModel::class.java)
        val quotaObserver = Observer<List<ParentType>>{ quotaList->
            if(quotaList .isNotEmpty()) setAdapter(quotaList) else mQuotaViewModel.loadData()
        }

        mQuotaViewModel.quotaList .observe(this, quotaObserver)
    }




    private fun setAdapter(quotaModelList : List<ParentType>){
        with(quota_fragment_rv) {
            adapter = QuotaAdapter(quotaModelList)
            layoutManager = LinearLayoutManager(this@QuotaFragment.context)
        }

    }

}
