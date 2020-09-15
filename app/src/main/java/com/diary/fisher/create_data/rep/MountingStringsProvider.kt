package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.repository.resource.ResourceManager

class MountingStringsProvider(private val resourceManager: ResourceManager) {

    fun getCreateMountingDialogTitle() = resourceManager.getString(R.string.create_mounting_title)
}