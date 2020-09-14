package com.diary.fisher.db.models.feed

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FeedDB(
    @PrimaryKey(autoGenerate = true) val feedId: Long = 0,
    val brandName: String
)