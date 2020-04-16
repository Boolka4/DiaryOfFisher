package com.diary.fisher.reports_list.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.diary.fisher.R
import com.diary.fisher.core.ui.fragment.BaseFragment
import com.diary.fisher.report_details.presentation.view.ReportDetailsFragment
import com.diary.fisher.reports_list.presentation.adapter.ReportsListAdapter
import com.diary.fisher.reports_list.presentation.view_model.ReportsListState
import com.diary.fisher.reports_list.presentation.view_model.ReportsListViewModel
import com.diary.fisher.reports_list.presentation.view_model.ReportsNavigationState
import com.diary.fisher.waters_list.presentation.adapter.WatersListAdapter
import com.diary.fisher.waters_list.presentation.view_model.WatersListState
import com.diary.fisher.waters_list.presentation.view_model.WatersListViewModel
import kotlinx.android.synthetic.main.fragment_reports_list.*
import kotlinx.android.synthetic.main.fragment_waters_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class ReportsListFragment : BaseFragment() {

    private val viewModel by viewModel<ReportsListViewModel>()
    private val reportsListAdapter: ReportsListAdapter =
        ReportsListAdapter { viewModel.onReportItemClicked(it) }

    override fun getLayoutId() = R.layout.fragment_reports_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvReports.adapter = reportsListAdapter
        rvReports.layoutManager = LinearLayoutManager(view.context)
        val screenStateObserver = Observer<ReportsListState> {
            when (it) {
                is ReportsListState.ProgressState -> {
                    tvNoReports.visibility = View.GONE
                    rvReports.visibility = View.GONE
                    showProgress(true)
                }
                is ReportsListState.EmptyDataState -> {
                    tvNoReports.visibility = View.VISIBLE
                    rvReports.visibility = View.GONE
                    showProgress(false)
                }

                is ReportsListState.ShowItemsState -> {
                    showProgress(false)
                    tvNoReports.visibility = View.GONE
                    rvReports.visibility = View.VISIBLE

                    reportsListAdapter.setItems(it.items)
                }
            }

        }
        val navigationObserver = Observer<ReportsNavigationState> {
            when (it) {
                is ReportsNavigationState.ReportDetailScreen -> {
                    findNavController().navigate(R.id.action_reportsListFragment_to_reportDetailsFragment)
                }
                is ReportsNavigationState.ReportAddScreen -> {
                    findNavController().navigate(R.id.action_reportsListFragment_to_reportAddFragment)
                }
            }
        }
        viewModel.getReportsLiveData().observe(viewLifecycleOwner, screenStateObserver)
        viewModel.getNavigationLiveData().observe(viewLifecycleOwner, navigationObserver)
        fabAddReport.setOnClickListener { viewModel.onReportAddClicked() }
    }

}