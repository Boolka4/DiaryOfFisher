package com.diary.fisher.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diary.fisher.db.models.line.LineDB
import com.diary.fisher.db.models.line.LineDiameterDB

@Dao
interface LinesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLine(line: LineDiameterDB)

    @Query("SELECT * FROM LineDiameterDB WHERE lineId = :id")
    fun getLineById(id: Long): LineDiameterDB
}