package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.hook_prototype.HookPrototypeDB

@Dao
interface HookPrototypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHookPrototypeDB(hookPrototypeDB: HookPrototypeDB): Long

    @Query("SELECT * FROM HookPrototypeDB WHERE hookPrototypeId = :id")
    fun getHookPrototypeDB(id: Long): HookPrototypeDB

    @Query("SELECT * FROM HookPrototypeDB")
    fun getHookPrototypesList(): List<HookPrototypeDB>
}