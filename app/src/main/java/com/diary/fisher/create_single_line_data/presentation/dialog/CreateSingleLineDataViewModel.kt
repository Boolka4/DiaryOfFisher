package com.diary.fisher.create_single_line_data.presentation.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diary.fisher.create_single_line_data.business.CreateSingleLineDataUseCase
import kotlinx.coroutines.launch

class CreateSingleLineDataViewModel(
    private val createSingleLineDataUseCase: CreateSingleLineDataUseCase
) :
    ViewModel() {

    private val state: MutableLiveData<Boolean> = MutableLiveData()

    init {
//        state.value = "STRING FROM VIEW MODEL"
//        viewModelScope.launch {
//            state.value = CreateDataState.ShowItemsState(emptyList())
//
//        }
    }

    fun getStateLiveData(): LiveData<Boolean> = state

    fun onSaveDataClicked(text: String) {
        viewModelScope.launch {
            createSingleLineDataUseCase.createHookBrand(text)
            state.value = true
        }
    }

    fun onCancelClicked() {
        state.value = true
    }
}