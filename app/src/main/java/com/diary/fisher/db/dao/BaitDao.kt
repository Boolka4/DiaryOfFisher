package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.bait.BaitDB

@Dao
interface BaitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBaitDB(baitDB: BaitDB): Long

    @Query("SELECT * FROM BaitDB WHERE baitId = :id")
    fun getBaitDB(id: Long): BaitDB

    @Query("SELECT * FROM BaitDB")
    fun getBaitsList(): List<BaitDB>
}