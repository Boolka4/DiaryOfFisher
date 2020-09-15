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
import com.diary.fisher.db.dao.*
import com.diary.fisher.db.models.bait.BaitDB
import com.diary.fisher.db.models.dip.DipDB
import com.diary.fisher.db.models.direction.DirectionDB
import com.diary.fisher.db.models.feed.FeedDB
import com.diary.fisher.db.models.feed_box.FeedBoxBrandDB
import com.diary.fisher.db.models.feed_box.FeedBoxDB
import com.diary.fisher.db.models.water.WaterDB
import com.diary.fisher.db.models.hook.HookBrandDB
import com.diary.fisher.db.models.hook.HookModelDB
import com.diary.fisher.db.models.hook_prototype.HookPrototypeDB
import com.diary.fisher.db.models.line.LineBrandDB
import com.diary.fisher.db.models.line.LineDiameterDB
import com.diary.fisher.db.models.mountings.MountingDB
import com.diary.fisher.db.models.rod.RodDB
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
        FeedBoxDB::class,
        DipDB::class,
        BaitDB::class,
        DirectionDB::class,
        FeedDB::class,
        HookPrototypeDB::class,
        MountingDB::class,
        RodDB::class],
    version = 4,
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

    abstract fun dipDao(): DipDao

    abstract fun baitDao(): BaitDao

    abstract fun directionDao(): DirectionDao

    abstract fun feedDao(): FeedDao

    abstract fun hookPrototypeDao(): HookPrototypeDao

    abstract fun mountingDao(): MountingDao

    abstract fun rodsDao(): RodsDao
}