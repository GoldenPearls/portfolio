package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository


interface HttpInterfaceRepository:JpaRepository<HttpInterface, Long>{
}