package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.repository.resource.ResourceManager

class AllSettingsListStringsProvider(private val resourceManager: ResourceManager) {

    fun getRodsText() = resourceManager.getString(R.string.all_settings_list_rods)

    fun getDirectionsText() = resourceManager.getString(R.string.all_settings_list_directions)

    fun getBitesText() = resourceManager.getString(R.string.all_settings_list_bites)

    fun getDipsText() = resourceManager.getString(R.string.all_settings_list_dips)

    fun getFeedsText() = resourceManager.getString(R.string.all_settings_list_feeds)

    fun getHooksText() = resourceManager.getString(R.string.all_settings_list_hooks)

    fun getMountingsText() = resourceManager.getString(R.string.all_settings_list_mountings)
}