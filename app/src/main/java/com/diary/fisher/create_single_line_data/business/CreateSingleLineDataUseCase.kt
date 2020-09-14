package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.common.Constants

abstract class CreateSingleLineDataUseCase(private val selectedItemId: Long) {

    abstract suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String

    abstract suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long

    suspend fun getDefaultText(): String {
        return if (selectedItemId == Constants.NOT_SELECTED_ITEM_ID) {
            ""
        } else {
            loadDefaultNameFromRepository(selectedItemId)
        }
    }

    suspend fun createSingleLineData(singleLineText: String): Long {
        return if (singleLineText.isNotEmpty()) {
            insertSingleLineElement(
                if (selectedItemId == Constants.NOT_SELECTED_ITEM_ID) 0 else selectedItemId,
                singleLineText
            )
        } else {
            Constants.NOT_SELECTED_ITEM_ID
        }
    }
}