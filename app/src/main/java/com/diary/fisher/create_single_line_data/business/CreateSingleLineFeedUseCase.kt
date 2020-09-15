package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.feed.Feed
import com.diary.fisher.repository.interfaces.FeedRepository

class CreateSingleLineFeedUseCase(
    selectItemId: Long,
    private val feedRepository: FeedRepository
) : CreateSingleLineDataUseCase(selectItemId) {

    override suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String {
        return feedRepository.getFeedById(selectedItemId).brandName
    }

    override suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long {
        return feedRepository.insertFeed(Feed(dbId, singleLineText))
    }
}