package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.core.models.feed_box.FeedBoxForm
import com.diary.fisher.core.models.feed_box.FeedBoxForm.*
import com.diary.fisher.core.models.feed_box.FeedBoxHoleType
import com.diary.fisher.core.models.feed_box.FeedBoxMaterialType
import com.diary.fisher.core.models.feed_box.FeedBoxMountingType
import com.diary.fisher.repository.resource.ResourceManager

class FeedBoxStringsProvider(private val resourceManager: ResourceManager) {

    fun getBrandNameInfoText(): String {
        return resourceManager.getString(R.string.select_feed_box_brand_title)
    }

    fun getDefaultBrandNameText(): String {
        return resourceManager.getString(R.string.select_feed_box_brand_name_text)
    }

    fun getFeedBoxFormInfoText(): String {
        return resourceManager.getString(R.string.select_feed_box_form_text)
    }

    fun getFeedBoxMaterialTypeInfoText(): String {
        return resourceManager.getString(R.string.select_feed_box_material_type)
    }

    fun getFeedBoxHoleTypeInfoText(): String {
        return resourceManager.getString(R.string.select_feed_box_hole_type)
    }

    fun getFeedBoxMountingTypeInfoText(): String {
        return resourceManager.getString(R.string.select_feed_box_hole_type)
    }


    fun getFeedBoxNameByType(feedBoxForm: FeedBoxForm): String {
        return when (feedBoxForm) {
            DEFAULT -> resourceManager.getString(R.string.feed_box_form_default)
            DUSE -> resourceManager.getString(R.string.feed_box_form_duse)
            BULLET -> resourceManager.getString(R.string.feed_box_form_bullet)
            FLAT -> resourceManager.getString(R.string.feed_box_form_flat)
        }
    }

    fun getFeedBoxMaterialNameByType(feedBoxMaterialType: FeedBoxMaterialType): String {
        return when (feedBoxMaterialType) {
            FeedBoxMaterialType.METAL -> resourceManager.getString(R.string.feed_box_material_type_metal)
            FeedBoxMaterialType.PLASTIC -> resourceManager.getString(R.string.feed_box_material_type_plastic)
        }
    }

    fun getFeedBoxHoleNameByType(feedBoxHoleType: FeedBoxHoleType): String {
        return when (feedBoxHoleType) {
            FeedBoxHoleType.OPENED -> resourceManager.getString(R.string.feed_box_hole_type_opened)
            FeedBoxHoleType.MEDIUM -> resourceManager.getString(R.string.feed_box_hole_type_medium)
            FeedBoxHoleType.CLOSED -> resourceManager.getString(R.string.feed_box_hole_type_closed)
        }
    }

    fun getFeedBoxMountingNameByType(feedBoxMountingType: FeedBoxMountingType): String {
        return when (feedBoxMountingType) {
            FeedBoxMountingType.DEFAULT -> resourceManager.getString(R.string.feed_box_mounting_type_default)
            FeedBoxMountingType.LINE -> resourceManager.getString(R.string.feed_box_mounting_type_line)
            FeedBoxMountingType.IN_LINE -> resourceManager.getString(R.string.feed_box_mounting_type_in_line)
        }
    }

    fun getCommentText() = resourceManager.getString(R.string.common_text_comment)
}