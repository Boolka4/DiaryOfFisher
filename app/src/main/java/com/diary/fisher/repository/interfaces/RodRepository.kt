package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.rod.Rod

interface RodRepository {

    suspend fun insertRod(rod: Rod): Long

    suspend fun getRodById(id: Long): Rod

    suspend fun getRodsList(): List<Rod>
}