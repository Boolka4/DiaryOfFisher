package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.feed_box.FeedBoxBrand
import com.diary.fisher.db.dao.FeedBoxDao
import com.diary.fisher.repository.interfaces.FeedBoxRepository
import com.diary.fisher.repository.mappers.feed_box.FeedBoxBrandMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class FeedBoxRepositoryImpl(
    private val feedBoxDao: FeedBoxDao,
    private val feedBoxBrandMapper: FeedBoxBrandMapper
) : FeedBoxRepository {

    override suspend fun insertFeedBoxBrand(feedBoxBrand: FeedBoxBrand) =
        withContext(Dispatchers.IO) {
            feedBoxDao.insertFeedBoxBrandDB(feedBoxBrandMapper.fromBusinessToDB(feedBoxBrand))
        }

    override suspend fun getFeedBoxBrandById(id: Long) =
        withContext(Dispatchers.IO) {
            feedBoxBrandMapper.fromDBtoBusiness(feedBoxDao.getFeedBoxBrandDB(id))
        }

    override suspend fun getFeedBoxBrandsList(): List<FeedBoxBrand> =
        withContext(Dispatchers.IO) {
            feedBoxDao.getFeedBoxBrandsList().map { feedBoxBrandMapper.fromDBtoBusiness(it) }
        }
}