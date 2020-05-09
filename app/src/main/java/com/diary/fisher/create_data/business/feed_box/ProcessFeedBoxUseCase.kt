package com.diary.fisher.create_data.business.feed_box

import android.util.Log
import com.diary.fisher.create_data.business.ProcessCreateItemsUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.CreateDataItemsHolder

class ProcessFeedBoxUseCase(private val createDataItemsHolder: CreateDataItemsHolder) :
    ProcessCreateItemsUseCase {

    override fun processCreateItems(createDataItem: CreateDataItem): ProcessCreateItemClickResult {
        return when (createDataItem) {
            is CreateDataItem.SingleChoiceItem -> {
                Log.d(
                    "logd",
                    "elementId =${createDataItem.elementId}, groupId = ${createDataItem.groupId}"
                )
                createDataItemsHolder.crateDataList.forEach {
                    if (it is CreateDataItem.SingleChoiceItem && it.groupId == createDataItem.groupId) {
                        Log.d(
                            "logd",
                            "elementId =${it.elementId}, groupId = ${it.groupId}"
                        )
                        it.isSelected = it.elementId == createDataItem.elementId
                    }
                }
                ProcessCreateItemClickResult.UpdateList(createDataItemsHolder.crateDataList)
            }
            is CreateDataItem.SelectDataItem -> {
                ProcessCreateItemClickResult.Nothing
            }
            else -> ProcessCreateItemClickResult.Nothing
        }
    }
}