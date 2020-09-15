package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.bait.Bait
import com.diary.fisher.db.dao.BaitDao
import com.diary.fisher.repository.interfaces.BaitRepository
import com.diary.fisher.repository.mappers.bait.BaitMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaitRepositoryImpl(
    private val baitDao: BaitDao,
    private val baitMapper: BaitMapper
) : BaitRepository {

    override suspend fun insertBait(bait: Bait) = withContext(Dispatchers.IO) {
        baitDao.insertBaitDB(baitMapper.fromBusinessToDB(bait))
    }

    override suspend fun getBaitById(id: Long) =
        withContext(Dispatchers.IO) {
            baitMapper.fromDBtoBusiness(baitDao.getBaitDB(id))
        }

    override suspend fun getBaitsList(): List<Bait> =
        withContext(Dispatchers.IO) {
            baitDao.getBaitsList().map { baitMapper.fromDBtoBusiness(it) }
        }
}