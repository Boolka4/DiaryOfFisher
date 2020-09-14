package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.direction.DirectionDB

@Dao
interface DirectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDirectionDB(directionDB: DirectionDB): Long

    @Query("SELECT * FROM DirectionDB WHERE directionId = :id")
    fun getDirectionDB(id: Long): DirectionDB

    @Query("SELECT * FROM DirectionDB")
    fun getDirectionsList(): List<DirectionDB>
}