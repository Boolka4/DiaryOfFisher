package com.diary.fisher.db.models.mountings

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MountingDB(
    @PrimaryKey(autoGenerate = true) val mountingId: Long = 0,
    val brandName: String
)