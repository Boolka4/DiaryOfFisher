package com.diary.fisher.reports_list.di

import com.diary.fisher.reports_list.business.PrepareReportsListUseCase
import com.diary.fisher.reports_list.presentation.view_model.ReportsListViewModel
import com.diary.fisher.waters_list.business.PrepareWaterItemsUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.KoinContextHandler.get
import org.koin.dsl.module

val reportsListModule = module {

    viewModel { ReportsListViewModel(get()) }

    single { PrepareReportsListUseCase() }
}