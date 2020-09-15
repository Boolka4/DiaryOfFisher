package com.diary.fisher.repository.mappers.bait

import com.diary.fisher.core.models.bait.Bait
import com.diary.fisher.db.models.bait.BaitDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class BaitMapper : BusinessDBMapper<Bait, BaitDB> {

    override fun fromDBtoBusiness(dbEntity: BaitDB): Bait {
        return Bait(dbEntity.baitId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: Bait): BaitDB {
        return BaitDB(businessEntity.id, businessEntity.brandName)
    }
}