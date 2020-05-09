package com.diary.fisher.create_data.di

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.feed_box.CreateFeedBoxUseCase
import com.diary.fisher.create_data.business.feed_box.PrepareFeedBoxDataUseCase
import com.diary.fisher.create_data.business.feed_box.ProcessFeedBoxUseCase
import com.diary.fisher.create_data.presentation.view_model.CreateDataViewModel
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.create_data.rep.FeedBoxStringsProvider
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val createDataModule = module {
    viewModel { (createDataType: CreateDataType) ->
        val prepareDataUseCase = when (createDataType) {
            CreateDataType.FEED_BOX -> PrepareFeedBoxDataUseCase(get(), get(), get())
            CreateDataType.FEED_BOX_BRAND_NAME -> PrepareFeedBoxDataUseCase(get(), get(), get())
        }
        val createDataUseCase = when (createDataType) {
            CreateDataType.FEED_BOX -> CreateFeedBoxUseCase()
            CreateDataType.FEED_BOX_BRAND_NAME -> CreateFeedBoxUseCase()
        }
        val processCreateItemsUseCase = when (createDataType) {
            CreateDataType.FEED_BOX -> ProcessFeedBoxUseCase(get())
            CreateDataType.FEED_BOX_BRAND_NAME -> ProcessFeedBoxUseCase(get())
        }
        CreateDataViewModel(prepareDataUseCase, processCreateItemsUseCase, createDataUseCase)
    }
    factory { FeedBoxStringsProvider(get()) }

    single { CreateDataItemsHolder() }
}