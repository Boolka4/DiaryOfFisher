package com.diary.fisher.create_single_line_data.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diary.fisher.core.live_data.SingleLiveEvent
import com.diary.fisher.core.models.common.Constants.Companion.NOT_SELECTED_ITEM_ID
import com.diary.fisher.create_single_line_data.business.CreateSingleLineDataUseCase
import kotlinx.coroutines.launch

class CreateSingleLineDataViewModel(private val createSingleLineDataUseCase: CreateSingleLineDataUseCase) :
    ViewModel() {

    private val navigationLiveData: MutableLiveData<Long> = SingleLiveEvent()

    fun getNavigationLiveData(): LiveData<Long> = navigationLiveData

    fun onSaveDataClicked(text: String) {
        viewModelScope.launch {
            navigationLiveData.value = createSingleLineDataUseCase.createSingleLineData(text)
        }
    }

    fun onCancelClicked() {
        navigationLiveData.value = NOT_SELECTED_ITEM_ID
    }
}