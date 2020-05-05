package com.diary.fisher.db.models.feed_box

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FeedBoxBrandDB(
    @PrimaryKey(autoGenerate = true) val feedBoxBrandId: Long = 0,
    val brandName: String
)