package com.diary.fisher.create_data.business.feeds_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.repository.interfaces.FeedRepository

class PrepareFeedsListUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val feedRepository: FeedRepository
) : BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val feedsList = feedRepository.getFeedsList()

        val itemsList = mutableListOf<CreateDataItem>()
        feedsList.sortedBy { it.feedId }
        feedsList.forEach { direction ->
            itemsList.add(
                CreateDataItem.SelectDataItem(
                    elementId = direction.feedId,
                    selectedItemId = direction.feedId,
                    isMandatory = false,
                    text = direction.brandName,
                    createDataType = CreateDataType.FEEDS_LIST
                )
            )
        }
        return itemsList
    }
}