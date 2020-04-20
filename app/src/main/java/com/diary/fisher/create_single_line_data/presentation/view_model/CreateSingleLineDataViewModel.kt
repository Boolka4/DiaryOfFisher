package com.diary.fisher.create_single_line_data.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diary.fisher.core.live_data.SingleLiveEvent
import com.diary.fisher.create_single_line_data.business.CreateSingleLineDataUseCase
import kotlinx.coroutines.launch

class CreateSingleLineDataViewModel(
    private val createSingleLineDataUseCase: CreateSingleLineDataUseCase
) : ViewModel() {

    private val state: MutableLiveData<Boolean> = SingleLiveEvent()

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