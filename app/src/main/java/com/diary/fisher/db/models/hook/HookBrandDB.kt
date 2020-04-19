package com.diary.fisher.db.models.hook

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HookBrandDB(
    @PrimaryKey(autoGenerate = true) val hookBrandId: Long = 0,
    val brandName: String
)
