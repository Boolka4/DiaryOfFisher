package com.diary.fisher.repository.mappers.dip

import com.diary.fisher.core.models.dip.Dip
import com.diary.fisher.db.models.dip.DipDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class DipMapper : BusinessDBMapper<Dip, DipDB> {

    override fun fromDBtoBusiness(dbEntity: DipDB): Dip {
        return Dip(dbEntity.dipId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: Dip): DipDB {
        return DipDB(businessEntity.id, businessEntity.brandName)
    }
}