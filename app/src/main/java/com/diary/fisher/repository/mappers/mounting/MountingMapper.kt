package com.diary.fisher.repository.mappers.mounting

import com.diary.fisher.core.models.mounting.Mounting
import com.diary.fisher.db.models.mountings.MountingDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class MountingMapper : BusinessDBMapper<Mounting, MountingDB> {

    override fun fromDBtoBusiness(dbEntity: MountingDB): Mounting {
        return Mounting(dbEntity.mountingId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: Mounting): MountingDB {
        return MountingDB(businessEntity.mountingId, businessEntity.brandName)
    }
}