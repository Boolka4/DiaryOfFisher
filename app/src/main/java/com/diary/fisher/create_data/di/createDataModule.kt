package com.diary.fisher.create_data.di

import com.diary.fisher.create_data.presentation.view_model.CreateDataViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val createDataModule = module {
    viewModel { CreateDataViewModel() }
}