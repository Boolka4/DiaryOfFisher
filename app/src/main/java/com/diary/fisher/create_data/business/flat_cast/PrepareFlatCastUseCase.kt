package com.diary.fisher.create_data.business.flat_cast

import com.diary.fisher.core.models.common.Constants
import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.core.models.feed_box.FeedBoxForm
import com.diary.fisher.core.system.CurrentTimeProvider
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.InputFieldType
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.create_data.rep.PrepareFlatCastStringsProvider

class PrepareFlatCastUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val prepareFlatCastStringsProvider: PrepareFlatCastStringsProvider,
    private val currentTimeProvider: CurrentTimeProvider
) : BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val itemsList = mutableListOf<CreateDataItem>()
        val lastRodElementId = getRoadItems(itemsList)
        val lastTimeItemId = getTimeItem(itemsList, lastRodElementId)
        val lastDistanceItemId = getDistanceItems(itemsList, lastTimeItemId)
        val lastDirectionItemId = getDirectionItem(itemsList, lastDistanceItemId)
        val lastBaitItemId = getBaitItems(itemsList, lastDirectionItemId)
        val lastDipItemId = getDipItem(itemsList, lastBaitItemId)
        val lastFeedItemId = getFeedItems(itemsList, lastDipItemId)
        val lastHookItemId = getHookItem(itemsList, lastFeedItemId)
        val lastHookLineId = getHookLineItems(itemsList, lastHookItemId)
        val lastMountingId = getMountingItem(itemsList, lastHookLineId)
        getCommentItem(itemsList, lastMountingId)
        return itemsList
    }

    private fun getRoadItems(itemsList: MutableList<CreateDataItem>): Long {
        val currentGroupId: Long = 1

        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = 1,
                text = prepareFlatCastStringsProvider.getRodText()
            )
        )

        //todo load rod list
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 2,
                groupId = currentGroupId,
                text = "rod 1",
                isSelected = true
            )
        )
        itemsList.add(
            CreateDataItem.SingleChoiceItem(
                elementId = 3,
                groupId = currentGroupId,
                text = "rod 2",
                isSelected = false
            )
        )
        val lastElementId = 3L
        return lastElementId
    }

    private fun getTimeItem(itemsList: MutableList<CreateDataItem>, previousElementId: Long): Long {
        val lastElementId = previousElementId + 1
        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = lastElementId,
                text = prepareFlatCastStringsProvider.getTimeText(currentTimeProvider.getCurrentTimeFormatted())
            )
        )
        return lastElementId
    }

    private fun getDistanceItems(
        itemsList: MutableList<CreateDataItem>,
        previousElementId: Long
    ): Long {
        val distanceCaptionId = previousElementId + 1
        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = distanceCaptionId,
                text = prepareFlatCastStringsProvider.getDistanceText()
            )
        )
        //todo implement choose value type

        val lastElementId = previousElementId + 2
        return lastElementId
    }

    private fun getDirectionItem(
        itemsList: MutableList<CreateDataItem>,
        previousElementId: Long
    ): Long {
        val directionItemId = previousElementId + 1

        //todo implement direction logic
        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = directionItemId,
                text = prepareFlatCastStringsProvider.getDirectionText("stub")
            )
        )
        return directionItemId
    }

    private fun getBaitItems(
        itemsList: MutableList<CreateDataItem>,
        previousElementId: Long
    ): Long {
        val baitDescriptionId = previousElementId + 1

        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = baitDescriptionId,
                text = prepareFlatCastStringsProvider.getBaitText()
            )
        )
        val selectedBaitId = baitDescriptionId + 1

        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = selectedBaitId,
                selectedItemId = Constants.NOT_SELECTED_ITEM_ID,
                isMandatory = true,
                text = "stub",
                createDataType = CreateDataType.FEED_BOX_BRAND_NAME
            )
        )

        return selectedBaitId
    }

    private fun getDipItem(
        itemsList: MutableList<CreateDataItem>,
        previousElementId: Long
    ): Long {
        val selectDipItemId = previousElementId + 1

        //todo implement choose dip logic

        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = selectDipItemId,
                selectedItemId = Constants.NOT_SELECTED_ITEM_ID,
                isMandatory = false,
                text = prepareFlatCastStringsProvider.getDipText("stub"),
                createDataType = CreateDataType.FEED_BOX_BRAND_NAME
            )
        )
        return selectDipItemId
    }

    private fun getFeedItems(
        itemsList: MutableList<CreateDataItem>,
        previousElementId: Long
    ): Long {
        val selectFeedItemId = previousElementId + 1

        //todo implement choose feed logic

        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = selectFeedItemId,
                selectedItemId = Constants.NOT_SELECTED_ITEM_ID,
                isMandatory = false,
                text = prepareFlatCastStringsProvider.getFeedText("stub"),
                createDataType = CreateDataType.FEED_BOX_BRAND_NAME
            )
        )
        return selectFeedItemId
    }

    private fun getHookItem(
        itemsList: MutableList<CreateDataItem>,
        previousElementId: Long
    ): Long {
        val selectHookItemId = previousElementId + 1

        //todo implement choose feed logic

        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = selectHookItemId,
                selectedItemId = Constants.NOT_SELECTED_ITEM_ID,
                isMandatory = false,
                text = prepareFlatCastStringsProvider.getHookText("stub"),
                createDataType = CreateDataType.FEED_BOX_BRAND_NAME
            )
        )
        return selectHookItemId
    }

    private fun getHookLineItems(
        itemsList: MutableList<CreateDataItem>,
        previousElementId: Long
    ): Long {

        val hookLineDescriptionId = previousElementId + 1

        itemsList.add(
            CreateDataItem.InfoTextItem(
                elementId = hookLineDescriptionId,
                text = prepareFlatCastStringsProvider.getHookLineWidthText()
            )
        )
        val selectHookLineItemId = hookLineDescriptionId + 1

        //todo implement choose hook line logic

        return selectHookLineItemId
    }

    private fun getMountingItem(
        itemsList: MutableList<CreateDataItem>,
        previousElementId: Long
    ): Long {
        val selectMountingItemId = previousElementId + 1

        //todo implement choose Mounting logic

        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = selectMountingItemId,
                selectedItemId = Constants.NOT_SELECTED_ITEM_ID,
                isMandatory = false,
                text = prepareFlatCastStringsProvider.getMountingText(),
                createDataType = CreateDataType.FEED_BOX_BRAND_NAME
            )
        )
        return selectMountingItemId
    }

    private fun getCommentItem(
        itemsList: MutableList<CreateDataItem>,
        previousElementId: Long
    ) {
        val commentItemId = previousElementId + 1
        itemsList.add(
            CreateDataItem.InputFieldDataItem(
                elementId = commentItemId,
                isMandatory = false,
                inputType = InputFieldType.STRING,
                hintText = prepareFlatCastStringsProvider.getCommentText(),
                currentValue = ""
            )
        )
    }
}