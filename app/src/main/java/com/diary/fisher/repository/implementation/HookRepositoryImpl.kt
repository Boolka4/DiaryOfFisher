package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.hook.HookBrand
import com.diary.fisher.db.dao.HooksDao
import com.diary.fisher.repository.interfaces.HookRepository
import com.diary.fisher.repository.mappers.hook.HookBrandMapper

class HookRepositoryImpl(
    private val hooksDao: HooksDao,
    private val hookBrandMapper: HookBrandMapper
) : HookRepository {

    override suspend fun insertHookBrand(hookBrand: HookBrand) {
        hooksDao.insertHookBrand(hookBrandMapper.fromBusinessToDB(hookBrand))
    }

    override suspend fun getHookBrand(id: Long): HookBrand {
        return hookBrandMapper.fromDBtoBusiness(hooksDao.getHookBrand(id))
    }
}