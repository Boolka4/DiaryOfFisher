package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.feed_box.FeedBoxBrand

interface FeedBoxRepository {

    suspend fun insertFeedBoxBrand(feedBoxBrand: FeedBoxBrand)

    suspend fun getFeedBoxBrandsList(): List<FeedBoxBrand>
}