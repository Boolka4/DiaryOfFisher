package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.direction.Direction
import com.diary.fisher.db.dao.DirectionDao
import com.diary.fisher.repository.interfaces.DirectionRepository
import com.diary.fisher.repository.mappers.direction.DirectionMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DirectionRepositoryImpl(
    private val directionDao: DirectionDao,
    private val directionMapper: DirectionMapper
) : DirectionRepository {

    override suspend fun insertDirection(direction: Direction) = withContext(Dispatchers.IO) {
        directionDao.insertDirectionDB(directionMapper.fromBusinessToDB(direction))
    }

    override suspend fun getDirectionById(id: Long) =
        withContext(Dispatchers.IO) {
            directionMapper.fromDBtoBusiness(directionDao.getDirectionDB(id))
        }

    override suspend fun getDirectionsList(): List<Direction> =
        withContext(Dispatchers.IO) {
            directionDao.getDirectionsList().map { directionMapper.fromDBtoBusiness(it) }
        }
}