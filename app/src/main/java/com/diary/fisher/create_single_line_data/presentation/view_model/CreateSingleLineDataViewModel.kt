package com.diary.fisher.create_single_line_data.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diary.fisher.core.live_data.SingleLiveEvent
import com.diary.fisher.core.models.common.SingleLineDataType
import com.diary.fisher.create_single_line_data.business.CreateSingleLineDataUseCase
import com.diary.fisher.create_single_line_data.business.CreateSingleLineHookBrandDataUseCase
import kotlinx.coroutines.launch

class CreateSingleLineDataViewModel(private val createSingleLineDataUseCase: CreateSingleLineDataUseCase) : ViewModel() {

    private val navigationLiveData: MutableLiveData<Unit> = SingleLiveEvent()
    fun getNavigationLiveData(): LiveData<Unit> = navigationLiveData

    fun onSaveDataClicked(text: String) {
        viewModelScope.launch {
            createSingleLineDataUseCase.createSingleLineData(text)
            navigationLiveData.value = Unit
        }
    }

    fun onCancelClicked() {
        navigationLiveData.value = Unit
    }
}