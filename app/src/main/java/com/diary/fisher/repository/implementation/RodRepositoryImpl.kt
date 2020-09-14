package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.rod.Rod
import com.diary.fisher.db.dao.RodsDao
import com.diary.fisher.repository.interfaces.RodRepository
import com.diary.fisher.repository.mappers.rod.RodMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RodRepositoryImpl(
    private val rodDao: RodsDao,
    private val rodMapper: RodMapper
) : RodRepository {

    override suspend fun insertRod(rod: Rod) = withContext(Dispatchers.IO) {
        rodDao.insertRodDB(rodMapper.fromBusinessToDB(rod))
    }

    override suspend fun getRodById(id: Long) =
        withContext(Dispatchers.IO) {
            rodMapper.fromDBtoBusiness(rodDao.getRodDB(id))
        }

    override suspend fun getRodsList(): List<Rod> =
        withContext(Dispatchers.IO) {
            rodDao.getRodsList().map { rodMapper.fromDBtoBusiness(it) }
        }
}