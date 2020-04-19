package com.diary.fisher.repository.di

import com.diary.fisher.db.DiaryDatabase
import com.diary.fisher.repository.implementation.HookRepositoryImpl
import com.diary.fisher.repository.implementation.WaterRepositoryFakeImpl
import com.diary.fisher.repository.interfaces.HookRepository
import com.diary.fisher.repository.interfaces.WaterRepository
import com.diary.fisher.repository.mappers.hook.HookBrandMapper
import org.koin.dsl.module


val repositoryModule = module {
    single {
        WaterRepositoryFakeImpl() as WaterRepository
    }

    single {
        HookRepositoryImpl(get<DiaryDatabase>().hooksDao(), get()) as HookRepository
    }

    single { HookBrandMapper() }
}