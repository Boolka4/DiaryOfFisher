package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.hook_prototype.HookPrototype

interface HookPrototypeRepository {

    suspend fun insertHookPrototype(hookPrototype: HookPrototype): Long

    suspend fun getHookPrototypeById(id: Long): HookPrototype

    suspend fun getHookPrototypesList(): List<HookPrototype>
}