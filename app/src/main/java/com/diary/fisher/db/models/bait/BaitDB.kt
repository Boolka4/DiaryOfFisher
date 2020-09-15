package com.diary.fisher.db.models.bait

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class BaitDB(
    @PrimaryKey(autoGenerate = true) val baitId: Long = 0,
    val brandName: String
)