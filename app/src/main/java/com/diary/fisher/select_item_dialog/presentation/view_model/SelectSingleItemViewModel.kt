package com.diary.fisher.select_item_dialog.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diary.fisher.select_item_dialog.business.SelectSingleItemUseCase
import com.diary.fisher.select_item_dialog.models.SelectSingleViewItem
import com.diary.fisher.waters_list.business.PrepareWaterItemsUseCase
import com.diary.fisher.waters_list.models.WaterViewItem
import kotlinx.coroutines.launch

class SelectSingleItemViewModel(
    private val selectSingleItemUseCase: SelectSingleItemUseCase
) : ViewModel() {

    private val state: MutableLiveData<SelectSingleItemState> = MutableLiveData()

    init {
        state.value = SelectSingleItemState.ProgressState
        viewModelScope.launch {
            state.value =
                SelectSingleItemState.ShowItemsState(selectSingleItemUseCase.getItemsList())
        }
    }

    fun getStateLiveData(): LiveData<SelectSingleItemState> = state

    fun onItemClicked(selectSingleViewItem: SelectSingleViewItem) {}
}

sealed class SelectSingleItemState {

    object ProgressState : SelectSingleItemState()

    data class ShowItemsState(val items: List<SelectSingleViewItem>) : SelectSingleItemState()
}
