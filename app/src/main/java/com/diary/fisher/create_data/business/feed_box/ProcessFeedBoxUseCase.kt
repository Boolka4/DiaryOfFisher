package com.diary.fisher.create_data.business.feed_box

import com.diary.fisher.core.models.common.Constants
import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem
import com.diary.fisher.create_data.business.ProcessCreateItemsUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.NavigationDestinationType
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.repository.interfaces.FeedBoxRepository

class ProcessFeedBoxUseCase(
    private val createDataItemsHolder: CreateDataItemsHolder,
    private val feedBoxRepository: FeedBoxRepository
) :
    ProcessCreateItemsUseCase {

    override fun processCreateItems(createDataItem: CreateDataItem): ProcessCreateItemClickResult {
        return when (createDataItem) {
            is CreateDataItem.SingleChoiceItem -> {
                createDataItemsHolder.crateDataList.forEach {
                    if (it is CreateDataItem.SingleChoiceItem && it.groupId == createDataItem.groupId) {
                        it.isSelected = it.elementId == createDataItem.elementId
                    }
                }
                ProcessCreateItemClickResult.UpdateList(createDataItemsHolder.crateDataList)
            }
            is CreateDataItem.SelectDataItem -> {
                if (createDataItem.selectedItemId == Constants.NOT_SELECTED_ITEM_ID) {
                    ProcessCreateItemClickResult.Navigation(
                        CreateDataType.FEED_BOX_BRAND_NAME,
                        NavigationDestinationType.DIALOG,
                        createDataItem.elementId
                    )
                } else {
                    ProcessCreateItemClickResult.Navigation(
                        CreateDataType.FEED_BOX_BRAND_NAME,
                        NavigationDestinationType.SCREEN,
                        createDataItem.elementId
                    )
                }
            }
            else -> ProcessCreateItemClickResult.Nothing
        }
    }

    override fun processTextInserted(
        createDataItem: CreateDataItem.InputFieldDataItem,
        text: String
    ) {
        createDataItem.currentValue = text
    }

    override suspend fun processCreateDataResult(
        elementId: Long,
        resultId: Long
    ): List<MultipleTypesViewItem> {
        return if (resultId == Constants.NOT_SELECTED_ITEM_ID) {
            createDataItemsHolder.crateDataList
        } else {
            val itemToUpdate: CreateDataItem.SelectDataItem =
                createDataItemsHolder.crateDataList.find { it is CreateDataItem.SelectDataItem && it.listItemId == elementId }!! as CreateDataItem.SelectDataItem

            itemToUpdate.selectedItemId = resultId
            itemToUpdate.text = feedBoxRepository.getFeedBoxBrandById(resultId).brandName
            return createDataItemsHolder.crateDataList
        }
    }
}