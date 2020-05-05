package com.diary.fisher.repository.di

import com.diary.fisher.db.DiaryDatabase
import com.diary.fisher.repository.implementation.FeedBoxRepositoryImpl
import com.diary.fisher.repository.implementation.HookRepositoryImpl
import com.diary.fisher.repository.implementation.WaterRepositoryFakeImpl
import com.diary.fisher.repository.interfaces.FeedBoxRepository
import com.diary.fisher.repository.interfaces.HookRepository
import com.diary.fisher.repository.interfaces.WaterRepository
import com.diary.fisher.repository.mappers.feed_box.FeedBoxBrandMapper
import com.diary.fisher.repository.mappers.hook.HookBrandMapper
import org.koin.dsl.module


val repositoryModule = module {
    single<WaterRepository> {
        WaterRepositoryFakeImpl()
    }

    single<HookRepository> {
        HookRepositoryImpl(get<DiaryDatabase>().hooksDao(), get())
    }

    single { HookBrandMapper() }

    single<FeedBoxRepository> { FeedBoxRepositoryImpl(get<DiaryDatabase>().feedBoxDao(), get()) }

    single { FeedBoxBrandMapper() }
}