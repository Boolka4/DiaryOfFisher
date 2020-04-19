package com.diary.fisher.db.models.hook

import androidx.room.Embedded
import androidx.room.Relation

data class HookDB(
    @Embedded val hookBrand: HookBrandDB,
    @Relation(
        parentColumn = "hookBrandId",
        entityColumn = "hookBrandId"
    )
    val hookModelDB: HookModelDB
)