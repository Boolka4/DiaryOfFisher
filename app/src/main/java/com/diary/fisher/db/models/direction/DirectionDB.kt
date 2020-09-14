package com.diary.fisher.db.models.direction

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DirectionDB(
    @PrimaryKey(autoGenerate = true) val directionId: Long = 0,
    val brandName: String
)