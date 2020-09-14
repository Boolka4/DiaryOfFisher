package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.feed.FeedDB

@Dao
interface FeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeedDB(feedDB: FeedDB): Long

    @Query("SELECT * FROM FeedDB WHERE feedId = :id")
    fun getFeedDB(id: Long): FeedDB

    @Query("SELECT * FROM FeedDB")
    fun getFeedsList(): List<FeedDB>
}