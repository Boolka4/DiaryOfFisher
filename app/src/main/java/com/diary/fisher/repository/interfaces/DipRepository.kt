package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.dip.Dip

interface DipRepository {

    suspend fun insertDip(dip: Dip): Long

    suspend fun getDipById(id: Long): Dip

    suspend fun getDipsList(): List<Dip>
}