package com.diary.fisher.db.models.line

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LineBrandDB(
    @PrimaryKey(autoGenerate = true) val lineBrandId: Long = 0,
    val brandName: String
)
