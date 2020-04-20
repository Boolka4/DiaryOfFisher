package com.diary.fisher.db.models.line

import androidx.room.Embedded
import androidx.room.Relation

data class LineDB(
    @Embedded val lineBrand: LineBrandDB,
    @Relation(
        parentColumn = "lineBrandId",
        entityColumn = "lineBrandId"
    )
    val lineDiameterDB: LineDiameterDB
)