package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.hook.HookBrand

interface HookRepository {

    suspend fun insertHookBrand(hookBrand: HookBrand)

    suspend fun getHookBrand(id: Long): HookBrand
}