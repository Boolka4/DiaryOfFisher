package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.hook_prototype.HookPrototype
import com.diary.fisher.db.dao.HookPrototypeDao
import com.diary.fisher.repository.interfaces.HookPrototypeRepository
import com.diary.fisher.repository.mappers.hook_prototype.HookPrototypeMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HookPrototypeRepositoryImpl(
    private val hookPrototypeDao: HookPrototypeDao,
    private val hookPrototypeMapper: HookPrototypeMapper
) : HookPrototypeRepository {

    override suspend fun insertHookPrototype(hookPrototype: HookPrototype) =
        withContext(Dispatchers.IO) {
            hookPrototypeDao.insertHookPrototypeDB(
                hookPrototypeMapper.fromBusinessToDB(
                    hookPrototype
                )
            )
        }

    override suspend fun getHookPrototypeById(id: Long) =
        withContext(Dispatchers.IO) {
            hookPrototypeMapper.fromDBtoBusiness(hookPrototypeDao.getHookPrototypeDB(id))
        }

    override suspend fun getHookPrototypesList(): List<HookPrototype> =
        withContext(Dispatchers.IO) {
            hookPrototypeDao.getHookPrototypesList()
                .map { hookPrototypeMapper.fromDBtoBusiness(it) }
        }
}