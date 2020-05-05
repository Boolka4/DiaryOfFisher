package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.feed_box.FeederBoxBrand
import com.diary.fisher.core.models.hook.HookBrand
import com.diary.fisher.db.dao.FeedBoxDao
import com.diary.fisher.db.dao.HooksDao
import com.diary.fisher.repository.interfaces.FeederBoxRepository
import com.diary.fisher.repository.interfaces.HookRepository
import com.diary.fisher.repository.mappers.feeder_box.FeederBoxBrandMapper
import com.diary.fisher.repository.mappers.hook.HookBrandMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class FeederBoxRepositoryImpl(
    private val feederBoxDao: FeedBoxDao,
    private val feederBoxBrandMapper: FeederBoxBrandMapper
) : FeederBoxRepository {

    override suspend fun insertFeederBoxBrand(feederBoxBrand: FeederBoxBrand) =
        withContext(Dispatchers.IO) {
            feederBoxDao.insertFeederBoxBrandDB(feederBoxBrandMapper.fromBusinessToDB(feederBoxBrand))
        }

    override suspend fun getFeederBoxBrandsList(): List<FeederBoxBrand> =
        withContext(Dispatchers.IO) {
            feederBoxDao.getFeederBoxBrandsList().map { feederBoxBrandMapper.fromDBtoBusiness(it) }
        }
}