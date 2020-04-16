package com.diary.fisher.reports_list.business

import com.diary.fisher.report_add.models.ReportViewItem

class PrepareReportsListUseCase {

    fun getItemsList(): List<ReportViewItem> {
        return listOf(ReportViewItem(1, "vileika"), ReportViewItem(2, "ludvinovo"))
    }
}