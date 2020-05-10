package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.common.Constants.Companion.NOT_SELECTED_ITEM_ID
import com.diary.fisher.core.models.feed_box.FeedBoxBrand
import com.diary.fisher.repository.interfaces.FeedBoxRepository

class CreateSingleLineFeedBoxBrand(
    private val feedBoxRepository: FeedBoxRepository
) : CreateSingleLineDataUseCase {

    override suspend fun createSingleLineData(singleLineText: String): Long {
        return if (singleLineText.isNotEmpty()) {
            feedBoxRepository.insertFeedBoxBrand(FeedBoxBrand(0, singleLineText))
        } else {
            NOT_SELECTED_ITEM_ID
        }
    }
}