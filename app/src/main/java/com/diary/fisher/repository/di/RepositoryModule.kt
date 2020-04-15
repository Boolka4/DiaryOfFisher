package com.diary.fisher.repository.di

import com.diary.fisher.repository.implementation.WaterRepositoryFakeImpl
import com.diary.fisher.repository.interfaces.WaterRepository
import org.koin.dsl.module


val repositoryModule = module {
    single {
        WaterRepositoryFakeImpl() as WaterRepository
    }
}