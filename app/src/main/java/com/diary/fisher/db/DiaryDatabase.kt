package com.diary.fisher.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.diary.fisher.db.converters.WaterTypeConverter
import com.diary.fisher.db.dao.WatersDao
import com.diary.fisher.db.models.WaterDB

@Database(entities = [WaterDB::class], version = 1, exportSchema = true)
@TypeConverters(value = [WaterTypeConverter::class])
abstract class DiaryDatabase : RoomDatabase() {

    abstract fun watersDao(): WatersDao
}