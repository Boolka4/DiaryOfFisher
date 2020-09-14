package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.mountings.MountingDB

@Dao
interface MountingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMountingDB(mountingDB: MountingDB): Long

    @Query("SELECT * FROM MountingDB WHERE mountingId = :id")
    fun getMountingDB(id: Long): MountingDB

    @Query("SELECT * FROM MountingDB")
    fun getMountingsList(): List<MountingDB>
}