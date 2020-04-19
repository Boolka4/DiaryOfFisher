package com.diary.fisher.repository.mappers

interface BusinessDBMapper<BUSINESS, DB> {

    fun fromDBtoBusiness(dbEntity: DB): BUSINESS

    fun fromBusinessToDB(businessEntity: BUSINESS): DB
}