package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.feed_box.FeedBoxBrand
import com.diary.fisher.repository.interfaces.FeedBoxRepository

class CreateSingleLineFeedBoxBrand(
    selectedItemId: Long,
    private val feedBoxRepository: FeedBoxRepository
) : CreateSingleLineDataUseCase(selectedItemId) {

    override suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String {
        return feedBoxRepository.getFeedBoxBrandById(selectedItemId).brandName
    }

    override suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long {
        return feedBoxRepository.insertFeedBoxBrand(FeedBoxBrand(dbId, singleLineText))
    }
}