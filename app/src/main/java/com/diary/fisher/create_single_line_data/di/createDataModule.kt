package com.diary.fisher.create_single_line_data.di

import com.diary.fisher.create_single_line_data.business.CreateSingleLineDataUseCase
import com.diary.fisher.create_single_line_data.presentation.view_model.CreateSingleLineDataViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val singleLineDataModule = module {
    viewModel {
        CreateSingleLineDataViewModel(
            get()
        )
    }

    single { CreateSingleLineDataUseCase(get()) }
}