package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.water.WaterDB

@Dao
interface WatersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWater(water: WaterDB)

    @Query("SELECT * FROM WaterDB WHERE waterId = :id_")
    fun getWaterById(id_: Long): WaterDB

    @Query("SELECT * FROM WaterDB")
    fun getWatersList(): List<WaterDB>
}