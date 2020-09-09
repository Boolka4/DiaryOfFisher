package com.diary.fisher.core.system

import java.text.SimpleDateFormat
import java.util.*

class CurrentTimeProvider {

    private val hourMinuteTimeFOrmatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        .apply {
            this.timeZone = TimeZone.getTimeZone("UTC")
        }

    fun getCurrentTimeFormatted(): String {
        return hourMinuteTimeFOrmatter.format(System.currentTimeMillis())
    }
}