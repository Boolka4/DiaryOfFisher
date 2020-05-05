package com.diary.fisher.repository.mappers.feed_box

import com.diary.fisher.core.models.feed_box.FeedBoxBrand
import com.diary.fisher.db.models.feed_box.FeedBoxBrandDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class FeedBoxBrandMapper : BusinessDBMapper<FeedBoxBrand, FeedBoxBrandDB> {

    override fun fromDBtoBusiness(dbEntity: FeedBoxBrandDB): FeedBoxBrand {
        return FeedBoxBrand(dbEntity.feedBoxBrandId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: FeedBoxBrand): FeedBoxBrandDB {
        return FeedBoxBrandDB(businessEntity.id, businessEntity.brandName)
    }
}