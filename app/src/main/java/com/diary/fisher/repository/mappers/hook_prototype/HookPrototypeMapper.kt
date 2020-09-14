package com.diary.fisher.repository.mappers.hook_prototype

import com.diary.fisher.core.models.hook_prototype.HookPrototype
import com.diary.fisher.db.models.hook_prototype.HookPrototypeDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class HookPrototypeMapper : BusinessDBMapper<HookPrototype, HookPrototypeDB> {

    override fun fromDBtoBusiness(dbEntity: HookPrototypeDB): HookPrototype {
        return HookPrototype(dbEntity.hookPrototypeId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: HookPrototype): HookPrototypeDB {
        return HookPrototypeDB(businessEntity.hookPrototypeId, businessEntity.brandName)
    }
}