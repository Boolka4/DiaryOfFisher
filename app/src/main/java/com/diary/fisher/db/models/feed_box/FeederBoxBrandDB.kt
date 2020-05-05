package com.diary.fisher.db.models.feed_box

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FeederBoxBrandDB(
    @PrimaryKey(autoGenerate = true) val feederBoxBrandId: Long = 0,
    val brandName: String
)