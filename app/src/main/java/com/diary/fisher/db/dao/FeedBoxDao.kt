package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.feed_box.FeedBoxBrandDB
import com.diary.fisher.db.models.feed_box.FeedBoxDB

@Dao
interface FeedBoxDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeedBoxBrandDB(feedBoxBrandDB: FeedBoxBrandDB): Long

    @Query("SELECT * FROM FeedBoxBrandDB WHERE feedBoxBrandId = :id")
    fun getFeedBoxBrandDB(id: Long): FeedBoxBrandDB

    @Query("SELECT * FROM FeedBoxBrandDB")
    fun getFeedBoxBrandsList(): List<FeedBoxBrandDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeedBox(feedBox: FeedBoxDB)

    @Query("SELECT * FROM FeedBoxDB WHERE feedBoxId = :id")
    fun getFeedBoxDB(id: Long): FeedBoxDB
}