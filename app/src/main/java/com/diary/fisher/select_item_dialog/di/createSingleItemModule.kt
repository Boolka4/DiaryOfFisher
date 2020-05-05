package com.diary.fisher.select_item_dialog.di

import com.diary.fisher.select_item_dialog.business.SelectSingleItemUseCase
import com.diary.fisher.select_item_dialog.presentation.view_model.SelectSingleItemViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val createSingleItemModule = module {
    viewModel {
        SelectSingleItemViewModel(
            get()
        )
    }

    single { SelectSingleItemUseCase(get()) }
}