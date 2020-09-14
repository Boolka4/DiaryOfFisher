package com.diary.fisher.repository.mappers.rod

import com.diary.fisher.core.models.rod.Rod
import com.diary.fisher.db.models.rod.RodDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class RodMapper : BusinessDBMapper<Rod, RodDB> {

    override fun fromDBtoBusiness(dbEntity: RodDB): Rod {
        return Rod(dbEntity.rodId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: Rod): RodDB {
        return RodDB(businessEntity.id, businessEntity.brandName)
    }
}