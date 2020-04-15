package com.diary.fisher

import android.app.Application
import com.diary.fisher.db.di.dbModule
import com.diary.fisher.repository.di.repositoryModule
import com.diary.fisher.waters_list.di.watersListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DiaryApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DiaryApplication)
            modules(dbModule)
            modules(repositoryModule)
            modules(watersListModule)
        }
    }
}