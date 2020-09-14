package com.diary.fisher.create_data.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diary.fisher.core.live_data.SingleLiveEvent
import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem
import com.diary.fisher.create_data.business.AddDataUseCase
import com.diary.fisher.create_data.business.SaveDataUseCase
import com.diary.fisher.create_data.business.PrepareDataUseCase
import com.diary.fisher.create_data.business.ProcessCreateItemsUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import kotlinx.coroutines.launch

class CreateDataViewModel(
    private val prepareDataUseCase: PrepareDataUseCase,
    private val processCreateItemsUseCase: ProcessCreateItemsUseCase,
    private val saveDataUseCase: SaveDataUseCase?,
    private val addDataUseCase: AddDataUseCase?
) : ViewModel() {

    private val state: MutableLiveData<CreateDataState> = MutableLiveData()

    private val navigation: SingleLiveEvent<ProcessCreateItemClickResult.Navigation> =
        SingleLiveEvent()

    init {
        state.value = CreateDataState.ProgressState
        viewModelScope.launch {
            state.value = CreateDataState.ShowItemsState(prepareDataUseCase.getItemsList())
        }
    }

    fun getReportsLiveData(): LiveData<CreateDataState> = state

    fun getNavigationLiveData(): LiveData<ProcessCreateItemClickResult.Navigation> = navigation

    fun onItemClicked(createDataItem: CreateDataItem) {
        processClickResult(processCreateItemsUseCase.processCreateItems(createDataItem))
    }

    fun onInputTextChanged(
        createDataItem: CreateDataItem.InputFieldDataItem,
        text: String
    ) {
        processCreateItemsUseCase.processTextInserted(createDataItem, text)
    }

    fun onSaveDataClicked() {
//        saveDataUseCase.saveData()
    }

    fun onAddDataClicked() {
        addDataUseCase?.processAddDataClick()?.let {
            processClickResult(it)
        }
    }

    fun onCreateDataResult(elementId: Long, resultId: Long) {
        viewModelScope.launch {
            state.value = CreateDataState.ShowItemsState(
                processCreateItemsUseCase.processCreateDataResult(
                    elementId,
                    resultId
                )
            )
        }
    }

    private fun processClickResult(processCreateItemClickResult: ProcessCreateItemClickResult) {
        when (processCreateItemClickResult) {
            is ProcessCreateItemClickResult.UpdateList -> state.value =
                CreateDataState.ShowItemsState(processCreateItemClickResult.itemsList)
            is ProcessCreateItemClickResult.Navigation -> navigation.value =
                processCreateItemClickResult
        }
    }
}

sealed class CreateDataState {

    object ProgressState : CreateDataState()

    data class ShowItemsState(val items: List<MultipleTypesViewItem>) : CreateDataState()
}