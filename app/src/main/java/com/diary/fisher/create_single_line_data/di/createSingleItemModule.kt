package com.diary.fisher.create_single_line_data.di

import com.diary.fisher.core.models.common.SingleLineDataType
import com.diary.fisher.create_single_line_data.business.CreateSingleLineDataUseCase
import com.diary.fisher.create_single_line_data.business.CreateSingleLineHookBrandDataUseCase
import com.diary.fisher.create_single_line_data.presentation.view_model.CreateSingleLineDataViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val singleLineDataModule = module {

    //todo move CreateSingleLineDataUseCase to factory
    viewModel { (singleLineDataType: SingleLineDataType) ->

        val createSingleLineDataUseCase: CreateSingleLineDataUseCase = when (singleLineDataType) {
            SingleLineDataType.HOOK_BRAND -> CreateSingleLineHookBrandDataUseCase(get())
            SingleLineDataType.FEED_BOX_BRAND -> CreateSingleLineHookBrandDataUseCase(get())
        }
        CreateSingleLineDataViewModel(createSingleLineDataUseCase)
    }
}