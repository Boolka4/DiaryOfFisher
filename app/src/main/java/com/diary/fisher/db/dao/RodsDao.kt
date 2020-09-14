package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.rod.RodDB


@Dao
interface RodsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRodDB(rodDB: RodDB): Long

    @Query("SELECT * FROM RodDB WHERE rodId = :id")
    fun getRodDB(id: Long): RodDB

    @Query("SELECT * FROM RodDB")
    fun getRodsList(): List<RodDB>
}