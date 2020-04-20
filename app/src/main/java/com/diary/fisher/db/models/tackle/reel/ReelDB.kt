package com.diary.fisher.db.models.tackle.reel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ReelDB(
    @PrimaryKey(autoGenerate = true) val reelId: Long = 0,
    val brandName: String,
    val size: Int,
    val lineId: Long,
    val shockLeaderId: Long
)