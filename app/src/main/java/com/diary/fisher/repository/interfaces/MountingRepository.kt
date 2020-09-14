package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.mounting.Mounting

interface MountingRepository {

    suspend fun insertMounting(mounting: Mounting): Long

    suspend fun getMountingById(id: Long): Mounting

    suspend fun getMountingsList(): List<Mounting>
}