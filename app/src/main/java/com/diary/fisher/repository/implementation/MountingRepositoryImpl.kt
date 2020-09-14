package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.mounting.Mounting
import com.diary.fisher.db.dao.MountingDao
import com.diary.fisher.repository.interfaces.MountingRepository
import com.diary.fisher.repository.mappers.mounting.MountingMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MountingRepositoryImpl(
    private val mountingDao: MountingDao,
    private val mountingMapper: MountingMapper
) : MountingRepository {

    override suspend fun insertMounting(mounting: Mounting) = withContext(Dispatchers.IO) {
        mountingDao.insertMountingDB(mountingMapper.fromBusinessToDB(mounting))
    }

    override suspend fun getMountingById(id: Long) =
        withContext(Dispatchers.IO) {
            mountingMapper.fromDBtoBusiness(mountingDao.getMountingDB(id))
        }

    override suspend fun getMountingsList(): List<Mounting> =
        withContext(Dispatchers.IO) {
            mountingDao.getMountingsList().map { mountingMapper.fromDBtoBusiness(it) }
        }
}