package com.diary.fisher.db.models.rod

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RodDB(
    @PrimaryKey(autoGenerate = true) val rodId: Long = 0,
    val brandName: String
)