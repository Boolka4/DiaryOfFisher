package com.diary.fisher.db.models.hook

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class HookModelDB(
    @PrimaryKey(autoGenerate = true) val hookModelId: Long = 0,
    val hookBrandId: Long,
    val modelName: String
)