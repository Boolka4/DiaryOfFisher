package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.repository.resource.ResourceManager

class DipStringsProvider(private val resourceManager: ResourceManager) {

    fun getCreateDipDialogTitle() = resourceManager.getString(R.string.create_dips_title)
}