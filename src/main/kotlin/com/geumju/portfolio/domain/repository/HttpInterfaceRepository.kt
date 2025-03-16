package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime


interface HttpInterfaceRepository:JpaRepository<HttpInterface, Long>{
    fun countAllByCreatedDateTimeBetween(startDateTime: LocalDateTime, endDateTime: LocalDateTime): Long
}