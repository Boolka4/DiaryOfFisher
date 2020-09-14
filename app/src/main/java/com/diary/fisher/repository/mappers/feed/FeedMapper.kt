package com.diary.fisher.repository.mappers.feed

import com.diary.fisher.core.models.feed.Feed
import com.diary.fisher.db.models.feed.FeedDB
import com.diary.fisher.repository.mappers.BusinessDBMapper

class FeedMapper : BusinessDBMapper<Feed, FeedDB> {

    override fun fromDBtoBusiness(dbEntity: FeedDB): Feed {
        return Feed(dbEntity.feedId, dbEntity.brandName)
    }

    override fun fromBusinessToDB(businessEntity: Feed): FeedDB {
        return FeedDB(businessEntity.feedId, businessEntity.brandName)
    }
}