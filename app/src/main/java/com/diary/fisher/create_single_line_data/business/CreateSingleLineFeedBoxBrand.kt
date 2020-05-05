package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.feed_box.FeedBoxBrand
import com.diary.fisher.repository.interfaces.FeedBoxRepository


class CreateSingleLineFeedBoxBrand(
    private val feedBoxRepository: FeedBoxRepository
) : CreateSingleLineDataUseCase {

    override suspend fun createSingleLineData(singleLineText: String) {
        feedBoxRepository.insertFeedBoxBrand(FeedBoxBrand(0, singleLineText))
    }
}