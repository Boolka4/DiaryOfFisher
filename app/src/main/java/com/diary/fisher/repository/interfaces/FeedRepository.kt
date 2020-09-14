package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.feed.Feed

interface FeedRepository {

    suspend fun insertFeed(feed: Feed): Long

    suspend fun getFeedById(id: Long): Feed

    suspend fun getFeedsList(): List<Feed>
}