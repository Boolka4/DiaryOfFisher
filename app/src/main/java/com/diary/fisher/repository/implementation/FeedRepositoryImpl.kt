package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.feed.Feed
import com.diary.fisher.db.dao.FeedDao
import com.diary.fisher.repository.interfaces.FeedRepository
import com.diary.fisher.repository.mappers.feed.FeedMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeedRepositoryImpl(
    private val feedDao: FeedDao,
    private val feedMapper: FeedMapper
) : FeedRepository {

    override suspend fun insertFeed(feed: Feed) = withContext(Dispatchers.IO) {
        feedDao.insertFeedDB(feedMapper.fromBusinessToDB(feed))
    }

    override suspend fun getFeedById(id: Long) =
        withContext(Dispatchers.IO) {
            feedMapper.fromDBtoBusiness(feedDao.getFeedDB(id))
        }

    override suspend fun getFeedsList(): List<Feed> =
        withContext(Dispatchers.IO) {
            feedDao.getFeedsList().map { feedMapper.fromDBtoBusiness(it) }
        }
}