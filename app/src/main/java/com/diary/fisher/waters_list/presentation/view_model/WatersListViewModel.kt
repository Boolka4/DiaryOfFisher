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
) :
    ViewModel() {

    private val _state: MutableLiveData<WatersListState> = MutableLiveData()
    val state: LiveData<WatersListState> get() = _state

    init {
        _state.value = WatersListState.ProgressState
        viewModelScope.launch {
            val watersList = prepareWaterItemsUseCase.getItemsList()
            if (watersList.isEmpty()) {
                _state.value = WatersListState.EmptyDateState
            } else {
                _state.value = WatersListState.ShowItemsState(watersList)
            }
        }
    }

    fun onItemClicked(waterViewItem: WaterViewItem){}
}

sealed class WatersListState {

    object ProgressState : WatersListState()

    object EmptyDateState : WatersListState()

    data class ShowItemsState(val items: List<WaterViewItem>) : WatersListState()
}