package com.diary.fisher.create_data.di

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.PrepareDataUseCase
import com.diary.fisher.create_data.business.all_settings_list.PrepareAllSettingsListUseCase
import com.diary.fisher.create_data.business.all_settings_list.ProcessAllSettingsListUseCase
import com.diary.fisher.create_data.business.directions_list.AddDirectionsListUseCase
import com.diary.fisher.create_data.business.directions_list.PrepareDirectionsListUseCase
import com.diary.fisher.create_data.business.directions_list.ProcessDirectionsListUseCase
import com.diary.fisher.create_data.business.feed_box.PrepareFeedBoxDataUseCase
import com.diary.fisher.create_data.business.feed_box.ProcessFeedBoxUseCase
import com.diary.fisher.create_data.business.rod_list.AddRodsListUseCase
import com.diary.fisher.create_data.business.rod_list.PrepareRodsListUseCase
import com.diary.fisher.create_data.business.rod_list.ProcessRodsListUseCase
import com.diary.fisher.create_data.presentation.view_model.CreateDataViewModel
import com.diary.fisher.create_data.rep.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val createDataModule = module {
    viewModel { (createDataType: CreateDataType) ->
        val prepareDataUseCase: PrepareDataUseCase = when (createDataType) {
            CreateDataType.FEED_BOX -> PrepareFeedBoxDataUseCase(get(), get(), get())
            CreateDataType.FEED_BOX_BRAND_NAME -> PrepareFeedBoxDataUseCase(get(), get(), get())
            CreateDataType.ALL_SETTINGS_LIST -> PrepareAllSettingsListUseCase(get(), get())
            CreateDataType.RODS_LIST -> PrepareRodsListUseCase(get(), get())
            CreateDataType.DIRECTIONS_LIST -> PrepareDirectionsListUseCase(get(), get())
            else -> TODO()
        }
        val processCreateItemsUseCase = when (createDataType) {
            CreateDataType.FEED_BOX -> ProcessFeedBoxUseCase(get(), get())
            CreateDataType.FEED_BOX_BRAND_NAME -> ProcessFeedBoxUseCase(get(), get())
            CreateDataType.ALL_SETTINGS_LIST -> ProcessAllSettingsListUseCase()
            CreateDataType.RODS_LIST -> ProcessRodsListUseCase(get())
            CreateDataType.DIRECTIONS_LIST -> ProcessDirectionsListUseCase(get())
            else -> TODO()
        }
        val createDataUseCase = when (createDataType) {
            else -> null
        }

        val addDataUseCase = when (createDataType) {
            CreateDataType.RODS_LIST -> AddRodsListUseCase(get())
            CreateDataType.DIRECTIONS_LIST -> AddDirectionsListUseCase(get())
            else -> null
        }
        CreateDataViewModel(
            prepareDataUseCase,
            processCreateItemsUseCase,
            createDataUseCase,
            addDataUseCase
        )
    }
    factory { FeedBoxStringsProvider(get()) }

    factory { AllSettingsListStringsProvider(get()) }

    factory { AddRodsStringsProvider(get()) }

    factory { DirectionStringsProvider(get()) }

    single { CreateDataItemsHolder() }
}