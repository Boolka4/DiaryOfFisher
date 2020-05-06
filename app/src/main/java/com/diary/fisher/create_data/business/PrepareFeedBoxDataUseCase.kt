package com.diary.fisher.create_data.business

import com.diary.fisher.core.models.feed_box.FeedBoxForm
import com.diary.fisher.core.models.feed_box.FeedBoxHoleType
import com.diary.fisher.core.models.feed_box.FeedBoxMaterialType
import com.diary.fisher.core.models.feed_box.FeedBoxMountingType
import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.InputFieldType
import com.diary.fisher.create_data.rep.FeedBoxStringsProvider
import com.diary.fisher.repository.interfaces.FeedBoxRepository

class PrepareFeedBoxDataUseCase(
    private val feedBoxRepository: FeedBoxRepository,
    private val feedBoxStringsProvider: FeedBoxStringsProvider
) :
    PrepareDataUseCase {

    override suspend fun getItemsList(): List<MultipleTypesViewItem> {
        val itemsList = mutableListOf<CreateDataItem>()
        getFeedBoxBrandItems(itemsList)
        getFeedBoxFormItems(itemsList)
        getFeedBoxFormItems(itemsList)
        getFeedBoxMaterialTypeItems(itemsList)
        getFeedBoxHoleTypeItems(itemsList)
        getFeedBoxMountingType(itemsList)
        getCommentItem(itemsList)
        return itemsList
    }

    private fun getFeedBoxBrandItems(itemsList: MutableList<CreateDataItem>) {
        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = 0,
                selectedItemId = -1,
                isMandatory = false,
                text = ""
            )
        )
    }

    private fun getFeedBoxFormItems(itemsList: MutableList<CreateDataItem>) {
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 1,
                text = feedBoxStringsProvider.getFeedBoxNameByType(FeedBoxForm.DEFAULT),
                isSelected = true
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 2,
                text = feedBoxStringsProvider.getFeedBoxNameByType(FeedBoxForm.DUSE),
                isSelected = false
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 3,
                text = feedBoxStringsProvider.getFeedBoxNameByType(FeedBoxForm.BULLET),
                isSelected = false
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 4,
                text = feedBoxStringsProvider.getFeedBoxNameByType(FeedBoxForm.FLAT),
                isSelected = false
            )
        )
    }

    private fun getFeedBoxMaterialTypeItems(itemsList: MutableList<CreateDataItem>) {
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 5,
                text = feedBoxStringsProvider.getFeedBoxMaterialNameByType(FeedBoxMaterialType.METAL),
                isSelected = true
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 6,
                text = feedBoxStringsProvider.getFeedBoxMaterialNameByType(FeedBoxMaterialType.PLASTIC),
                isSelected = false
            )
        )
    }

    private fun getFeedBoxHoleTypeItems(itemsList: MutableList<CreateDataItem>) {
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 7,
                text = feedBoxStringsProvider.getFeedBoxHoleNameByType(FeedBoxHoleType.OPENED),
                isSelected = true
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 8,
                text = feedBoxStringsProvider.getFeedBoxHoleNameByType(FeedBoxHoleType.MEDIUM),
                isSelected = false
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 9,
                text = feedBoxStringsProvider.getFeedBoxHoleNameByType(FeedBoxHoleType.CLOSED),
                isSelected = false
            )
        )
    }

    private fun getFeedBoxMountingType(itemsList: MutableList<CreateDataItem>) {
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 10,
                text = feedBoxStringsProvider.getFeedBoxMountingNameByType(FeedBoxMountingType.DEFAULT),
                isSelected = true
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 11,
                text = feedBoxStringsProvider.getFeedBoxMountingNameByType(FeedBoxMountingType.LINE),
                isSelected = false
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 12,
                text = feedBoxStringsProvider.getFeedBoxMountingNameByType(FeedBoxMountingType.IN_LINE),
                isSelected = false
            )
        )
    }

    private fun getCommentItem(itemsList: MutableList<CreateDataItem>) {
        itemsList.add(
            CreateDataItem.InputFieldDataItem(
                elementId = 13,
                isMandatory = false,
                inputType = InputFieldType.STRING,
                hintText = feedBoxStringsProvider.getCommentText(),
                currentValue = ""
            )
        )
    }
}