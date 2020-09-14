package com.diary.fisher.db.models.hook_prototype

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class HookPrototypeDB(
    @PrimaryKey(autoGenerate = true) val hookPrototypeId: Long = 0,
    val brandName: String
)