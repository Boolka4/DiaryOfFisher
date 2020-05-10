package com.diary.fisher.create_single_line_data.di

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_single_line_data.business.CreateSingleLineDataUseCase
import com.diary.fisher.create_single_line_data.business.CreateSingleLineFeedBoxBrand
import com.diary.fisher.create_single_line_data.business.CreateSingleLineHookBrandDataUseCase
import com.diary.fisher.create_single_line_data.presentation.view_model.CreateSingleLineDataViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val singleLineDataModule = module {

    //todo move CreateSingleLineDataUseCase to factory
    viewModel { (createDataType: CreateDataType) ->

        val createSingleLineDataUseCase: CreateSingleLineDataUseCase = when (createDataType) {
            CreateDataType.FEED_BOX -> TODO()
            CreateDataType.FEED_BOX_BRAND_NAME -> CreateSingleLineFeedBoxBrand(get())
            CreateDataType.HOOK_BRAND -> CreateSingleLineHookBrandDataUseCase(get())
        }
        CreateSingleLineDataViewModel(createSingleLineDataUseCase)
    }
}