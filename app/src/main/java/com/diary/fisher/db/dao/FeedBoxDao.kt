package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.feed_box.FeedBoxDB
import com.diary.fisher.db.models.feed_box.FeederBoxBrandDB
import com.diary.fisher.db.models.hook.HookBrandDB

@Dao
interface FeedBoxDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeederBoxBrandDB(feederBoxBrandDB: FeederBoxBrandDB)

    @Query("SELECT * FROM HookBrandDB")
    fun getFeederBoxBrandsList(): List<FeederBoxBrandDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeedBox(feedBox: FeedBoxDB)

    @Query("SELECT * FROM FeedBoxDB WHERE feedBoxId = :id")
    fun getFeedBoxDB(id: Long): FeedBoxDB
}