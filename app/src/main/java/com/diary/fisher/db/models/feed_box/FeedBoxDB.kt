package com.diary.fisher.db.models.feed_box

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diary.fisher.core.models.feed_box.FeedBoxForm
import com.diary.fisher.core.models.feed_box.FeedBoxHoleType
import com.diary.fisher.core.models.feed_box.FeedBoxMaterialType
import com.diary.fisher.core.models.feed_box.FeedBoxMounting

@Entity
data class FeedBoxDB(
    @PrimaryKey(autoGenerate = true) val FeedBoxId: Long = 0,
    val hookBrandId: Long,
    val feedBoxForm: FeedBoxForm,
    val feedBoxMaterialType: FeedBoxMaterialType,
    val feedBoxHoleType: FeedBoxHoleType,
    val feedBoxMounting: FeedBoxMounting,
    val photoUrl: String,
    val comment: String
)