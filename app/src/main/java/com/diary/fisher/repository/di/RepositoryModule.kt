package com.diary.fisher.repository.di

import com.diary.fisher.db.DiaryDatabase
import com.diary.fisher.repository.implementation.*
import com.diary.fisher.repository.interfaces.*
import com.diary.fisher.repository.mappers.bait.BaitMapper
import com.diary.fisher.repository.mappers.dip.DipMapper
import com.diary.fisher.repository.mappers.direction.DirectionMapper
import com.diary.fisher.repository.mappers.feed.FeedMapper
import com.diary.fisher.repository.mappers.feed_box.FeedBoxBrandMapper
import com.diary.fisher.repository.mappers.hook.HookBrandMapper
import com.diary.fisher.repository.mappers.hook_prototype.HookPrototypeMapper
import com.diary.fisher.repository.mappers.rod.RodMapper
import com.diary.fisher.repository.resource.ResourceManager
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

    single { ResourceManager(get()) }

    single<DipRepository> { DipRepositoryImpl(get<DiaryDatabase>().dipDao(), get()) }

    single { DipMapper() }

    single<BaitRepository> { BaitRepositoryImpl(get<DiaryDatabase>().baitDao(), get()) }

    single { BaitMapper() }

    single<FeedRepository> { FeedRepositoryImpl(get<DiaryDatabase>().feedDao(), get()) }

    single { FeedMapper() }

    single<DirectionRepository> {
        DirectionRepositoryImpl(
            get<DiaryDatabase>().directionDao(),
            get()
        )
    }

    single { DirectionMapper() }

    single<HookPrototypeRepository> {
        HookPrototypeRepositoryImpl(
            get<DiaryDatabase>().hookPrototypeDao(),
            get()
        )
    }

    single { HookPrototypeMapper() }

    single<MountingRepository> { MountingRepositoryImpl(get<DiaryDatabase>().mountingDao(), get()) }

    single<RodRepository> { RodRepositoryImpl(get<DiaryDatabase>().rodsDao(), get()) }

    single { RodMapper() }
}