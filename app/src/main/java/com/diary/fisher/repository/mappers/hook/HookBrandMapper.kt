package com.diary.fisher.repository.mappers.hook

import com.diary.fisher.core.models.hook.HookBrand
import com.diary.fisher.db.models.hook.HookBrandDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class HookBrandMapper() : BusinessDBMapper<HookBrand, HookBrandDB> {

    override fun fromDBtoBusiness(dbEntity: HookBrandDB): HookBrand {
        return HookBrand(dbEntity.hookBrandId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: HookBrand): HookBrandDB {
        return HookBrandDB(businessEntity.id, businessEntity.brandName)
    }
}