package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.dip.Dip
import com.diary.fisher.db.dao.DipDao
import com.diary.fisher.repository.interfaces.DipRepository
import com.diary.fisher.repository.mappers.dip.DipMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DipRepositoryImpl(
    private val dipDao: DipDao,
    private val dipMapper: DipMapper
) : DipRepository {

    override suspend fun insertDip(dip: Dip) = withContext(Dispatchers.IO) {
        dipDao.insertDipDB(dipMapper.fromBusinessToDB(dip))
    }

    override suspend fun getDipById(id: Long) =
        withContext(Dispatchers.IO) {
            dipMapper.fromDBtoBusiness(dipDao.getDipDB(id))
        }

    override suspend fun getDipsList(): List<Dip> =
        withContext(Dispatchers.IO) {
            dipDao.getDipsList().map { dipMapper.fromDBtoBusiness(it) }
        }
}