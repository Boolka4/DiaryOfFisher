package com.diary.fisher.create_data.business

import com.diary.fisher.create_data.models.ProcessCreateItemClickResult

interface AddDataUseCase {

    fun processAddDataClick(): ProcessCreateItemClickResult
}