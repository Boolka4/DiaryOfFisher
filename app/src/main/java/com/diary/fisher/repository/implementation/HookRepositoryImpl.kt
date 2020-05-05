package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.hook.HookBrand
import com.diary.fisher.db.dao.HooksDao
import com.diary.fisher.repository.interfaces.HookRepository
import com.diary.fisher.repository.mappers.hook.HookBrandMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HookRepositoryImpl(
    private val hooksDao: HooksDao,
    private val hookBrandMapper: HookBrandMapper
) : HookRepository {

    override suspend fun insertHookBrand(hookBrand: HookBrand) = withContext(Dispatchers.IO) {
        hooksDao.insertHookBrand(hookBrandMapper.fromBusinessToDB(hookBrand))
    }

    override suspend fun getHookBrand(id: Long): HookBrand = withContext(Dispatchers.IO) {
        hookBrandMapper.fromDBtoBusiness(hooksDao.getHookBrand(id))
    }

    override suspend fun getHooksBrandList(): List<HookBrand> = withContext(Dispatchers.IO) {
        hooksDao.getHookBrandsList().map { hookBrandMapper.fromDBtoBusiness(it) }
    }
}