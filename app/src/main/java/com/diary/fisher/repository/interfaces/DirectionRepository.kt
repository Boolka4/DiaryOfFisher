package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.direction.Direction

interface DirectionRepository {

    suspend fun insertDirection(direction: Direction): Long

    suspend fun getDirectionById(id: Long): Direction

    suspend fun getDirectionsList(): List<Direction>
}