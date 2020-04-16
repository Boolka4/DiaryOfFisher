package com.diary.fisher.reports_list.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diary.fisher.reports_list.business.PrepareReportsListUseCase
import com.diary.fisher.report_add.models.ReportViewItem
import kotlinx.coroutines.launch

class ReportsListViewModel(private val prepareReportsListUseCase: PrepareReportsListUseCase) :
    ViewModel() {

    private val state: MutableLiveData<ReportsListState> = MutableLiveData()
    private val navigationLiveData: MutableLiveData<ReportsNavigationState> = MutableLiveData()

    init {
        state.value = ReportsListState.ProgressState
        viewModelScope.launch {
            val watersList = prepareReportsListUseCase.getItemsList()
            if (watersList.isEmpty()) {
                state.value = ReportsListState.EmptyDataState
            } else {
                state.value = ReportsListState.ShowItemsState(watersList)
            }
        }
    }

    fun getReportsLiveData(): LiveData<ReportsListState> = state

    fun getNavigationLiveData(): LiveData<ReportsNavigationState> = navigationLiveData

    fun onReportItemClicked(waterViewItem: ReportViewItem) {
        navigationLiveData.value = ReportsNavigationState.ReportDetailScreen(waterViewItem.id)
    }

    fun onReportAddClicked() {
        navigationLiveData.value = ReportsNavigationState.ReportAddScreen
    }
}

sealed class ReportsListState {

    object ProgressState : ReportsListState()

    object EmptyDataState : ReportsListState()

    data class ShowItemsState(val items: List<ReportViewItem>) : ReportsListState()
}

sealed class ReportsNavigationState {

    data class ReportDetailScreen(val itemId: Long) : ReportsNavigationState()

    object ReportAddScreen : ReportsNavigationState()
}