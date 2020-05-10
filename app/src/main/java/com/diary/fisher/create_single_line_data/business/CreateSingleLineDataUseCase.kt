package com.diary.fisher.create_single_line_data.business

interface CreateSingleLineDataUseCase {

    suspend fun createSingleLineData(singleLineText: String): Long
}