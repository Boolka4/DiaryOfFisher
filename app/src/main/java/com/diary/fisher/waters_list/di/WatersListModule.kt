package com.diary.fisher.waters_list.di

import com.diary.fisher.waters_list.business.PrepareWaterItemsUseCase
import com.diary.fisher.waters_list.presentation.view_model.WatersListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val watersListModule = module {

    viewModel { WatersListViewModel(get()) }

    single { PrepareWaterItemsUseCase(get()) }
}