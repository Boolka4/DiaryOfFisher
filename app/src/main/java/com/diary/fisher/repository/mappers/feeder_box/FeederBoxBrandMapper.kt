package com.diary.fisher.repository.mappers.feeder_box

import com.diary.fisher.core.models.feed_box.FeederBoxBrand
import com.diary.fisher.db.models.feed_box.FeederBoxBrandDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class FeederBoxBrandMapper : BusinessDBMapper<FeederBoxBrand, FeederBoxBrandDB> {

    override fun fromDBtoBusiness(dbEntity: FeederBoxBrandDB): FeederBoxBrand {
        return FeederBoxBrand(dbEntity.feederBoxBrandId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: FeederBoxBrand): FeederBoxBrandDB {
        return FeederBoxBrandDB(businessEntity.id, businessEntity.brandName)
    }
}