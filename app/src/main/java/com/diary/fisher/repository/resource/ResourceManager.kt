package com.diary.fisher.repository.resource

import android.content.Context
import androidx.annotation.StringRes

class ResourceManager(private val context: Context) {

    fun getString(@StringRes id: Int): String = context.getString(id)

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String =
        context.getString(id, *formatArgs)

}