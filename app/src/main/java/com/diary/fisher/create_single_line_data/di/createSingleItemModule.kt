package com.diary.fisher.create_single_line_data.di

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.core.models.common.CreateDataType.*
import com.diary.fisher.create_single_line_data.business.CreateSingleLineDataUseCase
import com.diary.fisher.create_single_line_data.business.CreateSingleLineFeedBoxBrand
import com.diary.fisher.create_single_line_data.business.CreateSingleLineHookBrandDataUseCase
import com.diary.fisher.create_single_line_data.business.CreateSingleLineRodUseCase
import com.diary.fisher.create_single_line_data.presentation.view_model.CreateSingleLineDataViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val singleLineDataModule = module {

    //todo move CreateSingleLineDataUseCase to factory
    viewModel { (createDataType: CreateDataType, selectedItemId: Long) ->

        val createSingleLineDataUseCase: CreateSingleLineDataUseCase = when (createDataType) {
            FEED_BOX -> TODO()
            FEED_BOX_BRAND_NAME -> CreateSingleLineFeedBoxBrand(selectedItemId, get())
            HOOK_BRAND -> CreateSingleLineHookBrandDataUseCase(selectedItemId, get())
            ALL_SETTINGS_LIST -> TODO()
            RODS_LIST -> TODO()
            CREATE_ROD -> CreateSingleLineRodUseCase(selectedItemId, get())
            DIRECTIONS_LIST -> TODO()
            CREATE_DIRECTION -> TODO()
            BITES_LIST -> TODO()
            CREATE_BITE -> TODO()
            DIPS_LIST -> TODO()
            CREATE_DIP -> TODO()
            FEEDS_LIST -> TODO()
            CREATE_FEED -> TODO()
            HOOK_PROTOTYPES_LIST -> TODO()
            CREATE_HOOK_PROTOTYPE -> TODO()
            MOUNTINGS_LIST -> TODO()
            CREATE_MOUNTING -> TODO()
        }
        CreateSingleLineDataViewModel(createSingleLineDataUseCase)
    }
}