package com.diary.fisher.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diary.fisher.db.converters.LineTypeConverter
import com.diary.fisher.db.converters.WaterTypeConverter
import com.diary.fisher.db.converters.feed_box.FeedBoxFormTypeConverter
import com.diary.fisher.db.converters.feed_box.FeedBoxHoleTypeConverter
import com.diary.fisher.db.converters.feed_box.FeedBoxMaterialTypeConverter
import com.diary.fisher.db.converters.feed_box.FeedBoxMountingConverter
import com.diary.fisher.db.dao.FeedBoxDao
import com.diary.fisher.db.dao.HooksDao
import com.diary.fisher.db.dao.LinesDao
import com.diary.fisher.db.dao.WatersDao
import com.diary.fisher.db.models.feed_box.FeedBoxBrandDB
import com.diary.fisher.db.models.feed_box.FeedBoxDB
import com.diary.fisher.db.models.water.WaterDB
import com.diary.fisher.db.models.hook.HookBrandDB
import com.diary.fisher.db.models.hook.HookModelDB
import com.diary.fisher.db.models.line.LineBrandDB
import com.diary.fisher.db.models.line.LineDiameterDB
import com.diary.fisher.db.models.tackle.reel.ReelDB
import com.diary.fisher.db.models.tackle.road.RoadDB

@Database(
    entities = [WaterDB::class,
        HookBrandDB::class,
        HookModelDB::class,
        LineBrandDB::class,
        LineDiameterDB::class,
        ReelDB::class,
        RoadDB::class,
        FeedBoxBrandDB::class,
        FeedBoxDB::class],
    version = 2,
    exportSchema = true
)
@TypeConverters(
    value = [WaterTypeConverter::class,
        LineTypeConverter::class,
        FeedBoxFormTypeConverter::class,
        FeedBoxHoleTypeConverter::class,
        FeedBoxMaterialTypeConverter::class,
        FeedBoxMountingConverter::class]
)
abstract class DiaryDatabase : RoomDatabase() {

    abstract fun watersDao(): WatersDao

    abstract fun hooksDao(): HooksDao

    abstract fun linesDao(): LinesDao

    abstract fun feedBoxDao(): FeedBoxDao
}