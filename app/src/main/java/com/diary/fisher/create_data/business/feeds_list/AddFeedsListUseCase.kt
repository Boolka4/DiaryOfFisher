package com.diary.fisher.create_data.business.feeds_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.AddDataUseCase
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.FeedStringsProvider

class AddFeedsListUseCase(private val feedStringsProvider: FeedStringsProvider) : AddDataUseCase {

    override fun processAddDataClick(): ProcessCreateItemClickResult {
        return ProcessCreateItemClickResult.NavigationDialog(
            createDataType = CreateDataType.CREATE_FEED,
            elementId = -1,
            dialogTitle = feedStringsProvider.getCreateFeedDialogTitle()
        )
    }
}