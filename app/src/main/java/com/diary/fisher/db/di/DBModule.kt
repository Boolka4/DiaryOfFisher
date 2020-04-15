package com.diary.fisher.db.di

import androidx.room.Room
import com.diary.fisher.db.DiaryDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), DiaryDatabase::class.java,
            "diaryDB"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}