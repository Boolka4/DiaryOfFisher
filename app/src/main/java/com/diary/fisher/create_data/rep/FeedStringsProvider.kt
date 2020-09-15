package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.repository.resource.ResourceManager

class FeedStringsProvider(private val resourceManager: ResourceManager) {

    fun getCreateFeedDialogTitle() = resourceManager.getString(R.string.create_feeds_title)
}