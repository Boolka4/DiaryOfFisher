package com.diary.fisher.waters_list.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diary.fisher.waters_list.business.PrepareWaterItemsUseCase
import com.diary.fisher.waters_list.models.WaterViewItem
import kotlinx.coroutines.launch

class WatersListViewModel(
    private val prepareWaterItemsUseCase: PrepareWaterItemsUseCase
) : ViewModel() {

    private val state: MutableLiveData<WatersListState> = MutableLiveData()

    init {
        state.value = WatersListState.ProgressState
        viewModelScope.launch {
            val watersList = prepareWaterItemsUseCase.getItemsList()
            if (watersList.isEmpty()) {
                state.value = WatersListState.EmptyDataState
            } else {
                state.value = WatersListState.ShowItemsState(watersList)
            }
        }
    }

    fun getWaterLiveData(): LiveData<WatersListState> = state

    fun onItemClicked(waterViewItem: WaterViewItem) {}
}

sealed class WatersListState {

    object ProgressState : WatersListState()

    object EmptyDataState : WatersListState()

    data class ShowItemsState(val items: List<WaterViewItem>) : WatersListState()
}