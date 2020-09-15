package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.bait.Bait

interface BaitRepository {

    suspend fun insertBait(bait: Bait): Long

    suspend fun getBaitById(id: Long): Bait

    suspend fun getBaitsList(): List<Bait>
}