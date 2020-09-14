package com.diary.fisher.repository.mappers.direction

import com.diary.fisher.core.models.direction.Direction
import com.diary.fisher.db.models.direction.DirectionDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class DirectionMapper : BusinessDBMapper<Direction, DirectionDB> {

    override fun fromDBtoBusiness(dbEntity: DirectionDB): Direction {
        return Direction(dbEntity.directionId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: Direction): DirectionDB {
        return DirectionDB(businessEntity.directionId, businessEntity.brandName)
    }
}