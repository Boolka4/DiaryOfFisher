package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.hook.HookBrandDB

@Dao
interface HooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHookBrand(hookBrand: HookBrandDB)

    @Query("SELECT * FROM HookBrandDB WHERE hookBrandId = :id")
    fun getHookBrand(id: Long): HookBrandDB
}