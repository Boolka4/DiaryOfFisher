package com.diary.fisher.create_data.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem
import kotlinx.coroutines.launch


class CreateDataViewModel() : ViewModel() {

    private val state: MutableLiveData<CreateDataState> = MutableLiveData()

    init {
        state.value = CreateDataState.ProgressState
        viewModelScope.launch {
            state.value = CreateDataState.ShowItemsState(emptyList())

        }
    }

    fun getReportsLiveData(): LiveData<CreateDataState> = state

    fun onSaveDataClicked() {

    }
}

sealed class CreateDataState {

    object ProgressState : CreateDataState()

    data class ShowItemsState(val items: List<MultipleTypesViewItem>) : CreateDataState()
}