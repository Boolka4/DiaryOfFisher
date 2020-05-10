package com.diary.fisher.create_data.business.feed_box

import com.diary.fisher.core.models.common.Constants
import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.core.models.feed_box.*
import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.business.PrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.InputFieldType
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.create_data.rep.FeedBoxStringsProvider
import com.diary.fisher.repository.interfaces.FeedBoxRepository

class PrepareFeedBoxDataUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val feedBoxRepository: FeedBoxRepository,
    private val feedBoxStringsProvider: FeedBoxStringsProvider
) : BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val itemsList = mutableListOf<CreateDataItem>()
        getFeedBoxBrandItems(itemsList)
        getFeedBoxFormItems(itemsList)
        getFeedBoxMaterialTypeItems(itemsList)
        getFeedBoxHoleTypeItems(itemsList)
        getFeedBoxMountingType(itemsList)
        getCommentItem(itemsList)
        return itemsList
    }

    private suspend fun getFeedBoxBrandItems(itemsList: MutableList<CreateDataItem>) {
        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = 0,
                text = feedBoxStringsProvider.getBrandNameInfoText()
            )
        )
        val defaultSelectedBrand = getDefaultSelectedBrand()
        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = 1,
                selectedItemId = defaultSelectedBrand?.id ?: Constants.NOT_SELECTED_ITEM_ID,
                isMandatory = false,
                text = defaultSelectedBrand?.brandName
                    ?: feedBoxStringsProvider.getDefaultBrandNameText(),
                createDataType = CreateDataType.FEED_BOX_BRAND_NAME
            )
        )
    }

    private fun getFeedBoxFormItems(itemsList: MutableList<CreateDataItem>) {
        val currentCroupId: Long = 2
        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = 2,
                text = feedBoxStringsProvider.getFeedBoxFormInfoText()
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 3,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxNameByType(FeedBoxForm.DEFAULT),
                isSelected = true
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 4,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxNameByType(FeedBoxForm.DUSE),
                isSelected = false
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 5,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxNameByType(FeedBoxForm.BULLET),
                isSelected = false
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 6,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxNameByType(FeedBoxForm.FLAT),
                isSelected = false
            )
        )
    }

    private fun getFeedBoxMaterialTypeItems(itemsList: MutableList<CreateDataItem>) {
        val currentCroupId: Long = 3

        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = 7,
                text = feedBoxStringsProvider.getFeedBoxMaterialTypeInfoText()
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 8,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxMaterialNameByType(FeedBoxMaterialType.METAL),
                isSelected = true
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 9,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxMaterialNameByType(FeedBoxMaterialType.PLASTIC),
                isSelected = false
            )
        )
    }

    private fun getFeedBoxHoleTypeItems(itemsList: MutableList<CreateDataItem>) {
        val currentCroupId: Long = 4

        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = 10,
                text = feedBoxStringsProvider.getFeedBoxHoleTypeInfoText()
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 11,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxHoleNameByType(FeedBoxHoleType.OPENED),
                isSelected = true
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 12,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxHoleNameByType(FeedBoxHoleType.MEDIUM),
                isSelected = false
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 13,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxHoleNameByType(FeedBoxHoleType.CLOSED),
                isSelected = false
            )
        )
    }

    private fun getFeedBoxMountingType(itemsList: MutableList<CreateDataItem>) {
        val currentCroupId: Long = 5

        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = 14,
                text = feedBoxStringsProvider.getFeedBoxMountingTypeInfoText()
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 15,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxMountingNameByType(FeedBoxMountingType.DEFAULT),
                isSelected = true
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 16,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxMountingNameByType(FeedBoxMountingType.LINE),
                isSelected = false
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 17,
                groupId = currentCroupId,
                text = feedBoxStringsProvider.getFeedBoxMountingNameByType(FeedBoxMountingType.IN_LINE),
                isSelected = false
            )
        )
    }

    private fun getCommentItem(itemsList: MutableList<CreateDataItem>) {
        itemsList.add(
            CreateDataItem.InputFieldDataItem(
                elementId = 18,
                isMandatory = false,
                inputType = InputFieldType.STRING,
                hintText = feedBoxStringsProvider.getCommentText(),
                currentValue = ""
            )
        )
    }

    private suspend fun getDefaultSelectedBrand(): FeedBoxBrand? {
        val brandsList = feedBoxRepository.getFeedBoxBrandsList()
        return if (brandsList.isNotEmpty())
            brandsList.first()
        else null
    }
}