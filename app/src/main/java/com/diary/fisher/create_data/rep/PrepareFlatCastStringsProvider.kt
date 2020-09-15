package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.repository.resource.ResourceManager

class PrepareFlatCastStringsProvider(private var resourceManager: ResourceManager) {

    fun getRodText() = resourceManager.getString(R.string.common_select_rod)

    fun getTimeText(timeValue: String) =
        resourceManager.getString(R.string.common_select_time, timeValue)

    fun getDistanceText() = resourceManager.getString(R.string.common_select_distance)

    fun getDirectionText(directionValue: String) =
        resourceManager.getString(R.string.flat_cast_select_direction, directionValue)

    fun getBaitText() = resourceManager.getString(R.string.flat_cast_select_bait)

    fun getDipText(dipValue: String) =
        resourceManager.getString(R.string.flat_cast_select_dip, dipValue)

    fun getFeedText(feedValue: String) =
        resourceManager.getString(R.string.flat_cast_select_feed, feedValue)

    fun getHookText(feedValue: String) =
        resourceManager.getString(R.string.flat_cast_select_hook, feedValue)

    fun getHookLineWidthText() = resourceManager.getString(R.string.flat_cast_select_line_width)

    fun getMountingText() = resourceManager.getString(R.string.flat_cast_select_mounting)

    fun getCommentText() = resourceManager.getString(R.string.common_text_comment)
}