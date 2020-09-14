package com.diary.fisher.db.models.dip

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DipDB(
    @PrimaryKey(autoGenerate = true) val dipId: Long = 0,
    val brandName: String
)