package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.repository.resource.ResourceManager

class HookPrototypesStringsProvider(private val resourceManager: ResourceManager) {

    fun getCreateHookPrototypeDialogTitle() = resourceManager.getString(R.string.create_hook_prototype_title)
}