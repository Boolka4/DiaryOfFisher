package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.dip.DipDB

@Dao
interface DipDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDipDB(dipDB: DipDB): Long

    @Query("SELECT * FROM DipDB WHERE dipId = :id")
    fun getDipDB(id: Long): DipDB

    @Query("SELECT * FROM DipDB")
    fun getDipsList(): List<DipDB>
}